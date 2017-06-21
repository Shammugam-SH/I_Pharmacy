<%-- 
    Document   : newjsp
    Created on : Jun 12, 2017, 6:19:19 AM
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

        <button type="button" onclick="test()">Click Me!</button>


    </body>



    <script>


        var contextPath = '<%=request.getContextPath()%>';

        function test() {
            alert('Hello world!');

            var url = contextPath + "/test";

            var win = window.open(url, '_blank');
            win.focus();

        }


    </script>
</html>
