<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
        <style>
            span{
                color:red;
            }
        </style>
    </head>
    <body>
        Sua receita  
            <span>
            <%=request.getAttribute("nomeReceita")%>
            </span>
            foi inserida com sucesso!
    </body>
</html>