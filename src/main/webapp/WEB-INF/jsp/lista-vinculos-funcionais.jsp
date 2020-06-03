<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="mppa.folha.dao.VinculoFuncionalDao" %>
<%@ page import="java.lang.Math" %>

<c:set var="dao" value="${VinculoFuncionalDao.getInstancia()}" />
<c:set var="total_reg" value="${dao.contarRegistros()}" />
<fmt:formatNumber var="num_formatado" value="${Math.ceil(total_reg/10)}" maxFractionDigits="0" />
<c:set var="ultima_pag" value="${num_formatado}" />
<c:set var="pag_atual" value="${param.pag == null ? 1 : param.pag}" />

<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/controles-folha/resources/estilo.css" />
</head>
<body>

	<h2 class="titulo">LISTA DE VÍNCULOS FUNCIONAIS</h2>
	<h4>${pj.nome_fantasia}</h4>
	
	<a class="bt" href="novo?id_pj=${pj.id}">novo</a>
	
	<table class="table table-striped">

		<thead class="thead-dark">
			<tr>
				<th>MATRÍCULA</th>
				<th>NOME</th>
				<th>CARGO</th>
				<th>DATA INÍCIO</th>
				<th>DATA FIM</th>
				<th>LOTAÇÕES</th>
				<th>DOCUMENTOS MARGEM</th>
				<th>REMOVER</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="vf" items="${dao.getVinculosPJ(pj.id)}">

				<tr>
					<td><a href="editar?id=${vf.id}">${vf.matricula}</a></td>
					<td>${vf.pessoa_fisica.nome}</td>
					<td>${vf.cargo.denominacao}</td>
					<td><fmt:formatDate value="${vf.data_inicio}" pattern="dd/MM/yyyy"/></td>
					<td><fmt:formatDate value="${vf.data_fim}" pattern="dd/MM/yyyy"/></td>
					<td><a href="lotacoes/listar?id_vf=${vf.id}">lotações</a></td>
					<td><a href="doc-margem/listar?id_vf=${vf.id}">documetos margem</a></td>
					<td><a href="remover?id=${vf.id}">remover</a></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>
	
	<c:if test="${pag_atual > 1}">
		<a href="listar?pag=${pag_atual-1}" class="paginacao" >&lt;</a>
	</c:if>
	<c:if test="${pag_atual < ultima_pag}">
		<a href="listar?pag=${pag_atual+1}" class="paginacao" >&gt;</a>
	</c:if>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>