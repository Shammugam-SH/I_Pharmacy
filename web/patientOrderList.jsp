<%-- 
    Document   : patientOrderList
    Created on : Feb 6, 2017, 4:33:22 PM
    Author     : Shammugam
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="dBConn.Conn"%>
<%@page import="main.RMIConnector"%>
<%@page import="Config.Config"%>

<%
    Config.getFile_url(session);
    Config.getBase_url(request);
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap-3.3.6-dist/css/dataTables.bootstrap.min.css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    </head>



    <body>
        <!-- header -->
        <div w3-include-html="libraries/pharmacyHeader.jsp"></div>
        <!-- header -->

        <!-- menu top -->
        <div w3-include-html="libraries/pharmacyTopMenus.jsp"></div>
        <!-- menu top -->

        <div class="container-fluid">
            <div class="row">       
                <!-- menu side -->		
                <div w3-include-html="libraries/pharmacySideMenus.jsp"></div>
                <!-- menu side -->		

                <!-- main -->		
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="background: #f2f4f8;">
                    <div class="row">
                        <div class="col-md-12">
                            <div  class="thumbnail">


                                <!-- Tab Menu -->
                                <div class="tabbable-panel">
                                    <div class="tabbable-line">
                                        <ul class="nav nav-tabs ">
                                            <li class="active">
                                                <a href="#tab_default_1" data-toggle="tab">
                                                    PATIENT ORDER LIST</a>
                                            </li>
                                            <li>
                                                <a href="#tab_default_2" data-toggle="tab">
                                                    PATIENT DETAIL LIST</a>
                                            </li>
                                        </ul>
                                        <!-- tab content -->
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tab_default_1">
                                                <div id="patientOrderListContent">

                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab_default_2">
                                                <div id="patientOrderDetailContent">

                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <!-- Tab Menu -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- main -->		

        </div>


        <!-- Update Dispense Start -->
        <div class="modal fade" id="updateOrder" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><i class="fa fa-times fa-lg"></i></button>
                        <h3 class="modal-title" id="lineModalLabel">Update Order Detail</h3>
                    </div>
                    <div class="modal-body">

                        <!-- content goes here -->
                        <form class="form-horizontal" id="addForm">

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Order No</label>
                                <div class="col-md-8">
                                    <input id="updateOrderNo" name="updateOrderNo" type="text" placeholder="Order No" class="form-control input-md" maxlength="15" readonly>
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Drug Code</label>
                                <div class="col-md-8">
                                    <input id="updateDrugCode" name="updateDrugCode" type="text" placeholder="Drug Code" class="form-control input-md" maxlength="15" readonly>
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Ordered Drug Quantity</label>
                                <div class="col-md-8">
                                    <input id="updateOrderedDrugQuantity" name="updateOrderedDrugQuantity" type="text" placeholder="Ordered Drug Quantity" class="form-control input-md" maxlength="50" readonly>
                                </div>
                            </div>
                            
                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Supplied Drug Quantity</label>
                                <div class="col-md-8">
                                    <input id="updateSuppliedDrugQuantity" name="updateSuppliedDrugQuantity" type="number" placeholder="Dispensed Drug Quantity" class="form-control input-md" maxlength="50" readonly>
                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Dispensed Drug Quantity</label>
                                <div class="col-md-8">
                                    <input id="updateDispensedDrugQuantity" name="updateDispensedDrugQuantity" type="number" placeholder="Dispensed Drug Quantity" class="form-control input-md" maxlength="50" required>
                                </div>
                            </div>

                            <!-- Select input-->
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="textinput">Status</label>
                                <div class="col-md-8">
                                    <select class="form-control" name="tstatus" id="updatestatus">
                                        <option value="0" selected="">-- Select Order Status --</option>
                                        <option value="1" >Partial</option>
                                        <option value="2" >Complete Partial</option>
                                        <option value="3" >Complete Full</option>
                                        <option value="4" >Full</option>
                                    </select>
                                </div>
                            </div>


                        </form>
                        <!-- content goes here -->
                    </div>
                    <div class="modal-footer">
                        <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                            <div class="btn-group" role="group">
                                <button type="submit" class="btn btn-success btn-block btn-lg" role="button" id="updateOrderMButton">Update</button>
                            </div>
                            <div class="btn-group" role="group">
                                <button type="reset" class="btn btn-danger btn-block btn-lg" data-dismiss="modal" role="button" >Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Update Dispense End -->                         




        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="http://www.w3schools.com/lib/w3data.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/4.4.0/bootbox.min.js"></script>
        <script src="bootstrap-3.3.6-dist/js/jquery.dataTables.min.js"></script>
        <script src="bootstrap-3.3.6-dist/js/dataTables.bootstrap.min.js" type="text/javascript"></script>

        <script>

            w3IncludeHTML();

            $("#patientOrderListContent").load("patientOrderListTable.jsp");
            $("#patientOrderDetailContent").load("patientOrderListBasicInfoNew.jsp");

        </script>

    </body>

</html>