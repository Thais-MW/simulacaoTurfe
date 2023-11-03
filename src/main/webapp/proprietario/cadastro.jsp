<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" data-bs-theme="light">
<head>
<meta charset="UTF-8" />
<title>Cadastro de Proprietário</title>
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
	<jsp:include page="../partials/header.html" />

	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-8 mb-3 mb-sm-0">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Cadastre um novo proprietário</h5>
						<form action="/simulacaoTurfe/ProprietarioAdd" method="get">
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputNome" class="form-label">Nome:</label> <input
										name="nome" type="text" class="form-control" id="inputNome"
										required />
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputCpf" class="form-label">CPF:</label> <input
										name="cpf" type="text" class="form-control" id="inputCpf"
										required />
								</div>
								<div class="col-md-3 mb-3">
									<label for="inputTelefone" class="form-label">Telefone:</label>
									<input name="telefone" type="tel" class="form-control"
										id="inputTelefone" required />
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="inputEmail" class="form-label">Email:</label> <input
										name="email" type="email" class="form-control" id="inputEmail"
										required />
								</div>
								<div class="col-md-6 mb-3">
									<label for="inputSenha" class="form-label">Senha:</label> <input
										name="senha" type="password" class="form-control"
										id="inputSenha" />
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


	<div class="toast-container position-fixed bottom-0 end-0 p-3">
		<div id="liveToast"
			class="toast ${proprietarioCadastrado ? 'show' : 'hide'}"
			role="alert" aria-live="assertive" aria-atomic="true">
			<div class="toast-header">
				<strong class="me-auto">Proprietário
					${proprietario.getNome()} adicionado com sucesso!</strong>
				<button type="button" class="btn-close" data-bs-dismiss="toast"
					aria-label="Close"></button>
			</div>
		</div>
	</div>
</body>
</html>
