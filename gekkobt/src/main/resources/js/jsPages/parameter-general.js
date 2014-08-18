var idDelete = null;
var trName = null;
var delBtn = null;
var deleteButton = null;
jQuery(document)
		.ready(
				function($) {

					loadMaintenanceParameter();

					$("button").button().click(function(event) {
						event.preventDefault();
					});

					$("#delete-email").dialog({
						autoOpen : false,
						modal : true,
						show : {
							effect : "fade",
							duration : 400
						},
						width : 300,
						marginTop : 40
					});

					$("#delete-time").dialog({
						autoOpen : false,
						modal : true,
						show : {
							effect : "fade",
							duration : 400
						},
						width : 300,
						marginTop : 40
					});

					$("#add-time").dialog({
						autoOpen : false,
						modal : true,
						show : {
							effect : "fade",
							duration : 400
						},
						width : 320,
						marginTop : 40
					});

					$("#add-alert").dialog({

						autoOpen : false,
						modal : true,
						show : {
							effect : "fade",
							duration : 400
						},
						width : 320,
						marginTop : 40
					});

					$("#add-email").dialog({
						autoOpen : false,
						modal : true,
						show : {
							effect : "fade",
							duration : 400
						},
						width : 500,
						marginTop : 40
					});

					$(
							'#hourClosingSchedule, #minClosingSchedule, #hourSchedBalance, #minSchedBalance')
							.bind("cut copy paste", function(e) {
								e.preventDefault();
							});

					$(
							'#hourClosingSchedule, #minClosingSchedule, #hourSchedBalance, #minSchedBalance')
							.keypress(
									function(e) {
										var regex = new RegExp("^[0-9|\b]");
										var str = String
												.fromCharCode(!e.charCode ? e.which
														: e.charCode);
										if (regex.test(str)) {
											return true;
										}
										e.preventDefault();
										return false;
									});

					$(document).on("click", "#btn-save-warning", function() {
						OpenProcessTime();
						$.post("parametrization/saveAlertBody", {
							id : $("#warningId").val(),
							textBody : $("#txt-alert-body").val()
						}, function(data) {
							obj = handleJSON(data);
							hasError = handleError(obj);

							if (!hasError)
								ShowMessage("Alerta alterado.");
						});
					});

					$("#btn-delete-alert-email").click(function() {
						var emailDelete = idDelete;
						idDelete = null;
						CloseModal("delete-email");
						OpenProcessTime();
						$.post("parametrization/deleteEmail", {
							id : $("#warningId").val(),
							emails : emailDelete
						}, function(data) {
							obj = handleJSON(data);
							hasError = handleError(obj);

							if (!hasError)
								$(deleteButton).closest('tr').hide();
						});
					});

					$("#btn-delete-schedule").click(function() {
						var idDel = idDelete;
						var btn = delBtn;
						delBtn = null;
						idDelete = null;
						CloseModal("delete-time");
						OpenProcessTime();

						$.post("parametrization/deleteSchedule", {
							id : idDel
						}, function(data) {
							obj = handleJSON(data);
							hasError = handleError(obj);
							
							if (!hasError) {
								$(btn).closest('tr').hide();
							}
						});
					});

					$("#btn-add-email").click(function() {
						CloseModal("add-email");
						OpenProcessTime();
						$.post("parametrization/addEmail", {
							id : $("#warningId").val(),
							emails : $("#newEmail").val()
						}, function(data) {
							obj = handleJSON(data);
							hasError = handleError(obj);

							if (!hasError) {
								$("#body-alert-email").append(data);
							}

						});
					});

					$("#btn-save-alert-schedule").click(
							function() {
								var hour = $("#hourSchedBalance").val();
								var min = $("#minSchedBalance").val();
								

								var time = null;
								if (hour != null && hour != '' && min != null
										&& min != '') {
									time = hour + ':' + min;
								}
								
								if (validHour(hour) == false
										|| validMinute(min) == false) {
									ShowMessage("Horário inválido.",
											350, true);
									return;
								}
								
								CloseModal("add-alert");
								OpenProcessTime();

								$.post("parametrization/addSchedule", {
									scheduleTimeText : time,
									"warningBean.id" : $("#warningId").val(),
									scheduleTypeInd : 'W'
								}, function(data) {

									obj = handleJSON(data);
									hasError = handleError(obj);

									if (!hasError)
										$("#tb-alert-schedule").append(data);
								});
							});

					$("#btn-save-closing-schedule")
							.click(
									function() {
										var hour = $("#hourClosingSchedule")
												.val();
										var min = $("#minClosingSchedule")
												.val();

										var time = null;
										if (hour != null && hour != ''
												&& min != null && min != '') {
											time = hour + ':' + min;
										}

										if (validHour(hour) == false
												|| validMinute(min) == false) {
											ShowMessage("Horário inválido.",
													350, true);
											return;
										}

										CloseModal("add-time");
										OpenProcessTime();

										$.post("parametrization/addSchedule", {
											scheduleTimeText : time,
											"warningBean.id" : null,
											scheduleTypeInd : 'C'
										}, function(data) {
											obj = handleJSON(data);
											hasError = handleError(obj);

											if (!hasError) {
												$("#tb-closing-schedules")
														.append(data);
												loadMaintenanceParameter();
											}
										});
									});
				});

