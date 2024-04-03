<%@page import="com.emergentes.te_calificaciones.Calificaciones"%>
<%  //Optener un objeto que obtenga los datos para mostrar "miobjper" que viene desde servelet
    //se adiciona la importacion
    Calificaciones reg = (Calificaciones) request.getAttribute("miobjcal");
    //el objeto es reg que vendra con el atriburo "miobjper"
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
        <form action="MainServlet" method="post"> <%-- formulario para recivir datos que se prosece en el MainServlet--%>
        <table> <%-- una tabla para un formato diferente --%>
            <tr> <%-- Fila --%>
                <td>ID</td> <%-- Celda --%>
                <%-- Luego de obtener el objeto reg se añade en los values de cada variable "<%= reg.***** %> --%>
                <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                <%-- Cuadro de texto para id con un valor, tamaño, "readonly" es solo para lectura sin edicion --%>
                
            </tr>
            <tr>
                <td>Nombre del Estudiante</td>
                <td><input type="text" name="nombres" value="<%= reg.getNombre() %>"></td>
            </tr>
            <tr>
                <td>Primer parcial (sobre 30)</td>
                <td><input type="text" name="P1" value="<%= reg.getP1() %>"></td>
            </tr>
            <tr>
                <td>Segundo parcial (sobre 30)</td>
                <td><input type="text" name="P2" value="<%= reg.getP2() %>"></td>
            </tr>
            <tr>
                <td>Examen final (sobre 40)</td>
                <td><input type="text" name="EF" value="<%= reg.getEF() %>"></td>
            </tr>
            <tr>
                <td></td><%-- Boton para enviar --%>
                <td><input type="submit" value="Enviar"></td>
                <%-- El boton es input de tipo "submit value es el nombre del boton--%>
            </tr>
        </table>
      </form>
    </body>
</html>
