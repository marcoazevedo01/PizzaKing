package br.com.syspizza.controle;

import br.com.syspizza.dao.ClienteDAO;
import br.com.syspizza.modelo.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Cliente oCliente = new Cliente();
            
            oCliente.setEmail(email);
            oCliente.setSenha(senha);
            
            ClienteDAO dao = new ClienteDAO();
            
            Cliente clienteLogado = (Cliente) dao.logar(oCliente);
            
            if(clienteLogado.getId() != null){
            

                // criando uma sessão
                HttpSession sessao = request.getSession(true);
                sessao.setAttribute("nome", clienteLogado.getNome());
                
                
                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
            }else{
                request.setAttribute("msg", "E-mail ou senha incorretos!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("Erro ao logarCTR " + e.getMessage());
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
