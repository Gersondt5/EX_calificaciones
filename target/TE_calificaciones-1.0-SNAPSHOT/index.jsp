
<%@page import="com.emergentes.te_calificaciones.Calificaciones"%>
<%@page import="java.util.ArrayList"%>
<% 
    //creacion para la lista
    if (session.getAttribute("listacal") == null){
        ArrayList<Calificaciones> lisaux = new ArrayList<Calificaciones>();
        //lista auxiliar es una coleccion vacia y para ponerlo como atributo es lo siguiente
        session.setAttribute("listacal", lisaux);
    }
    //se crea un listado un ArrayList con la espesificacion de la clase y llamando a session luego inportar 
    ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) session.getAttribute("listacal");
    //La coleccion lista tendra el atributo "listaper" que es parte del objeto session

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de calificaciones</h1>
        <a href="MainServlet?op=nuevo">Nuevo</a>
        <table border="1"> 
            <tr><%--Fila--%>
                <th>Id</th><%--Encabezado de la fila--%>
                <th>Nombres</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>NOTA</th>
                <th></th><%-- Vacio para la edicion--%>
                <th></th><%-- Vacio para la eliminacion --%>
            </tr>
            <% //en codigo jaba se pregunta si la lista es diferente de null y seguido un recorrido
                if (lista != null){
                    for(Calificaciones item : lista){
            %>
            <tr><%-- Fila para los datos --%>
                <td><%= item.getId() %></td><%-- Se pone los valores con "<%= item.get"  --%>
                <td><%= item.getNombre()%></td>
                <td><%= item.getP1()%></td>
                <td><%= item.getP2() %></td>
                <td><%= item.getEF() %></td>
                <td><%= item.getNota() %></td>
                
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                       onclick="return(confirm('Esta seguro de eliminar??'))"
                       >Eliminar</a>
                </td>
            </tr>
            <%
                }
            }
            %>
            
         </table>
    </body>
</html>
