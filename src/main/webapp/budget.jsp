<%@page contentType="text/html" %>
  <%@page pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <jsp:useBean id="userbeanses" scope="session" class="webApplication27.UserBean" />
      <html>

      <style>
        div.btnLeft {
          text-align: left;
          float: left;
        }

        div.btnRight {
          text-align: right;
        }
      </style>

      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <div>
          <h1>予算検索</h1>
          <div class="btnRight">
            <button type="button" onclick="history.back()">戻る</button>
          </div>
        </div>
      </head>

      <body>
        <FORM method="POST" action="Control">
          <h2>検索条件</h2>
          組織コード：<input type="text" name="conditionOrgCd" value="${conditionOrgCd}">&nbsp;&nbsp;
          商品コード：<input type="text" name="conditionPdcCd" value="${conditionPdcCd}">
          <br />
          <hr /><br />
          <table border="1">
            <tr>
              <th>組織コード
              </th>
              <th>商品コード
              </th>
              <th>予算月
              </th>
              </th>
              <th>予算額
              </th>
            </tr>
            <c:forEach var="obj" items="${data}" varStatus="count">
              <tr>
                <td>
                  <c:out value="${obj.orgCd}" />
                </td>
                <td>
                  <c:out value="${obj.pdcCd}" />
                </td>
                <td>
                  <c:out value="${obj.yosanYm}" />
                </td>
                <td>
                  <c:out value="${obj.amount}" /><BR />
                </td>
              </tr>
            </c:forEach>
          </table>
          <BR><BR>
          <INPUT type="submit" name="budgetSearch" value="Search">
        </FORM>
      </body>

      </html>
