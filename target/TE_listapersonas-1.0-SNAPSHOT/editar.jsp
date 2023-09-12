<%@page import="com.emer.gestor"%>
<%
  gestor reg=(gestor) request.getAttribute("mioobjtar");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Redistro de Persona</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly=""></td>
                </tr>
                <tr>
                    <td>Tareas</td>
                    <td><input type="text" name="tarea" value="<%= reg.getTarea() %>"></td>
                </tr>
                <tr>
                    <td>Complemento</td>
                    <td><input type="checkbox" name="estado" value="<%= reg.getEstado() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value]="Enviar"></td>
                </tr>
            </table>   
        </form>
    </body>
</html>
