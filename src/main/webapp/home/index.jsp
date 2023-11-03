<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="dark">
<head>
<meta charset="UTF-8" />
<title>Home</title>
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
	<jsp:include page="/partials/header.html" />

	<div class="container mt-5">
		<div class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="card mb-3">
						<div class="card-header">Proprietário</div>
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Cadastre um novo proprietário</h5>
											<p class="card-text">Registre um novo proprietário para
												permitir que outros usuários utilizem o sistema.</p>
											<a href="/simulacaoTurfe/proprietario/cadastro.jsp"
												class="btn btn-primary">Cadastrar Proprietário</a>
										</div>
									</div>
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Ver proprietários</h5>
											<p class="card-text">Consulte a lista completa dos
												proprietários registrados em nosso sistema.</p>
											<a
												href="/simulacaoTurfe/ProprietarioList?next=proprietario/listagem.jsp"
												class="btn btn-primary">Listar Proprietários</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="card mb-3">
						<div class="card-header">Cavalo</div>
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Cadastre um novo cavalo</h5>
											<p class="card-text">Registre um novo cavalo e comece a
												participar de competições e apostas.</p>
											<a href="/simulacaoTurfe/cavalo/cadastro.jsp"
												class="btn btn-primary">Cadastrar Cavalo</a>
										</div>
									</div>
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Ver cavalos</h5>
											<p class="card-text">Consulte a lista completa dos
												cavalos registrados em nosso sistema.</p>
											<a href="/simulacaoTurfe/CavaloList?next=cavalo/listagem.jsp"
												class="btn btn-primary">Listar Cavalos</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="card mb-3">
						<div class="card-header">Corridas</div>
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Cadastre uma nova corrida</h5>
											<p class="card-text">Registre uma nova corrida e
												disponibilize-a para que os proprietários inscrevam seus
												cavalos.</p>
											<a href="/simulacaoTurfe/corrida/cadastro.jsp"
												class="btn btn-primary">Cadastrar Corrida</a>
										</div>
									</div>
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Ver corridas</h5>
											<p class="card-text">Consulte a lista completa das
												corridas registradas em nosso sistema.</p>
											<a
												href="/simulacaoTurfe/CorridaList?next=corrida/listagem.jsp"
												class="btn btn-primary">Listar Corridas</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="card mb-3">
						<div class="card-header">Inscrições das Corridas</div>
						<div class="card-body text-center">
							<div class="row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Inscreva seu cavalao em uma corrida</h5>
											<p class="card-text">Faça a inscrição para que seu cavalo possa participar das corridas já agendadas.</p>
											<a href="/simulacaoTurfe/CavaloList?next=CorridaList?next=cavalo/inscricaoCorrida.jsp"
												class="btn btn-primary">Inscrever Cavalo</a>
										</div>
									</div>
								</div>

								<div class="col-sm-6 mb-3 mb-sm-0">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Ver inscrições nas corridas</h5>
											<p class="card-text">Consulte a lista completa dos cavalos inscritos em cada corrida.</p>
											<a
												href="/simulacaoTurfe/InscricaoCorridaList?next=corrida/inscricoes.jsp"
												class="btn btn-primary">Listar Inscrições</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
