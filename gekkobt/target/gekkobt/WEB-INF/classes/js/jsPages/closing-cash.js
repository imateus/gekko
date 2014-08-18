jQuery(document).ready(function($) {
		loadJquery();
	});


function formatReal(valor)
	{
        var tmp = valor+'';
        var neg = false;
        if(tmp.indexOf("-") == 0)
        {        	
            neg = true;
            tmp = tmp.replace("-","");         
        }
        
        if(tmp.length == 1) tmp = "0"+tmp;
    
        tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
        if( tmp.length > 6)
            tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");
        
        if( tmp.length > 9)
            tmp = tmp.replace(/([0-9]{3}).([0-9]{3}),([0-9]{2}$)/g,".$1.$2,$3");
    
        if( tmp.length > 12)
            tmp = tmp.replace(/([0-9]{3}).([0-9]{3}).([0-9]{3}),([0-9]{2}$)/g,".$1.$2.$3,$4");
            
       if( tmp.length > 15)
            tmp = tmp.replace(/([0-9]{3}).([0-9]{3}).([0-9]{3}),([0-9]{3}),([0-9]{2}$)/g,".$1.$2.$3,$4,$5");     
        
        if(tmp.indexOf(".") == 0) tmp = tmp.replace(".","");
        if(tmp.indexOf(",") == 0) tmp = tmp.replace(",","0,");
		
		return (neg ? '-'+tmp : tmp);

	}
		
function showTokenModal() {
	var width = 350;
	$("#modalToken").dialog({width : width});
	$("#modalToken").dialog("open");
}	


	
	function loadJquery() {
		$('#tbClosingCash').flexigrid({
			width : 943,	
			singleSelect : true,
		});	
		
		$('input[type="text"]').setMask();				
			
		$(document).on('click', '#btn-Closing-Cash', function() {
			var mattress = null;
			var debit = null;
			var credit = null;
			var net = null;
			var closeList = new Array();			
							
			$('#tbClosingCash > tbody  > tr').each(function() {
			    var index = $(this).attr('id');
			    
			    mattress = $("#mattress" + index).val().replace(/[.]/g, "");
				mattress = mattress.replace(/[,]/g , ".");
				
				debit = $("#hdnDebitAccount" + index).val().replace(/[.]/g, "");
				debit = debit.replace(/[,]/g , ".");
												
				credit = $("#hdnCreditAccount" + index).val().replace(/[.]/g, "");
				credit = credit.replace(/[,]/g , ".");			
								
				net = $("#hdnNetAccount" + index).val().replace(/[.]/g, "");
				net = net.replace(/[,]/g , ".");
						
								
			var closeBean = { 
			 		"acctId" : $("#hdnAccountId" + index).val(),				
					"profileAccountId" : $("#hdnAccountTypeId" + index).val(),
					"closeReserveValue" : mattress,
					"closeDebtValue" : debit,
					"closeCreditValue" : credit,	
					"closeNetValue" : net	
			 	};
			    closeList.push(closeBean);		  
			}); 
			
			CloseModal('modalToken');
			alert(JSON.stringify(closingCashSaveBean));
			$.ajax(
			{
			type: "POST",
            url:"saveClosingCash",  
            data: JSON.stringify({
					listCloseBean: closeList,
					token: document.getElementById('tokenTxt').value
				  }),
            success: function(data) {              
			  ShowMessage("Fechamento enviado");
			  window.location.href="../monitor";
			},
			  
			error: function(data) {
			  ShowMessage("Ocorreu um erro, tente novamente.", null, true);
			  window.location.href="../monitor";
            }, 	
            dataType: "json",
            contentType: "application/json"
            }); 
		});
	}
	
	 function recalculateClosing(index) {
		//	OpenProcessTime();
		var mattress = null;
		var debit = null;
		var credit = null;
		var net = null;
		 
		mattress = $("#mattress" + index).val().replace(/[.]/g, "");
		mattress = mattress.replace(/[,]/g , ".");					
						
		debit = $("#hdnDebitInitial" + index).val().replace(/[.]/g, "");		
		debit = debit.replace(/[,]/g , ".");
								 
		credit = $("#hdnCreditAccount" + index).val().replace(/[.]/g, "");
		credit = credit.replace(/[,]/g , ".");
				
		net = $("#hdnNetAccount" + index).val().replace(/[.]/g, "");
		net = net.replace(/[,]/g , ".");
		
		$.post("recalculateClosingCash",
		{		
			"accountId" : $("#hdnAccountId" + index).val(),				
			"accountTypeName" : $("#hdnAccountTypeName" + index).val(),
			"mattress" : mattress,
			"debitAccount" : debit,
			"creditAccount" : credit,	
			"netAccount" : net
			
		},		
		function(data) {
			var obj = handleJSON(data);
			var hasError = handleError(obj);
			if (!hasError) {							
					$("#debitAccount" + index).html(formatReal(parseFloat(obj.debitAccount).toFixed(2).toString().replace(/[.]/g, "").replace(/[-]/g, "")));										
					$("#netAccount" + index).html(formatReal(parseFloat(obj.netAccount).toFixed(2).toString().replace(/[.]/g, "").replace(/[-]/g, "")));	
					$("#hdnDebitAccount" + index).val(formatReal(parseFloat(obj.debitAccount).toFixed(2).toString().replace(/[.]/g, "")));					
					$("#hdnNetAccount" + index).val(formatReal(parseFloat(obj.netAccount).toFixed(2).toString().replace(/[.]/g, "")));						
				}
			}
		);		
	} 