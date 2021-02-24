package Servlets;

import Dao.CurrencyDao;
import Entity.Currency;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCurServlet", value = "/AddCurServlet")
public class AddCurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrencyDao currencyDao = new CurrencyDao();
        Currency currencyUah = new Currency("UAH", 1);
        Currency currencyUsd = new Currency("USD", 28);
        Currency currencyEur = new Currency("EUR", 33);
        currencyDao.insert(currencyUah);
        currencyDao.insert(currencyUsd);
        currencyDao.insert(currencyEur);
        response.sendRedirect("index.jsp");
    }

}
