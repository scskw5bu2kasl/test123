<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" %>
  <%@page pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
      <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
        <html xmlns="http://www.w3c.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html"
          xmlns:f="http://java.sun.com/jsf/core" xmlns:p="http://primefaces.org/ui">

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
          <title>Product Detail</title>
          <div>
            <h2>商品詳細</h2>
            <div class="btnRight">
              <button type="button" onclick="history.back()">戻る</button>
            </div>
          </div>

          <script type="text/javascript">
            function getdata() {
              if (window.location.search) {
                /* URLの「?」以降のパラメータを変数nに代入 */
                var pram = window.location.search.substring(1, window.location.search.length);
                /* 先頭の?をカット */
                pram = pram.substring(0);
                /* 「&」で引数を分割して配列に */
                var pair = pram.split("&");
                var i = temp = "";
                var key = new Array();
                for (i = 0; i < pair.length; i++) {
                  /* 配列の値を「=」で分割 */
                  temp = pair[i].split("=");
                  keyName = temp[0];
                  keyValue = temp[1];
                  /* キーと値の連想配列を生成 */
                  key[keyName] = keyValue;
                }
                /* テキストボックスにパラメータを表示 */
                document.form1.elements["productCd"].value = key["productCd"];
                document.form2.elements["productNm"].value = decodeURI(key["productNm"]);
                document.form3.elements["productClass"].value = decodeURI(key["productClass"]);
                document.form4.elements["modelNum"].value = key["modelNum"];
                document.form5.elements["tanka"].value = key["tanka"];
              }
            }
            /* オンロード時に実行 */
            window.onload = getdata;
          </script>
        </head>

        <body>
          <table border="1">
            <tr>
              <th>商品コード</th>
              <td>
                <form name="form1" action="#">
                  <input type="text" name="productCd" />
                </form>
              </td>
            </tr>
            <tr>
              <th>商品名</th>
              <td>
                <form name="form2" action="#">
                  <input type="text" name="productNm" />
                </form>
              </td>
            </tr>
            <tr>
            <tr>
              <th>商品分類</th>
              <td>
                <form name="form3" action="#">
                  <input type="text" name="productClass" />
                </form>
              </td>
            </tr>
            <tr>
            <tr>
              <th>型番</th>
              <td>
                <form name="form4" action="#">
                  <input type="text" name="modelNum" />
                </form>
              </td>
            </tr>
            <tr>
              <th>単価</th>
              <td>
                <form name="form5" action="#">
                  <input type="text" name="tanka" />
                </form>
              </td>
            </tr>
          </table>
          </FORM>
        </body>

        </html>
