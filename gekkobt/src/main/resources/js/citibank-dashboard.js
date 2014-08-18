function CloseModal(id) {
    $("#" + id).dialog("close");
}

function handleJSON(data) {
	try {
		return JSON.parse(data);
	}
	catch (ex) {
		return null;
	}
}

function handleError(obj) {
	var response = true;	
	if(obj != null && obj.pageRedirect != null){
		window.location.href = obj.pageRedirect;
	}else if(obj != null && obj.msg != null){		
		ShowMessage(obj.msg, null, true);
	}
	else {
		response = false;
	}
	
	return response;
}

function ShowMessage(message, varWidth, isError) {
	var width = 350;
	
	if (varWidth != null && varWidth != 'undefined') {
		width = varWidth;
	}

	if (isError) {
		$("#titleMessageModal").html("Erro");
	}
	else {
		$("#titleMessageModal").html("Sucesso");
	}
	
	$("#divMessage").html(message);
	$("#messageModal").dialog({width : width});
	$("#messageModal").dialog("open");
}	

function OpenProcessTime() {
	
	
	$.blockUI({message : '<h3><img src="resources/image/busy.gif" /> Processando...</h3>'});
}