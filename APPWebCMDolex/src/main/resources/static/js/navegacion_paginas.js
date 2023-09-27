$(document).ready(function() {

	$("#btnCitas").click(function() {
		$("#contenedorPagina").empty();
	    $.ajax({
	      url: "/CMDolex/citas",
	      type: "GET",
	      dataType: "html",
	      success: function(response) {
			console.log("test2")
	        $("#contenedorPagina").html(response);
	      },
	      error: function(error) {
	        console.log("Error al cargar el archivo JSP:", error);
	      }
	    });
	});
	
	$("#btnRegistroCitas").click(function() {
		$("#contenedorPagina").empty();
	    $.ajax({
	      url: "/CMDolex/registroCitas",
	      type: "GET",
	      dataType: "html",
	      success: function(response) {
	        $("#contenedorPagina").html(response);
	      },
	      error: function(error) {
	        console.log("Error al cargar el archivo JSP:", error);
	      }
	    });
	});
	
	$('#menuPaginas').click();
	$("#menuPaginas").prop("disabled", true);
	
});