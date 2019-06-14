package controller;

import entity.Phone;
import model.ConnectionHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addPhone")
public class PhoneController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addphones.jsp").forward(req,resp);
        resp.sendRedirect("/listPhones.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Phone phone = new Phone();
        phone.setName(req.getParameter("name"));
        phone.setBrand(req.getParameter("brand"));
        phone.setPrice(Integer.parseInt(req.getParameter("price")));
        phone.setDescription(req.getParameter("des"));
        ConnectionHelper helper = new ConnectionHelper();
        try {
            helper.insert(phone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
