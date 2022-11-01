<%@ include file="/WEB-INF/jsp/common/Include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>App de Ventas TFM</title>

	<!-- JS -->

	<script src="../js/jquery.min.js" type="text/javascript"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/DataTable/jquery.dataTables.js"></script>
	<script src="../js/bootstrap-dialog.min.js" type="text/javascript"></script>
	<script src="../js/jquery.table2excel.js"></script>
	<script src="../js/bootstrap-selectpicker/js/bootstrap-select.min.js"></script>
	<script src="../js/general.js" type="text/javascript"></script>
	
	<script src="../dist/DataTables/datatables.min.js" type="text/javascript"></script>
	<script	src="../dist/DataTables/RowGroup-1.1.0/js/dataTables.rowGroup.min.js" type="text/javascript"></script>
	
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	

	<!-- CSS -->
	<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<link rel="stylesheet" href="../js/bootstrap-selectpicker/css/bootstrap-select.min.css">
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />
	<link href="../css/DataTable/jquery.dataTables.css" rel="stylesheet">
	<link href="../css/DataTable/buttons.dataTables.css" type="text/css" rel="stylesheet">
	<link href="../css/estilos.css" rel="stylesheet" type="text/css"/>  
	<link href="../dist/DataTables/datatables.min.css" rel="stylesheet">
	<link href="../dist/DataTables/RowGroup-1.1.0/css/rowGroup.dataTables.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	
	<script type="text/javascript">
	
	
	$('#producto').show();
	
	</script>

</head>
<body>

        <nav class="navbar navbar-expand-lg navbar-light bg-warning" style="background-color: #e3f2fd;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="#"><i>Ventas TFM</i></a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                        <a class="nav-link" href=""><i class="fas fa-home"></i> Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: black"><i class="fas fa-plus-circle"></i> Ofertas del Dia</a>
                    </li>                   
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="color: black" onclick="verCarrito();"><i class="fas fa-cart-plus">(<label style="color: blue">${datosUusario.totalCarrito}</label>)</i> Carrito</a>
                    </li> 
                    <li class="nav-item">
                        <a class="nav-link" href="" style="color: black">Productos</a>
                    </li> 
                </ul>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <!--<form class="form-inline my-2 my-lg-0">-->
                    <input style="width:400px" class="form-control mr-sm-2" id="txtBuscar">
                    <button class="btn btn-outline-light my-2 my-sm-0" id="btnBuscar" style="color: black"><i class="fas fa-search"></i> Buscar</button>
                    <!-- </form>       -->                 
                </ul>                                
                <ul class="navbar-nav btn-group my-2 my-lg-0" role="group">
                    <a style="color: black; cursor: pointer" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fas fa-user-tie"></i> ${datosUusario.email}</a>
                    <div class="dropdown-menu text-center dropdown-menu-right">
                        <a class="dropdown-item" href="#"><img src="../img/user.png" alt="60" height="60"/></a>                        
                        <a class="dropdown-item" href="#">${user}</a>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#myModal" ><label style="color: black">${datosUusario.email}</label></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Controlador?accion=MisCompras">Mis Compras</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="./Controlador?accion=Salir"> <i class="fas fa-arrow-right"> Salir</i></a>                        
                    </div>
                </ul>     
            </div>
        </nav>

		
	<div id="errores">	</div>	
	
		<div id="contenedor" style="margin-top: 5px;">
				
			<div class="common_loader" id="common_loader" style="height: 100%; position: fixed;" onchange=""><span id="loader-ico" class="common_loader_ico"></span></div>
		 </div> 
 
</body>
<input type="hidden" id="usuario" value="${datosUusario.userN}">
</html>