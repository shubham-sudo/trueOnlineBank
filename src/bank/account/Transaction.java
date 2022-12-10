package bank.account;

import database.Database;
import database.DbModel;

import java.time.LocalDate;


/**
 * Transaction keeps all the history for credit and debit
 * happens on any of the account. It also stores tax info
 * This works similar to the logs of an application.
 */
public class Transaction implements DbModel {
    public static final String tableName = "transaction";
    public static final String idColumn = "id";
    public static final String aidColumn = "aid";
    private final int id;
    private final int aid;
    private final String message;
    private final LocalDate todayDate;
    private final double oldValue;
    private final double newValue;

    public Transaction(int id, int aid, String message, double oldValue, double newValue, LocalDate date) {
        this.id = id != 0 ? id :getNewId();
        this.aid = aid;
        this.message = message;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.todayDate = date;
    }

    public int getId() {
        return id;
    }

    private int getNewId() {
        return Database.getNewId(tableName, idColumn);
    }

    public int getAid() {
        return aid;
    }

    public LocalDate getTodayDate() {
        return todayDate;
    }

    public String getMessage() {
        return message;
    }

    public double getOldValue() {
        return oldValue;
    }

    public double getNewValue() {
        return newValue;
    }

    @Override
    public boolean isValid() {
        return !Database.isIdExists(tableName, idColumn, getId());
    }

    @Override
    public int create() {
        if (!isValid()) {
            throw new IllegalStateException("Account already exists!");
        }
        return Database.addTransaction(this);
    }

    @Override
    public void delete() {
        // Transaction history would never be deleted
    }

    @Override
    public int update() {
        // Transactions are write only, can't be updated
        // this can be done in some cases, like message update
        return 0;
    }
    
    @Override
    public String toString() {
        return "<Transaction" + id +"> " + message;
    }
}
