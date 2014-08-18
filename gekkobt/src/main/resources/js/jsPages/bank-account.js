var indexRowAccounts;

jQuery(document).ready(function($) {

	setQtip();
	
	$("#approve-bank-account").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 300,
		marginTop : 40
	});

	$("#delete-bank-account").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 300,
		marginTop : 40
	});

	$("#edit-bank-account").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 500,
		marginTop : 10
	});

	$("#maintenance-bank-account").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 500,
		marginTop : 10
	});

	$('#accountId').bind("cut copy paste", function(e) {
		e.preventDefault();
	});

	$(".delete-bank-account").click(function() {
		$("#delete-bank-account").dialog("open");
	});

	$('#tbBankAccount').flexigrid({
		width : 799,
		singleSelect : true,
		buttons : [ {
			name : 'Adicionar',
			bclass : 'add-grid',
			onpress : openBankAccount
		}, {
			separator : true
		}, {
			name : 'Aprovar',
			bclass : 'accept-grid',
			onpress : approveBankAccount
		}, {
			separator : true
		} ]
	});

	$('#mattressDefault').setMask();

	$(document).on('click', '#btn-approve-account', function() {
		try {
			OpenProcessTime();
			var accountList = new Array();
			var account = null;
			indexRowAccounts = "";
			$('#tbBankAccount > tbody  > tr').each(function() {
				var index = $(this).attr('id');
				
				if ($("#chkAccount" + index).prop('checked') == true) {
					account = {
						"accountId" : $("#hdnAccount" + index).val(),
						"accountTypeId" : $("#hdnProfileAccount" + index).val()
					};
					
					indexRowAccounts += index + ",";
					accountList.push(account);
				}
			});

			$.ajax(
			{
				url : "bank-account/approveBankAccount",
				type : "POST",
				data : JSON.stringify(accountList),
				success : function(data) {
					try {
						CloseModal("approve-bank-account");
						ShowMessage("Conta corrente aprovada.");
						
						var arrayIndex = indexRowAccounts.split(",");	
						
						$.each(arrayIndex,function(i){
							$("#tdAproove" + arrayIndex[i]).addClass("aprooved");
							$("#tdAproove" + arrayIndex[i]).html("<div style='width:50px;'><img src='" + $("#hdnImgCheck").val() + "' alt='Aprovado'/></div>");
						});
						
						
						setQtip();
					} catch (ex) {
						alert(ex);
					}
				},
				error: function(data){
					CloseModal("approve-bank-account");
					ShowMessage("Ocorreu um erro ao tentar aprovar a conta corrente, tente novamente mais tarde.");
				},
				dataType : "json",
				contentType : "application/json"
			});
		} catch (ex) {
			alert(ex);
		}
	});

	$('#accountId').keypress(function(e) {
		var regex = new RegExp("^[0-9|\b]");
		var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
		if (regex.test(str)) {
			return true;
		}
		e.preventDefault();
		return false;
	});

	$('#txtAccountNumber').keypress(function(e) {
		var regex = new RegExp("^[0-9|\b]");
		var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
		if (regex.test(str)) {
			return true;
		}
		e.preventDefault();
		return false;
	});

	$(document).on('click', '#submitFrmNewBankAccount', function() {
		OpenProcessTime();
		var url;
		var method = null;
		var mattress = null;

		getAliasAccount = $("#alias").val();
		getProfileAccount = $("#profileType option:selected").text();

		mattress = $("#mattressDefault").val().replace(/[.]/g, "");
		mattress = mattress.replace(/[,]/g, ".");

		if ($("#hdnTypeAction").val() == "newType") {
			url = "bank-account/includeBankAccount";
			method = newBankAccount;
		} else {
			url = "bank-account/updateBankAccount";
			method = updateBankAccount;
		}

		$.post(url, {
			accountId : $("#accountId").val(),
			alias : $("#alias").val(),
			mattressDefault : mattress,
			accountGrb : $("#txt-account-grb").val(),
			"profileAccountBean.accountTypeId" : $("#profileType").val()
		}, method);
	});

	$('#accountId').keypress(function(e) {
		var regex = new RegExp("^[0-9|\b]");
		var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
		if (regex.test(str)) {
			return true;
		}
		e.preventDefault();
		return false;
	});

	$('#txtAccountNumber').keypress(function(e) {
		var regex = new RegExp("^[0-9|\b]");
		var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
		if (regex.test(str)) {
			return true;
		}
		e.preventDefault();
		return false;
	});

	$(document).on('click', '#btn-delete-account', function() {
		OpenProcessTime();
		var clearAccount = accountDelete;
		accountDelete = null;
		$.post("bank-account/excludeBankAccount", {
			"accountId" : accountId,
			"accountTypeId" : accountTypeId
		}, function(data) {
			obj = handleJSON(data);
			CloseModal("delete-bank-account");
		
			hasError = handleError(obj);

			if (!hasError) {
				$(clearAccount).closest('tr').hide();
				CloseModal("delete-bank-account");
				ShowMessage("Conta corrente removida.");
			}
		});
	});

	$("#account-grb").hide();
});

