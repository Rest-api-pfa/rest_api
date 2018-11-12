<%-- 
    Document   : client
    Created on : 2 nov. 2018, 13:35:47
    Author     : win87
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <title>JSP Page</title>
        <style>
             form{
                border-top: 1px solid #ccc;
                padding-top: 15px;
            }
            #crud{
                display: flex;
                              
            }
        </style>
    </head>
    <body>
      
        
 <form class="form-horizontal" autocomplete="off">
  
     <div class="form-group">
    <div class="col-sm-offset-2 col-sm-2">
    <input type="search" class="form-control" id="searchInput" placeholder="Search">
   
    </div>
     <div class="col-sm-2">
   <button type="submit" id="search" class="btn btn-primary">Search</button>
    </div>
    
     </div>

     <div class="form-group">
    <label for="cinInput" class="col-sm-2 control-label">CIN</label>
     <div class="col-sm-6">
     <input type="text" class="form-control" id="cinInput" placeholder="CIN">
    </div>
  </div>
     
     
  <div class="form-group">
    <label for="nomInput" class="col-sm-2 control-label">NOM</label>
     <div class="col-sm-6">
     <input type="text" class="form-control" id="nomInput" placeholder="NOM">
    </div>
  </div>
       <div class="form-group">
    <label for="prenomInput" class="col-sm-2 control-label">PRENOM</label>
     <div class="col-sm-6">
     <input type="text" class="form-control" id="prenomInput" placeholder="PRENOM">
    </div>
  </div>
     
     <div class="form-group">
    <label for="villeInput" class="col-sm-2 control-label">VILLE</label>
     <div class="col-sm-6">
     <input type="text" class="form-control" id="villeInput" placeholder="VILLE">
    </div>
  </div>
     <div id="base">
     <label for="mysqlradio" >MySQL</label>
     <input type="radio"  id="mysqlradio" name="to" class ="to" value="mysql"><br>
     <label for="postgreradio" >PostgreSql</label>
     <input type="radio"  id="postgreradio" name="to" class ="to" value="PostgreSql"><br>
     <label for="oracleradio" >Oracle</label>
     <input type="radio"  id="oracleradio" name="to" class ="to" value="Oracle"><br>
     </div>
     
     
   <div class="form-group" id="crud">
    <div class="col-sm-offset-2">
      <button type="submit" id="submit" class="btn btn-primary">Submit</button>
    </div>
       <div class="col-sm-offset-1">
      <button type="submit" id="update" class="btn btn-success">Update</button>
    </div>
        <div class="col-sm-offset-1">
      <button type="submit" id="delete" class="btn btn-danger">Delete</button>
    </div>
  </div>
      
</form>
       
        <div id="content">
            
        </div> 
         
      
        
    </body>
    
    <script src="jq.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
     
   <script>
            $(document).ready(function(){
                //var url="http://localhost:8084/WebApplication2/webresources/client/";
                var nom=$("#nomInput");
                var prenom=$("#prenomInput");
                var cin=$("#cinInput");
                var ville=$("#villeInput");
                var submit=$("#submit");
                var search=$("#search");
                var del=$("#delete");
                var content=$("#content");
                var update=$("#update");
                var to;
              
               
               
                
                submit.click(function(e) {
                    e.preventDefault();
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/client/";
                     url+=$(".to:checked").val();
                   var data={cin:cin.val(),nom:nom.val(),prenom:prenom.val(),ville:ville.val()};
                   data=JSON.stringify(data);
                   $.ajax({
                        url: url,
                        type: "POST",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            },
                            data:data
                    });
                    
                });
                
                
                update.click(function(e) {
                    e.preventDefault();
                    var url="http://192.168.9.9:8084/WebApplication2/webresources/client";

                    
                   var data={cin:cin.val(),nom:nom.val(),prenom:prenom.val(),ville:ville.val()};
                   
                   data=JSON.stringify(data);
                   $.ajax({
                        url: url,
                        type: "PUT",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            },
                            data:data
                    });
                    
                });
                
                
                
                search.click(function(e) {
                    
                    content.html('');
                    e.preventDefault();
                   var url="http://192.168.9.9:8084/WebApplication2/webresources/client/";

                   
                        url =  url+$("#searchInput").val();
                   
                     nom.val('');
                     prenom.val('');
                     cin.val('');
                     ville.val('');
                    $.ajax({
                        url: url,
                        type: "GET",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            },
                    success: function(data) {
                         if(Array.isArray(data))
                         {
                             nom.val(data[0].nom);
                            prenom.val(data[0].prenom);
                            cin.val(data[0].cin);
                            ville.val(data[0].ville);
                             for(var i=1;i<data.length;i++)
                             {
                            content.append('<form class="form-horizontal"><div class="form-group"><label class="col-sm-2 control-label">CIN</label><div class="col-sm-6"><input type="text" class="form-control"  placeholder="CIN" value="'+data[i].cin+'"></div></div><div class="form-group"><label  class="col-sm-2 control-label">Nom</label><div class="col-sm-6"><input type="text" class="form-control"  placeholder="Nom" value="'+data[i].nom+'"></div></div><div class="form-group"><label  class="col-sm-2 control-label">Prenom</label><div class="col-sm-6"><input type="text" class="form-control"  placeholder="Prenom" value="'+data[i].prenom+'"></div></div><div class="form-group"><label  class="col-sm-2 control-label">VILLE</label><div class="col-sm-6"><input type="text" class="form-control"  placeholder="VILLE" value="'+data[i].ville+'"></div></div></form>'); 

                             }
                         }
                        else 
                        {
                            nom.val(data.nom);
                            prenom.val(data.prenom);
                            cin.val(data.cin);
                            ville.val(data.ville);
                        }
                          
                        
                         
                        }
                    });
                });
                
                //////////delete
                del.click(function(e) {
                    e.preventDefault();
                   var url="http://192.168.9.9:8084/WebApplication2/webresources/client/";

                     
                     url =  url+$("#searchInput").val();
                    
                     nom.val('');
                     prenom.val('');
                     cin.val('');
                     ville.val('');
                    $.ajax({
                        url: url,
                        type: "DELETE",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            }
                           
                   
                    });
                });
  
            });
        </script>
</html>
