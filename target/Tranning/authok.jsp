<%@page contentType="text/html" %>
  <%@page pageEncoding="UTF-8" %>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <jsp:useBean id="userbeanses" scope="session" class="webApplication27.UserBean" />
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>JSP Page</title>
    </head>

    <body>
      <h1>メイン画面</h1>
      <p>
        <jsp:getProperty name="userbeanses" property="aName" /> さん、ようこそ!!
      </p>

      <FORM name="form1" method="POST" action="Control">
        <a href="product.jsp">商品一覧</a><br />
        <a href="productregit.jsp">商品登録</a><br />
        <a href="budget.jsp">予算検索</a><br />
        <a href="autherror.jsp">実績検索(未完成)</a>
    </body>

    </html>
