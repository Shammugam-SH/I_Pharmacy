<%-- 
    Document   : patientOrderListDetailsDispenceEHRCentralInsert
    Created on : Apr 22, 2017, 1:17:05 AM
    Author     : Shammugam
--%>


<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="main.RMIConnector"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="dBConn.Conn"%>

<%
    Conn conn = new Conn();
    String userID = (String) session.getAttribute("USER_ID");
    String hfc = (String) session.getAttribute("HEALTH_FACILITY_CODE");
    String dis = (String) session.getAttribute("DISCIPLINE_CODE");
    String subdis = (String) session.getAttribute("SUB_DISCIPLINE_CODE");
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    
    String FullEHRHeader = "";
    
    String EHRFirstHeader = request.getParameter("EHRFirstHeader");
    String EHRSecondHeader = request.getParameter("EHRSecondHeader");
    
    FullEHRHeader = EHRFirstHeader+EHRSecondHeader;


    out.print(FullEHRHeader);
    
%>

