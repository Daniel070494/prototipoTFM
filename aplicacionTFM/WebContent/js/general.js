$(document).ready(function() {
	$('#common_loader').hide();
	
	cargar_ofertas();
});

function cargar_ofertas(){
	
	$('#common_loader').show();
	$("#contenedor").empty();	

	
	$.ajax({
		type : "GET",
		url : "./ofertas",
		data: {
		
	},
		success : function(response) {
			$("#contenedor").html(response);
			$('#contenedor').show();
			$('#common_loader').hide();
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
	
}

function verCarrito(){
	
	$('#common_loader').show();
	$("#contenedor").empty();	
	$("#errores").empty();

	var usuario = $('#usuario').val();
	
	$.ajax({
		type : "GET",
		url : "./carrito",
		data: {usuario:usuario
		
	},
		success : function(response) {
			$("#contenedor").html(response);
			$('#contenedor').show();
			$('#common_loader').hide();
		},
		error : function(e) {
			alert("ERROR: ", e);
			console.log("ERROR: ", e);
		}
	});
	
}

function addCarrito(pro_n){
	
	console.log('***Agregar al carrito***');
	
	var cantidad = 1;
	var usuario = $('#usuario').val();
	
	console.log('Producto: ' + pro_n);
	console.log('cantidad: ' + cantidad);
	console.log('usuario: ' + usuario);
	
	$(function () {
		
		var $message= $('<div></div>');
		var $title= $('<i></i>');
		
		$title.append('ATENCI&Oacute;N');		    						
		$message.append('&iquest;Deseas continuar?');
		BootstrapDialog.show({
	            title:$title,
				message: $message,
				buttons: [{
	                label: 'Aceptar',
	                cssClass: 'btn-success',
	                action: function(dialogRef) {  
	                	dialogRef.close();
	                	
	                	$.ajax({
	                		type:'GET',	
	                		url:'./productos/agregarCarrito', 
	                		data: {producto:pro_n,
	                			   usuario:usuario,
	                			   cantidad:cantidad

	                		},
	                		success:function(responseText) {
	                			$("#errores").html(responseText);	  
	                			
	                			setTimeout(
	        						    function() {
	        						    	location.reload();
	        						    }, 3000);
	                		}
	                	}); 
	                },
	            },{ label: 'Cancelar',
		                cssClass: 'btn-danger',
		                action: function(dialogRef) {
		                	dialogRef.close();
		                	
		                },
	            }]
        	});
		});
	
	
}

function editaCarrito(car_n){
	
	console.log('***Agregar al carrito***');
	
	var cantidad = $('#cantidad_'+car_n).val();
	var usuario = $('#usuario').val();
	
	console.log('num carrito: ' + editaCarrito);
	console.log('cantidad: ' + cantidad);

	
	$(function () {
		
		var $message= $('<div></div>');
		var $title= $('<i></i>');
		
		$title.append('ATENCI&Oacute;N');		    						
		$message.append('&iquest;Deseas continuar?');
		BootstrapDialog.show({
	            title:$title,
				message: $message,
				buttons: [{
	                label: 'Aceptar',
	                cssClass: 'btn-success',
	                action: function(dialogRef) {  
	                	dialogRef.close();
	                	
	                	$.ajax({
	                		type:'GET',	
	                		url:'./productos/editaCantidad', 
	                		data: {car_n:car_n,
	                			   cantidad:cantidad

	                		},
	                		success:function(responseText) {
	                			$("#errores").html(responseText);	  
	                			
	                			setTimeout(
	        						    function() {
	        						    	
	        						    	verCarrito();
	        						    }, 3000);
	                		}
	                	}); 
	                },
	            },{ label: 'Cancelar',
		                cssClass: 'btn-danger',
		                action: function(dialogRef) {
		                	dialogRef.close();
		                	
		                },
	            }]
        	});
		});
	
	
}






