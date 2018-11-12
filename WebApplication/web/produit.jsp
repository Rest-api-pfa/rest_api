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
            #jsonOutput {
                margin-left:  130px;
            }
            #submit,#delete,#jsonOutput textArea{
                display: none;
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
    
     <div class="col-sm-2">
    <select id="method">
  <option value="GET" selected>GET</option>
  <option value="POST">POST</option>
  <option value="PUT">PUT</option>
  <option value="DELETE">DELETE</option>
</select> 
    </div>
     </div>
  <div class="form-group">
    <label for="libelleInput" class="col-sm-2 control-label">Libelle</label>
    <div class="col-sm-6">
        <input type="text" class="form-control" id="libelleInput" placeholder="Libelle" >
        <input style="display: none" type="text" class="form-control" id="idproduit">
    </div>
    
  </div>
  <div class="form-group">
    <label for="prixInput" class="col-sm-2 control-label">Prix</label>
     <div class="col-sm-6">
     <input type="number" class="form-control" id="prixInput" placeholder="Prix">
    </div>
  </div>
     
    
     
     
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="submit" class="btn btn-primary">Submit</button>
    </div>
       <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="update" class="btn btn-success">Update</button>
    </div>
        <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="delete" class="btn btn-danger">Delete</button>
    </div>
  </div>
      
</form>
       
        <div id="content">
            
        </div> 
         
        <form autocomplete="off"> 
        <div id="jsonOutput" >
            <label for="jsonInput" class=" control-label">JSON OUTPUT :</label>
            <input type="checkbox" name="json" id="jsonInput" value="0" />
            <br>
            <textarea></textarea>
        </div>
       </form>
        
    </body>
    
    <script src="jq.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script>
         function clearInp() {
                document.getElementsByTagName("input").value = "";
                }
                function clearChk() {
                for(var i = 0; i < document.myForm.myCheckboxes.lenght; i++) {
                document.myForm.myCheckboxes.checked = false;
                }
                }
               
     </script>
   <script>
            $(document).ready(function(){
                //var url = "LivreController?action=livres";
                var nom=$("#libelleInput");
                var prix=$("#prixInput");
                var id=$("#idproduit");
                var method=$("#method");
                var submit=$("#submit");
                var search=$("#search");
                var del=$("#delete");
                var content=$("#content");
                var output=$("#jsonOutput textarea");
                var update=$("#update");
              
               init();
                method.change(function() {
                    
                    init();
                    
                    });
                
                submit.click(function(e) {
                    e.preventDefault();
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/produit";
                    
                   var data={id:0,nom:nom.val(),prix:prix.val()};
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
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/produit";
                    
                   var data={id:id.val(),nom:nom.val(),prix:prix.val()};
                   
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
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/produit/";          
                        url =  url+$("#searchInput").val();
                   
                     nom.val("");
                     prix.val("");
                    $.ajax({
                        url: url,
                        type: "GET",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            },
                    success: function(data) {
                        // $("#content").text(JSON.stringify(data));
                        output.val(JSON.stringify(data));
                         if(Array.isArray(data))
                         {
                             nom.val(data[0].nom);
                            prix.val(data[0].prix);
                             for(var i=1;i<data.length;i++)
                             {
                            content.append('<form class="form-horizontal"><div class="form-group"><label class="col-sm-2 control-label">Libelle</label><div class="col-sm-6"><input type="text" class="form-control"  placeholder="Libelle" value="'+data[i].nom+'"></div></div><div class="form-group"><label  class="col-sm-2 control-label">Prix</label><div class="col-sm-6"><input type="number" class="form-control"  placeholder="Prix" value="'+data[i].prix+'"></div></div></form>'); 

                             }
                         }
                        else 
                        {
                            nom.val(data.nom);
                            prix.val(data.prix);
                            id.val(data.id);
                        }
                          
                        
                         
                        }
                    });
                });
                
                //////////delete
                del.click(function(e) {
                    e.preventDefault();
                     var url="http://192.168.9.9:8084/WebApplication2/webresources/produit/";
                     url =  url+$("#searchInput").val();
                    // var data={id:,nom:"",prix:""};
                    // data=JSON.stringify(data);
                     nom.val("");
                     prix.val("");
                    $.ajax({
                        url: url,
                        type: "DELETE",
                        headers: {
                              Accept:  "application/json; charset=utf-8",
                                "Content-Type" : "application/json; charset=utf-8"
                            }
                           
                   
                    });
                });
                
                
              function init(){
                  submit.hide();
                  search.hide();
                  update.hide();
                  del.hide();
                  content.html('');
                  if(method.val()== "GET")
                    {
                        search.show();
                    }
                    else if(method.val()== "POST")
                    {
                        submit.show();  
                    }
                    else if(method.val()=="DELETE")
                    {
                        del.show();
                    }
                     else if(method.val()=="PUT")
                    {
                        update.show();
                    }
                }
                $("#jsonInput").click(function(){
                    output.toggle();
                });
                
                
            });
        </script>
</html>
