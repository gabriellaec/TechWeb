<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.gabriellaec.*" %>
<html>

<head>
<meta charset="UTF-8">
<title>Lista Pessoas</title>
</head>
<body>
<jsp:useBean id="dao" class="br.edu.insper.gabriellaec.DAO"/> 

 <table border="1">
 <tr>
 <td><b>#</b></td>
 <td><b>Nome Tarefa</b></td>
  <td><b>Conteúdo</b></td>
  <td><b>Categoria</b></td>
  <td><b>Nome Usuário</b></td>
<td><b>Data Entrega</b></td>
 </tr>
 
 <c:forEach var="tarefa" items="${tarefas}" varStatus="id">
 <tr bgcolor="#${id.count%2 == 0 ? 'bbffcc' : 'ffffbb' }" >
  <td>${id.count}</td>
  <td>${tarefa.nometarefa}</td>
  <td>${tarefa.conteudo}</td>
  <td>${tarefa.categoria}</td>
  <td>${tarefa.nome_usuario}</td>
 
<td>
<fmt:formatDate
 value="${tarefa.data.time}"
 pattern="dd/MM/yyyy"/>
 </td>

 </tr>
 </c:forEach>

</table>
</body>
</html>