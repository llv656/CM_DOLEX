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
		<script src="/CMDolex/static/js/citas.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">		
		<link rel="stylesheet" type="text/css" href="/CMDolex/static/css/consulta_citas.css">
		<title>Consulta citas</title>
	</head>
	<body class="row">
	
			<div class="col-sm-1 C_headerbody"></div>
			
			<div class="col-sm-10" id="contenedor">
				
				<!--Header-->
				<div class="row" id="divTitleContainer">
					<h1>CITAS</h1>
				</div>
		
				<!--Cuerpo -->
				<div class="row" id="divTable">
				<!--contenido de la tabla-->
						<table class="table">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col">
										<select style="opacity: 0.3;" id="listaDoctores"></select>
									</th>
									<th scope="col">
										<input type="date" style="opacity: 0.3;" id="fechaFiltro" class=""></input>
										<i class="bi bi-x-circle-fill" id="iconCleanDate"></i>
									</th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>
									<th scope="col"></th>
								</tr>
							</thead>
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">#</th>
									<th scope="col">Doctor<i class="glyphicon glyphicon-search"></i></th>
									<th scope="col">Fecha<i class="glyphicon glyphicon-search"></i></th>
									<th scope="col">Hora<i class=" glyphicon glyphicon-calendar"></i></th>
									<th scope="col">Paciente<i class="glyphicon glyphicon-chevron-down"></i> </th>
									<th scope="col">Correo paciente<i class="glyphicon glyphicon-chevron-down"></i> </th>
									<th scope="col">Estatus cita<i class="glyphicon glyphicon-chevron-down"></i> </th>
								</tr>
							</thead>
							<tbody id="cuerpoTabla"></tbody>
							
						</table>
						
					</div>
					
					<div class="row" id="divPagination">
						<nav>
							<ul class="pagination" id="paginador">
							  <li class="page-item active" id="paginaInicial"><a class="page-link paginas" href="#">1</a></li>
							</ul>
						</nav>
					</div>
				</div>

			<div class="col-sm-1 C_headerfooter"></div>
	
	</body>
</html>