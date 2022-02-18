 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html xmlns="http://www.w3c.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:p="http://primefaces.org/ui">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
  </head>
  <body>
    <h2>Login Page</h2>
    <FORM method="POST" action="Control">
      UserName : <INPUT type="text" name="username"><br><br>
      Password : <INPUT type="password" name="password"><br><br>
      <INPUT type="submit" name="pagename" value="SEND">
      <INPUT type="reset" value="RESET">
    </FORM>
  </body>
</html>
