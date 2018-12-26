	//得到cookie
	function getCookie(cname){
	  var name = cname + "=";
	  //得到cookie值
	  var cookieValue=document.cookie;
	  //将cookie值进行解码
	  var valCookie=decodeURIComponent(cookieValue);
	  var ca = valCookie.split(';');
	  for(var i=0; i<ca.length; i++){
	    var c = ca[i].trim();                                         
	    if (c.indexOf(name)==0)
	    return c.substring(name.length,c.length);
	  }
	  return "";
	}
	/*
	*设置cookie
	* cname cookie的名字
	* cvalue cookie的值
	* exdays 过期时间
	*/
	function setCookie(cname,cvalue,exdays){
		//将值进行编码
		var value=encodeURIComponent(cvalue);
	    var d = new Date();
		//设置过期时间
	    d.setTime(d.getTime()+(exdays*24*60*60*1000));
	    var expires = "expires="+d.toGMTString();
		//将值增加到cookie
	    document.cookie = cname+"="+value+"; "+expires;
	}