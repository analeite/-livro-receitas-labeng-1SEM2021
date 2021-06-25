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
	<h4 id="text">Gerenciamento de Medidas</h4>
	<fieldset>
		<h4 id="text">Novo</h4>
		<div id="divb">

			<form id=formb action="consultamedidas.action" method="get">
				<label for="ent_01">ID Medidas:</label> 
				<input name=idMedidas id=ent_01 type="text" />
				<button name="button">Buscar</button>
			</form>
			
			<br> <br>
			
			<form id=formb action="consultanomemedida.action" method="get">
				<label for="ent_01">Nome Ingredientes:</label> 
				<input name=nomeMedidas id=ent_01 type="text" />
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
					<c:forEach var="medida" items="${listaMedidas}">
						<tr>
							<td><input class="medida.id"
								value="${medida.getIdMedidas()}" /></td>
							<td><input class="medida.nome"
								value="${medida.getNomeMedidas()}" /></td>
							<td><form id=formb action="confirmarexclusaomedida.action" method="get">
								<input name=idMedidas value="${medida.getIdMedidas()}" id=ent_01 type="hidden" />
								<button name="button">Excluir</button>
								</form></td>
							<td><form id=formb action="editarmedida.action" method="get">
								<input name=idMedidas value="${medida.getIdMedidas()}" id=ent_01 type="hidden" />
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