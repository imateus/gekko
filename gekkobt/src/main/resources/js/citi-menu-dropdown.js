$(document).ready(function() { 
                var isMobileDevice = navigator.userAgent.match(/iPad/i);
	            if(isMobileDevice){
	                $(".drop-submenu_content").css("marginTop",-1);
	                $(".div_drop_submenu_bottom").css("marginTop",-2);
	            }                   		
                $("#wrapper").click(function(){});
                $("ul").css("list-style", "none");
                //Accordion effect start
                $(".legendA").hover(function(){
                    if($(this).attr("info")!="1"){
                            $(this).find("a").addClass("closed_over");
                            $(this).find("a").removeClass("closed");
                    }
                    else{
                            $(this).find("a").addClass("opend_over");
                            $(this).find("a").removeClass("opend");
                    }
                },
                function(){
                    if($(this).attr("info")!="1"){
                        $(this).find("a").addClass("closed");
                        $(this).find("a").removeClass("closed_over");
                    }
                    else{
                        $(this).find("a").removeClass("opend_over");
                        $(this).find("a").addClass("opend");
                    }
                    //$(this).css("background", "#FFFFFF");
                });
                            
                $(".legendA").click(function(){
                    if($(this).attr("info")!="1"){
                        $(this).find("a").removeClass("closed_over");
                        $(this).find("a").addClass("opend_over");
                        $(this).attr("height", "auto");
                        $(this).find(".legendA_detail").show();
                        $(this).attr("info", "1");
                    }
                    else{
                        $(this).find("a").removeClass("opend_over");
                        $(this).find("a").addClass("closed_over");	                                            
                        $(this).attr("height", "30px");
                        $(this).find(".legendA_detail").hide();
                        $(this).attr("info", "0");
                    }
                });
                //Accordion effect end
                     
            //Facebox close button style
            $("#a_facebook_close").hover(
	            function() {
	                $(this).addClass("a_hover");
	                $(this).removeClass("a_link");
	            },
	            function() {
	                $(this).addClass("a_link");
	                $(this).removeClass("a_hover");
	            });
            });
            //Facebox close button style end
                     
            //Facebox modal
            function getBrowser() {
                var OsObject = "";
                if (navigator.userAgent.indexOf("MSIE") > 0) {
                    return "MSIE";
                } else if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
                    return "Firefox";
                } else if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
                    return "Safari";
                } else if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
                    return "Camino";
                } else if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
                    return "Gecko";
                }
            }

            function isIE7() {
                var browser = navigator.appName;
                var b_version = navigator.appVersion;
                var version = b_version.split(";");
                var trim_Version = version[1].replace(/[ ]/g, "");
                if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0")
                    return true;
                return false;
            }

            function getPageSize() {
                var scrW, scrH;
                if (window.innerHeight && window.scrollMaxY) {
                    // Mozilla    
                    scrW = window.innerWidth + window.scrollMaxX;
                    scrH = window.innerHeight + window.scrollMaxY;
                }
                else if (document.body.scrollHeight > document.body.offsetHeight) {
                    // all but IE Mac    
                    scrW = document.body.scrollWidth;
                    scrH = document.body.scrollHeight;
                }
                else if (document.body) {
                    // IE Mac    
                    scrW = document.body.offsetWidth;
                    scrH = document.body.offsetHeight;
                }
                var winW, winH;
                if (window.innerHeight) {
                    // all except IE    
                    winW = window.innerWidth;
                    winH = window.innerHeight;
                }
                else if (document.documentElement && document.documentElement.clientHeight) {
                    // IE 6 Strict Mode    
                    winW = document.documentElement.clientWidth;
                    winH = document.documentElement.clientHeight;
                } else if (document.body) {
                    // other   
                    winW = document.body.clientWidth;
                    winH = document.body.clientHeight;
                }

                var pageW = (scrW < winW) ? winW : scrW;
                var pageH = (scrH < winH) ? winH : scrH;
                return { pageW: pageW, pageH: pageH, winW: winW, winH: winH };
            }

            function showFbModal() {
                var psize = getPageSize();
                var modal = document.getElementById("facebookModal");
                modal.style.left = (psize.pageW - 425) / 2 + "px";
                modal.style.top = "50px";
                modal.style.display = "block";
                var closebnt = document.getElementById("div_facebook_close");
                closebnt.style.display = "block";

                var _body = document.getElementsByTagName('body')[0];
                var _div = document.createElement("div");

                _div.id = "div_shape";
                _body.appendChild(_div);
            }

            function closeFbModal() {
                var modal = document.getElementById("facebookModal");
                modal.style.display = "none";
                var closebnt = document.getElementById("div_facebook_close");
                closebnt.style.display = "none";

                var _div = document.getElementById("div_shape");
                if (_div != null) {
                    document.body.removeChild(_div);
                }
            }
            //Facebox modal end
    
	$(document).ready(function(){
		$('#edit-menu-weight-wrapper').show();
		$("ul").css("list-style", "none");
		//Share icon style
		$('.share_icon').hover(
		    function(){
		        var imgSrc = $(this).attr("src");
		        strImg = imgSrc.replace(".jpg", "_1.jpg");
		        $(this).attr("src", strImg);
		    },
		    function(){
		        var imgSrc = $(this).attr("src");
		        strImg = imgSrc.replace("_1.jpg", ".jpg");
		        $(this).attr("src", strImg);
		});
		//Share icon style end
                  
        //Menu
        function displaySubMenu(item, lst, tlst, tobject){
            //style of top
            $(".div_submenu_top").removeClass("drop-submenu-top").removeClass("drop-submenu-top2").removeClass("drop-submenu-top3");
					   
			//style of middle
			$(".drop-submenu_content").removeClass("drop-submenu2").removeClass("drop-submenu3").removeClass("drop-submenu");
			           
			//style of bottom
			$(".div_drop_submenu_bottom").removeClass("drop-submenu-bottom2").removeClass("drop-submenu-bottom3").removeClass("drop-submenu-bottom");
			           
			$(".drop-submenu-right2-2,.drop-submenu-right3").hide();
			           
			$(".firstlink").removeClass("linkstate");
					   
			//style of split line
			$(".drop-submenu-split,.drop-submenu-split2").height(0).hide();
					   
			if(item == 0){
				//show the first block menu items here.
				$(".div_submenu_top").addClass("drop-submenu-top");
				$(".drop-submenu_content").addClass("drop-submenu");
				$(".div_drop_submenu_bottom").addClass("drop-submenu-bottom");
			}else if(item == 1){
				//add new menu(second & third) items here
				$(tobject).addClass("linkstate");
				$(".div_submenu_top").addClass("drop-submenu-top3");
				$(".drop-submenu_content").addClass("drop-submenu3");
				$(".div_drop_submenu_bottom").addClass("drop-submenu-bottom3");
					        
				$(".drop-submenu-right2-2[lst='"+lst+"']").show();
			    $(".drop-submenu-right3[tlst='"+tlst+"']").show();
				var lineheight = $(".drop-submenu_content").has(tobject).height();
				/*var lineheight = 0;
				$(".drop-submenu_content").each(function(){
					if($(this).height() > 0)
					    lineheight = $(this).height();
				});*/
				$(".drop-submenu-split").height(lineheight).show();
				$(".drop-submenu-split2").height(lineheight).show();
			}else if(item == 2){
				//add new menu(third) items here
				$(tobject).addClass("linkstate");
				$(".div_submenu_top").addClass("drop-submenu-top2");
				$(".drop-submenu_content").addClass("drop-submenu2");
				$(".div_drop_submenu_bottom").addClass("drop-submenu-bottom2");
					        
				$(".drop-submenu-right2-2[lst='"+lst+"']").show();
				var lineheight = $(".drop-submenu_content").has(tobject).height();
				/*var lineheight = 0;
				$(".drop-submenu_content").each(function(){
					if($(this).height() > 0)
					    lineheight = $(this).height();
				});*/
				$(".drop-submenu-split").height(lineheight).show();
			}
        }
                                    
		var info = 0;
		$(".firstlink").mouseenter(
		function(event) {
            if ($(this).attr("info") == "0") {
                //show the first block menu items here.
                displaySubMenu(0, this);
            }else if ($(this).attr("info") == "1") {
			    //show the second & third block menu items here.
			    info = 1;
			    lst = $(this).attr("lst");
			    tlst = $(this).attr("tlst");
			    displaySubMenu(1, lst, tlst, this);
			}else if ($(this).attr("info") == "2") {
			    //show the third block menu items here.
			    info = 2;
			    lst = $(this).attr("lst");
			    displaySubMenu(2, lst, 0, this);
			}
			disabledEventPropagation(event);
		});
			        
		function disabledEventPropagation(event) {
			if (event.stopPropagation) {
				event.stopPropagation();
			}
			else if (window.event) {
				window.event.cancelBubble = true;
			}
		}
									      
		$(".drop-menu-large").hover(
	        function() {
	            //add the style to the item in first block in state
	            if (info == 1) {
	                //show the second & third block menu items here.
	                lst = $(this).attr("lst");
	                tlst = $(this).attr("tlst");
	                displaySubMenu(1, lst, tlst, this);
	            }
	            if (info == 2) {
	                //show the third block menu items here.
	                lst = $(this).attr("lst");
	                displaySubMenu(2, lst, 0, this);
	            }
	        },
	        function() {
	            //leave the the second or third block menu
	            info = 0;
	            displaySubMenu(0, 0, 0, this);
	        }
	    );
	                
	    $(".second").mouseenter(
	        function(){
	            var wholeLen = $(this).width();
	            var leftLen = (wholeLen-13)*0.5+15;
	            $(".div_submenu_top_dot").css("marginLeft",leftLen);
	        }
	    );
		//Menu end
	});
