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
	<title>Nova Receita</title>
	<link rel="stylesheet" href="./css/estilos.css">  
    
</head>
<body id="background">
		<header id="menu">
			<p id="text">Livro de Receitas Shalom</p>
		</header>
		<h4 id="text">Nova Receita</h4>
		<fieldset>
			<div id="divb">
				<form id=formb action="inserirreceita.action" method="post">
			    	<label>Nome Receita:</label>
			        <input name=nomeReceita type="text" required />
			        <br><br>
			        <label>Descrição:</label>
			        <input name=desc type="text" required />
			        <br><br>
					
			        <br><br>
					
					<table>
						<tr>
							<th>Quantidade</th>
							<th>Nome</th>
							<th>Selecionar</th>
						</tr>
						<c:forEach var="ingrediente" items="${ingredientes}">
							<tr>
								<td><input name="quantidade" value="0" type="text"/></td>
								<td><input class="ingrediente.nome"
									value="${ingrediente.getNomeIngredientes()}" />
								</td>
								<td><input class="ingrediente.id"
									value="${ingrediente.getIdIngredientes()}" type="checkbox" name="idIngrendientes"/></td>
							</tr>
						</c:forEach>
					</table>
			   		<br><br>
			        
			        <label>Modo de Preparo:</label>
			        <input name=modoPreparo type="text" required />
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
