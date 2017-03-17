<%-- 
    Document   : tester
    Created on : Mar 17, 2017, 6:25:01 AM
    Author     : Shammugam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>

<script src="http://cdn.jsdelivr.net/alasql/0.3/alasql.min.js"></script>
<script>
    
    alasql('SELECT * FROM XLSX("text.xlsx")').then(function(data){
        console.log(data);
    });
    
</script>
