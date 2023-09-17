<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Inscrição de Cavalo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous" defer></script>
<script src="../scripts/main.js" defer></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">
							Opções </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/cadastroProprietario/">Cadastrar
									Proprietário</a></li>
							<li><a class="dropdown-item" href="/cadastroCavalo/">Cadastrar
									Cavalo</a></li>
							<li><a class="dropdown-item" href="/agendamentoCorrida/">Agendar
									Corrida</a></li>
							<li><a class="dropdown-item" href="/inscricaoCavalo/">Inscrever
									Cavalo em Corrida</a></li>
						</ul></li>
				</ul>
			</div>
			<a class="navbar-brand" href="/">Administração - Turfe</a>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 mb-3 mb-sm-0">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Inscreva um cavalo em uma corrida</h5>
						<form>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputCavalo" class="form-label">Cavalo:</label>
									<select class="form-select" id="inputCavalo"
										aria-label="Cavalo a disputir corrida" required>
										<option selected>Selecione um Cavalo</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
								<div class="col-md-6 mb-3">
									<label for="inputCorrida" class="form-label">Corrida:</label>
									<select class="form-select" id="inputCorrida"
										aria-label="Corrida a ser disputada">
										<option selected>Selecione uma Corrida</option>
										<option value="1">One</option>
										<option value="2">Two</option>
										<option value="3">Three</option>
									</select>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Enviar</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Observações:</h5>
						<p class="card-text"></p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
