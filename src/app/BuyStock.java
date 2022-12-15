/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import bank.accounts.Account;
import bank.accounts.AccountType;
import bank.accounts.SecuritiesAccount;
import bank.atm.CustomerATM;
import bank.atm.CustomerATMController;
import bank.trades.Stock;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author shubham
 */
public class BuyStock extends javax.swing.JFrame {
    private final CustomerATM customerATM;

    /**
     * Creates new form BuyStock
     */
    public BuyStock() {
        this.customerATM = CustomerATMController.getInstance();        
        initComponents();
        
        DefaultComboBoxModel<String> accountsComboBoxList = new DefaultComboBoxModel<String>();

        for (Account account : this.customerATM.getAccounts()) {
            if (account.getAccountType() == AccountType.SECURITIES) {
                accountsComboBoxList.addElement(account.getAccountNo() + " | " + account.getAccountType());                
            }
        }
        accounts.setModel(accountsComboBoxList);
 
        DefaultComboBoxModel<String> stocksList = new DefaultComboBoxModel<String>();

        
        for (Stock stock : this.customerATM.pullAllStocks()) {
            stocksList.addElement(stock.getId() + " | " + stock.getName() + " | " + stock.getValue());                
        }
        stocks.setModel(stocksList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancel = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        accounts = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        stocks = new javax.swing.JComboBox<>();
        amountToTransfer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cancel.setText("cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        header.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        header.setForeground(new java.awt.Color(0, 0, 0));
        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/icon.png"))); // NOI18N
        header.setText("Buy Stock");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Account No.");

        accounts.setName("Account no"); // NOI18N

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Stock");

        stocks.setName("Account no"); // NOI18N

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Quantity");

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Buy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancel)
                .addGap(40, 40, 40)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accounts, 0, 130, Short.MAX_VALUE)
                    .addComponent(amountToTransfer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stocks, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cancel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountToTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        DashBoardScreen dashboardScreen = new DashBoardScreen();
        dashboardScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String accountString = (String) accounts.getSelectedItem();
        if (accountString == null) {
            JOptionPane.showMessageDialog(this, "Select account first!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] accounts = accountString.split(" | ");
        int accountNo = Integer.parseInt(accounts[0]);

        Account account = null;
        for (Account acc : this.customerATM.getAccounts()) {
            if (acc.getAccountNo() == accountNo) {
                account = acc;
            }
        }

        if (account == null) {
            JOptionPane.showMessageDialog(this, "Securities Account not found!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        String stockString = (String) stocks.getSelectedItem();
        if (stockString == null) {
            JOptionPane.showMessageDialog(this, "Select Stock first!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String[] stocks = stockString.split(" | ");
        int stockId = Integer.parseInt(stocks[0]);
        
        Stock stock = null;
        for (Stock scc : this.customerATM.pullAllStocks()) {
            if (scc.getId() == stockId) {
                stock = scc;
            }
        }
        
        if (stock == null) {
            JOptionPane.showMessageDialog(this, "Stock not found!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }


        int quantity;

        try{
            quantity = Integer.parseInt(amountToTransfer.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!", "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            this.customerATM.buyStock((SecuritiesAccount)account, stock, quantity);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Invalid", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Bought "+quantity+" Stocks of "+stock.getName()+" successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
        DashBoardScreen dashBoardScreen = new DashBoardScreen();
        dashBoardScreen.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(BuyStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BuyStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BuyStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BuyStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BuyStock().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accounts;
    private javax.swing.JTextField amountToTransfer;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> stocks;
    // End of variables declaration//GEN-END:variables
}