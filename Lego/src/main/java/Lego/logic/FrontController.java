package Lego.logic;

import Lego.data.LegoBrick;
import Lego.data.LegoHouseOrder;
import Lego.data.User;
import Lego.data.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ibenk
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, LoginException, SQLException {

        response.setContentType("text/html;charset=UTF-8");

        /* Pulling the user out of Session */
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        String origin = (String) request.getParameter("origin");
        switch (origin) {
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "order":
                order(request, response);
                break;
            case "view":
                view(request, response);
                break;
            default:
                throw new AssertionError();
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LoginException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LoginException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        try {
            /* Get email and password from parameters in url */
            String email = (String) request.getParameter("email");
            String password = (String) request.getParameter("password");

            /* Make an instance of UserMapper to get acces to its methods */
            UserMapper mapper = new UserMapper();
            User user = mapper.getUser(email);

            if (password.equals(user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                RequestDispatcher dispatch = request.getRequestDispatcher("shop.jsp");
                dispatch.forward(request, response);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
//        /* Get email and password from parameters in url */
//        String email = (String) request.getParameter("email");
//        String password = (String) request.getParameter("password");
//
//        /* Make an instance of UserMapper to get acces to its methods */
//        UserMapper mapper = new UserMapper();
//
//        /* Isert the new user information into the sql database */
//        mapper.createUser(email, password);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void order(HttpServletRequest request, HttpServletResponse response) {
        /* Get parameters from the request and parse to int */
        int length = (int) Integer.parseInt((String) request.getParameter("length"));
        int width = (int) Integer.parseInt((String) request.getParameter("width"));
        int height = (int) Integer.parseInt((String) request.getParameter("height"));

        LegoHouseOrder order = new LegoHouseOrder(length, width, height);
        
        BrickCalculator calc = new BrickCalculator(order);
        
        List<LegoBrick> listOfBricks = calc.getListOfBricks(order);
        List<Integer> totalBricks = calc.getTotalBricks(listOfBricks);

    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        LegoBrick brick = new LegoBrick();

    }

}
