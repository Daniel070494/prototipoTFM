<%@ include file="/WEB-INF/jsp/common/Include.jspf"%>

<script>

$(document).ready(function() {

});

</script>
	
	<fieldset>
				
		<legend ><strong>Carrito de Compras</strong></legend>
	
	</fieldset>

		<div class="col-lg-12 col-md-12 col-sm-12" style="padding-right: 0px; padding-left: 0px; margin-bottom: 0px;" id="">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="basic_label">Nombre</label>
				<input type="text" class="form-control"  id="nombre" value="${tienda.nombre_usuario}" disabled="disabled">
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="basic_label">Teléfono</label>
				<input type="text" class="form-control" id="email" value="${tienda.email}" disabled="disabled">
			</div>
			
		
		</div>
		

	<button id="btnRegresar" style="margin-right: 15px;" class="btn btn-primary pull-right" onclick="location.reload();">Regresar al Inicio</button>