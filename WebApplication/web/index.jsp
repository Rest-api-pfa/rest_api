<%-- 
    Document   : test
    Created on : Oct 26, 2018, 3:50:55 PM
    Author     : drging
--%>

<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="Model.Livre"%>
<%@page import="Resources.LivreResource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <input type="text" />
        <button id="pot">Get Data</button><br>
     
        <textarea id="txt"></textarea>
        
    </body>
    <script src="jq.min.js"></script>
   <script>
            $(document).ready(function(){
                //var url = "LivreController?action=livres";
                     
                $("#pot").click(function(e) {
                    e.preventDefault();
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/";
                     url =  url+$("input").val();
                    //var formData = $("#form").serialize();
                   
                    $.ajax({
                        url: url,
                        type: "GET",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            },
                    success: function(data) {
                         $("#txt").text(JSON.stringify(data));
                         
                        }
                    });
                });
                
            });
        </script>
    
</html>
