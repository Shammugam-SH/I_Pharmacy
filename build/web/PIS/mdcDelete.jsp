<%-- 
    Document   : mdcDelete
    Created on : Jan 31, 2017, 4:56:13 PM
    Author     : Shammugam
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Config.Config"%>
<%@page import="dBConn.Conn"%>
<%@page import="main.RMIConnector"%>
<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%

    String hfc = session.getAttribute("HEALTH_FACILITY_CODE").toString();
    String dis = session.getAttribute("DISCIPLINE_CODE").toString();
    String sub = session.getAttribute("SUB_DISCIPLINE_CODE").toString();
    String id = request.getParameter("iditem");

    RMIConnector rmic = new RMIConnector();
    Conn conn = new Conn();

    String sql = "DELETE FROM pis_mdc2 WHERE UD_MDC_CODE = '" + id + "' AND hfc_cd  = '" + hfc + "' AND discipline_cd  = '" + dis + "' ";

    boolean status = rmic.setQuerySQL(conn.HOST, conn.PORT, sql);

    if (status == true) {
        out.print("Success");
    } else {
        out.print("Failed");
    }

%>
