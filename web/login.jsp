<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>

<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://how2j.cn/study/jquery.min.js"></script>
<script>
$(function(){
   $("#login_button").click(function(){
     var url="/login";
     var name = $("#input_name").val();
     var password = $("#input_password").val();
        $.post(
            url,
            {"name":name, "password":password},
            function(result){
                alert("账号密码错误，登录失败");
            }
        );
   });
});

</script>

<form action="/login" method="post" align="center">
    账号：<input type="text" id ="input_name" name="name"> <br>
    密码：<input type="text" id ="input_password" name="password"> <br>
    <br>
    <input type="submit" id="login_button" value="登录">
    <a href="/regist">
    <input type="button" value="注册">
    </a>
</form>