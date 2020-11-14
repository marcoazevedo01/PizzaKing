/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.syspizza.controle;

import br.com.syspizza.dao.BebidaDAO;
import br.com.syspizza.dao.GenericDAO;
import br.com.syspizza.modelo.Bebida;
import br.com.syspizza.util.manipulaData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author neto
 */
@WebServlet(name = "CadastrarBebida", urlPatterns = {"/CadastrarBebida"})
public class CadastrarBebida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String idProduto = request.getParameter("idProduto");
            String descricao = request.getParameter("descricao");
            String tipo = request.getParameter("tipo");
            String dataValidade = request.getParameter("dataValidade");
            Double medida = Double.parseDouble(request.getParameter("medida"));
            Double valor = Double.parseDouble(request.getParameter("valor"));

            Bebida bebida = new Bebida();

            bebida.setDescricao(descricao);
            bebida.setTipo(tipo);
            bebida.setDataValidade(manipulaData.convertToDate(dataValidade));
            bebida.setMedida(medida);
            bebida.setValor(valor);

            String mensagem = "";

            GenericDAO dao = new BebidaDAO();

            if (idProduto.equals("")) {

                if (dao.cadastrar(bebida)) {
                    mensagem = "Bebida cadastrada com sucesso";
                } else {
                    mensagem = "Erro ao cadastrar bebida";
                }
                request.setAttribute("msg", mensagem);
                request.getRequestDispatcher("ListarBebida").forward(request, response);

            } else {

                bebida.setIdProduto(Integer.parseInt(idProduto));

                if (dao.alterar(bebida)) {
                    mensagem = "Bebida alterada com sucesso";
                } else {
                    mensagem = "Erro ao alterar bebida";
                }
                
                request.setAttribute("msg", mensagem);
                request.setAttribute("idProduto", idProduto);
                request.getRequestDispatcher("ListarBebida").forward(request, response);

            }

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar bebidaCTR " + e.getMessage());
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
