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
	<h4 id="text">Gerenciamento de Receitas</h4>
	<fieldset>
		<div id="divb">

			<form id=formb action="consultareceitas.action" method="get">
				<label for="ent_01">ID Receitas:</label> 
				<input name=idReceitaCompleta id=ent_01 type="text" />
				<button name="button">Buscar</button>
			</form>
			
			<br> <br>
			
			<form id=formb action="consultanomereceita.action" method="get">
				<label for="ent_01">Nome Receitas:</label> 
				<input name=nomeReceitas id=ent_01 type="text" />
				<button name="button">Buscar</button>
			</form>
			
			<br> <br> <br>
			
				<table border=1>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Ingredientes</th>
						<th>Excluir</th>
						<th>Editar</th>
						
					</tr>

					<c:forEach var="receitaCompleta" items="${listaReceitas}">
						<tr>
							<td><input class="receitacompleta.id" type="text"
								value="${receitaCompleta.getIdReceitaCompleta()}" /></td>

							<td><input class="receitacompleta.nome" type="text"
								value="${receitaCompleta.getReceita().getNomeReceitas()}" /></td>

							<td>
                                <c:forEach var="ingredientes" items="${receitaCompleta.getReceitaCompletaIngrediente()}">
                                    <p><input value="${ingredientes.getIdIngrediente().getNomeIngredientes()}" /></p>
                                </c:forEach>
							</td>
							
                            <td><form id=formb action="confirmarexclusaoreceita.action" method="get">
                                <input name=idReceitaCompleta value="${receitaCompleta.getIdReceitaCompleta()}" id=ent_01 type="hidden" />
                                <button name="button">Excluir</button>
                                </form>
                            </td>
                            <td><form id=formb action="editarreceitacompleta.action" method="get">
								<input name=id value="${receitaCompleta.getIdReceitaCompleta()}" id=ent_01 type="hidden" />
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
