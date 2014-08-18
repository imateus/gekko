//<![CDATA[
jQuery(document).ready(function($) {
	$('#tbProfileAccount').flexigrid({
		width : 672,
		singleSelect : true
	});

	$("#edit-profile-bank-account").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 730,
		marginTop : 10
	});
});

function updateProfile(id) {
	OpenProcessTime();
	$.post("profile-bank-account/findProfile", {
		accountTypeId : id
	}, function(data) {
		var obj = handleJSON(data);
		var hasError = handleError(obj);

		if (!hasError) {
			$("#accountTypeId").val(obj.accountTypeId);
			$("#accountTypeName").val(obj.accountTypeName);
			$("#profileDescription").val(obj.profileDescription);
			$("#edit-profile-bank-account").dialog("open");
		}
	});
}

$(document).on('click', '#btnUpdateProfile', function() {
	OpenProcessTime();
	$.post("profile-bank-account/updateProfile", {
		accountTypeId : $("#accountTypeId").val(),
		profileDescription : $("#profileDescription").val()
	}, function(data) {
		var obj = handleJSON(data);
		var hasError = handleError(obj);

		if (!hasError) {
			$("#edit-profile-bank-account").dialog("close");
			ShowMessage("Perfil de conta corrente alterada.");
		}
	});
});

// ]]>
