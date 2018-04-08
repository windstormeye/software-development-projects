<%--
  Created by IntelliJ IDEA.
  User: pjpjpj
  Date: 2018/4/8
  Time: 下午5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

    <div id="bgView">
        <form action="/insertNewuser" method="post">
            <input type="text" name="nickname">
            <input type="password" name="passwd">
            <input type="submit" value="确定">
        </form>
    </div>

</body>

<style type="text/css">

    #bgView {
        background-color: azure;
        width: 100%;
        height: 100%;
        text-align: center;
    }

</style>

</html>
