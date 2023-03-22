<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.caio.gerenciador.servlet.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>		
	<ul>
		<%
			List<Empresa> lista = (List<Empresa>)request.getAttribute("Empresas");
			for (Empresa empresa : lista) {
		%>
			<li><%= empresa.getNome() %></li>
		<%	
			}
		 %>
	</ul>
</body>
</html>