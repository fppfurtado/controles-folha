<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="mppa.folha.modelo.enumeracoes.Esferas,
				 mppa.folha.modelo.enumeracoes.Poderes,
				 mppa.folha.dao.PessoaFisicaDao,
				 mppa.folha.dao.CargoDao" %>

<c:set var="pfDao" value="${PessoaFisicaDao.getInstancia()}" />
<c:set var="cgDao" value="${CargoDao.getInstancia()}" />
<c:set var="pag_atual" value="1" />

<!DOCTYPE html>
<html>
<head>
<title>Cadastro VÍNCULO</title>
<link href="/controles-folha/resources/estilo.css" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="/controles-folha/resources/validacaoFrontEnd.js" ></script>
</head>
<body>

	<h1>CADASTRO VÍNCULO FUNCIONAL</h1>

	<form action="${vinculoFuncional.id == null ? 'criar' : 'atualizar'}">
	
		<input type="hidden" name="id" value="${vinculoFuncional.id}" />
		
		<label for="pj">PESSOA JURÍDICA: </label>
		<input type="text" id="pj" name="pessoa_juridica" required="required" value="${vinculoFuncional.pessoa_juridica.nome_fantasia}" disabled="disabled" />
		<input type="hidden" name="pessoa_juridica" value="${vinculoFuncional.pessoa_juridica.id}" >
		<label for="mat">MATRÍCULA: </label>
		<input type="text" id="mat" name="matricula" value="${vinculoFuncional.matricula}" />
		<label for="pf">PESSOA FÍSICA: </label>
		<select id="pf" name="pessoa_fisica">
		
			<c:forEach var="pf" items="${pfDao.getRegistrosPaginacao(pag_atual)}">
				<option value="${pf.id}" ${pf.id == vinculoFuncional.pessoa_fisica.id ? 'selected' : ''} >${pf.nome}</option>
			</c:forEach>
		
		</select>
		<label for="cg">CARGO: </label>
		<select id="cg" name="cargo">
		
			<c:forEach var="cg" items="${cgDao.getRegistrosPaginacao(pag_atual)}">
				<option value="${cg.id}" ${cg.id == vinculoFuncional.cargo.id ? 'selected' : ''}>${cg.denominacao}</option>
			</c:forEach>
		
		</select>		


		<label for="dt_ini">DATA INÍCIO: </label>
		<fmt:formatDate value="${vinculoFuncional.data_inicio}" var="dti" pattern="yyyy-MM-dd"/>
		<input type="date" id="dt_ini" name="data_inicio" value="${dti}" />
		<label for="dt_ini">DATA FIM: </label>
		<fmt:formatDate value="${vinculoFuncional.data_fim}" var="dtf" pattern="yyyy-MM-dd"/>
		<input type="date" id="dt_fim" name="data_fim" value="${dtf}" />
		<a href="lotacoes?id_vf=${vinculoFuncional.id}" >LOTAÇÕES</a>
		<a href="doc_margem?id_vf=${vinculoFuncional.id}" >DOCUMENTOS MARGEM</a>
		
		<input type="submit" value="SALVAR" />
	
	</form>

</body>
</html>