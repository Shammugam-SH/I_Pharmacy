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
    <h4 style="padding-bottom: 1%">
        List of Order
        <div class="pull-right">
            <button id="patientOrderNewDrugButton" name="patientOrderNewDrugButton" class="btn btn-primary" data-toggle="modal" ><i class="fa fa-plus fa-lg"></i>&nbsp; New Order</button>
        </div>
    </h4>


    <div id="patientOrderDetailsListTableDiv" class="form-group">
        <table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; width: 100%" id="patientOrderDetailsListTable">
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

            </tbody>
        </table>
    </div>

    <div class="text-center" id="patientOrderDispenseButtonDiv"> 
        <button class="btn btn-success " type="button" id="btnOrderDispense" name="btnOrderDispense" > <i class="fa fa- fa-lg"></i>&nbsp; Dispense &nbsp;</button>
        <button class="btn btn-primary " type="button" id="btnOrderDispensePrescribe" name="btnOrderDispensePrescribe" > <i class="fa fa- fa-lg" ></i>&nbsp; Prescribe &nbsp;</button>
    </div>
</div>



<div class="thumbnail">
    <div class="text-center"> 
        <button class="btn btn-default " type="button" id="btnClearOrderDetailDispense" name="btnClearOrderDetailDispense" > <i class="fa fa-ban fa-lg"></i>&nbsp; Clear Screen</button>
    </div>
</div>

<script>


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    // Move to Order Details Fetch Details Start
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
    // Move to Order Details Fetch Details End


    // Move to Order Details Load Table Data Start
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
    // Move to Order Details Load Table Data End


//======================================================================================================================================================================================//





