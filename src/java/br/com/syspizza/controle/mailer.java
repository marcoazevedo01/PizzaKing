package br.com.syspizza.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

@WebServlet(name = "mailer", urlPatterns = {"/mailer"})
public class mailer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            SimpleEmail envioEmail = new SimpleEmail();
           
            envioEmail.setHostName("smtp.umbler.com");
            envioEmail.setSmtpPort(587);
            envioEmail.setAuthenticator(new DefaultAuthenticator("marco@bytecodesoft.com.br", "321321a321!"));
            envioEmail.setFrom("marco@bytecodesoft.com.br");
            //envioEmail.setSSL(true);
            //envioEmail.setTLS(true);
            //envioEmail.setDebug(true);
            envioEmail.setCharset(HtmlEmail.ISO_8859_1);
            envioEmail.addTo(email);
            envioEmail.setSubject("Contato - Syspizza");
            envioEmail.setMsg("Email de verificacao click no link para ativar sua conta:  http://localhost:8080/PizzaKing/returnMailer?id="+cpf);
            envioEmail.send();
            request.setAttribute("msg", "Messagem enviada ao email");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro no mailer" + e.getMessage());
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
