jQuery(document).ready(function($) {
	$("#delete-filter").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 300,
		marginTop : 40
	});

	$(".delete-filter").click(function() {
		$("#delete-filter").dialog("open");
	});

	$(document).on('click', '#btn-delete-filter', function() {
		OpenProcessTime();
		var clearFilter = filterDelete;
		filterDelete = null;
		$.post("filter/excludeFilter", {
			filterId : clearFilter.id,
		}, function(data) {
			obj = handleJSON(data);
			CloseModal("delete-filter");
			hasError = handleError(obj);

			if (!hasError) {
				$(clearFilter).closest('tr').hide();
				CloseModal("delete-filter");
				ShowMessage("Filtro removido.");
			}
		});
	});

	$("#maintenance-filter").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "fade",
			duration : 400
		},
		width : 500,
		marginTop : 10
	});

	$('#tb-filter').flexigrid({
		width : 500,
		singleSelect : true,
		buttons : [ {
			name : 'Adicionar',
			bclass : 'add-grid',
			onpress : openFilter
		}, {
			separator : true
		} ]
	});

	$(document).on('click', '#submitFrmNewFilter', function() {
		OpenProcessTime();
		var url;
		var method = null;

		url = "filter/includeFilter";
		method = newFilter;

		$.post(url, {
			filterValue : $("#filterValue").val(),
			"filterTypeBean.filterTypeId" : $("#filterType").val()
		}, method);
	});
	
	$(document).on('change', '#filterGroup', function() {
		OpenProcessTime();
		$.post("filter/filterOption", {
			filterGroup: $("#filterGroup option:selected").val(),
		}, function(data) {			
			obj = handleJSON(data);
			hasError = handleError(obj);
			
			if (!hasError) {
				
				var opt = '<option value="">Todos...</option>';
				$.each(obj, function(){
					opt = opt + '<option value="' + this.filterTypeId + '">' + this.name + '</option>';
			    });
				
				$('#filterTypeSelect').html(opt);			
			}
		});
	});	
	
});

var filterDelete;
function setDeleteFilter(btnDelete) {
	$("#delete-filter").dialog("open");
	filterDelete = btnDelete;
}

function newFilter(data) {
	obj = handleJSON(data);
	hasError = handleError(obj);
	if (!hasError) {
		$("#tb-filter").append(data);
		CloseModal("maintenance-filter");
		ShowMessage("Filtro incluído.");
	}
}
function openFilter() {
	$('#filterId, #filterValue').val('');
	$('#filterType').val(0);
	$("#maintenance-filter").dialog("open");
}

