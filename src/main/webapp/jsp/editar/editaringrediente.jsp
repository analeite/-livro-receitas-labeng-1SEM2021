<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Nova Medida</title>
	<link rel="stylesheet" href="./css/estilos.css">  
    
</head>
<body id="background">
		<header id="menu">
			<p id="text">Livro de Receitas Shalom</p>
		</header>
		<h4 id="text">Editar Ingrediente</h4>
		<fieldset>
			<h4 id="text">Editar</h4>
			<div id="divb">
			
			<%	            
	            String id = request.getAttribute("id").toString();
	            String nome = (String) request.getAttribute("nome");
        	%>
			
				<form id=formb action="alteraringrediente.action" method="post">
			    	<label>Nome Ingrediente:</label>
			    	<input name=id value="<%= id%>" id=ent_01 type="hidden" />
					<input name=nome value="<%= nome%>" id=ent_01 />
			        <br><br>
			        <div id="divb">
			        	<button id=formb name="button" type="submit">Editar</button></a>
			        </div>
        		</form>
			</div>
			<br><br>
			<div id="divb">
				<form id="formb" formtarget="_self" type="form" action="home.action" method="get">
					<input name="homeBTN" type="submit" value="Voltar para a Home" />
				</form>  
			</div>
		</fieldset>
</body>
</html>