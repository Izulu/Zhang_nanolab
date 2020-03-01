<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
   $("#login_button").click(function(event){
     var page="login";
     var name = $("#input_name").val();
     var password = $("#input_password").val();
        $.ajax({
            url:page,
            data: {"name":name, "password":password},
            async: true,
            type:"post",
            dataType:"text",
            success: function(result){
                if( result =='false'){alert('登录失败,账户密码错误')}
                else{ window.location.href = '/home_page.jsp'}

            }
        });
   });
});

</script>
<div align="center" id="checkResult"></div>
<form action="/login" method="post" align="center">
    账号：<input type="text" id ="input_name" name="name"> <br>
    密码：<input type="password" id ="input_password" name="password"> <br>
    <br>
    <input type="button" id="login_button" value="登录">
    <a href="/regist">
    <input type="button" value="注册">
    </a>
</form>