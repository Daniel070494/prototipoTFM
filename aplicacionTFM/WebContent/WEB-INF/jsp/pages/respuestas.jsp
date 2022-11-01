<%@ include file="/WEB-INF/jsp/common/Include.jspf"%>
<c:if test="${mensaje.codigo eq '0' }">
	<div class="alert alert-success alert-dismissible">
		<strong>${mensaje.descripcion }</strong>
	</div>
</c:if>

<c:if test="${mensaje.codigo ne '0' }">
	<div class="alert alert-danger alert-dismissible">
		<strong>Ocurrió un problema!</strong>
		<p>${mensaje.descripcion }</p>
	</div>
</c:if>