package webApplication27;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.net.URLEncoder;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control extends HttpServlet {
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = null;
        rd = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (Objects.equals(request.getParameter("pagename"), "SEND") == true) {
            webApplication27.UserBean ub = null;
            ub = new webApplication27.UserBean();

            String formun = request.getParameter("username");
            String formps = request.getParameter("password");
            ub.setaName(formun);
            ub.setPassword(formps);

            webApplication27.UserAuthBean uab = null;
            uab = new webApplication27.UserAuthBean();

            HttpSession session = null;
            RequestDispatcher rd = null;

            if (uab.execute(ub) == true) {
                if (checkSession(request) == true) {
                    session = request.getSession(false);
                } else {
                    session = request.getSession(true);
                }
                session.setAttribute("userbeanses", ub);

                ub.setaName(formun);
                rd = getServletConfig().getServletContext().getRequestDispatcher("/authok.jsp");
            } else {
                // 隱崎ｨｼ縺ｫ螟ｱ謨�
                rd = getServletConfig().getServletContext().getRequestDispatcher("/autherror.jsp");
            }
            rd.forward(request, response);
        } else if (Objects.equals(request.getParameter("pagename"), "REGIT") == true) {
            regitUser(request, response);
        } else if (Objects.equals(request.getParameter("productRegit"), "REGIT") == true) {
            productRegit(request, response);
        } else if (Objects.equals(request.getParameter("productIchiran"), "Search") == true) {
            searchProduct(request, response);
        } else if (Objects.equals(request.getParameter("budgetSearch"), "Search") == true) {
            searchBudget(request, response);
        } else {
        }
    }

    // 繝ｦ繝ｼ繧ｶ逋ｻ骭ｲ
    private void regitUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String connectionUrl = "jdbc:sqlserver://scsknishi5bu2kasampleworkspace.sql.azuresynapse.net:1433;database=scskW5bu2kasl2;user=sqladminuser@scsknishi5bu2kasampleworkspace;password=Welcome1;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.sql.azuresynapse.net;loginTimeout=30;";

        ResultSet resultSet = null;
        String userName = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP (100) [EMPLOYEE_CD]\r\n" + ",[EMPLOYEE_NM]\r\n" + " FROM [dbo].[EMPLOYEE]";
            resultSet = statement.executeQuery(selectSql);
            // Print results from select statement
            while (resultSet.next()) {
                userName = resultSet.getString("EMPLOYEE_NM");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 商品検索
    private void searchProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String connectionUrl = "jdbc:sqlserver://scsknishi5bu2kasampleworkspace.sql.azuresynapse.net:1433;database=scskW5bu2kasl2;user=sqladminuser@scsknishi5bu2kasampleworkspace;password=Welcome1;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.sql.azuresynapse.net;loginTimeout=30;";
        ResultSet resultSet = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();

            String conditionPdcCd = request.getParameter("conditionPdcCd");
            String conditionPdcClass = new String(request.getParameter("conditionPdcClass").getBytes("ISO-8859-1"));
            // String conditionPdcClass = request.getParameter("conditionPdcClass");
            // String conditionPdcClass =
            // URLDecoder.decode(URLEncoder.encode(conditionPdcClassTemp, "UTF-8");

            request.setAttribute("conditionPdcCd", conditionPdcCd);
            request.setAttribute("conditionPdcClass", conditionPdcClass);

            String selectSql = "SELECT [PRD_CD]" + ",[PRD_CLASS]" + ",[MODEL_NUM]" + ",[PRD_NM]" + ",[TANKA]"
                    + "FROM [dbo].[PRODUCT]";
            if ((null != conditionPdcCd) && !"".equals(conditionPdcCd)) {
                selectSql = selectSql + "WHERE [PRD_CD] = '" + conditionPdcCd + "'";
                if ((null != conditionPdcClass) && !"".equals(conditionPdcClass)) {
                    selectSql = selectSql + "AND [PRD_CLASS] = '" + conditionPdcClass + "'";
                }
            } else if ((null != conditionPdcClass) && !"".equals(conditionPdcClass)) {
                selectSql = selectSql + "WHERE [PRD_CLASS] = '" + conditionPdcClass + "'";
            }
            selectSql = selectSql + "ORDER BY [PRD_CD]";
            resultSet = statement.executeQuery(selectSql);

            ProductBean bean = null;
            List<ProductBean> list = new ArrayList<ProductBean>();
            String productCd = null;
            String productNm = null;
            String productClass = null;
            String modelNum = null;
            String tanka = null;
            // Print results from select statement
            while (resultSet.next()) {
                bean = new ProductBean();
                productCd = resultSet.getString("PRD_CD");
                productNm = resultSet.getString("PRD_NM");
                productClass = resultSet.getString("PRD_CLASS");
                modelNum = resultSet.getString("MODEL_NUM");
                tanka = resultSet.getString("TANKA");
                bean.setProductCd(productCd);
                bean.setProductNm(productNm);
                bean.setProductClass(productClass);
                bean.setModelNum(modelNum);
                bean.setTanka(tanka);
                list.add(bean);
            }

            request.setAttribute("data", list);
            RequestDispatcher rd = null;
            rd = getServletConfig().getServletContext().getRequestDispatcher("/product.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 予算検索
    private void searchBudget(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String connectionUrl = "jdbc:sqlserver://scsknishi5bu2kasampleworkspace.sql.azuresynapse.net:1433;database=scskW5bu2kasl2;user=sqladminuser@scsknishi5bu2kasampleworkspace;password=Welcome1;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.sql.azuresynapse.net;loginTimeout=30;";
        ResultSet resultSet = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();

            String conditionOrgCd = request.getParameter("conditionOrgCd");
            String conditionPdcCd = request.getParameter("conditionPdcCd");

            request.setAttribute("conditionOrgCd", conditionOrgCd);
            request.setAttribute("conditionPdcCd", conditionPdcCd);

            String selectSql = "SELECT TOP (100) [SEQ]" + ",[ORG_CD]" + ",[PRD_CD]" + ",[YOSAN_YM]" + ",[AMOUNT]"
                    + ",[FUNC_ID]" + " FROM [dbo].[BUDGET]";
            if ((null != conditionOrgCd) && !"".equals(conditionOrgCd)) {
                selectSql = selectSql + "WHERE [ORG_CD] = '" + conditionOrgCd + "'";
                if ((null != conditionPdcCd) && !"".equals(conditionPdcCd)) {
                    selectSql = selectSql + "AND [PRD_CD] = '" + conditionPdcCd + "'";
                }
            } else if ((null != conditionPdcCd) && !"".equals(conditionPdcCd)) {
                selectSql = selectSql + "WHERE [PRD_CD] = '" + conditionPdcCd + "'";
            }
            selectSql = selectSql + "ORDER BY [ORG_CD]";
            resultSet = statement.executeQuery(selectSql);

            BudgetBean bean = null;
            List<BudgetBean> list = new ArrayList<BudgetBean>();
            String orgCd = null;
            String pdcCd = null;
            String yosanYm = null;
            String amount = null;
            // Print results from select statement
            while (resultSet.next()) {
                bean = new BudgetBean();
                orgCd = resultSet.getString("ORG_CD");
                pdcCd = resultSet.getString("PRD_CD");
                yosanYm = resultSet.getString("YOSAN_YM");
                amount = resultSet.getString("AMOUNT");
                bean.setOrgCd(orgCd);
                bean.setPdcCd(pdcCd);
                bean.setYosanYm(yosanYm);
                bean.setAmount(amount);
                list.add(bean);
            }

            request.setAttribute("data", list);
            RequestDispatcher rd = null;
            rd = getServletConfig().getServletContext().getRequestDispatcher("/budget.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 商品登録
    private void productRegit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String connectionUrl = "jdbc:sqlserver://scsknishi5bu2kasampleworkspace.sql.azuresynapse.net:1433;database=scskW5bu2kasl2;user=sqladminuser@scsknishi5bu2kasampleworkspace;password=Welcome1;encrypt=false;trustServerCertificate=false;hostNameInCertificate=*.sql.azuresynapse.net;loginTimeout=30;";
        ResultSet resultSet = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();

            String selectSql = "SELECT MAX([PRD_CD]) AS MAX_PRD_CD FROM [dbo].[PRODUCT]";
            resultSet = statement.executeQuery(selectSql);

            String productCd = null;
            while (resultSet.next()) {
                productCd = String.valueOf(Integer.parseInt(resultSet.getString("MAX_PRD_CD")) + 1);
                productCd = String.format("%5s", productCd).replace(" ", "0");
            }

            String productName = request.getParameter("product_name");
            String productClass = request.getParameter("product_class");
            String modelNum = request.getParameter("model_num");
            String tanka = request.getParameter("tanka");

            // Create and execute a SELECT SQL statement.
            String insertSql = "INSERT INTO [dbo].[PRODUCT]  VALUES\r\n" + "        ('" + productCd + "', '"
                    + productName + "', '" + productClass + "','" + modelNum + "','" + tanka + "');";
            int regitnum = statement.executeUpdate(insertSql);

            request.setAttribute("regitnum", regitnum);

            RequestDispatcher rd = null;
            //rd = getServletConfig().getServletContext().getRequestDispatcher("/regitcomp.jsp");
            //rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Returns a short description of the servlet. */
    public String getServletInfo() {
        return "Short description";
    }

    // 繧ｻ繝�繧ｷ繝ｧ繝ｳ繧ｪ繝悶ず繧ｧ繧ｯ繝医�ｮ繝√ぉ繝�繧ｯ繝｡繧ｽ繝�繝�
    public boolean checkSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            return true;
        } else {
            return false;
        }
    }
}
