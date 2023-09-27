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
		<script src="/CMDolex/static/js/registro_citas.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">		
		<link rel="stylesheet" type="text/css" href="/CMDolex/static/css/registro_citas.css">
		<title>Consulta citas</title>
	</head>
	<body class="row">
			
			<!-- Modal -->
			<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="staticBackdropLabel">Confirmar datos cita</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body" id="contenidoModal"></div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" id="btnConfirmarCita">Confirmar</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<div class="col-sm-1 C_headerbody"></div>
			
			<div class="col-sm-10" id="contenedor">
				
				<!--Titulo-->
				<div class="row" id="tituloRegistroCitas">
					<h1>Registro citas</h1>				
				</div>
		
				<!--Formulario -->
				<div id="containerform" class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<form class="row">
							<div class="mb-3 row">
								<div class="col-sm-6 ">
									<label for="doctorLabel" class="form-label">Doctor</label>
							  	</div>
							  	<div class="col-sm-6 ">
									<select id="listaDoctores" name="doctor_id" required>
										<option value="">Seleccionar</option>
									</select >
							  	</div>
							</div>
							<div class="mb-3 row">
								<div class="col-sm-6 ">
									<label for="fechaLabel" class="form-label">Fecha</label>
							  	</div>
							  	<div class="col-sm-6 ">
									<input type="date" id="fechaCita" name="fecha_cita" class="form-control" required>
							  	</div>
							</div>
							<div class="mb-3 row">
								<div class="col-sm-6 ">
									<label for="horaLabel" class="form-label">Hora</label>
								</div>
								<div class="col-sm-6 ">
									<select id="listaHorario" name="hora_inicio" required>
										<option value="">Seleccionar</option>
									</select >
							  	</div>
							</div>
							<div class="mb-3 row">
								<div class="col-sm-6 ">
									<label for="nombrePaciente" class="form-label">Nombre paciente</label>
							  	</div>
							  	<div class="col-sm-6 ">
							  		<input type="text" class="form-control" name="nombre_paciente" id="formNombrePaciente" required>
							  	</div>
							</div>
							<div class="mb-3 row">
								<div class="col-sm-6 ">
							  		<label for="correoPaciente" class="form-label">Correo paciente</label>
							  	</div>
							  	<div class="col-sm-6 ">
									<input type="email" class="form-control" name="correo_paciente" id="formCorreoPaciente" required>
							  	</div>
							</div>
						  
							
						</form>
						<div class="row" id="contenedorBtnRegistrar">
							<button class="btn btn-primary" id="btnRegistrarCita" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Registrar</button>
						</div>
					</div>
					
					<div class="col-sm-2"></div>
				</div>

			<div class="col-sm-1 C_headerfooter"></div>
		</div>
	
	</body>
</html>