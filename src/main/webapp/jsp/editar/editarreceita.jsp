<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.List"%>
<%@page import="main.java.model.Ingrediente"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editar Receita</title>
	<link rel="stylesheet" href="./css/estilos.css">  
    
</head>
<body id="background">
		<header id="menu">
			<p id="text">Livro de Receitas Shalom</p>
		</header>
		<h4 id="text">Editar Receita</h4>
		<fieldset>
			<h4 id="text">Editar</h4>
			<div id="divb">
			
			<%	            
	            String id = request.getAttribute("id").toString();
	            String nome = (String) request.getAttribute("nome");
	            String descricao = (String) request.getAttribute("descricao");
	            String preparo = (String) request.getAttribute("preparo");

        	%>
			
				<form id=formb action="alterarreceitacompleta.action" method="post">
			    	<label>Nome Receita:</label>
			    	<input name=id value="<%= id%>" id=ent_01 type="hidden" />
					<input name=nome value="<%= nome%>" id=ent_01 />
			        <br><br>
			        <label>Descrição:</label>
					<input name=descricao value="<%= descricao%>" id=ent_01 />
			        <br><br>
			        
			        <table>
						<tr>
							<th>Quantidade</th>
							<th>Nome</th>
							<th>Selecionar</th>
						</tr>
						<c:forEach var="ingrediente" items="${ingredientes}" varStatus="loop">
							<tr>
								<td><input id="quantidade" name="quantidade" value="${quantidadesDaReceita.get(loop.index)}" type="text"/></td>
								<td><input class="ingrediente.nome"
									value="${ingrediente.getNomeIngredientes()}" />
								</td>
								<td><input class="ingrediente.id"
									value="${ingrediente.getIdIngredientes()}"
									 type="checkbox" name="idIngredientes" ${ingredientesdareceita.get(loop.index) ? "checked" : ""}/></td>
							</tr>
						</c:forEach>
			       	</table>
			        <label>Modo de Preparo:</label>
					<input name=preparo value="<%= preparo%>" id=ent_01 />
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
