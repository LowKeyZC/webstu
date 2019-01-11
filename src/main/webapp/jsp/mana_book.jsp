<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
    <script type="text/javascript" src="../static/js/jquery-1.10.2.js"></script>
</head>
<body>
<div align="center">
    <a href="/user/login">LOGOUT</a>
    <table border="1px" id="tab">
        <tr>
            <td>图书ID</td>
            <td>图书名称</td>
            <td>图书价格</td>
        </tr>
    </table>
    <a href="/book/add">新增图书</a>
</div>
<script type="text/javascript">

    var data = [];
    $.ajax({
        type : 'post',
        url : "/book/list",
        success : function (result) {
            console.info(result);
            data = result;

            initTable();
        }
    });

    function initTable() {
        for(var i = 0; i < data.length; i++) {
            var s = "<tr>";
            s += "<td>" + data[i].bookId + "</td>";
            s += "<td>" + data[i].bookName + "</td>";
            s += "<td>" + data[i].value + "</td>";
            s += "</tr>";
            $("#tab").append(s);
        }
    }
</script>
</body>
</html>
