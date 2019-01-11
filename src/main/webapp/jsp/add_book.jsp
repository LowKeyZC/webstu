<%--
  Created by IntelliJ IDEA.
  User: ZC
  Date: 2019/1/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增图书</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../static/css/default.css">
    <link rel="stylesheet" href="../static/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="../static/css/style.css"> <!-- Resource style -->
    <script type="text/javascript" src="../static/js/jquery-1.10.2.js"></script>
    <script src="../static/js/modernizr.js"></script> <!-- Modernizr -->
    <script src="../static/js/jquery-1.8.3.min.js"></script>
    <script src="../static/js/main.js"></script> <!-- Resource jQuery -->
</head>
<body>
    <div class="zzsc-container">
        <form class="cd-form floating-labels" action="/book/add" method="post">
            <fieldset>
                <div class="icon">
                    <label class="cd-label" for="bookName">图书名称</label>
                    <input class="email error" type="text" name="bookName" id="bookName" required>
                </div>
                <div class="icon">
                    <label class="cd-label" for="bookContent">图书内容</label>
                    <textarea class="message" name="bookContent" id="bookContent" required></textarea>
                </div>
                <div class="icon">
                    <label class="cd-label" for="value">价格</label>
                    <input class="email error" type="text" name="value" id="value" required>
                </div>
                <div>
                    <input type="submit" value="录入">
                </div>
            </fieldset>
        </form>
    </div>
</body>
</html>
