<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
	<meta charset="utf-8">
	<link rel="stylesheet" href="estilos.css" />
	
</head>
<body>
	<p id="texto">Teste...</p>
	
	<h1>Bem Vindo ao Livro de Receitas</h1>
	<form method="get" action="sucesso.action">
	<fieldset>
			Nome da Receita: <input name ="nome_receita"/><br/> <br/>
			Ingredientes: <input name ="ingredientes"/><br/> <br/>
			Modo de preparo: <textarea name="modo_preparo"></textarea><br/>
			<input type= "submit">
		</fieldset>
	</form>
</body>
</html>	