//------------------------------------------------------------------------------  Add Part Start  -------------------------------------------------------------------------------------//


    // Getting Order Id And Date Start
    $('#patientOrderDetailContent').off('click', '#patientOrderNewDrugButton').on('click', '#patientOrderNewDrugButton', function (e) {

        e.preventDefault();

        var patientOrderNo = $("#patientOrderNo").val();
        var patientOrderDate = $("#patientOrderDate").val();

        if (patientOrderNo === "" || patientOrderNo === null) {

            $('.nav-tabs a[href="#tab_default_1"]').tab('show');
            bootbox.alert("Please Select A Order First");

        } else {

            $('#addOrderDrug').modal('show');

            console.log(patientOrderDate);
            console.log(patientOrderNo);

            $("#orderDrugDetailsID").val(patientOrderNo);
            $("#orderDrugDetailsDate").val(patientOrderDate);

        }

    });
    // Getting Order Id And Date End


    //js Search in add drug Start
    $(function () {
        $("#orderDrugSearchInput").on('keyup', function () { // everytime keyup event
            var input = $(this).val(); // We take the input value
            if (input.length >= 1) { // Minimum characters = 2 (you can change)
                $('#orderDrugSearchInputDisplayResult').html('<img src="LoaderIcon.gif"/>'); // Loader icon apprears in the <div id="match"></div>
                var dataFields = {'input': input}; // We pass input argument in Ajax
                $.ajax({
                    type: "POST",
                    url: "Search2.jsp", // call the jsp file ajax/auto-autocomplete.php
                    data: dataFields, // Send dataFields var
                    timeout: 3000,
                    success: function (dataBack) { // If success
                        $('#orderDrugSearchInputDisplayResult').html(dataBack); // Return data (UL list) and insert it in the <div id="match"></div>
                        $('#orderDrugSearchInputDisplayResult li').on('click', function () { // When click on an element in the list
                            $('#orderDrugSearchInput').val($(this).text()); // Update the field with the new element
                            $('#orderDrugSearchInputDisplayResult').text(''); // Clear the <div id="match"></div>
                        });
                    },
                    error: function () { // if error
                        $('#orderDrugSearchInputDisplayResult').text('No Eecord Found !');
                    }
                });
            } else {
                $('#orderDrugSearchInputDisplayResult').text('Problem!'); // If less than 2 characters, clear the <div id="match"></div>
            }
        });
    });
    //js Search in add drug End


    //Start js Search Select drug
    $('#orderDrugSearchInputDisplayResult').on('click', function () {
        var id = $('#orderDrugSearchInput').val();
        $.ajax({
            type: 'post',
            url: 'SearchDTO_cd.jsp',
            data: {'id': id},
            success: function (reply_data) {
                console.log(reply_data);
                var array_data = String(reply_data).split("|");
                var dtoCode = array_data[0];
                var dtoGnr = array_data[1];
                var dtoQty = array_data[2];
                var dtoPackage = array_data[8];
                var dtoRoute = array_data[3];
                var dtoForm = array_data[4];
                var dtoStrength = array_data[5];
                var dtoInstruction = array_data[6];
                var dtoCaution = array_data[7];

                console.log(dtoCode);

                $('#orderDrugDisplayDrugCode').val(dtoCode);
                $('#orderDrugDisplayTradeName').val(dtoGnr);
                $('#orderDrugDisplayStockQuantity').val(dtoQty);
                $('#orderDrugDisplayForm').val(dtoForm);
                $('#orderDrugDisplayRoute').val(dtoRoute);
                $('#orderDrugDisplayStrength').val(dtoStrength);
                $('#orderDrugDisplayInstruction').val(dtoInstruction);
                $('#orderDrugDisplayCautionary').val(dtoCaution);

            }
        });
    });
    //End js Search Select drug


    // Add Order Start
    $('#orderDrugAddButton').on('click', function (e) {

        e.preventDefault();

        var orderNo = $('#orderDrugDetailsID').val();
        var orderDate = $('#orderDrugDetailsDate').val();

        var drugTradeName = $('#orderDrugSearchInput').val();
        var drugCode = $('#orderDrugDisplayDrugCode').val();
        var drugGName = $('#orderDrugDisplayTradeName').val();
        var drugRoute = $('#orderDrugDisplayRoute').val();
        var drugForm = $('#orderDrugDisplayForm').val();

        var drugStrength = $('#orderDrugDisplayStrength').val();
        var drugInstruction = $('#orderDrugDisplayInstruction').val();
        var drugCaution = $('#orderDrugDisplayCautionary').val();
        var drugTotalQty = $('#orderDrugDisplayStockQuantity').val();

        var drugQty = $('#orderDrugInputQuantity').val();
        var drugDose = $('#orderDrugInputDose').val();
        var drugDoseT = $('#orderDrugInputDoseT').val();
        var drugFrequency = $('#orderDrugInputFrequency').val();
        var drugDuration = $('#orderDrugInputDuration').val();
        var drugDurationT = $('#orderDrugInputDurationT').val();

        if (drugTradeName === "" || drugTradeName === null) {
            bootbox.alert("Please Search The Drug Before Continue");
        } else if (drugQty === "" || drugQty === null) {
            bootbox.alert("Please Insert Drug Order Quantity");
        } else if (drugDose === "" || drugDose === null) {
            bootbox.alert("Please Insert Drug Order Dose");
        } else if (drugDoseT === "No Dose" || drugDoseT === null) {
            bootbox.alert("Please Select Drug Dose Type");
        } else if (drugFrequency === "No Frequency" || drugFrequency === null) {
            bootbox.alert("Please Select Drug Frequency");
        } else if (drugDuration === "" || drugDuration === null) {
            bootbox.alert("Please Insert Drug Duration");
        } else if (drugDurationT === "No Duration" || drugDurationT === null) {
            bootbox.alert("Please Select Drug Frequency");
        } else {

            var ItemDesc = (drugTradeName + " - " + drugGName);
            var dosage = (drugDose + drugDoseT);

            var data = {
                orderNo: orderNo
            };

            var datas = {
                orderNo: orderNo,
                drugCode: drugCode,
                drugDesc: ItemDesc,
                drugFrequency: drugFrequency,
                drugRoute: drugRoute,
                drugFrom: drugForm,
                drugStrength: drugStrength,
                dosage: dosage,
                orderOUM: "-",
                drugDuration: drugDuration,
                orderStatus: "0",
                drugQty: drugQty,
                qtySupplied: "0",
                suppliedOUM: "-",
                qtyDispensed: "0",
                dispensedOUM: "-",
                drugDurationT: drugDurationT
            };

            console.log(datas);

            $.ajax({
                url: "patientOrderListNewOrderInsert.jsp",
                type: "post",
                data: datas,
                timeout: 10000,
                success: function (datas) {

                    if (datas.trim() === 'Success') {

                        $('#addOrderDrug').modal('hide');
                        bootbox.alert({
                            message: "Order is Added Successful",
                            title: "Process Result",
                            backdrop: true
                        });
                        resetAddOrder();

                        $.ajax({
                            url: "patientOrderListDetailsNew.jsp",
                            type: "post",
                            data: data,
                            timeout: 3000,
                            success: function (returnOrderDetailsTableHTML) {
                                //console.log(returnOrderDetailsTableHTML);
                                $('#patientOrderDetailsListTable').html(returnOrderDetailsTableHTML);

                            }
                        });

                    } else if (datas.trim() === 'Duplicate') {

                        bootbox.alert({
                            message: "Order Product Code Duplication Detected. Please Order diffrent drug as the data already there",
                            title: "Process Result",
                            backdrop: true
                        });

                    } else if (datas.trim() === 'Failed') {

                        bootbox.alert({
                            message: "Order Add Failed",
                            title: "Process Result",
                            backdrop: true
                        });
                        $('#addOrderDrug').modal('hide');
                        resetAddOrder();
                    }

                },
                error: function (err) {
                    console.log("Ajax Is Not Success");
                }

            });
        }

    });
    // Add Order End


    // Reset Order Button Start
    $('#orderDrugResetButton').on('click', function (e) {
        resetAddOrder();
    });
    // Reset Order Button End


    // Reset Order Function Start
    function resetAddOrder() {
        document.getElementById("addDrugOrderForm").reset();
    }
    // Reset Order Function End


