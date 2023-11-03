<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Listagem dos Proprietários</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous" defer></script>
<script src="scripts/main.js" defer></script>
</head>
<body>
	<jsp:include page="../partials/header.html" />

	<div class="container mt-5">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">Listagem dos Proprietários</h5>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">CPF</th>
							<th scope="col">Email</th>
							<th scope="col">Telefone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="proprietario" items="${proprietarios}">
							<tr>
								<th scope="row">${proprietario.getId()}</th>
								<td>${proprietario.getNome()}</td>
								<td>${proprietario.getCpf()}</td>
								<td>${proprietario.getEmail()}</td>
								<td>${proprietario.getTelefone()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
