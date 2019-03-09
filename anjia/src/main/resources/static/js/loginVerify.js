document.writeln("<style type=\"text/css\">");
document.writeln(".schmenu{height:33px; line-height:33px; background:#636871; width:100%; margin:0 auto; overflow:hidden;}");
document.writeln(".schmenu ul{width:1180px; margin:0 auto; overflow:hidden;}");
document.writeln(".schmenu ul li{float:left;list-style:none;}");
document.writeln(".schmenu ul li a{height:33px; line-height:33px; display:block;color:#fff; font-size: 13px; padding: 0 10px;text-decoration: none;}");
document.writeln(".schmenu ul li a:hover{color:#fff; background:#000; text-decoration:none;-moz-transition:all 0.2s ease;-webkit-transition:all 0.2s ease;-o-transition:all 0.2s ease;-moz-transition:all 0.2s ease;transition:all 0.2s ease;}");
document.writeln("<\/style>");

function check_login()
{
 var name=$("#user_name").val();
 var pass=$("#password").val();
 if(name == "" || pass == "")
 {
 	document.getElementById("error_box").innerHTML = "用户名或密码不能为空";
 	//震动特效
 	$("#login_form").removeClass('shake_effect');
 	setTimeout(function()
  	{
   $("#login_form").addClass('shake_effect')
  		},1);
  	return false;
 }
 else
 {
 	return true;
 }
}
function check_register(){
    var name = $("#r_user_name").val();
    var namepattern =/^[a-zA-Z0-9]{4,16}$/;
    var pass = $("#r_password").val();
    var checkpass = $("#r_checkpassword").val();
    var email = $("#r_email").val();
    var emailpattern = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
   	if(!namepattern.test(name)) 
   	{
   		document.getElementById("error_boxusername").innerHTML = "用户名必须是由4-16位数字或者字母组成";
   	//震动特效
 	$("#login_form").removeClass('shake_effect');
 	setTimeout(function()
  	{
   $("#login_form").addClass('shake_effect')
  		},1);
  	return false;
   	}
   	else if(!check_Length())
   	{
   		document.getElementById("error_boxpassword").innerHTML = "密码的长度必须在6-20位";
   		  	//震动特效
 	$("#login_form").removeClass('shake_effect');
 	setTimeout(function()
  	{
   $("#login_form").addClass('shake_effect')
  		},1);
   		return false;
   	}
   	else if(!check_password())
   	{
   	document.getElementById("error_boxcheckpassword").innerHTML = "两次输入的密码长度必须一致";
   	//震动特效
 	$("#login_form").removeClass('shake_effect');
 	setTimeout(function()
  	{
   $("#login_form").addClass('shake_effect')
  		},1);
   		return false;
   	}
   	else if(!emailpattern.test(email))
   	{
   		document.getElementById("error_boxEmail").innerHTML = "请输入正确的Email            ";
   		  	//震动特效
 	$("#login_form").removeClass('shake_effect');
 	setTimeout(function()
  	{
   $("#login_form").addClass('shake_effect')
  		},1);
   		return false;
   	}
     else
     {
     	return true;
     }
}
function check_password(){
	var pass = $("#r_password").val();
	var checkpass = $("#r_checkpassword").val();
	if( pass == checkpass)
		return true;
	else
		{
		return false;
		}
}
//监听用户名正确性
function check_username(){
	var name = $("#r_user_name").val();
    var namepattern =/^[a-zA-Z0-9]{4,16}$/;
    if(namepattern.test(name))
    {
    	return true;
    }
    else
    {
    	return false;
    }
}
//监听邮箱名正确性
function check_Email(){
	var email = $("#r_email").val();
    var emailpattern = /^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
    if(emailpattern.test(email))
    {
    	return true;
    }
    else{
    	return false;
    }
}
//检测密码长度
function check_Length(){
	var pass = $("#r_password").val();
	if(pass.length>20||pass.length<6)
	{
		return false;
	}
	else
		return true;

}
$(function(){
    // $("#create").click(function(){
    //     check_register();
    //     return false;
    // })
    // $("#login").click(function(){
    //     check_login();
    //     return false;
    // })
    //隐藏和显示框
    $('.message a').click(function () {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        }, 'slow');
        $('span').animate({
            height: 'toggle',
            opacity: 'toggle'
		}, 'slow');
    })
    $('#r_password').bind()
    //检查密码
    $("#r_checkpassword").bind("input propertychange",function(){
    	if(check_password())
    	{
    		document.getElementById("error_boxcheckpassword").innerHTML="";
    		return;
    	}
    	else
    	{
    		document.getElementById("error_boxcheckpassword").innerHTML="两次输入的密码必须相同";
    	}
    });
    //监听用户名输入事件
    $("#r_user_name").bind("input propertychange", function(){
    	if(check_username()) document.getElementById("error_boxusername").innerHTML = "";
    	else
    	{
    		document.getElementById("error_boxusername").innerHTML = "用户名必须是由4-16位数字或者字母组成";
    	}
    })
    $("#r_password").bind("input propertychange", function(){
    	if(check_Length())
    	{
    		document.getElementById("error_boxpassword").innerHTML = "";
    	}
    	else{
    		document.getElementById("error_boxpassword").innerHTML = "密码的长度必须在6-20位";
    	}
    })
    //监听邮件输入事
    $("#r_email").bind("input propertychange", function(){
    	if(check_Email())
    	{
    		document.getElementById("error_boxEmail").innerHTML = "";
    	}
    	else
    	{
    		document.getElementById("error_boxEmail").innerHTML = "请输入正确的邮箱格式";
    	}
    });
})