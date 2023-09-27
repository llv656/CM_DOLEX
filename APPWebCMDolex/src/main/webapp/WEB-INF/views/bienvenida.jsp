<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta charset="ISO-8859-1">	
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="/CMDolex/static/js/navegacion_paginas.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">		
		<link rel="stylesheet" type="text/css" href="/CMDolex/static/css/consulta_citas.css">
		<title>Inicio</title>
	</head>
	<body>
		
		<!-- Header  -->
		<div class="row" style="display:flex;" id="encabezadoPrincipal">
			<nav class="navbar navbar-dark bg-dark">
				<div class="container-fluid">
			  		<div class="col-sm-2" style="text-align:start;">
				    	<button class="navbar-toggler" type="button" id="menuPaginas" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
				      		<span class="navbar-toggler-icon"></span>
				    	</button>
			    	</div>
				    <div class="col-sm-8">
						<h1>Consultorio medico dolEX</h1>
					</div>
					<div class="col-sm-2">
						<span style="color:white;">${login}</span>
						<img src="${avatar}" alt="Avatar de usuario" style="height:40px;border-radius:50%;">
					</div>
				</div>
			</nav>
			<div class="collapse" id="navbarToggleExternalContent">
			  	<div class="row bg-dark p-4">
			  		<div class="col-sm-2"></div>
			  		<div class="col-sm-4 opcion-contextual">
			  			<button type="button" class="btn btn-primary" id="btnRegistroCitas" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Agregar cita">
			  				<i class="bi bi-hospital menu-modulos"></i>
					    	<i class="bi bi-person-add menu-modulos"></i>
					    	<span class="menu-modulos"> Registro cita </span>
			  			</button>
			    	</div>
			    	<div class="col-sm-4 opcion-contextual">
			    		<button type="button" class="btn btn-primary" id="btnCitas" data-bs-toggle="tooltip" data-bs-placement="bottom" title="Consulta cita">
				    		<i class="bi bi-calendar-week menu-modulos"></i>
				    		<span class="menu-modulos"> Citas </span>
			    		</button>
			    	</div>
			    	<div class="col-sm-2"></div>
				</div>
			</div>
		</div>
		
		<!--Body-->
		<div class="row" id="contenedorPagina"></div>	
		
		<!--Footer-->
		<div class="row">
			<p id="leyenda">© Pie de pagina, derechos de autor...</p>
		</div>
		
	</body>
</html>