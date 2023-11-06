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

	<div class="container mx-auto mt-5" style="max-width: 40rem">
		<div class="row">
			<div class="mb-3 mb-sm-0">
				<ul class="nav nav-pills" role="tablist">
					<li class="nav-item mx-3" role="presentation">
						<button class="nav-link active" id="login-tab"
							data-bs-toggle="tab" data-bs-target="#login-tab-pane"
							type="button" role="tab" aria-controls="login-tab-pane"
							aria-selected="true">Login</button>
					</li>
					<li class="nav-item mx-3" role="presentation">
						<button class="nav-link" id="cadastro-tab" data-bs-toggle="tab"
							data-bs-target="#cadastro-tab-pane" type="button" role="tab"
							aria-controls="cadastro-tab-pane" aria-selected="false">Cadastro</button>
					</li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active p-5" id="login-tab-pane"
						role="tabpanel" aria-labelledby="home-tab" tabindex="0">
						<h5 class="card-title mb-3">Login</h5>
						<form action="/simulacaoTurfe/UsuarioLogin" method="post">
							<div class="mb-3">
								<label for="emailLogin" class="form-label"> Email: </label> <input
									type="email" class="form-control" name="email" id="emailLogin"
									required />
							</div>
							<div class="mb-3">
								<label for="senhaLogin" class="form-label"> Senha: </label> <input
									type="password" class="form-control" name="senha"
									id="senhaLogin" required />
							</div>
							<button type="submit" class="btn btn-primary">Entrar</button>
						</form>
					</div>
					<div class="tab-pane fade p-5" id="cadastro-tab-pane"
						role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
						<h5 class="card-title mb-3">Cadastro</h5>
						<form action="/simulacaoTurfe/UsuarioAdd" method="post">
							<div class="mb-3">
								<label for="nomeCadastro" class="form-label"> Nome: </label> <input
									type="text" class="form-control" name="nome" id="nomeCadastro"
									required />
							</div>
							<div class="mb-3">
								<label for="emailCadastro" class="form-label"> Email: </label> <input
									type="email" class="form-control" name="email"
									id="emailCadastro" required />
							</div>
							<div class="mb-3">
								<label for="senhaCadastro" class="form-label"> Senha: </label> <input
									type="password" class="form-control" name="senha"
									id="senhaCadastro" required />
							</div>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
