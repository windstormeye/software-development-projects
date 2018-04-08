<%--
  Created by IntelliJ IDEA.
  User: pjpjpj
  Date: 2018/4/8
  Time: 下午4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
    <div id="bgView">

        <h1>修改${nickname}的信息</h1>

        <form action="/updateStudent/${id}" method="post">
            <input type="text" name="nickname">
            <input type="hidden" name="id" value="${id}">
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
    }

</style>

</html>
