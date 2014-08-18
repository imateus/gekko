<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Detalhamento</title>
 <link rel="stylesheet" href="resources/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="resources/jquery-1.10.2.js"></script>
  <script src="resources/ui/1.10.4/jquery-ui.js"></script>
 <style type="text/css" media="all">
body{}
.label_1{width:150px; align:"right";}
</style>
  
</head>
<body>
	<div id="detalhamento" style="display: none; width: 730px;" class="modal_form">
		<div class="modal_form_header">
			<h2>Detalhe da ocorrência</h2>
		</div>
		<div class="txt-fld">
			<label class="label_1" align="right"> Nome projeto:</label> 
			<select name="nomeProjeto" id="nomeProjeto">
				<option value="0">Selecione...</option>
				<c:forEach items="${typefilters}" var="option">
					<option value="${option.filterTypeId}">
						<c:out value="${option.name}"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="txt-fld">
			<label class="label_1" align="right">Ocorrência:</label> <input id="filterValue" name="ocorrencia"
				type="text" MaxLength="30" size="68" />
		</div>
		<div class="txt-fld">
			<label class="label_1" align="right">Descrição:</label>
			<textarea name="descricao" rows="5" cols="60"></textarea>
			<br />
		</div>
		<div class="txt-fld">
			<label class="label_1" align="right" >Nome do responsável:</label> <input id="filterValue"
				name="nomeResponsavel" type="text" MaxLength="30" size="40" /> <label align="right">Status:</label>
			<select name="status" id="statusOcorrencia">
				<option value="0">Selecione...</option>
				<c:forEach items="${typefilters}" var="option">
					<option value="${option.filterTypeId}">
						<c:out value="${option.name}"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
		<div class="txt-fld">

			<label class="label_1" align="right">Tipo da ocorrência:</label> <input name="tipoOcorrencia"
				type="text" MaxLength="30" size="40" />
		</div>
		<div class="btn-fld">
			<input type="submit" id="salvaOcorrencia" class="blue" value="Salvar" />
			<input class="botao" type="submit" value="Cancelar"  />
		</div>
	</div>
	
	<div id="tabs">
  <ul>
    <li><a href="#historico">Histórico</a></li>
    <li><a href="#anexo">Anexo</a></li>
    
  </ul>
  <div id="historico">
  </div>

  <div id="anexos">
    </div>
</div>
	
</body>
</html>