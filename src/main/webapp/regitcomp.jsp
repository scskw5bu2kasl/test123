<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userbeanses" scope="session" class="webApplication27.UserBean" />
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book online</title>
  </head>
  <body>

    <h1>登録完了</h1>
    <c:out value="${regitnum}" />件を登録しました。
    <BR><BR>
    <A HREF="https://scske5bu2ka-appservice.azurewebsites.net/product.jsp">一覧画面</A>
  </body>
</html>
