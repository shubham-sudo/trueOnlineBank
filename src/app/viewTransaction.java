package app;

import javax.swing.*;
import database.Database;
import bank.account.Account;
import bank.customer.Customer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class viewTransaction extends JFrame {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewTransaction().setVisible(true);
            }
        });
    }

    public viewTransaction(){
        iniView();

    }

    private JButton backButton;
    private JPanel BackGround;
    private JScrollPane accounts;
    private JLabel title;

    private void iniView(){
        setContentPane(BackGround);
        setTitle("All transaction today");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);

        backButton = new JButton();
        accounts = new JScrollPane();
        title = new JLabel();

        title.setText("All transaction today:");

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonmouseClicked(e);
            }
        });
    }

    private void backButtonmouseClicked(MouseEvent e){
        managerDashBoard managerdashboard = new managerDashBoard();
        managerdashboard.setVisible(true);
        dispose();
    }

}