package Servlets;


import Dao.BankAccountDao;
import Dao.CurrencyDao;
import Dao.TransactionDao;
import Dao.UsersDao;
import Entity.BankAccount;
import Entity.Currency;
import Entity.Transaction;
import Entity.Users;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

@WebServlet(name = "addBankAc", value = "/convert")
public class AddNewBankAccountServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TransactionDao transactionDao = new TransactionDao();
        BankAccountDao bankAccountDao = new BankAccountDao();
        CurrencyDao currencyDao = new CurrencyDao();
        UsersDao usersDao = new UsersDao();
        int drfo = Integer.parseInt(request.getParameter("drfo1"));
        int sumto = Integer.parseInt(request.getParameter("sumto"));
        Users users = usersDao.getUserByDrfo(drfo);
        String curFrom = request.getParameter("curFrom");
        String curTo = request.getParameter("curTo");
        Currency currencyFrom = currencyDao.getCurByName(curFrom);
        Currency currencyTo = currencyDao.getCurByName(curTo);
        BankAccount bankAccountFrom = bankAccountDao.getAcByUserAndCurr(users, currencyFrom);
        BankAccount bankAccountTo = bankAccountDao.getAcByUserAndCurr(users, currencyTo);
        bankAccountFrom.setBalance(bankAccountFrom.getBalance() - sumto);
        if (currencyFrom.getName().equals("UAH")) {   //довольно странная и не продуманая конструкция получилась + возникает баг если добавлено больше 1го юзера
            bankAccountTo.setBalance(bankAccountTo.getBalance() + sumto / bankAccountTo.getCurrency().getValue());
        }
        if (currencyTo.getName().equals("UAH")) {
            bankAccountTo.setBalance(bankAccountTo.getBalance() + sumto * bankAccountFrom.getCurrency().getValue());
        } else {
            bankAccountTo.setBalance(bankAccountTo.getBalance() + sumto * (bankAccountFrom.getBalance() / bankAccountTo.getBalance()));
        }
        Transaction transaction = new Transaction(bankAccountFrom, sumto);
        transactionDao.insert(transaction);
        bankAccountDao.update(bankAccountFrom);
        bankAccountDao.update(bankAccountTo);
        response.sendRedirect("index.jsp");
    }
}
