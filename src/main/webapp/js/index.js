$(function(){
	var user=window.localStorage.getItem('userInfo');
	alert(user);
	var obj = eval('('+user+')'); 
	$box=$(".user_info");
	var temp='<img src="'+obj.avatar+'"></img><br>'+
		    '<label>用户　名：<span>'+obj.name+'</span></label><br>'+
		    '<label>等　　级：<span>'+obj.grade+'</span></label><br>'+
		    '<label>经　　验：<span>'+obj.experience+'</span></label><br>'+
		    '<label>创建时间：<span>'+obj.createtime+'</span></label><br>'+
		    '<label>最近登录：<span>'+obj.lastlogintime+'</span></label><br>';
	$box.append(temp);
})