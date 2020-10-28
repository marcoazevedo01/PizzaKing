package br.com.syspizza.controle;

import br.com.syspizza.dao.ClienteDAO;
import br.com.syspizza.dao.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarCliente", urlPatterns = {"/ListarCliente"})
public class ListarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String tipo = request.getParameter("tipo");
            String pesquisa = request.getParameter("pesquisa");
            ClienteDAO dao = new ClienteDAO();
            
            if(pesquisa == null){
                request.setAttribute("clientes", dao.listar());
                request.getRequestDispatcher("listar-cliente.jsp").forward(request, response);
            }
            
            if(tipo.equals("nome")){
                    request.setAttribute("clientes", dao.listarPorNome(pesquisa));                    
            } else {
                    request.setAttribute("clientes", dao.listarPorCodigo(Integer.parseInt(pesquisa)));
            }
            request.getRequestDispatcher("listar-cliente.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao listar clienteCTR " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
