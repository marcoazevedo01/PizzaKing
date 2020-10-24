package br.com.syspizza.controle;

import br.com.syspizza.dao.FuncionarioDAO;
import br.com.syspizza.dao.GenericDAO;
import br.com.syspizza.modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String id = request.getParameter("id");

            Funcionario funcionario = new Funcionario();

            funcionario.setNome(request.getParameter("nome"));
            funcionario.setSalario(Double.parseDouble(request.getParameter("salario")));
            funcionario.setTelefone(request.getParameter("telefone"));

            GenericDAO dao = new FuncionarioDAO();

            String mensagem = "";

            if (id.equals("")) {
                if (dao.cadastrar(funcionario)) {
                    mensagem = "Funcionário cadastrado com sucesso!";
                } else {
                    mensagem = "Erro ao cadastrar Funcionário!";
                }
            } else {
                funcionario.setId(Integer.parseInt(id));
                if (dao.alterar(funcionario)) {
                    mensagem = "Funcionário alterado com sucesso!";
                } else {
                    mensagem = "Erro ao alterar Funcionário!";
                }
            }
            request.setAttribute("msg", mensagem);
            request.getRequestDispatcher(
                    "/ListarFuncionario").forward(
                            request, response);
        } catch (Exception e) {
            System.out.println(
                    "Erro ao cadastrar funcionarioCTR "
                    + e.getMessage());
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