function setSelectionRange(input, selectionStart, selectionEnd) {
	if (input.setSelectionRange) {
		input.focus();
		input.setSelectionRange(selectionStart, selectionEnd);
	} else if (input.createTextRange) {
		var range = input.createTextRange();
		range.collapse(true);
		range.moveEnd('character', selectionEnd);
		range.moveStart('character', selectionStart);
		range.select();
	}
}

function getPosCursor(element) {
	var value = 0;
	if (typeof (element.selectionStart) != "undefined") {
		value = element.selectionStart;
	} else if (document.selection) {
		var range = document.selection.createRange();
		var storedRange = range.duplicate();
		storedRange.moveToElementText(element);
		storedRange.setEndPoint("EndToEnd", range);
		value = storedRange.text.length - range.text.length;
	}
	element.cursorPosition = value;
	return value;
}

function setCaretToPos(input, pos) {
	setSelectionRange(input, pos, pos);
}

function openTime() {
	$('#hourClosingSchedule, #minClosingSchedule').val('');
	$("#add-time").dialog("open");
}

function openTimeAlert() {
	$('#hourSchedBalance, #minSchedBalance').val('');
	$("#add-alert").dialog("open");
}

function openEmail() {
	$('#newEmail').val('');
	$("#add-email").dialog("open");
}
function openAlert(id) {
	OpenProcessTime();
	$.post("parametrization/findWarning", {
		warningId : id
	}, function(data) {
		var obj = handleJSON(data);
		var hasError = handleError(obj);
		if (!hasError) {
			$("#maintenance-alert").html(data);
			loadMaintenanceAlert();
			$("#maintenance-alert").dialog("open");
		}
	});
}

function loadMaintenanceParameter() {
	$('#tb-closing-schedules').flexigrid({
		height : 100,
		width : 360,
		singleSelect : true,
		buttons : [ {
			name : 'Adicionar',
			bclass : 'add-grid',
			onpress : openTime
		}, {
			separator : true
		} ]
	});

	$('#tb-alerts').flexigrid({
		height : 100,
		width : 360,
		singleSelect : true
	});
}

function loadMaintenanceAlert() {
	$('#tb-variables').flexigrid({
		height : 125,
		width : 220,
		singleSelect : true
	});

	$('#tb-alert-schedule').flexigrid({
		height : 100,
		width : 220,
		singleSelect : true,
		buttons : [ {
			name : 'Adicionar',
			bclass : 'add-grid',
			onpress : openTimeAlert
		}, {
			separator : true
		} ]
	});

	$('#tb-alert-email').flexigrid({
		height : 100,
		width : 470,
		singleSelect : true,
		buttons : [ {
			name : 'Adicionar',
			bclass : 'add-grid',
			onpress : openEmail
		}, {
			separator : true
		} ]
	});

	$("#maintenance-alert").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 750,
		height : 550,
		marginTop : 40
	});
}

function addVariable(inputId, tag) {
	input = document.getElementById(inputId);
	var qtdChar = input.value.length;
	str1 = input.value.substr(0, input.cursorPosition);
	str2 = input.value.substr(input.cursorPosition, qtdChar);

	strFinal = str1 + tag + str2;
	input.value = strFinal;
	setCaretToPos(input, input.cursorPosition + tag.length);
}

function deleteClosingSchedule(id, btn) {
	idDelete = id;
	delBtn = btn;
	$("#delete-time").dialog("open");
}

function deleteEmail(varEmail, varButton) {
	idDelete = varEmail;
	deleteButton = varButton;
	$("#delete-email").dialog("open");
}

function validHour(varHour) {
	if ((varHour >= 0) && (varHour <= 23))
		return true;
	else
		return false;
}

function validMinute(varMinute) {
	if ((varMinute >= 0) && (varMinute <= 59))
		return true;
	else
		return false;
}