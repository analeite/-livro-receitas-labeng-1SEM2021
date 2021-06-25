<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h4 id="text">Gerenciamento de Ingredientes</h4>
	<fieldset>
		<div id="divb">

			<form id=formb action="consultaingredientes.action" method="get">
				<label for="ent_01">ID Ingredientes:</label> 
				<input name=idIngredientes id=ent_01 type="text" />
				<button name="button">Buscar</button>
			</form>
			
			<br> <br>
			
			<form id=formb action="consultanomeingrediente.action" method="get">
				<label for="ent_01">Nome Ingredientes:</label> 
				<input name=nomeIngredientes id=ent_01 type="text" />
				<button name="button">Buscar</button>
			</form>
			
			<br> <br> <br>
			
				<table border=1>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Excluir</th>
						<th>Editar</th>
					</tr>
					<c:forEach var="ingrediente" items="${listaIngredientes}">
						<tr>
							<td><input class="ingrediente.id"
								value="${ingrediente.getIdIngredientes()}" /></td>
							<td><input class="ingrediente.nome"
								value="${ingrediente.getNomeIngredientes()}" /></td>
							<td><form id=formb action="confirmarexclusaoingrediente.action" method="get">
								<input name=idIngredientes value="${ingrediente.getIdIngredientes()}" id=ent_01 type="hidden" />
								<button name="button">Excluir</button>
								</form></td>
							<td><form id=formb action="editaringrediente.action" method="get">
								<input name=idIngredientes value="${ingrediente.getIdIngredientes()}" id=ent_01 type="hidden" />
								<button name="button">Editar</button>
								</form></td>
						</tr>
					</c:forEach>
				</table>
		</div>
		<br>
		<br>
		<div id="divb">
			<form id="formb" formtarget="_self" type="form" action="home.action"
				method="get">
				<input name="homeBTN" type="submit" value="Voltar para a Home" />
			</form>
		</div>
	</fieldset>
</body>
</html>