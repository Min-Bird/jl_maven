<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script>
</script>
<body>
<form action="/login/login" method="post">
    用户名：
    <input type="text" name="username" id="username"><br><br>
    密码：
    <input type="text" name="password" id="password"><br><br>
    验证码：
    <img src="/login/getPic" id="img" onclick="getPic()" alt="无法加载">
    <input type="text" name="picCode" id="picCode"><br><br>
    <input type="submit" value="登录">
</form>
</body>
<script>
    function getPic() {
        document.getElementById("img").src = document.getElementById("img").src + "?nocache=" + new Date().getTime();
    }

</script>
</html>