package servlets;

import dao.BankAccountDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "all", value = "/allServlet")
public class AllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankAccountDao bankAccountDao = new BankAccountDao();
        int drfo = Integer.parseInt(req.getParameter("drfoAll"));
        req.setAttribute("list",bankAccountDao.getAll(drfo));
        getServletContext().getRequestDispatcher("/all.jsp").forward(req, resp);
    }
}
