<%-- 
    Document   : patientOrderListDetailsDespense
    Created on : Feb 8, 2017, 2:46:06 PM
    Author     : Shammugam
--%>


<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="dBConn.Conn"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Conn conn = new Conn();
    String orderNo = request.getParameter("orderNo");
    String orderProductCode = request.getParameter("orderProductCode");

    String orderList = "select * from pis_order_detail where ORDER_NO = '" + orderNo + "' and DRUG_ITEM_CODE = '" + orderProductCode + "' ";
    ArrayList<ArrayList<String>> dataOrderDispenseList;
    dataOrderDispenseList = conn.getData(orderList);

%>

<table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; " id="patientOrderDetailsListDispenseTable">
    <thead>
    <th>Order No</th>
    <th>Drug Code</th>
    <th>Drug Description</th>
</thead>
<tbody>
    <%        for (int i = 0; i < dataOrderDispenseList.size(); i++) {

    %>
    <tr id="moveToDispenseTButton" data-status="pagado" data-toggle="modal" data-id="1" data-target="#type">
<input id="dataPatientOrderDetailsListDispensehidden" type="hidden" value="<%=String.join("|", dataOrderDispenseList.get(i))%>">
<td ><%=dataOrderDispenseList.get(i).get(0)%></td>
<td ><%=dataOrderDispenseList.get(i).get(1)%></td>
<td ><%=dataOrderDispenseList.get(i).get(2)%></td>
</tr>
<%  }
%>
</tbody>
</table>