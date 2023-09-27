$(document).ready(function() {
	
	$.ajax({
      url: "http://localhost:8080/CMDolex/medicos",
      type: "GET",
      dataType: "json",
      success: function(response) {
		$.each(response.response, function(index, object){
			$("#listaDoctores").append(
                "<option value=\""+object.doctor_id+"\">"+object.nombre_completo+"</option>"
            );
		});
      },
      error: function(error) {
        console.log("Error al cargar el archivo JSP:", error);
      }
    });
    

	$('#fechaCita').on('keydown', function(e) {
		e.preventDefault(); 
	});
	
	$('#fechaCita').on('change', function(e) {
		var doctorID = $("#listaDoctores").val();
		var fechaCita = $(this).val();
		
		fechaFormato = '';
    	if (fechaCita !== null && fechaCita !== '') {
			var partesFecha = fechaCita.split("-");
			var fechaFormato = partesFecha[2] + "-" + partesFecha[1] + "-" + partesFecha[0];	
		}
		
		getHorarios(doctorID, fechaFormato);
	});
	
	$('#listaDoctores').on('change', function(e) {
		var doctorID = $(this).val();
		var fechaCita = $('#fechaCita').val();
		
		fechaFormato = '';
    	if (fechaCita !== null && fechaCita !== '') {
			var partesFecha = fechaCita.split("-");
			var fechaFormato = partesFecha[2] + "-" + partesFecha[1] + "-" + partesFecha[0];	
		}
		
		getHorarios(doctorID, fechaFormato);
	});
	
	$("#btnConfirmarCita").click(function(event) {
        var doctorID = $('#listaDoctores').val();
        var fechaCita = $("#fechaCita").val();
        var horaCita = $("#listaHorario").val();
        var paciente = $("#formNombrePaciente").val();
        var correoPaciente = $("#formCorreoPaciente").val();
        
        fechaFormato = '';
    	if (fechaCita !== null && fechaCita !== '') {
			var partesFecha = fechaCita.split("-");
			var fechaFormato = partesFecha[2] + "-" + partesFecha[1] + "-" + partesFecha[0];	
		}

	    var data = {};
	    
	    data["doctor_id"] = doctorID;
	    data["fecha_cita"] = fechaFormato;
	    data["hora_inicio"] = horaCita;
	    data["nombre_paciente"] = paciente;
	    data["correo_paciente"] = correoPaciente;
	
	
	    $.ajax({
	      url: "http://localhost:8080/CMDolex/citas",
	      type: "POST",
	      dataType: "json",
	      data: JSON.stringify(data), // Convertir los datos a JSON
	      contentType: "application/json",
	      success: function(response) {
	        console.log("Respuesta de la API externa:", response);
	      },
	      error: function(error) {
	        console.log("Error en la solicitud:", error);
	      }
	    });
        
        window.location.href = "/CMDolex";
    });
    
    $("#btnRegistrarCita").click(function(event) {
		$("#contenidoModal").empty();
		$("#contenidoModal").append('<div class="row" id="modalDoctor"></div>');
		$("#modalDoctor").append('<div class="col-sm-6"><p>Doctor:</p></div>');
		$("#modalDoctor").append('<div class="col-sm-6"><p>'+$('#listaDoctores option:selected').text()+'</p></div>');
		
		$("#contenidoModal").append('<div class="row" id="modalFecha"></div>');
		$("#modalFecha").append('<div class="col-sm-6"><p>Fecha:</p></div>');
		$("#modalFecha").append('<div class="col-sm-6"><p>'+$('#fechaCita').val()+'</p></div>');
		
		$("#contenidoModal").append('<div class="row" id="modalHora"></div>');
		$("#modalHora").append('<div class="col-sm-6"><p>Hora:</p></div>');
		$("#modalHora").append('<div class="col-sm-6"><p>'+$('#listaHorario option:selected').text()+'</p></div>');
		
		$("#contenidoModal").append('<div class="row" id="modalNombrePaciente"></div>');
		$("#modalNombrePaciente").append('<div class="col-sm-6"><p>Paciente:</p></div>');
		$("#modalNombrePaciente").append('<div class="col-sm-6"><p>'+$('#formNombrePaciente').val()+'</p></div>');
		
		$("#contenidoModal").append('<div class="row" id="modalCorreoPaciente"></div>');
		$("#modalCorreoPaciente").append('<div class="col-sm-6"><p>Correo:</p></div>');
		$("#modalCorreoPaciente").append('<div class="col-sm-6"><p>'+$('#formCorreoPaciente').val()+'</p></div>');
	});
	
	function getHorarios(doctorID, fechaCita) {
		$.ajax({
	      url: 'http://localhost:8080/CMDolex/horarios?doctor_id='+doctorID+'&fecha='+fechaCita,
	      type: "GET",
	      dataType: "json",
	      success: function(response) {
			var elementoSeleccionar = '<option value="">Seleccionar</option>';
			$("#listaHorario").empty();
			$('#listaHorario').append(elementoSeleccionar);
			$.each(response.response, function(index, object){
				if(object.citaAgendada){
					$("#listaHorario").append(
		                '<option style="background:#F56B4C; color:white;" value="'+object.horaInicioCita+'" disabled>'+object.horaInicioCita+'</option>'
		            );
				} else {
					$("#listaHorario").append(
		                '<option style="background:#39B4F7; color:white;" value="'+object.horaInicioCita+'" >'+object.horaInicioCita+'</option>'
		            );	
				}
				
			});
	      },
	      error: function(error) {
			var elementoSeleccionar = '<option value="">Seleccionar</option>';
			$("#listaHorario").empty();
			$('#listaHorario').append(elementoSeleccionar);
	        console.log("Error al cargar el archivo JSP:", error);
	      }
	    });
	}
	
});