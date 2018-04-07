<%--
  Created by IntelliJ IDEA.
  User: pjpjpj
  Date: 2018/4/6
  Time: 下午12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <script type="text/javascript" src='<c:url value="/js/jquery-3.3.1.min.js" ></c:url>'></script>
    <script type="text/javascript">
        // $ (function () {
        //     for (var i = 0; i < 5; i++) {
        //         $("#bgView").append('<div id="cellView"></div>');
        //     }
        // })
    </script>
</head>
<body>
    <div id="bgView">
        <h1>你的所有联系人</h1>

        <c:forEach items="${userList}" var="user">

            <div id="cellView">
                <p>${user.getNickname()}</p>
            </div>
        </c:forEach>

    </div>
</body>

<style type="text/css">
    #bgView {
        background-color: azure;
        width: 100%;
        height: 100%;
        text-align: center;
    }

    #cellView {
        border-radius: 10px;
        border:2px solid gray;
        width: 70%;
        height: 60px;
        margin:0 auto;

        margin-bottom: 20px;
    }
</style>

<>

</html>
