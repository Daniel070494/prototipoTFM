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
				<label class="basic_label">Cliente</label>
				<input type="text" class="form-control"  id="nombre" value="${listaCarrito[0].nombre_usuario}" disabled="disabled">
			</div>
			
			<div class="col-lg-4 col-md-4 col-sm-4">
				<label class="basic_label">Usuario</label>
				<input type="text" class="form-control" id="email" value="${listaCarrito[0].email}" disabled="disabled">
			</div>
			
		
		</div>
		
		<div class="col-lg-12 col-md-12 col-sm-12">
		<div class="row" id="listaCarrito" style="margin-left: 15px; margin-right: 15px; margin-top: 15px;">
			<table id="tabla_listaCarrito" class="table table-striped"
				style=" margin-top: 6px; font-size: 12px !important;">
		
				<thead>
					<tr>
						<th>#</th>
						<th>Cantidad</th>
						<th>Producto</th>
						<th>Fecha</th>				
						<th style="text-align: center !important;">Guardar</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="list"	items="${listaCarrito}">
								<tr>
									<td><c:out value="${list.carN}" /></td>
									<td style="width: 50%"><input class="form-control" type="number" id="cantidad_${list.carN}" value="${list.cantidad}"></td>													
									<td><c:out value="${list.nombre_producto}" /></td>
									<td><c:out value="${list.fecha}" /></td>
									<td style="text-align: center !important;"><button type="button" class="btn btn-success" onclick="editaCarrito(${list.carN});" title="Guardar cambios" 
									onclick="">Guardar</button></td>
														
								</tr>
						</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<button id="btnRegresar" style="margin-right: 15px;" class="btn btn-primary pull-right" onclick="location.reload();">Regresar al Inicio</button>