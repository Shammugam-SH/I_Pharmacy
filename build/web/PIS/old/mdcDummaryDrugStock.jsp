<%-- 
    Document   : mdcDummaryDrugStock
    Created on : Apr 28, 2017, 12:55:23 PM
    Author     : Shammugam
--%>

<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Config.Config"%>
<%@page import="dBConn.Conn"%>
<%@page import="main.RMIConnector"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conn conn = new Conn();
    String hfc = session.getAttribute("HEALTH_FACILITY_CODE").toString();
    String dis = session.getAttribute("DISCIPLINE_CODE").toString();
    String sub = session.getAttribute("SUB_DISCIPLINE_CODE").toString();
%>
<div class="thumbnail">
    <h4 style="padding-top: 0px; padding-bottom: 30px;">Medicine's List With Limited Stock (Less Than 100 Quantity)</h4>
    <hr class="pemisah" />
    <div style="height: 250px; overflow: auto; margin-top:-30px; padding-top: 30px;">    
        <table class="table table-striped"  width="30%" style="margin-bottom: 0px; margin-top:-30px;">
            <thead>
                <tr >
                    <th style="color: #999; font-weight: 500;" > Drug Name</th>
                    <th style="color: #999; font-weight: 500;" > Drug Stock </th>
                </tr>
            </thead>
            <tbody>

                <%                    String sqlMDCStock = "SELECT UD_MDC_CODE,D_TRADE_NAME,D_STOCK_QTY FROM pis_mdc2 "
                        + "WHERE D_STOCK_QTY < '100' AND hfc_cd = '" + hfc + "' AND discipline_cd = '" + dis + "' ";
                    ArrayList<ArrayList<String>> dataMDCStock = conn.getData(sqlMDCStock);

                    int sizeStock = dataMDCStock.size();
                    for (int i = 0; i < sizeStock; i++) {

                        int stockValue = Integer.parseInt(dataMDCStock.get(i).get(2).toString());

                        if (stockValue < 101 && stockValue > 0) {

                %>
                <tr >
                    <td style="font-weight: bolder;" align="center"><%= dataMDCStock.get(i).get(1)%> [<%= dataMDCStock.get(i).get(0)%>]</td>
                    <td style="color:#f9c851;font-weight: bolder;" align="center"><%= dataMDCStock.get(i).get(2)%></td>
                </tr>
                <%
                } else {
                %>
                <tr>
                    <td style="font-weight: bolder;" align="center"><%= dataMDCStock.get(i).get(1)%> [<%= dataMDCStock.get(i).get(0)%>]</td>
                    <td style="color:red;font-weight: bolder;" align="center"><%= dataMDCStock.get(i).get(2)%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
    <div style="position: absolute; color: #999; top: 65px; right: 30px; font-weight: 500; text-transform: uppercase">Total Medicine : <%= sizeStock%></div>
</div>
