<%@page import="com.emer.gestor"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("listgest") == null) {
        ArrayList<gestor> lisaux = new ArrayList<gestor>();
        session.setAttribute("listgest", lisaux);
    }
    ArrayList<gestor> lista = (ArrayList<gestor>) session.getAttribute("listgest");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de registros</h1>
        <h3>JORGE LUIS CALLIZAYA DIAZ</h3>
        <a href="MainServlet?op=nuevo">Nuevo registro</a>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Tarea</th>
                <th>Completado</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                    for (gestor item : lista) {

            %>
            <tr>
                <td><%= item.getId() %> </td>
                <td><%= item.getTarea()%></td>
                <td><input type="checkbox" value="<%= item.getEstado()%>" /></td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>" onclick="return(confirm('Esta seguro de eliminar??'))">
                        Eliminar</a>
                </td>
            </tr>
            <%            }
                }
            %>
        </table>
    </body>
</html>
