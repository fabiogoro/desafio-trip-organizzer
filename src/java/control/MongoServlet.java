/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agency;
import model.Agent;
import model.AgentDAO;
import model.User;
import model.UserDAO;

/**
 *
 * @author Fabio
 */
public class MongoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String agente = request.getParameter("agente");
        String agenciaNome = request.getParameter("nomeAgencia");
        String endereco = request.getParameter("endereco");
        String tel = request.getParameter("tel");
        PrintWriter out = response.getWriter();
        try {
            if(agente.equals("n")){
                UserDAO dao = new UserDAO();
                User u = new User();
                u.setNome(nome);
                u.setEmail(email);
                u.setSenha(senha);
                dao.insert(u);
                out.println("Usuário cadastrado com sucesso");
            } else {
                AgentDAO dao = new AgentDAO();
                Agent a = new Agent();
                a.setNome(nome);
                a.setEmail(email);
                a.setSenha(senha);
                Agency agencia = new Agency();
                agencia.setNome(agenciaNome);
                agencia.setEndereco(endereco);
                agencia.setTelefone(tel);
                a.setAgencia(agencia);
                dao.insert(a);
                out.println("Agente cadastrado com sucesso");
            }
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
