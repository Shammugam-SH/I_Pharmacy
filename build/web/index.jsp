<%-- 
    Document   : index
    Created on : Jan 13, 2017, 9:26:29 AM
    Author     : user
--%>
<%@page import="java.nio.charset.Charset"%>
<%
    
    session.setAttribute("USER_ID", "DR024");
    session.setAttribute("USER_NAME", "SHAMMUGAM RAMASAMY");
    session.setAttribute("PICTURE", "libraries/img/Profile.jpg");
    session.setAttribute("HEALTH_FACILITY_CODE", "04010101");
    session.setAttribute("HFC_NAME", "Klinik UTeM Induk");
    session.setAttribute("ROLE_CODE", "001");
    session.setAttribute("ROLE_NAME", "SYSTEM ADMINISTRATOR");

    session.setAttribute("DISCIPLINE_CODE", "-");
    session.setAttribute("SUB_DISCIPLINE_CODE", "-");

    session.setMaxInactiveInterval(-1);
    response.sendRedirect("PIS/patientOrderList.jsp");
    //response.sendRedirect("RIS/HIS060001.jsp");

%>