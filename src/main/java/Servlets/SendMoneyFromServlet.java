package Servlets;

import Dao.BankAccountDao;
import Dao.CurrencyDao;
import Dao.TransactionDao;
import Dao.UsersDao;
import Entity.BankAccount;
import Entity.Currency;
import Entity.Transaction;
import Entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sendMoneyFromServlet", value = "/sendMoneyFromServlet")
public class SendMoneyFromServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TransactionDao transactionDao = new TransactionDao();
        BankAccountDao bankAccountDao = new BankAccountDao();
        CurrencyDao currencyDao = new CurrencyDao();
        UsersDao usersDao = new UsersDao();
        int drfo = Integer.parseInt(req.getParameter("drfo1"));
        int sumto = Integer.parseInt(req.getParameter("sumto"));
        Users users = usersDao.getUserByDrfo(drfo);
        String cur = req.getParameter("cur");
        Currency currency = currencyDao.getCurByName(cur);
        BankAccount bankAccount = bankAccountDao.getAcByUserAndCurr(users, currency);
        bankAccount.setBalance(bankAccount.getBalance()+sumto);
        bankAccountDao.update(bankAccount);
        Transaction transaction = new Transaction(bankAccount, sumto);
        transactionDao.insert(transaction);
        resp.sendRedirect("index.jsp");
    }
}
