package bank.atm;

import bank.accounts.*;
import bank.customers.Customer;
import bank.trades.Stock;
import bank.currencies.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class ManagerATMController extends ATM implements ManagerATM{
    private static ManagerATMController managerATM = null;

    private ManagerATMController() {
    }

    public static ManagerATMController getInstance() {
        if (managerATM == null) {
            managerATM = new ManagerATMController();
        }
        return managerATM;
    }

    private void setUpDashBoard() {
        // TODO Set up manager dashboard
    }

    @Override
    public Customer getCustomer(String email){
        return customerRepository.readByEmail(email);
    }

    @Override
    public List<Customer> getCustomers(){
        return customerRepository.read();
    }

    @Override
    public List<Transaction> getTransaction(LocalDate todayDate){
        List<Transaction> transactions = transactionRepository.read();
        List<Transaction> transactionOfDate = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(transaction.getTodayDate().equals(todayDate)) {
                transactionOfDate.add(transaction);
            }
        }
        return transactionOfDate;
    }

    @Override
    public List<Transaction> getTransactions(){
        return transactionRepository.read();
    }

    @Override
    public boolean addStock(Stock stock){
        // Todo
        return false;
    }

    @Override
    public boolean removeStock(Stock stock){
        // Todo
        return false;
    }

    @Override
    public boolean updateStock(Stock stock){
        // Todo
        return false;
    }

    @Override
    public void payInterest(double rate){
        List<? extends Account> savingAccounts = accountRepository.readByAccountTypes(new ArrayList<>(Collections.singletonList(AccountType.SAVING)));

        if (rate == 0) {
            rate = SAVING_INTEREST_RATE;
        }

        for(Account account : savingAccounts){
            SavingAccount savingAccount = (SavingAccount) account;
            if (account.getBalance() > 2) {  // if balance is more than 2 pay interest
                savingAccount.credit((savingAccount.getBalance() * rate), new USDollar((savingAccount.getBalance() * rate)));
                accountRepository.update(savingAccount);
            }
        }
    }

    @Override
    public void chargeInterest(double rate){
        List<? extends Account> loanAccounts = accountRepository.readByAccountTypes(new ArrayList<>(Collections.singletonList(AccountType.LOAN)));

        if (rate == 0) {
            rate = LOAN_INTEREST_RATE;  // default rate
        }

        for(Account account : loanAccounts){
            LoanAccount loanAccount = (LoanAccount) account;
            if (account.getBalance() < loanAccount.getLoan().getAmount()) {
                double usedAmount = loanAccount.getLoan().getAmount() - account.getBalance();
                loanAccount.getLoan().addInterest(usedAmount * rate);
                loanRepository.update(loanAccount.getLoan());
            }
        }
    }

    @Override
    public String greet() {
        return "Hi, " + loggedInPerson.getLastName();
    }

    @Override
    public void endSession() {
        this.loggedInPerson = null;
        // TODO (shubham) make rest of the stuff also null
    }

    @Override
    public void startSession(Customer manager) {
        this.loggedInPerson = manager;
    }
}