//================================================================================  Add Part End  =====================================================================================//





//-------------------------------------------------------------------------  Update And Delete Part Start  ----------------------------------------------------------------------------//

    // global variable declaration
    var row;

    // Get Data For Delete And Update To Load On the Modal
    $('#patientOrderDetailContent').off('click', '#patientOrderDetailsListTable #updateOrderDetailsTButton').on('click', '#patientOrderDetailsListTable #updateOrderDetailsTButton', function (e) {

        e.preventDefault();

        row = $(this).closest("tr");
        var rowData = row.find("#dataPatientOrderDetailsListhidden").val();
        var arrayData = rowData.split("|");
        console.log(row);
        console.log(arrayData);

        var updateOrderNo = arrayData[0];
        var updateOrderDrugCode = arrayData[1];
        var updateOrderDrugOrdered = parseInt(arrayData[11]);
        var updateOrderDrugSupplied = arrayData[12];
        var updateOrderDrugStockQty = arrayData[18];
        var updateOrderDrugDispensed = row.find('td').eq(11).text();
        var updateOrderDrugStatus = row.find('td').eq(12).text();

        $("#updateOrderNo").val(updateOrderNo);
        $("#updateStockQuantity").val(updateOrderDrugStockQty);
        $("#updateDrugCode").val(updateOrderDrugCode);
        $("#updateOrderedDrugQuantity").val(updateOrderDrugOrdered);
        $("#updateOrderedDrugQuantity").val(updateOrderDrugOrdered);
        $("#updateSuppliedDrugQuantity").val(updateOrderDrugSupplied);
        $("#updatestatus").val(updateOrderDrugStatus);

        if (updateOrderDrugDispensed === "0") {
            $("#updateDispensedDrugQuantity").val("");
        } else {
            $("#updateDispensedDrugQuantity").val(updateOrderDrugDispensed);
        }

    });
    // Get Data For Delete And Update To Load On the Modal End

    // Update Order Data
    $('#updateOrder').off('click', '#updateOrderMButton').on('click', '#updateOrderMButton', function (e) {

        e.preventDefault();
        
        var validDispense = document.getElementById("updateDispensedDrugQuantity");

        var updateStockQty = $("#updateStockQuantity").val();
        var updateOrderedQty = $("#updateOrderedDrugQuantity").val();
        var updateSuppliedQty = $("#updateSuppliedDrugQuantity").val();
        var updateDispensedQuantity = $("#updateDispensedDrugQuantity").val();
        var updateOrderStatusStatic = $("#updatestatus").val();

        if (updateDispensedQuantity === "" || updateDispensedQuantity === null || parseInt(updateDispensedQuantity) < 1) {
            bootbox.alert("Please Insert The Dispense Quantity Than Is More That 0 !!!");
        } else if (updateOrderStatusStatic === "New" || updateOrderStatusStatic === null) {
            bootbox.alert("Please Select The Order Status");
        } else if ((parseInt(updateDispensedQuantity) > parseInt(updateOrderedQty))) {
            bootbox.alert("The Dispense Quantity Is More Than Ordered Quantity. Please Choose Valid Number !!!");
            $("#updateDispensedDrugQuantity").val("");
        } else if (validDispense.checkValidity() === false) {
            bootbox.alert("The Dispense Quantity Should Not Be Decimal Number. Please Choose Valid Number !!!");
            $("#updateDispensedDrugQuantity").val("");
        } else if ((parseInt(updateDispensedQuantity) > parseInt(updateStockQty))) {
            bootbox.alert("The Dispense Quantity Is More Than Stock Quantity. Please Choose Valid Number !!!");
            $("#updateDispensedDrugQuantity").val("");
        } else if (((parseInt(updateDispensedQuantity) + parseInt(updateSuppliedQty)) > parseInt(updateOrderedQty))) {
            bootbox.alert("The Combination of Dispense And Supplied Quantity Is More Than Ordered Quantity. Please Choose Valid Number !!!");
            $("#updateDispensedDrugQuantity").val("");
        } else {

            var updateOrderDrugDispensed = row.find('td').eq(11).text(updateDispensedQuantity);
            var updateOrderDrugStatus = row.find('td').eq(12).text(updateOrderStatusStatic);
            $('#updateOrder').modal('hide');

            bootbox.alert({
                message: "Drug Order Detail is Updated Successfully",
                title: "Process Result",
                backdrop: true
            });

        }
    });
    // Update Order Data End


    // Delete Order Data 
    $('#updateOrder').on('click', '#deleteOrderMButton', function (e) {

        var orderNo = $("#updateOrderNo").val();
        var drugCode = $("#updateDrugCode").val();

        var data = {
            orderNo: orderNo,
            drugCode: drugCode
        };

        console.log(data);

        $('#updateOrder').modal('hide');

        bootbox.confirm({
            message: "Are you sure want to delete this order ?",
            title: "Delete Item?",
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {

                if (result === true) {

                    $.ajax({
                        url: "patientOrderListNewOrderDelete.jsp",
                        type: "post",
                        data: data,
                        timeout: 10000, // 10 seconds
                        success: function (datas) {

                            if (datas.trim() === 'Success') {

                                $.ajax({
                                    url: "patientOrderListDetailsNew.jsp",
                                    type: "post",
                                    data: data,
                                    timeout: 3000,
                                    success: function (returnOrderDetailsTableHTML) {
                                        //console.log(returnOrderDetailsTableHTML);
                                        $('#patientOrderDetailsListTable').html(returnOrderDetailsTableHTML);

                                        bootbox.alert({
                                            message: "Drug Order is Deleted Successfully",
                                            title: "Process Result",
                                            backdrop: true
                                        });

                                    }
                                });

                            } else if (datas.trim() === 'Failed') {
                                bootbox.alert({
                                    message: "Drug Order Delete Failed",
                                    title: "Process Result",
                                    backdrop: true
                                });
                            }

                        },
                        error: function (err) {
                            alert("Error! Deletion Ajax failed!!");
                        }

                    });
                } else {
                    console.log("Process Is Canceled");
                }

            }
        });
    });
    // Delete Order Data End


