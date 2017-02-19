<%-- 
    Document   : patientOrderListBasicInfo
    Created on : Feb 7, 2017, 2:44:32 PM
    Author     : Shammugam
--%>

<div class="thumbnail">
    <h4>Basic Info</h4>
    <hr/>
    <form class="form-horizontal" name="patientOrderDetailContentBasicInfoForm" id="patientOrderDetailContentBasicInfoForm">
        <div class="row">

            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient PMI No.</label>
                    <div class="col-md-8">
                        <input id="patientpmino" name="patientpmino" type="text" placeholder="" readonly class="form-control input-md">   
                    </div>
                </div>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient Name</label>
                    <div class="col-md-8">
                        <input id="patientName" name="patientName" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>


            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient New IC No.</label>
                    <div class="col-md-8">
                        <input id="patientnic" name="patientnic" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>
                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient Gender</label>
                    <div class="col-md-8">
                        <input id="patientGender" name="patientGender" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>


            <div class="col-md-4">

                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient Birthday Date</label>
                    <div class="col-md-8">
                        <input id="patientBdate" name="patientBdate" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>
                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Patient Blood Type</label>
                    <div class="col-md-8">
                        <input id="patientBtype" name="patientBtype" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>


        </div>
    </form>
</div>



<div class="thumbnail">
    <h4>Order Info</h4>
    <hr/>
    <form class="form-horizontal" name="patientOrderDetailContentOrderInfoForm" id="patientOrderDetailContentOrderInfoForm">
        <div class="row">

            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Order Received No.</label>
                    <div class="col-md-8">
                        <input id="patientOrderNo" name="patientOrderNo" type="text" placeholder=" " readonly class="form-control input-md">   
                    </div>
                </div>

            </div>


            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Order Received Date</label>
                    <div class="col-md-8">
                        <input id="patientOrderDate" name="patientOrderDate" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>


            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Order Location Code</label>
                    <div class="col-md-8">
                        <input id="patientOrderLocationCode" name="patientOrderLocationCode" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>


        </div>
    </form>
</div>


<div class="thumbnail">
    <h4>List of Order</h4>
    <div id="patientOrderDetailsListTableDiv" class="form-group">


        <table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; width: 100%" id="patientOrderDetailsListTable">
            <thead>
            <th>Order No</th>
            <th>Code</th>
            <th>Description</th>
            <th>Strength</th>
            <th>Frequency</th>
            <th>Duration</th>
            <th>Duration Type</th>
            <th>Dose</th>
            <th>Ordered Qty</th>
            <th>Stock Qty</th>
            <th>Dispense Qty</th>
            <th>Price/Pack</th>
            <th>Total Price</th>
            <th>Status</th>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>

    <div class="text-center" id="patientOrderDispenseButtonDiv"> 
        <button class="btn btn-success " type="button" id="btnOrderDispense" name="btnOrderDispense" > <i class="fa fa- fa-lg"></i>&nbsp; Dispense</button>
    </div>
</div>




<div class="thumbnail">
    <div class="text-center"> 
        <button class="btn btn-default " type="button" id="btnClearOrderDetailDispense" name="btnClearOrderDetailDispense" > <i class="fa fa-ban fa-lg"></i>&nbsp; Clear Screen</button>
    </div>
</div>

