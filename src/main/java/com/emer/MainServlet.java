
package com.emer;

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String op = request.getParameter("op");
       gestor objtar = new gestor();
       int id,pos;
       HttpSession ses = request.getSession();
       ArrayList<gestor> lista = (ArrayList<gestor>) ses.getAttribute("listgest");
       switch(op){
           case "nuevo":
               // enviar un objeto vacio a editar
               request.setAttribute("mioobjtar",objtar);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "editar":
               //enviar un objeto a editar pero con contenido
               id = Integer.parseInt(request.getParameter("id"));
               //Averiguar la posicion del elemento en la lista);
               //Averiguar la 
               pos = buscarPorIndice(request,id);
               //obtener el objeto
               objtar = lista.get(pos);
               request.setAttribute("mioobjtar",objtar);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
           case "eliminar":
               //Eliminar el registro de la coleccion segun el id
               id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if(pos>=0){
                        lista.remove(pos);
                        }
                request.setAttribute("listgest",lista);
                response.sendRedirect("index.jsp");
               break;
           default:
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        HttpSession ses = request.getSession();
        ArrayList<gestor> lista = (ArrayList<gestor>)ses.getAttribute("listgest");
        gestor objtar = new gestor();
        objtar.setId(id);
        objtar.setTarea(request.getParameter("tarea"));
        objtar.setEstado(estado);
        if(id==0){
            //nuevo registro
            int idnuevo = obtenerId(request);
            objtar.setId(idnuevo);
            lista.add(objtar);
        }
        else{
            //edicion de registro
            int pos =buscarPorIndice(request, id);
            lista.set(pos, objtar);
        }
        request.setAttribute("listgest", lista);
        response.sendRedirect("index.jsp");
    }
    public int buscarPorIndice(HttpServletRequest request , int id){
        HttpSession ses = request.getSession();
        ArrayList<gestor> lista = (ArrayList<gestor>) ses.getAttribute("listgest");
        int pos=-1;
        if(lista!= null){
            for(gestor ele:lista){
                ++pos;
                if(ele.getId() == id){
                    break;
                }
            }
        }
        return pos;
            
    }
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<gestor> lista=(ArrayList<gestor>) ses.getAttribute("listgest");
        //Bsucar el ultimo id
        int idn= 0;
        for(gestor ele: lista){
            idn=ele.getId();
        }
        return idn + 1;
    }
    
}
