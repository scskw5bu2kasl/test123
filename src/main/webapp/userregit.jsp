<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="userbeanses" scope="session" class="webApplication27.UserBean" />
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>ユーザ登録画面</h1>
    <P><jsp:getProperty name="userbeanses" property="aName" /> さん！商品を選んでね</P>
    <FORM method="POST" action="Control">
      USER_NAME_EN_F : <INPUT type="text" name="username_en_f"><br><br>
      USER_NAME_EN_L : <INPUT type="text" name="username_en_l"><br><br>
      USER_NAME_EN_M : <INPUT type=text name="username_en_m"><br><br>
      <BR><BR>
      <INPUT TYPE="submit" name="pagename" value="REGIT">
      <INPUT TYPE="reset" value="リセット">
    </FORM>
  </body>
</html>