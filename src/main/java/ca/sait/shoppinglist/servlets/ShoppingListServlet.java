package ca.sait.shoppinglist.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Vidhy Patel
 */
public class ShoppingListServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("user");
        if (name == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
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
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        if (action != null && action.equals("register")) {
            String username = request.getParameter("username");
            session.setAttribute("user", username);

            ArrayList<String> items = new ArrayList<>();
            session.setAttribute("items", items);
        } else if (action != null && action.equals("add")) {
            String item = request.getParameter("item");

            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.add(item);

            session.setAttribute("items", items);
        } else if (action != null && action.equals("delete")) {
            String item = request.getParameter("item");

            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.remove(item);

            session.setAttribute("items", items);
        } else {

        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
