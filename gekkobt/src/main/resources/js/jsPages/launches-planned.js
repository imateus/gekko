jQuery(document).ready(function($) {
		
		$('.maskValue').setMask();
		
		$(document).on('click', '#submitNewLaunch', function() {
			var netValue = null;
			
			OpenProcessTime();
			netValue = $("#closeNetValue").val().replace(/[.]/g, "");
			netValue = netValue.replace(/[,]/g , ".");	
			
			$.post("launches-planned/save",
			{
				acctId : $("#acctId").val(),
				liquidationType : $("#liquidationType").val(),
				launchType : $("#launchType").val(),				
				historic : $("#historic").val(),
				closeNetValue: netValue,
				originOperation : $("#originOperation").val()
				
			},
			function (data) {	
				obj = handleJSON(data);
				hasError = handleError(obj);
				if (!hasError) {
					$('#historic').val('');
					$('#acctId, #originOperation, #liquidationType, #launchType, #closeNetValue').val("");
					$('.maskValue').setMask();
					ShowMessage("Incremento solicitado.");
				}
			}
			);
		});
		
	});

	function isNumber(e){
		var key =(window.event)?event.keyCode:e.which;
		if((key >47 && key <58) || (key ==8 || key ==0))
			return true;
		return false;
	}