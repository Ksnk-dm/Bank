package Servlets;

import Dao.BankAccountDao;
import Dao.CurrencyDao;
import Dao.TransactionDao;
import Dao.UsersDao;
import Entity.BankAccount;
import Entity.Currency;
import Entity.Transaction;
import Entity.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "addUser", value = "/addUser")
public class AddNewUserServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsersDao usersDao = new UsersDao();
        CurrencyDao currencyDao = new CurrencyDao();
        BankAccountDao bankAccountDao = new BankAccountDao();
        int drfo = Integer.parseInt(request.getParameter("drfo"));
        String username = request.getParameter("username");
        Users users = new Users(username, drfo);
        usersDao.insert(users);
        Currency currency = currencyDao.getCurByName("UAH");
        Currency currency1=currencyDao.getCurByName("USD");
        Currency currency2=currencyDao.getCurByName("EUR");
        BankAccount bankAccount = new BankAccount(currency, users, 0);
        BankAccount bankAccount1 = new BankAccount(currency1, users,0);
        BankAccount bankAccount2 = new BankAccount(currency2,users,0);
        bankAccountDao.insert(bankAccount1);
        bankAccountDao.insert(bankAccount2);
        bankAccountDao.insert(bankAccount);
        response.sendRedirect("index.jsp");
    }

}