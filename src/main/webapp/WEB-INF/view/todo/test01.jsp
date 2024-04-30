<%--
  Created by IntelliJ IDEA.
  User: 평일 오전 계정
  Date: 2024-04-30
  Time: 오전 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
  <span>Title</span>
  ${todoDTO.title}
</div>
<div>
  <span>DueDate</span>
  ${todoDTO.dueDate}
</div>
<div>
  <span>Writer</span>
  ${todoDTO.writer}
</div>
<div>
  <span>finished</span>
  ${todoDTO.finished}
</div>
</body>
</html>
