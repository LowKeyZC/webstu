<%--
  Created by IntelliJ IDEA.
  User: ZC
  Date: 2019/1/9
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>
    <script type="text/javascript" src="../static/js/jquery-1.10.2.js"></script>
</head>
<body>
    <div align="center">
        <span>用户：${user.userName}</span><br>
        <span>我的余额：${user.hasMoney}</span>
        <a href="/user/login">LOGOUT</a>
        <table border="1px" id="tab">
            <tr>
                <td>图书ID</td>
                <td>图书名称</td>
                <td>图书价格</td>
                <td>操作</td>
            </tr>
        </table>
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

        function play(i) {
            var bookId = data[i].bookId;
            $.ajax({
                type : 'post',
                url : '/book/play',
                data : {
                    "bookId" : bookId
                },
                success : function (result) {
                    alert(result);
                }
            })
        }

        function buy(i) {
            var bookId = data[i].bookId;
            console.info("bookId="+bookId);
            $.ajax({
                type : 'post',
                url : '/book/buy',
                data : {
                    "bookId":bookId
                },
                success : function (result) {
                    if (result === "200") {
                        window.location.reload();
                    } else if (result === "1003") {
                        alert("余额不足！")
                    } else {
                        alert("系统异常！")
                    }
                }
            })
        }

        function initTable() {
            for(var i = 0; i < data.length; i++) {
                var s = "<tr>";
                s += "<td>" + data[i].bookId + "</td>";
                s += "<td>" + data[i].bookName + "</td>";
                s += "<td>" + data[i].value + "</td>";
                if (data[i].status === 1) {
                    s += "<td bgcolor='#f5f5dc'><a onclick=play("+i+")>阅读</a></td>";
                } else if(data[i].status === 2) {
                    s += "<td bgcolor='#7fffd4'><a onclick=buy("+i+")>购买</a></td>"
                }
                s += "</tr>";
                $("#tab").append(s);
            }
        }
    </script>
</body>
</html>
