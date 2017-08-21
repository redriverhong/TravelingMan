
$(function(){
    $("#a_login").click(function(){
        $(".login").show();
        $(".reg").hide();
    })
    $("#a_reg").click(function(){
        $(".reg").show();
        $(".login").hide();
    })
    
    /**登录控制**/
    $("#btn_login").click(function(){
        var name=$("#name").val();
        var password=$("#password").val();
        if(null==name || ""==name){
			$("#name").focus();
			return;
        }
        if(null==password || ""==password){
        	$("#password").focus();
        	return;
        }
        $.ajax({
                type:'post',
                Header:'Access-Control-Allow-Origin: * ',
                url:'http://localhost:8888/TravelingMan/user/userLogin.do',
                data:{name:name,password:password,method:'userLogin'},
                async:true,
                success: function(data){
                	var {data:userInfo={}}=data;
                	if(data.rstCode==0){
                		var user=userInfo;
                		window.localStorage.setItem('userInfo',JSON.stringify(userInfo));
                		window.location.href =  "http://localhost:8888/TravelingMan/index.html";//跳转到项目首页
                	}
                	else{
                		$('#login_warn').text('用户名或密码错误！');
                		$("#password").focus();
                		return;
                    }  
                },
                error:function(){
                	window.location.href =  "http://localhost:8888/TravelingMan/modules/eachhtml/login.html";//跳转到项目首页
                	$("#password").focus();
                }
            })
    })
    $("#sendEmailOrMsg").click(function(){
    	var emailOrTel=$("#emailOrTel").val();
    	if(null==emailOrTel||""==emailOrTel){
    		$("#emailOrTel").focus();
    		return;
    	}
    	var countdown=10;
    	$.ajax({
    		type:'post',
            Header:'Access-Control-Allow-Origin: * ',
            url:'http://localhost:8888/TravelingMan/user/sendEmailOrMsg.do',
            data:{emailOrTel:emailOrTel,method:'sendEmailOrMsg'},
            async:true,
            success: function(data){
            	if(data.rstCode==0){
            		$('#emailOrTel').css('border-color','#00ff00');
            		settime(this);
            	}else{
            		$('#emailOrTel').css('border-color','red');
            		$("#emailOrTel").focus();
            		return;
            	}
           }
    	})
    	function settime(obj) {
            	if (countdown == 0) {
            		$('#sendEmailOrMsg').attr('href','javascript:void(0)');
            		$("#sendEmailOrMsg").text("发送验证码"); 
            		 countdown = 10; 
            		 return;
            	} else { 
            		$('#sendEmailOrMsg').removeAttr('href');//去掉a标签中的href属性
            		$("#sendEmailOrMsg").text("重新发送(" + countdown + ")");
            		countdown--; 
            	} 
            	setTimeout(function() { 
            		settime(obj) 
            	},1000) 
       }
    })
    $("#et_code").blur(function(){
    	    	var emailOrTel=$("#emailOrTel").val();
    	    	var code=$('#et_code').val();
    	    	$.ajax({
    	    		type:'post',
    	            Header:'Access-Control-Allow-Origin: * ',
    	            url:'http://localhost:8888/TravelingMan/user/checkCode.do',
    	            data:{emailOrTel:emailOrTel,code:code,method:'checkCode'},
    	            async:true,
    	            success: function(data){
    	            	$('#etcode_ok').removeAttr('hidden');
    	            	if(data.rstCode==0){
    	            		$('#et_code').css('border-color','#00ff00');
    	            		$('#etcode_ok').attr('src','../../icon/CheckOK.png');
    	            		
    	            	}else{
    	            		$('#et_code').css('border-color','red');
    	            		$('#etcode_ok').attr('src','../../icon/CheckER.png');
    	            	}
    	            	
    	           }
    	    	})
    })
    var new_code=getRandomCode().toString();
    $("#create_code").text(new_code);
    
    $("#code").blur(function(){
    	var code=$('#code').val();
    	$('#code_ok').removeAttr('hidden');
    	if(new_code.toUpperCase()==code.toUpperCase()){
    		$('#code').css('border-color','#00ff00');
    		$('#code_ok').attr('src','../../icon/CheckOK.png');
    	}else{
    		$('#code').css('border-color','red');
    		$('#code_ok').attr('src','../../icon/CheckER.png');
    	}
    })
    $("#create_code").click(function(){
    	new_code=getRandomCode().toString();
        $("#create_code").text(new_code);
    })
    function getRandomCode(){
    	var arr = ['A','B','C','D','E','F','G','H','I','J','K','L','M',
    	           'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
    	           'a','b','c','d','e','f','g','h','i','j','k','l','m',
    	           'n','o','p','q','r','s','t','u','v','w','x','y','z',
    	           '0','1','2','3','4','5','6','7','8','9']; 

        var str = '';
        for(var i=0;i<5;i++){
        	str +=arr[Math.floor(Math.random() * arr.length)]; 
        }
        return str;
    }
    
    //注册用户名判断
     $('#name_reg').blur(function(){
    	var name_reg=$('#name_reg').val();
    	if(name_reg==null||name_reg==""){
    		$('.name_reg_warn').text('用户名不能为空！');
    		$('#name_reg').css('border-color','red');
    		return;
    	}else if(/[\'=*%;]/.test(name_reg)||name_reg.length<3||name_reg.length>20){
    		$('.name_reg_warn').text('用户名格式不正确！');
    		$('#name_reg').css('border-color','red');
    		return;
    	}
    	$.ajax({
    		type:'post',
    		Header:'Access-Control-Allow-Origin: * ',
            url:'http://localhost:8888/TravelingMan/user/checkUser.do',
            data:{name:name_reg,method:'checkUser'},
            async:true,
            success:function(data){
            	if(data.rstCode==0){
            		$('.name_reg_warn').text('');
            		$('#name_reg').css('border-color','#00ff00');
            	}else{
            		$('.name_reg_warn').text('用户名已存在！');
            		$('#name_reg').css('border-color','red');
            	}
            }
    	})
    })
    //注册密码判断
    $('#pwd_reg').blur(function(){
    	var pwd_reg=$('#pwd_reg').val();
    	var pwd1_reg=$('#pwd1_reg').val();
    	if(pwd_reg==null||pwd_reg==""){
    		$('.pwd_reg_warn').text('密码不能为空！');
    		$('#pwd_reg').css('border-color','red');
    		return;
    	}else if(/[\'=*%;]/.test(pwd_reg)||pwd_reg.length<3||pwd_reg.length>20){
    		$('.pwd_reg_warn').text('密码格式不正确！');
    		$('#pwd_reg').css('border-color','red');
    		return;
    	}else{
    		$('.pwd_reg_warn').text('');
    		$('#pwd_reg').css('border-color','#00ff00');
    	}
    	if(!(pwd1_reg==null||pwd1_reg=='')){
    		if(pwd1_reg!=pwd_reg){
        		$('.pwd1_reg_warn').text('两次输入密码不一致！');
        		$('#pwd1_reg').css('border-color','red');
        		return;
        	}else{
        		$('.pwd1_reg_warn').text('');
        		$('#pwd1_reg').css('border-color','#00ff00');
        	}
    	}
    })
     //确认密码判断
    $('#pwd1_reg').blur(function(){
    	var pwd_reg=$('#pwd_reg').val();
    	var pwd1_reg=$('#pwd1_reg').val();
    	if(pwd1_reg!=pwd_reg){
    		$('.pwd1_reg_warn').text('两次输入密码不一致！');
    		$('#pwd1_reg').css('border-color','red');
    		return;
    	}else{
    		$('.pwd1_reg_warn').text('');
    		$('#pwd1_reg').css('border-color','#00ff00');
    	}
    })
    //注册
   $('#btn_reg').click(function(){
	    var c0=$('#login_reg').css('border-color');
    	var c1=$('#name_reg').css('border-color');
    	var c2=$('#pwd_reg').css('border-color');
    	var c3=$('#pwd1_reg').css('border-color');
    	var c4=$('#emailOrTel').css('border-color');
    	var c5=$('#et_code').css('border-color');
    	var c6=$('#code').css('border-color');
    	
    	if(c0==c1&&c0==c2&&c0==c3&&c0==c4&&c0==c5&&c0==c6){
    		var name=$('#name_reg').val();
    		var password=$('#pwd_reg').val();
    		var emailOrTel=$('#emailOrTel').val();
    		alert(name+" "+password+" "+emailOrTel);
    		$.ajax({
        		type:'post',
        		Header:'Access-Control-Allow-Origin: * ',
                url:'http://localhost:8888/TravelingMan/user/register.do',
                data:{name:name,password:password,emailOrTel:emailOrTel},
                async:true,
                success:function(data){
                	alert(data.rstCode);
                	if(data.rstCode==0){
                		alert("注册成功，请登录...");
                		//window.location.href =  "http://localhost:8888/TravelingMan/modules/eachhtml/login.html";//跳转到项目首页
                		$(".login").show();
                		$(".reg").hide();
                		$(".name").text("ccc");
                		$("#password").focus();
                	}else{
                		return;
                	}
                }
    		})
    	}else{
    		$("#name_reg").focus();
    		return;
    	}
    })
})