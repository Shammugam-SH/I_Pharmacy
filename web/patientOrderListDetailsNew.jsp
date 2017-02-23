<%-- 
    Document   : patientOrderListDetailsNew
    Created on : Feb 15, 2017, 1:13:37 PM
    Author     : Shammugam
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="dBConn.Conn"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conn conn = new Conn();
    String orderNo = request.getParameter("orderNo");

    NumberFormat formatter = new DecimalFormat("#0.00");

    String orderList = "select ORDER_NO,DRUG_ITEM_CODE,DRUG_ITEM_DESC,DRUG_FREQUENCY,DRUG_ROUTE,DRUG_FORM,DRUG_STRENGTH,"
            + "DRUG_DOSAGE,ORDER_OUM,DURATION,ORDER_STATUS,QTY_ORDERED,QTY_SUPPLIED,SUPPLIED_OUM,QTY_DISPENSED,"
            + "DISPENSE_OUM,pis_order_detail.STATUS,DURATIONT,D_STOCK_QTY,D_SELL_PRICE,"
            + "CASE ORDER_STATUS WHEN '0' THEN 'New' WHEN '1' THEN 'Partial' WHEN '2' THEN 'Complete Partial' WHEN '3' THEN 'Full Complete' WHEN '4' THEN 'Full' END  AS ORDER_STATUSCON"
            + " FROM pis_order_detail "
            + "JOIN pis_mdc2 ON (pis_order_detail.DRUG_ITEM_CODE = pis_mdc2.UD_MDC_CODE) "
            + "where ORDER_NO = '" + orderNo + "' AND (ORDER_STATUS='0' OR ORDER_STATUS='1')  ";

 
    String orderTotal = "select COUNT(ORDER_NO),SUM((D_SELL_PRICE * QTY_DISPENSED)) from pis_order_detail "
            + "join pis_mdc2 on (pis_order_detail.DRUG_ITEM_CODE = pis_mdc2.UD_MDC_CODE) "
            + "where ORDER_NO = '" + orderNo + "' AND (ORDER_STATUS='0' OR ORDER_STATUS='1') ";

    ArrayList<ArrayList<String>> dataOrderList;
    dataOrderList = conn.getData(orderList);



    ArrayList<ArrayList<String>> dataOrderTotal;
    dataOrderTotal = conn.getData(orderTotal);

%>

<table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; width: 100%; text-align: center" id="patientOrderDetailsListTable">
    <thead>
    <th>Order No</th>
    <th>Code</th>
    <th>Description</th>
    <th>Strength</th>
    <th>Frequency</th>
    <th>Duration</th>
    <th>Dose</th>
    <th>Price/Pack</th>
    <th>Stock Qty</th>
    <th>Ordered Qty</th>
    <th>Supplied Qty</th>
    <th>Dispensed Qty</th>
<!--    <th>Total Price (RM)</th>-->
    <th>Status</th>
</thead>
<tbody>
    <%        for (int i = 0; i < dataOrderList.size(); i++) {

    %>
    <tr id="updateOrderDetailsTButton" data-status="pagado" data-toggle="modal" data-id="1" data-target="#updateOrder">
<input id="dataPatientOrderDetailsListhidden" type="hidden" value="<%=String.join("|", dataOrderList.get(i))%>">
<td ><%= dataOrderList.get(i).get(0)%></td> <!-- Order No -->
<td ><%= dataOrderList.get(i).get(1)%></td> <!-- Code -->
<td ><%= dataOrderList.get(i).get(2)%></td> <!-- Description -->
<td ><%= dataOrderList.get(i).get(6)%></td> <!-- Strength -->
<td ><%= dataOrderList.get(i).get(3)%></td> <!-- Frequency -->
<td ><%= dataOrderList.get(i).get(9)%> <%= dataOrderList.get(i).get(17)%></td> <!-- Duration/Duration T -->
<td ><%= dataOrderList.get(i).get(7)%></td> <!-- Dose -->
<td ><%= dataOrderList.get(i).get(19)%></td> <!-- Price -->
<td ><%= dataOrderList.get(i).get(18)%></td> <!-- Stock -->
<td ><%= dataOrderList.get(i).get(11)%></td> <!-- Ordered -->
<td ><%= dataOrderList.get(i).get(12)%></td> <!-- Supplied -->
<td ><%= dataOrderList.get(i).get(14)%></td> <!-- Dispensed -->
<!--<td ><//%= formatter.format(Double.parseDouble(dataOrderList.get(i).get(14)) * Double.parseDouble(dataOrderList.get(i).get(19)))%></td>  Total -->
<td ><%= dataOrderList.get(i).get(20)%></td> <!-- Status -->
</tr>


<%  }
%>


</tbody>
</table>