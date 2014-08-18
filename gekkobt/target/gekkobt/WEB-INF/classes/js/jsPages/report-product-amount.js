jQuery(document).ready(function($) {
	$(".initialDate").datepicker({ dateFormat: 'dd/mm/yy', altField: "#initialDate", altFormat:"yy-mm-dd" });
	$(".endDate").datepicker({ dateFormat: 'dd/mm/yy', altField: "#endDate", altFormat:"yy-mm-dd" });

	try {
		$('input[type="text"]').setMask();

		$("#tb-report-product-amount").flexigrid({
			width : 943,
			singleSelect : true,
			buttons : [ {
				name : 'Excel',
				bclass : 'excel-grid',
				onpress : exportExcel
			}, {
				separator : true
			}, {
				name : 'PDF',
				bclass : 'pdf-grid',
				onpress : exportPDF
			}, {
				separator : true
			} ]
		});
		
	} catch (ex) {
		alert(ex);
	}

});

function exportPDF() {
	window.open("pdf", '_blank');
}

function exportExcel() {
	window.open("excel", '_blank');
}
