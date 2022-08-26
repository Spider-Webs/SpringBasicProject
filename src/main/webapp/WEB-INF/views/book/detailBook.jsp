<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
 <head>
  <title>책 상세</title>
 </head>
 <body>
  <h1>책 상세</h1>
  <p>제목 : ${ book.subject } </p>
  <p>카테고리 : ${ book.category }</p>
  <p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${book.price}" /></p>


  <p>
   <a href="/list">목록으로</a>
  </p>
 </body>
</html>