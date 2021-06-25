<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
	<link rel="stylesheet" href="./css/estilos.css">  
    
</head>
<body id="background">
		<header id="menu">
			<p id="text">Livro de Receitas Shalom</p>
		</header>
		<h4 id="text">Bem Vindo(a)!</h4>
		<fieldset>
			<h4 id="text">Novo</h4>
			<div id="divb">
				<form id="formb" formtarget="_self" type="form" action="novoingrediente.action" method="get">
					<input name="novoingreBTN" type="submit" value="Novo Ingrediente" />
				</form>
				<form id="formb" formtarget="_self" type="form" action="novareceita.action" method="get">
					<input name="novareceiBTN" type="submit" value="Nova Receita" />
				</form>
			</div>
		</fieldset>
		<br/> <br/> <br/>
		<fieldset>
			<h4 id="text">Gerenciamento</h4>
			<div id="divb">
				<form id="formb" formtarget="_self" type="form" action="consultaingredientes.action" method="get">
					<input name="cadasingreBTN" type="submit" value="Ingredientes Cadastrados" />
				</form>
				<form id="formb" formtarget="_self" type="form" action="gerenciarreceitas.action" method="get">
					<input name="cadasreceiBTN" type="submit" value="Receitas Cadastradas" />
				</form>
			</div>
		</fieldset>
</body>
</html>