//============================================================================  Update And Delete Part End  ===========================================================================//





//-------------------------------------------------------------------------------  Dispense Part Start  -------------------------------------------------------------------------------//


    // Dispense Order Data
    $('#patientOrderDetailContent').off('click', '#patientOrderDispenseButtonDiv #btnOrderDispense').on('click', '#patientOrderDispenseButtonDiv #btnOrderDispense', function (e) {

        e.preventDefault();

        bootbox.confirm({
            message: "Are you sure want to dispense this order ?",
            title: "Dispense Item?",
            buttons: {
                confirm: {
                    label: 'Yes',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'No',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {

                if (result === true) {

                    var orderNo = $("#patientOrderNo").val();
                    var totalOrder = (document.getElementById("patientOrderDetailsListTable").rows.length) - 1;
                    var table = $("#patientOrderDetailsListTable tbody");

                    var drugPrice, drugDispensedQty, product;

                    var grandTotal = 0.0;

                    table.find('tr').each(function (i) {

                        var $tds = $(this).find('td');

                        drugPrice = parseFloat($tds.eq(7).text());
                        drugDispensedQty = parseFloat($tds.eq(11).text());
                        product = drugDispensedQty * drugPrice;

                        grandTotal = grandTotal + product;

                    });

                    $("#dispenseOrderNo").val(orderNo);
                    $("#dispenseTotalOrder").val(totalOrder);
                    $("#dispenseGrandTotal").val(grandTotal);

                    $('#dispenseOrder').modal('show');

                } else {
                    console.log("Process Is Canceled");
                }

            }
        });


    });
    // Dispense Order Data End


    // Dispense Order
    $('#dispenseOrder').off('click', '#dispenseOrderMButton').on('click', '#dispenseOrderMButton', function (e) {

        var table = $("#patientOrderDetailsListTable tbody");

        var orderNo, drugCode, drugDesc, drugStrength, drugFrequency, drugDuration, drugDose, drugPrice,
                drugStockQty, drugOrderedQty, drugSuppliedQty, drugDispensedQty, drugStatus;

        var orderDate, locationCode, arrivalDate;

        orderDate = $("#patientOrderDate").val();
        locationCode = $("#patientOrderLocationCode").val();
        arrivalDate = $("#patientOrderDate").val();

        table.find('tr').each(function (i) {

            var $tds = $(this).find('td');

            // Get The Data
            orderNo = $tds.eq(0).text();
            drugCode = $tds.eq(1).text();
            drugDesc = $tds.eq(2).text();
            drugStrength = $tds.eq(3).text();
            drugFrequency = $tds.eq(4).text();
            drugDuration = $tds.eq(5).text();
            drugDose = $tds.eq(6).text();
            drugPrice = $tds.eq(7).text();
            drugStockQty = $tds.eq(8).text();
            drugOrderedQty = String(parseInt($tds.eq(9).text()));
            drugSuppliedQty = $tds.eq(10).text();
            drugDispensedQty = $tds.eq(11).text();
            drugStatus = $tds.eq(12).text();

            // do something with productId, product, Quantity
            if (drugStatus === "New") {
                drugStatus = "0";
            } else if (drugStatus === "Partial") {
                drugStatus = "1";
            } else if (drugStatus === "Complete Partial") {
                drugStatus = "2";
            } else if (drugStatus === "Full Complete") {
                drugStatus = "3";
            } else {
                drugStatus = "4";
            }

            var updatedQtySupplied = String(parseInt(drugDispensedQty) + parseInt(drugSuppliedQty));
            var updateQtyStock = parseInt(drugStockQty) - parseInt(drugDispensedQty);

            var dataAjax = {
                orderNo: orderNo,
                drugCode: drugCode,
                drugPrice: drugPrice,
                drugStockQty: updateQtyStock,
                drugOrderedQty: drugOrderedQty,
                drugSuppliedQty: updatedQtySupplied,
                drugDispensedQty: drugDispensedQty,
                drugStatus: drugStatus,
                orderDate: orderDate,
                locationCode: locationCode,
                arrivalDate: arrivalDate
            };

            console.log(dataAjax);

            $.ajax({
                url: "patientOrderListDetailsDispenceUpdateOrderTable.jsp",
                type: "post",
                data: dataAjax,
                timeout: 3000,
                success: function (datas) {
                    console.log(datas);

                    $.ajax({
                        url: "patientOrderListDetailsDispenceUpdateDispenseTable.jsp",
                        type: "post",
                        data: dataAjax,
                        timeout: 3000,
                        success: function (datas) {
                            console.log(datas);

                            $.ajax({
                                url: "patientOrderListDetailsDispenceUpdateMDCTable.jsp",
                                type: "post",
                                data: dataAjax,
                                timeout: 3000,
                                success: function (datas) {
                                    console.log(datas);


                                },
                                error: function (err) {
                                    console.log("Error update!");
                                }

                            });
                        },
                        error: function (err) {
                            console.log("Error update!");
                        }

                    });

                },
                error: function (err) {
                    console.log("Error update!");
                }

            });
        }).promise().done(function () {

            $('#dispenseOrder').modal('hide');

            bootbox.alert({
                message: "Dispense Order is Successfully",
                title: "Dispense Result",
                backdrop: true
            });

            resetDispense();

        });

    });
    // Dispense Function End


//===============================================================================  Dispense Part End  ================================================================================//




//-------------------------------------------------------------------------------  Reset Part Start  --------------------------------------------------------------------------------//


    // Dispense Reset Function  
    function resetDispense() {
        console.log("Ok Clean");
        $.ajax({
            timeout: 3000,
            success: function () {
                $("#patientOrderListContent").load("patientOrderListTable.jsp");
            }
        });
        document.getElementById("patientOrderDetailContentBasicInfoForm").reset();
        document.getElementById("patientOrderDetailContentOrderInfoForm").reset();
        $("#patientOrderDetailContent #patientOrderDetailsListTableDiv").load("patientOrderListBasicInfoNew.jsp #patientOrderDetailsListTableDiv");
        $('.nav-tabs a[href="#tab_default_1"]').tab('show');
    }
    // Dispense Reset Function End


    // Reset Fields    
    $('#patientOrderDetailContent').on('click', '#btnClearOrderDetailDispense', function (e) {
        document.getElementById("patientOrderDetailContentBasicInfoForm").reset();
        document.getElementById("patientOrderDetailContentOrderInfoForm").reset();
        $("#patientOrderDetailContent #patientOrderDetailsListTableDiv").load("patientOrderListBasicInfoNew.jsp #patientOrderDetailsListTableDiv");
    });


//=================================================================================  Reset Part End  ==================================================================================//


</script>