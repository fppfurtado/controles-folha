<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="mppa.folha.dao.PessoaJuridicaDao" %>
<%@ page import="java.lang.Math" %>

<c:set var="dao" value="${PessoaJuridicaDao.getInstancia()}" />
<c:set var="total_reg" value="${dao.contarRegistros()}" />
<fmt:formatNumber var="num_formatado" value="${Math.ceil(total_reg/param['reg_por_pag'])}" maxFractionDigits="0" />
<c:set var="ultima_pag" value="${num_formatado}" />
<c:set var="pag_atual" value="${param.pag == null ? '1' : param.pag}" />

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

	<h2 class="titulo">LISTA DE PESSOAS JURÍDICAS</h2>
	
	<a class="bt" href="novo">novo</a>
	
	<table class="table table-striped">

		<thead class="thead-dark">
			<tr>
				<th>NOME FANTASIA</th>
				<th>RAZÃO SOCIAL</th>
				<th>ACRÔNIMO</th>
				<th>CNPJ</th>
				<th>ESFERA</th>
				<th>PODER</th>
				<th>VÍNCULOS FUNCIONAIS</th>
				<th>REMOVER</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="pj" items="${dao.getRegistrosPaginacao(pag_atual)}">

				<tr>
					<td><a href="../pessoa-juridica/editar?id=${pj.id}">${pj.nome_fantasia}</a></td>
					<td>${pj.razao_social}</td>
					<td>${pj.acronimo}</td>
					<td>${pj.cnpj}</td>
					<td>${pj.esfera}</td>
					<td>${pj.poder}</td>
					<td><a href="../pessoa-juridica/vinculos-funcionais/listar?id_pj=${pj.id}">vínculos</a>					
					<td><a href="remover?id=${pj.id}">remover</a></td>
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