$(document).ready(function() {
  // DataTable en español
  $('#table_id').DataTable({
    "language" : {
      "decimal" : "",
      "emptyTable" : "Sin datos disponible en esta tabla",
      "info" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
      "infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
      "infoFiltered" : "(filtrado de un total de _MAX_ registros)",
      "infoPostFix" : "",
      "thousands" : ",",
      "lengthMenu" : "Mostrar _MENU_ registros",
      "loadingRecords" : "Cargando...",
      "processing" : "Procesando...",
      "search" : "Buscar:",
      "zeroRecords" : "No se encontraron resultados",
        "paginate" : {
        "first" : "Primera",
        "last" : "Última",
        "next" : "Siguiente",
        "previous" : "Anterior"
      },
      "aria" : {
        "sortAscending" : ": Activar para ordenar la columna de manera ascendente",
        "sortDescending" : ": Activar para ordenar la columna de manera descendente"
      }
    }
  });
  
  // Mostrar u ocultar columna de DataTable
  $('a.toggle-vis').on( 'click', function (e) {
    e.preventDefault();
    
    // Get the column API object
    var column = $('#table_id').DataTable().column( $(this).attr('data-column') );
    
    // Toggle the visibility
    column.visible( ! column.visible() );
  });  
});

// Texto a buscar en DataTable
$(document).on('keyup', '#txtSearch', function() {
    $('#table_id')
      .DataTable()
      .search($('#txtSearch').val(), true, false)
      .draw();
});