function newBankAccount(data) {
	obj = handleJSON(data);
	hasError = handleError(obj);
	if (!hasError) {
		$("#bankAccounts").append(data);
		setQtip();
		CloseModal("maintenance-bank-account");
		ShowMessage("Conta corrente incluída.");
	}
}

function updateBankAccount(data) {
	obj = handleJSON(data);
	hasError = handleError(obj);

	if (!hasError) {
		$(btnUpdate).closest("tr").find(".tdAccountAlias").find("div").html(
				getAliasAccount);
		$(btnUpdate).closest("tr").find(".tdAccountTypeName").find("div").html(
				getProfileAccount);

		CloseModal("maintenance-bank-account");
		ShowMessage("Dados da conta corrente foram alterados.");
	}
}

var btnUpdate;
var getAliasAccount;
var getProfileAccount;

function findUpdateAccount(btn, accountId, accountTypeId) {
	$("#titleMaintenanceBankAccount").html("Alterar conta corrente");
	$("#hdnTypeAction").val('editType');
	$('#accountId').prop('disabled', true);
	$('#txt-account-grb').prop('disabled', true);
	$('#profileType').prop('disabled', true);

	btnUpdate = btn;
	OpenProcessTime();

	$.post("bank-account/findAccount", {
		"accountId" : accountId,
		"accountTypeId" : accountTypeId
	}, function(data) {
		var obj = handleJSON(data);
		var hasError = handleError(obj);
		if (!hasError) {
			try
			{
				$("#accountId").val(obj.accountId);
				$("#alias").val(obj.alias);
				$("#mattressDefault").val(
						parseFloat(obj.mattressDefault).toFixed(2));
				$("#mattressDefault").setMask();
				$("#profileType").val(obj.profileAccountBean.accountTypeId);
				if (obj.accountParent != null) {
					$("#txt-account-grb").val(obj.accountParent.accountId);
				}
				
				showDiv();
				$("#maintenance-bank-account").dialog("open");
			}
			catch (ex) {
				alert(ex);
			}
		}
	});
}

function openBankAccount() {
	$('#accountId').prop('disabled', false);
	$('#txt-account-grb').prop('disabled', false);
	$('#profileType').prop('disabled', false);
	$("#hdnTypeAction").val("newType");
	$("#titleMaintenanceBankAccount").html("Nova conta corrente");
	$('#accountId, #alias, #mattressDefault, #txt-account-grb').val('');
	$('#profileType').val(0);
	$("#account-grb").hide();
	$("#maintenance-bank-account").dialog("open");
}

function approveBankAccount() {
	$("#approve-bank-account").dialog("open");
}

var accountDelete;
var accountId;
var accountTypeId;
function setDeleteAccount(btnDelete, varAccountId, varAccountTypeId) {
	accountDelete = btnDelete;
	accountId = varAccountId;
	accountTypeId = varAccountTypeId;
	$("#delete-bank-account").dialog("open");
}

function showDiv() {
	if ($("#profileType").val() == 1) {
		$("#account-grb").show();
	} else {
		$("#account-grb").hide();
	}
}

function setQtip() {
	$('.waitingCheck').each(function() {
		try {
			if ($(this).data("qtip"))
				$(this).qtip("destroy");

			$(this).qtip({
				show : 'mouseover',
				hide : 'mouseout',
				content : {
					text : "Aguardando aprovação"
				},
				position : {
					adjust : {
						x : -17,
						y : -10
					}
				},
				style : {
					classes : 'qtip-yellow',
					width : 200,
					fontSize : '10px',
					tip : true,
					overwrite : true
				}
			});
		} catch (e) {
		}
	});

	$('.aprooved').each(function() {
		try {
			if ($(this).data("qtip"))
				$(this).qtip("destroy");

			$(this).qtip({
				show : 'mouseover',
				hide : 'mouseout',
				content : {
					text : "Aprovado"
				},
				position : {
					adjust : {
						x : -17,
						y : -10
					}
				},
				style : {
					classes : 'qtip-green',
					width : 200,
					fontSize : '10px',
					tip : true,
					overwrite : true
				}
			});
		} catch (e) {
		}
	});
}