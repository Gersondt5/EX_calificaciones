
package com.emergentes.te_calificaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Se crea la opcion de tipo String "op" con parametros
        String op = request.getParameter("op");
        //adicionamos unas variables
        Calificaciones objcal = new Calificaciones();
        // variable id (manejar el valor que nos mande), pos (averiguar en que lugar se encuentra en la coleccion)
        int id, pos;
        
        //Como es un objeto que se encuentra en session se necesita optener la session con su respectiva inportacion
        HttpSession ses = request.getSession();
        //Optener la lista con su inportacion
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>)ses.getAttribute("listacal");
        
        switch(op){ // switch es segn el valor del enlace
            case "nuevo":
                //Enviar un objeto vacio a editar
                //El objeto vacio es = "objper" hay que ponerlo como atributo de request
                request.setAttribute("miobjcal", objcal);
                //redireccionar al archivo editar.jsp 
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                //Enviar un objeto a editar pero con contenido
                id = Integer.parseInt(request.getParameter("id")); //averigua el id
                //Averiguar la posicion del elemento en la lista
                pos = buscarPorIndice(request, id); //el buscarPorIndice es un metodo que se tiene que crear mas abajo
                //Obtener el objeto y ponerle los valores
                objcal = lista.get(pos); 
                // lo mismo que el anterior caso
                request.setAttribute("miobjcal", objcal);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //Eliminar el registro de la coleccion segun el id
                id = Integer.parseInt(request.getParameter("id"));//averigua el id
                //Averiguar la posicion del elemento en la lista
                pos = buscarPorIndice(request, id);
                if(pos >= 0){
                    lista.remove(pos);//elimina el objeto que se encuentra en la posicion (pos)
                }
                //actualizar la lista
                request.setAttribute("listacal", lista);
                //mandar el control a index.jsp con response.sendRedirect
                response.sendRedirect("index.jsp");
                break;
            default: //opcion por defecto default
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        int id = Integer.parseInt(request.getParameter("id"));
        //Como es un objeto que se encuentra en session se necesita optener la session con su respectiva inportacion
        HttpSession ses = request.getSession();
        //Optener la lista con su inportacion
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>)ses.getAttribute("listacal");
        Calificaciones objcal = new Calificaciones();
        //Poner datos a objper con set.Id(id)
        objcal.setId(id);
        // aqui se pone el valor igual con set.***** que viene en el parametro con request.getParameter
        objcal.setNombre(request.getParameter("nombres"));
        objcal.setP1(Integer.parseInt(request.getParameter("P1")));
        objcal.setP2(Integer.parseInt(request.getParameter("P2")));
        objcal.setEF(Integer.parseInt(request.getParameter("EF")));

        if (id == 0){
            //Nuevo registro
            //si es nuevo se necesita tener un nuevo ID
            int idNuevo = obtenerId(request);// con la ayuda de un metodo que se creara
            //actualizar el objeto con el nuevo ID
            objcal.setId(idNuevo);
            //adicionar el elemento a objper
            lista.add(objcal);
        }
        else{
            //Edicion de registro
            //averiguar la posicion con el metodo que se creo para buscar
            int pos = buscarPorIndice(request, id);
            //actualizar en la posicion del elemento
            lista.set(pos, objcal);
        }
        //Actualizar la lista
        request.setAttribute("listacal", lista);
        //redireccionar el control al archivo index.jsp
        response.sendRedirect("index.jsp");
        
    }
    
    
    public int buscarPorIndice(HttpServletRequest request, int id) //Se crea el metodo para buscar por indice
            // recive el parametro de httpServletRequest request y un ID
    {
        //se optiene la session
        HttpSession ses = request.getSession(); 
        //se optiene la lista
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) ses.getAttribute("listacal");
        
        //recorrer toda la lista para encontrar la posicion del elemento
        int pos = -1;
        if (lista != null){
            for(Calificaciones ele : lista){ //Persona lo llama variable como ele
                ++pos;
                if(ele.getId() == id){ //si el id de persona es = al id que estoy buscado
                    break;
                }
            }
        }
        return pos; //retornamos pos
    }
    
    public int obtenerId(HttpServletRequest request){ //Se crea el metodo para obtener por indice
            // recive el parametro de httpServletRequest request
        //obtener la session
        HttpSession ses = request.getSession();
        //obtener la lista
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) ses.getAttribute("listacal");
        //Buscar el ultimo id
        int idn = 0;
        for(Calificaciones ele : lista){ //se recorre la lista
            idn = ele.getId(); //obtener el ultimo numero
        }
        return idn + 1;
    }


}
