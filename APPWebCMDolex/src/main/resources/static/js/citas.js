$(document).ready(function() {
	const numeroElementos = 10;
	
	$('#fechaFiltro').on('keydown', function(e) {
		e.preventDefault(); 
	});
	
	$("#iconCleanDate").click(function() {
        $("#fechaFiltro").val('');
        $("#cuerpoTabla").empty();
		var doctorID = $('#listaDoctores').val();
	    
	    buildTable(0,numeroElementos,doctorID,'');
    });

    $("#cuerpoTabla").empty();
    buildTable(0,numeroElementos,'','');
    
    
    function buildTable(pagina, noElementos, doctorID, fecha) {
    	fechaFormato = '';
    	if (fecha !== null && fecha !== '') {
			var partesFecha = fecha.split("-");
			var fechaFormato = partesFecha[2] + "-" + partesFecha[1] + "-" + partesFecha[0];	
		}
    
    	// Array de URLs para las peticiones
        var requests = [
            { url:'http://localhost:8080/CMDolex/citas?page_number='+pagina+'&page_size='+noElementos+'&doctor_id='+doctorID+'&fecha='+fechaFormato, id: 'getCitas' },
            { url:'http://localhost:8080/CMDolex/medicos', id: 'getMedicos' }
        ];

        // Array de promesas
        var promises = [];

        // Objeto para almacenar las respuestas por identificador
        var responses = {};
        // Crear las solicitudes AJAX
        $.each(requests, function(index, request) {
            var promise = $.ajax({
                url: request.url,
                type: 'GET',
                async: true
            });

            promises.push(promise);
        });

        // Ejecutar todas las solicitudes concurrentemente
        $.when.apply($, promises)
        .done(function() {
            $.each(arguments, function(index, response) {
                var request = requests[index];
                responses[request.id] = response[0];
            });

            // Utilizar las respuestas almacenadas
            var almacenCitas = responses['getCitas'];
            var almacenMedicos = responses['getMedicos'];

			agregarContenidoTabla(almacenCitas);
            agregarPaginador(almacenCitas);
            agregarDoctoresTabla(almacenMedicos,doctorID);	
			

        }).fail(function(xhr, status, error) {
            console.log('Error:', error);
        }).always(function() {
			console.log('Solicitud terminada');
		});
		

    }
    
    function agregarDoctoresTabla(responseMedicos,doctorID) {
		$('#listaDoctores').empty();
		var elementoSeleccionar = '<option value="">Seleccionar</option>';
		$('#listaDoctores').append(elementoSeleccionar);
		$.each(responseMedicos.response, function(index, object){
			$("#listaDoctores").append(
                "<option value=\""+object.doctor_id+"\">"+object.nombre_completo+"</option>"
            );
		});
		if (doctorID !== null && doctorID !=='') {
			$('#listaDoctores').val(doctorID);	
		} else {
			$('#listaDoctores').val("");
		}
		
	}
    
    function agregarContenidoTabla(responseCitas) {
		
        $.each(responseCitas.response.items, function(index, object){
			index=index+1;
            $("#cuerpoTabla").append(
                "<tr>"+
                    "<td><input class=\"form-check-input\" type=\"radio\" value=\""+object.cita_id+"\"></td>"+
                    "<td>"+index+"</td>"+
                    "<td>"+object.nombre_doctor+"</td>"+
                    "<td>"+object.fecha_cita+"</td>"+
                    "<td>"+object.hora_inicio+"</td>"+
                    "<td>"+object.nombre_paciente+"</td>"+
                    "<td>"+object.correo_paciente+"</td>"+
                    "<td>"+object.estatus+"</td>"+
                "</tr>"
            ); 
        });
        
    }
    
    function agregarPaginador(responseCitas) {
		var paginaInicial = '<li class="page-item" id="paginaInicial"><a class="page-link paginas" href="#" id="paginaInicialBtn">1</a></li>';
		$('#paginador').empty();
		$('#paginador').append(paginaInicial);
		//$("#paginaInicialBtn").click();
		for (var i = 1; i < responseCitas.response.pages; i++) {
			var numeroPagina = i;
			var numeroPaginaText = i+1;
			var nuevaPagina = $('<li class="page-item" id="paginadorSelect'+numeroPagina+'"><a class="page-link" href="#" id="pagina'+numeroPagina+'">'+numeroPaginaText+'</a></li>');
			$('#paginador').append(nuevaPagina);
			
			$('#pagina'+numeroPagina).on("click", function(event) {
				$("#cuerpoTabla").empty();
				$(".page-item").removeClass("active");
				$('#paginadorSelect'+numeroPagina).addClass("active");
				
			    var pagina = numeroPagina;
			    var doctorID = $('#listaDoctores').val();
			    var fecha = $('#fechaFiltro').val();
			    
			    buildTable(pagina,numeroElementos,doctorID,fecha);
			});	
		}
		
		$('#paginaInicialBtn').on("click", function(event) {
			$("#cuerpoTabla").empty();
		    var doctorID = $('#listaDoctores').val();
		    var fecha = $('#fechaFiltro').val();
		    $(".page-item").removeClass("active");
		    $('#paginaInicial').addClass("active");
		    
		    buildTable(0,numeroElementos,doctorID,fecha);
		});
	}
	
	$('#listaDoctores').on("change", function(event) {
		$("#cuerpoTabla").empty();
		var doctorID = $(this).val();
	    var fecha = $('#fechaFiltro').val();
	    
	    
	    buildTable(0,numeroElementos,doctorID,fecha);
	});
	
	$('#fechaFiltro').on("change", function(event) {
		$("#cuerpoTabla").empty();
		var doctorID = $('#listaDoctores').val();
	    var fecha = $(this).val();
	    
	    
	    buildTable(0,numeroElementos,doctorID,fecha);
	});
    
});