<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Listagem dos Cavalos</title>
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
				<h5 class="card-title">Listagem dos Cavalos</h5>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nome</th>
							<th scope="col">Número</th>
							<th scope="col">Cor</th>
							<th scope="col">Velocidade</th>
							<th scope="col">Resistência</th>
							<th scope="col">Preço</th>
							<th scope="col">Proprietário</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cavalo" items="${cavalos}">
							<tr>
								<th scope="row">${cavalo.getId()}</th>
								<td>${cavalo.getNome()}</td>
								<td>${cavalo.getNumero()}</td>
								<td>
									<input
										type="color"
										class="form-control form-control-color w-40" id="inputColor"
										value="${cavalo.getCor()}" disabled />
								</td>
								<td>${cavalo.getVelocidade()}</td>
								<td>${cavalo.getResistencia()}</td>
								<td>R$ ${cavalo.getPreco()}</td>
								<td>${cavalo.getProprietario().getNome()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
