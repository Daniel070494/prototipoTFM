/**
 * 
 */
var paginas = 0;

$(document).ready(
		function() {
			
			
			
			ajaxGet(1);
			
			pagination();
			
			function pagination(){
				$("#pagination").twbsPagination({
					
					totalPages:50,
					visiblePages:5,
					onPageClick: function(e){
						$("ul > li").click(function (e){
							//alert($(this).text());//numero
							var pagina = $(this).text();
							ajaxGet(pagina);
						});
					}
					
				});
				
			}
			// DO GET
			function ajaxGet(page) {
				$("#tbodyid").empty();
				$.ajax({
					type : "GET",
					url : "./servicios/lista",
					data : {page:page,limit:10},
					success : function(result) {
						console.log(result);
						
						$.each(result, function(i, servicio) {

							var customerRow = '<tr>' + '<td>' + servicio.serN
									+ '</td>' + '<td>'
									+ servicio.cfaN + '</td>'
									+ '</td>' + '</tr>';

							$('#customerTable tbody').append(customerRow);

						});

						$("#customerTable tbody tr:odd").addClass("info");
						$("#customerTable tbody tr:even").addClass("success");
						
					},
					error : function(e) {
						alert("ERROR: ", e);
						console.log("ERROR: ", e);
					}
				});
			}
		});