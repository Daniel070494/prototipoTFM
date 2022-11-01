<%@ include file="/WEB-INF/jsp/common/Include.jspf"%>

<script type="text/javascript">
function add_Carrito(pro_n){
			
console.log('Abriendo modal');
		
			$('#modalCliente').click();
		
}
</script>

	<fieldset>
				
		<legend style="margin-left: 10px; font-size: 50px;"><strong>Productos en Oferta</strong></legend>
	
	</fieldset>
		<div class="container mt-4">
			<h1>Comida</h1>
		            <div class="row">
		                <c:forEach var="p" items="${comida}">
		                    <div class="col-sm-4">
		                        <div class="form-group">
		                            <div class="card">
		                                <div class="card-header">
		                                    <label class="col-sm-12">${p.nombre}</label>                                    
		                                </div>
		                                <div class="card-body text-center d-flex">
		                                    <i class="fas fa-dollar-sign" style="color: #098503 !important; margin-right:  20px;">${p.precio}</i><br>
		                                    <img src="${p.imagen}" width="200" height="170">
		                                </div>
		                                <div class="card-footer">
		                                    <div class="col-sm-12">                                       
		                                        <p>${p.descripcion}</p>
		                                        <p style="color: #0CBB04 !important;">Envio gratis...</p>
		                                       
		                                    </div>
		                                    <div class=" col-sm-12 text-center">                                
		                                        <a href="#" data-toggle="modal" data-target="#add_carrito" class="btn btn2 btn-outline-primary"  onclick="addCarrito('${p.pro_n}')">Agregar a Carrito<i class="fas fa-cart-plus"></i></a>
		                                        <a href="#" class="btn btn-danger">Comprar</a>
		                                    </div>                         
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </c:forEach>
		            </div>
		        </div>
	<div class="container mt-4">
	<h1>Celulares</h1>
            <div class="row">
                <c:forEach var="p" items="${celulares}">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="card">
                                <div class="card-header">
                                    <label class="col-sm-12">${p.nombre}</label>                                    
                                </div>
                                <div class="card-body text-center d-flex">
                                    <i class="fas fa-dollar-sign" style="color: #098503 !important; margin-right: 20px;">${p.precio}</i><br>
                                    <img src="${p.imagen}" width="200" height="170">
                                </div>
                                <div class="card-footer">
                                    <div class="col-sm-12">                                       
                                        <p>${p.descripcion}</p>
                                        <p style="color: #0CBB04 !important;">Envio gratis...</p>
                                       
                                    </div>
                                    <div class=" col-sm-12 text-center">                                
                                        <a href="#" data-toggle="modal" data-target="#add_carrito" class="btn btn2 btn-outline-primary"  onclick="addCarrito('${p.pro_n}')">Agregar a Carrito<i class="fas fa-cart-plus"></i></a>
                                        <a href="#" class="btn btn-danger">Comprar</a>
                                    </div>                         
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
		  
        
        <!-- Modal -->
            <div class="modal" id="add_carrito" role="dialog" style="position: fixed;
              top: 180px; margin-left: 30%; padding: 10px; ">
                <div class="modal-dialog">
				
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Capture la cantidad</h4>
                        </div>
                       <div id="mensajeSitio"></div> 
                        <div class="modal-body">
							<input id="nombreCte" class="form-control" value="" onkeypress="return check(event)">
							<input type="hidden" id="idSitio" class="form-control" value="" onkeypress="return check(event)">
                        </div>
                        <div class="modal-footer">
                        	<button type="button" class="btn btn-success" onclick="actualizaIDCliente();">Guardar</button>
                            <button id="btnCerrar" type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>

                </div>
            </div>