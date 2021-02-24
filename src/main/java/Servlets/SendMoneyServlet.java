package Servlets;

import Dao.BankAccountDao;
import Dao.CurrencyDao;
import Dao.TransactionDao;
import Dao.UsersDao;
import Entity.BankAccount;
import Entity.Currency;
import Entity.Transaction;
import Entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;


@WebServlet(name = "addMoneyServlet", value = "/addMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TransactionDao transactionDao = new TransactionDao();
        BankAccountDao bankAccountDao = new BankAccountDao();
        int  userFrom = Integer.parseInt(request.getParameter("drfofrom"));
        int  userTo = Integer.parseInt(request.getParameter("drfoto"));
        int sum = Integer.parseInt(request.getParameter("sum"));
        UsersDao usersDao = new UsersDao();
        Users users = usersDao.getUserByDrfo(userFrom);
        Users users2 = usersDao.getUserByDrfo(userTo);
        CurrencyDao currencyDao = new CurrencyDao();
        String name = request.getParameter("curname");
        Currency currency = currencyDao.getCurByName(name);
        Currency currency1 = currencyDao.getCurByName(name);
        BankAccount bankAccount = bankAccountDao.getAcByUserAndCurr(users, currency);
        BankAccount bankAccount1 = bankAccountDao.getAcByUserAndCurr(users2, currency1);
        bankAccount.setBalance(bankAccount.getBalance()-sum);
        bankAccount1.setBalance(bankAccount1.getBalance()+sum);
        Transaction transaction = new Transaction(bankAccount,bankAccount1, sum);
        bankAccountDao.update(bankAccount);
        bankAccountDao.update(bankAccount1);
        transactionDao.insert(transaction);
        response.sendRedirect("index.jsp");

    }

}
