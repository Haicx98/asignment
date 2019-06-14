package controller;

import entity.Phone;
import model.ConnectionHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listPhone")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConnectionHelper helper = new ConnectionHelper();
        List<Phone> phoneList = helper.returnList();
        req.setAttribute("list",phoneList);
        req.getRequestDispatcher("/listPhones.jsp").forward(req,resp);
    }
}
