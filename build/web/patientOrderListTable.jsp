<%-- 
    Document   : patientOrderListTable
    Created on : Feb 7, 2017, 12:19:40 PM
    Author     : Shammugam
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="dBConn.Conn"%>
<%@page import="main.RMIConnector"%>

<%
    Conn conn = new Conn();
%>

<h4 style="padding-top: 2%;padding-bottom: 1%;">Patient Information</h4>

<table  id="patientOrderListTable"  class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <th>Order No.</th>
    <th>PMI No.</th>
    <th>Name</th>
    <th>Order Date</th>
    <th>Health Facility Code</th>
    <th>Doctor's Name</th>
    <th>Action</th>
</thead>
<tbody>

    <%
        String sql = "SELECT ORDER_NO,PMI_NO,HEALTH_FACILITY_CODE,EPISODE_CODE,ENCOUNTER_DATE,ORDER_DATE,ORDER_BY,ORDER_FROM,ORDER_TO,HFC_FROM,HFC_TO,SPUB_NO,KEYIN_BY,TOTAL_ORDER,STATUS,PATIENT_NAME,NEW_IC_NO,BIRTH_DATE,SEX_CODE,BLOOD_TYPE FROM pis_order_master JOIN pms_patient_biodata USING (PMI_NO) WHERE STATUS = 0;";
        ArrayList<ArrayList<String>> dataPatientOrderList = conn.getData(sql);

        int size = dataPatientOrderList.size();
        for (int i = 0; i < size; i++) {
    %>

    <tr>
<input id="dataPatientOrderListhidden" type="hidden" value="<%=String.join("|", dataPatientOrderList.get(i))%>">
<td><%= dataPatientOrderList.get(i).get(0)%></td>
<td><%= dataPatientOrderList.get(i).get(1)%></td>
<td><%= dataPatientOrderList.get(i).get(15)%></td>
<td><%= dataPatientOrderList.get(i).get(5)%></td>
<td><%= dataPatientOrderList.get(i).get(2)%></td>
<td><%= dataPatientOrderList.get(i).get(6)%></td>
<td>
    <!-- Delete Button Start -->
    <a id="moveToOrderDetailsTButton" ><i class="fa fa-arrow-right fa-2x" aria-hidden="true" style="display: inline-block;" ></i></a>
    <!-- Delete Button End -->
</td>
</tr>
<%
    }
%>
</tbody>
</table>


<script type="text/javascript" >


    $('#patientOrderListContent').off('click', '#patientOrderListTable #moveToOrderDetailsTButton').on('click', '#patientOrderListTable #moveToOrderDetailsTButton', function (e) {

        e.preventDefault();

        var row = $(this).closest("tr");
        var rowData = row.find("#dataPatientOrderListhidden").val();
        var arrayData = rowData.split("|");
        console.log(arrayData);

        //Assign Array into seprated val
        var patientpmino = arrayData[1];
        var patientName = arrayData[15];
        var patientnic = arrayData[16];
        var patientGender = arrayData[18];
        var patientBdate = arrayData[17];
        var patientBtype = arrayData[19];
        var patientOrderNo = arrayData[0];
        var patientOrderDate = arrayData[5];
        var patientOrderLocationCode = arrayData[2];


        //Set value to the Second Tab 
        $("#patientpmino").val(patientpmino);
        $("#patientName").val(patientName);
        $("#patientnic").val(patientnic);
        $("#patientGender").val(patientGender);
        $("#patientBdate").val(patientBdate);
        $("#patientBtype").val(patientBtype);
        $("#patientOrderNo").val(patientOrderNo);
        $("#patientOrderDate").val(patientOrderDate);
        $("#patientOrderLocationCode").val(patientOrderLocationCode);

        loadOrder(patientOrderNo);

    });


    function loadOrder(orderNo) {

        var data = {
            orderNo: orderNo
        };

        $.ajax({
            url: "patientOrderListDetails.jsp",
            type: "post",
            data: data,
            timeout: 3000,
            success: function (returnOrderDetailsTableHTML) {
                console.log(returnOrderDetailsTableHTML);
                $('#patientOrderDetailsListTable').html(returnOrderDetailsTableHTML);
                $('.nav-tabs a[href="#tab_default_2"]').tab('show');
            }
        });

    }


    $('#patientOrderDetailContent').off('click', '#patientOrderDetailsListTable #moveToOrderDispenseDetailsTButton').on('click', '#patientOrderDetailsListTable #moveToOrderDispenseDetailsTButton', function (e) {

        e.preventDefault();

        var row = $(this).closest("tr");
        var rowData = row.find("#dataPatientOrderDetailsListhidden").val();
        var arrayData = rowData.split("|");
        console.log(arrayData);

        var orderNo = arrayData[0];
        var orderProductCode = arrayData[1];

        dispenceDetail(orderNo, orderProductCode);

    });

    function dispenceDetail(orderNo, orderProductCode) {

        var data = {
            orderNo: orderNo,
            orderProductCode: orderProductCode
        };

        $.ajax({
            url: "patientOrderListDetailsDespense.jsp",
            type: "post",
            data: data,
            timeout: 3000,
            success: function (returnOrderDetailsTableHTML) {
                console.log(returnOrderDetailsTableHTML);
                $('#patientOrderDetailsListDispenseTable').html(returnOrderDetailsTableHTML);
            }
        });
    }
    
     $('#patientOrderDetailContent').on('click', '#btnClearOrderDetailDispense', function (e) {
        document.getElementById("patientOrderDetailContentBasicInfoForm").reset();
        document.getElementById("patientOrderDetailContentOrderInfoForm").reset();
        $( "#patientOrderDetailContent #patientOrderDetailsListTableDiv" ).load( "patientOrderListBasicInfo.jsp #patientOrderDetailsListTableDiv" );
        $( "#patientOrderDetailContent #patientOrderDetailsListDispenseTableDiv" ).load( "patientOrderListBasicInfo.jsp #patientOrderDetailsListDispenseTableDiv" );
    });
    
</script>



<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {
        $('#patientOrderListTable').DataTable();
    });
</script>

