package onlinebank.account;
import onlinebank.currency.Currency;
import onlinebank.person.Person;
public interface Transaction {
    public Currency c;
    public boolean TransactionSucc;
    public Person user;

    public Currency getAmount();
    public boolean getSuccess();
    public Person getUser();
    /*
    public void saveMoney(SavingAccount account,Currency c);
    public void saveMoney(CheckingAccount account,Currency c,float FeeRate);

    public boolean WithdrawMoney(SavingAccount account,Currency c);
    public boolean WithdrawMoney(CheckingAccount account,Currency c,float FeeRate);

    public boolean PayLoan(Loan loan, Currency c);
    */

}
