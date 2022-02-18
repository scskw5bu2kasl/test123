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
          <h1>商品一覧</h1>
          <div class="btnRight">
            <button type="button"
              onclick="location.href='https://scske5bu2ka-appservice.azurewebsites.net/authok.jsp'">戻る</button>
          </div>
        </div>
      </head>

      <body>
        <FORM method="POST" action="Control">
          <h2>検索条件</h2>
          商品コード：<input type="text" name="conditionPdcCd" value="${conditionPdcCd}">&nbsp;&nbsp;
          商品分類：<input type="text" name="conditionPdcClass" value="${conditionPdcClass}">
          <br />
          <hr /><br />
          <table border="1">
            <tr>
              <th>商品コード
              </th>
              <th>商品名
              </th>
              <th>単価
              </th>
            </tr>
            <c:forEach var="obj" items="${data}" varStatus="count">
              <tr>
                <td>
                  <a
                    href="https://scske5bu2ka-appservice.azurewebsites.net/productDetail.jsp?productCd=${obj.productCd}&productNm=${obj.productNm}&productClass=${obj.productClass}&modelNum=${obj.modelNum}&tanka=${obj.tanka}">
                    <c:out value="${obj.productCd}" />
                  </a>
                </td>
                <td>
                  <c:out value="${obj.productNm}" />
                </td>
                <td>
                  <c:out value="${obj.tanka}" /><BR />
                </td>
              </tr>
            </c:forEach>
          </table>
          <BR><BR>
          <INPUT type="submit" name="productIchiran" value="Search">
        </FORM>
      </body>

      </html>
