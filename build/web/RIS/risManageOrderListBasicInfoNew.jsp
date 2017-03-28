<%-- 
    Document   : risManageOrderListBasicInfoNew
    Created on : Mar 28, 2017, 4:43:19 PM
    Author     : Shammugam
--%>

<div class="thumbnail">
    <h4>Basic Info</h4>
    <hr/>
    <form class="form-horizontal" name="risManageOrderDetailContentBasicInfoForm" id="risManageOrderDetailContentBasicInfoForm">
        <div class="row">

            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">PMI No.</label>
                    <div class="col-md-8">
                        <input id="rispatientpmino" name="rispatientpmino" type="text" placeholder="" readonly class="form-control input-md">   
                    </div>
                </div>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Name</label>
                    <div class="col-md-8">
                        <input id="rispatientName" name="rispatientName" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>

            <div class="col-md-4">

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">New IC No.</label>
                    <div class="col-md-8">
                        <input id="rispatientnic" name="rispatientnic" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>
                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Gender</label>
                    <div class="col-md-8">
                        <input id="rispatientGender" name="rispatientGender" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>

            <div class="col-md-4">

                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">D.O.B</label>
                    <div class="col-md-8">
                        <input id="rispatientBdate" name="rispatientBdate" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>
                <!--Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Blood Type</label>
                    <div class="col-md-8">
                        <input id="rispatientBtype" name="rispatientBtype" type="text" readonly placeholder="" class="form-control input-md">
                    </div>
                </div>

            </div>

        </div>
    </form>

    <hr/>
    <h5 style="padding-bottom: 1%;font-weight: bolder">
        Allergy List
    </h5>

    <div id="patientAllergyListTableDiv" class="form-group">
        <table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; width: 100%" id="patientAllergyListTable">
            <thead>
            <th style="display: none">PMI NO</th>
            <th>HFC CODE</th>
            <th>EPISODE DATE</th>
            <th>ENCOUNTER DATE</th>
            <th>ALLERGY CODE</th>
            <th>ALLERGY DESCRIPTION</th>
            <th>COMMENT</th>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>


<div class="thumbnail">
    <h4>Diagnosis Info</h4>
    <hr/>
    <div id="patientDiagnosisListTableDiv" class="form-group">
        <table class="table table-filter table-striped table-bordered" style="background: #fff; border: 1px solid #ccc; width: 100%" id="patientDiagnosisListTable">
            <thead>
            <th style="display: none">PMI NO</th>
            <th >HFC CODE</th>
            <th>EPISODE DATE</th>
            <th>ENCOUNTER DATE</th>
            <th>DIAGNOSIS CODE</th>
            <th>DIAGNOSIS DESCRIPTION</th>
            <th>COMMENT</th>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>

<script>


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//



    // Move to Order Details Fetch Details Start
    $('#risOrderListContent').off('click', '#risManageOrderListTable #moveToRISOrderDetailsTButton').on('click', '#risManageOrderListTable #moveToRISOrderDetailsTButton', function (e) {

        e.preventDefault();

        var row = $(this).closest("tr");
        var rowData = row.find("#dataRISOrderListhidden").val();
        var arrayData = rowData.split("|");
        console.log(arrayData);

        //Assign Array into seprated val
        var patientpmino = arrayData[0];
        var patientName = arrayData[13];
        var patientnic = arrayData[14];
        var patientGender = arrayData[16];
        var patientBdate = arrayData[15];
        var patientBtype = arrayData[17];
        var patientOrderNo = arrayData[1];
        var patientOrderDate = arrayData[5];
        var patientOrderLocationCode = arrayData[2];


        //Set value to the Second Tab 
        $("#rispatientpmino").val(patientpmino);
        $("#rispatientName").val(patientName);
        $("#rispatientnic").val(patientnic);
        $("#rispatientGender").val(patientGender);
        $("#rispatientBdate").val(patientBdate);
        $("#rispatientBtype").val(patientBtype);
        $("#rispatientOrderNo").val(patientOrderNo);
        $("#rispatientOrderDate").val(patientOrderDate);
        $("#rispatientOrderLocationCode").val(patientOrderLocationCode);

        //loadAllergyDiagnosisOrder(patientOrderNo, patientpmino);

    });
    // Move to Order Details Fetch Details End


</script>