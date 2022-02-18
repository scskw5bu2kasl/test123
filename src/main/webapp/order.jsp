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

    <h1>注文</h1>
    <TABLE align="center" border="1" width="10">
      <CAPTION align="TOP">
        <jsp:getProperty name="userbeanses" property="aName" /> さんの注文リスト<br/><br/>
          <c:forEach var="product" items="${product}">
               <c:out value="${product}"/><br/>
          </c:forEach>
      </CAPTION>
    </TABLE>
    <BR><BR>
    <A HREF="./Control">ログインに戻る</A>
  </body>
</html>