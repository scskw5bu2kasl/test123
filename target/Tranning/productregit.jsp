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
      <h1>商品登録画面</h1>
      <FORM method="POST" action="Control">
        商品名 : <INPUT type="text" name="product_name"><br><br>
        商品分類 : <INPUT type="text" name="product_class"><br><br>
        型番 : <INPUT type=text name="model_num"><br><br>
        単価 : <INPUT type=text name="tanka"><br><br>
        <BR><BR>
        <INPUT TYPE="submit" name="productRegit" value="REGIT">
        <INPUT TYPE="reset" value="リセット">
      </FORM>
    </body>

    </html>
