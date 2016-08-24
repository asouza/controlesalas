<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de computadores</title>
</head>
<body>
	
	<form:form commandName="filtroComputadores" action="/computador/filtraComputadores" method="get">
		<form:select path="salaId" itemLabel="numero" itemValue="id" items="${viewModel.salas}"/>
		<form:errors path="salaId"/>
		<input type="submit" value="Filtrar" />
	</form:form>

	<table>
		<thead>
			<tr>
				<th>Configuração</th>
				<th>Número de série</th>
				<th>Observação</th>
				<th>Sala</th>
				<th>Número na Sala</th>
				<th>Ações</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="computador" items="${viewModel.computadores}">
				<tr>
					<td>${computador.configuracao}</td>
					<td>${computador.numeroDeSerie}</td>
					<td>${computador.observacao}</td>
					<td>${computador.sala.numero}</td>
					<td>${computador.numeroNaSala}</td>
					<td><a href="/computador/${computador.id}/problema/form">Adicionar Problema</a></td>
					<td>${computador.problematico ? "Problematico": "Ok" }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

</body>
</html>