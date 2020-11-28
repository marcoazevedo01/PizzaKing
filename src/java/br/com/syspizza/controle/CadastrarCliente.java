package br.com.syspizza.controle;

import Validacao.ValidaCPF;
import br.com.syspizza.dao.ClienteDAO;
import br.com.syspizza.dao.GenericDAO;
import br.com.syspizza.modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");

            Cliente cliente = new Cliente();

            cliente.setNome(request.getParameter("nome"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setSenha(request.getParameter("senha"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setStatus(false);

            GenericDAO dao = new ClienteDAO();
            String mensagem = "";
            
            if (ValidaCPF.isCPF(request.getParameter("cpf")) == true) {
                if (id.equals("")) {
                    if (dao.cadastrar(cliente)) {
                        mensagem = "Cliente cadastrado com sucesso";
                        request.getRequestDispatcher("mailer").forward(request, response);
                    } else {
                        mensagem = "Erro ao cadastrar cliente";
                    }
                } else {
                    cliente.setId(Integer.parseInt(id));
                    if (dao.alterar(cliente)) {
                        mensagem = "Cliente alterado com sucesso!";
                    } else {
                        mensagem = "Erro ao alterar Cliente!";
                    }
                }
                request.setAttribute("msg", mensagem); 
                request.getRequestDispatcher("ListarCliente").forward(request, response);                      
            } else {            
                mensagem = "CPF invalido";
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }     
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar clienteCTR "+ e.getMessage());
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
