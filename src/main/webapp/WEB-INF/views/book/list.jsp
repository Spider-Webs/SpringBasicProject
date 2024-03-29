<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>책 목록</title>
</head>
<body>
<h1>책 목록</h1>
<table>
<thead>
<tr>
<td>제목</td>
<td>카테고리</td>
<td>가격</td>
</tr>
</thead>
<tbody>
<c:forEach var="row" items="${bookList}">
<tr>
<td>
<a href="/SpringBasicProject/detail?idx=${row.idx}">
${row.subject}
</a>
</td>
<td>${row.category}</td>
<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price}" /></td>
</tr>
</c:forEach>
</tbody>
</table>
<p>
<a href="/create">생성</a>
</p>
</body>
</html>