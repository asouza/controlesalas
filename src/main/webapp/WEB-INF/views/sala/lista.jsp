<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <table>
		<thead>
			<tr>
				<th>Sala</th>
				<th>Quantidade de Máquinas</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sala" items="${salas}">
				<tr>
					<td>${sala.numero}</td>
					<td>${sala.quantidadeMaquinas}</td>
					<td><a href="/sala/${sala.id}/problema/form">Adicionar Problema</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>