<script>

    // Move to Order Details Fetch Details
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

    // Move to Order Details Load Table Data
    function loadOrder(orderNo) {

        var data = {
            orderNo: orderNo
        };

        $.ajax({
            url: "patientOrderListDetailsNew.jsp",
            type: "post",
            data: data,
            timeout: 3000,
            success: function (returnOrderDetailsTableHTML) {
                //console.log(returnOrderDetailsTableHTML);
                $('#patientOrderDetailsListTable').html(returnOrderDetailsTableHTML);
                $('.nav-tabs a[href="#tab_default_2"]').tab('show');

            }
        });
    }


    // Get Order Data
    $('#patientOrderDetailContent').off('click', '#patientOrderDetailsListTable #updateOrderDetailsTButton').on('click', '#patientOrderDetailsListTable #updateOrderDetailsTButton', function (e) {

        e.preventDefault();

        var row = $(this).closest("tr");
        var rowData = row.find("#dataPatientOrderDetailsListhidden").val();
        var arrayData = rowData.split("|");
        console.log(arrayData);

        var updateOrderNo = arrayData[0];
        var updateDrugCode = arrayData[1];
        var updateOrderedQuantity = parseInt(arrayData[11]);
        var updateSuppliedDrugQuantity = parseInt(arrayData[12]);
        var updateDispensedQuantity = parseInt(arrayData[14]);
        var status = parseInt(arrayData[20]);

        $("#updateOrderNo").val(updateOrderNo);
        $("#updateDrugCode").val(updateDrugCode);
        $("#updateOrderedDrugQuantity").val(updateOrderedQuantity);
        $("#updateSuppliedDrugQuantity").val(updateSuppliedDrugQuantity);
        $("#updateDispensedDrugQuantity").val("");
        $("#updatestatus").val(status);


    });

    // Update Order Data
    $('#updateOrder').on('click', '#updateOrderMButton', function (e) {

        e.preventDefault();



        var ORDER_NO = $("#updateOrderNo").val();
        var DRUG_ITEM_CODE = $("#updateDrugCode").val();
        var QTY_ORDERED = $("#updateOrderedDrugQuantity").val();
        var QTY_DISPENSED = $("#updateDispensedDrugQuantity").val();
        var ORDER_STATUS = $("#updatestatus").val();


        if (QTY_DISPENSED === "") {
            alert("Enter Dispense Qty");
        } else if (ORDER_STATUS === "") {
            alert("Select A Order Status");
        } else {

            var data = {
                ORDER_NO: ORDER_NO,
                DRUG_ITEM_CODE: DRUG_ITEM_CODE,
                QTY_ORDERED: QTY_ORDERED,
                QTY_DISPENSED: QTY_DISPENSED,
                ORDER_STATUS: ORDER_STATUS
            };

            var dataOrderNo = {
                orderNo: ORDER_NO
            };

            var dataDispence = {
                orderNo: ORDER_NO,
                orderProductCode: DRUG_ITEM_CODE
            };

            console.log(data);
            console.log(dataOrderNo);
            console.log(dataDispence);

            $.ajax({
                url: "patientOrderListDetailsDispenceUpdateNew.jsp",
                type: "post",
                data: data,
                timeout: 3000,
                success: function (datas) {
                    if (datas.trim() === 'Success') {

                        $.ajax({
                            url: "patientOrderListDetailsNew.jsp",
                            type: "post",
                            data: dataOrderNo,
                            timeout: 3000,
                            success: function (returnOrderDetailsTableHTML) {

                                console.log(returnOrderDetailsTableHTML);

                                $('#patientOrderDetailsListTable').html(returnOrderDetailsTableHTML);
                                $('#updateOrder').modal('hide');

                            }
                        });

                    } else if (datas.trim() === 'Failed') {
                        alert("Update Failed");
                    }
                },
                error: function (err) {
                    alert("Error update!");
                }

            });
        }




    });

    // Dispense Order Data
    $('#patientOrderDetailContent').off('click', '#patientOrderDispenseButtonDiv #btnOrderDispense').on('click', '#patientOrderDispenseButtonDiv #btnOrderDispense', function (e) {

        e.preventDefault();

        var row = $("#patientOrderDetailsListTable");
        var rowData = row.find("#dataPatientOrderDetailsListhidden").val();
        var rowDataArray = row.find("#dataPatientOrderDetailsListhiddenArray").val();
        console.log(rowData);
        console.log(rowDataArray);



        var table = $("#patientOrderDetailsListTable tbody");

        var data = new Array();
        var dataIn  = new Array();
        var productId, product;
        var dataAjax;

        table.find('tr').each(function (i) {

            var $tds = $(this).find('td');
            dataIn = new Array();

            productId = $tds.eq(0).text();
            product = $tds.eq(1).text();
            // do something with productId, product, Quantity
          
            dataIn.push(productId);
            dataIn.push(product);
            
            dataAjax = {
                id : productId,
                type : product
            };
            
            console.log(dataAjax);
            data.push(dataIn);
            
        });

        console.log(data);
        




//for (row = 0; row < rowDataArray.length ; row++) {
//    console.log(row);
//}


//        var patientpmino = $("#patientpmino").val();
//        var patientName = $("#patientName").val();
//        var patientnic = $("#patientnic").val();
//        var patientGender = $("#patientGender").val();
//        var patientBdate = $("#patientBdate").val();
//        var patientBtype = $("#patientBtype").val();
//
//        var patientOrderNo = $("#patientOrderNo").val();
//        var patientOrderDate = $("#patientOrderDate").val();
//        var patientOrderLocationCode = $("#patientOrderLocationCode").val();
//
//        var data = {
//            patientpmino: patientpmino,
//            patientName: patientName,
//            patientnic: patientnic,
//            patientGender: patientGender,
//            patientBdate: patientBdate,
//            patientBtype: patientBtype,
//            patientOrderNo: patientOrderNo,
//            patientOrderDate: patientOrderDate,
//            patientOrderLocationCode: patientOrderLocationCode
//        };
//
//        console.log(data);

    });




</script>