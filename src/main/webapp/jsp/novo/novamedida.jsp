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
		<h4 id="text">Novo Ingrediente</h4>
		<fieldset>
			<h4 id="text">Novo</h4>
			<div id="divb">
				<form id=formb action="inserirmedida.action" method="post">
			    	<label>Nome Medida:</label>
			        <input name=nomeMedida type="text" required />
			        <br><br>
			        <div id="divb">
			        	<button id=formb name="button" type="submit">Cadastrar</button></a>
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