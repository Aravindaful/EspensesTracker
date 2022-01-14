/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.views;

import espensestracker.util.Formatter;
import espensestracker.controller.ExpensesController;
import espensestracker.controller.IncomeController;
import espensestracker.dto.ExpensesListDto;
import espensestracker.views.ExpensesAddView;
import espensestracker.views.StatisticsView;
import espensestracker.views.IncomeAddView;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import espensestracker.controller.IIncomeController;
import espensestracker.controller.IExpensesController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Aravinda
 */
public class DashboardDataView extends javax.swing.JPanel {

    private IExpensesController expensesController;
    private IIncomeController incomeController;
    private int month;

    
    public DashboardDataView() {
        System.out.println("Summary view called");
        initComponents();
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        TableColumn tableColumn = tblExpensesList.getColumnModel().getColumn(1);
        tblExpensesList.setBackground(UIManager.getColor(new JTableHeader().getBackground()));
        tableColumn.setCellRenderer(tableCellRenderer);
        loadIcons();

    }

    private void loadIcons() {
        try {
            BufferedImage incomImg = null;
            BufferedImage expenseImg = null;
            BufferedImage balanceImg = null;
            try {
                incomImg = ImageIO.read(getClass().getResource("/espensestracker/assets/incom-icon.png"));
                expenseImg = ImageIO.read(getClass().getResource("/espensestracker/assets/expense-ico.png"));
                balanceImg = ImageIO.read(getClass().getResource("/espensestracker/assets/balance-ico.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image dimgIncome = incomImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon incomeIcon = new ImageIcon(dimgIncome);
            lblIcoIncome.setIcon(incomeIcon);

            Image dimgExpense = expenseImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon expensesIcon = new ImageIcon(dimgExpense);
            lblIcoExpenses.setIcon(expensesIcon);

            Image dimgBalance = balanceImg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon balanceIcon = new ImageIcon(dimgBalance);
            lblIcoBalance.setIcon(balanceIcon);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public DashboardDataView(int month) {
        this();
        expensesController = new ExpensesController();
        incomeController = new IncomeController();
        this.month = month;
        calculateTotal(month);
    }

    private double loadExpenses(int month) {
        double total = 0.00;
        try {
            ArrayList<ExpensesListDto> expensesByMonth = expensesController.getExpensesListByMonth(month);
            DefaultTableModel model = (DefaultTableModel) tblExpensesList.getModel();
            model.setNumRows(0);
            total = expensesByMonth.stream().map((exp) -> {
                model.addRow(new Object[]{exp.getCategoryName(),
                    Formatter.currencyFormat(exp.getAmount())});
                return exp;
            }).map((expp) -> expp.getAmount()).reduce(total, (accumulator, _item) -> accumulator + _item);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DashboardDataView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    private double getIncomeListByMonth(int month) {
        try {
            return incomeController.getIncomeTotalByMonth(month);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DashboardDataView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    private void calculateTotal(int month) {
        double expensesTotal = loadExpenses(month);
        double incomeTotal = getIncomeListByMonth(month);
        initializeProgressBar(expensesTotal, incomeTotal);
        expenditureLbl.setText(Formatter.currencyFormat(expensesTotal));
        expenditureLbl.setForeground(Color.red);
        incomeLbl.setText(Formatter.currencyFormat(incomeTotal));
        incomeLbl.setForeground(Color.GREEN);
        balanceLbl.setText(Formatter.currencyFormat(incomeTotal - expensesTotal));
        balanceLbl.setForeground(Color.blue);
    }

    private void initializeProgressBar(double expensesTotal, double incomeTotal) {

        if (incomeTotal > 0 || expensesTotal > 0) {
            progressBar.setForeground(Color.GREEN);
            progressBar.setBackground(Color.RED);
            progressBar.setMinimum(0);
            progressBar.setMaximum(100);
            progressBar.setValue(20);
            double incomeTotalValue = incomeTotal / (expensesTotal + incomeTotal) * 100;
            progressBar.setValue((int) incomeTotalValue);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list1 = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        incomeLbl = new javax.swing.JLabel();
        balanceLbl = new javax.swing.JLabel();
        expenditureLbl = new javax.swing.JLabel();
        lblIcoIncome = new javax.swing.JLabel();
        lblIcoExpenses = new javax.swing.JLabel();
        lblIcoBalance = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpensesList = new javax.swing.JTable();
        btnAddIncome = new javax.swing.JButton();
        btnAddExpenses = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        btnStatics = new javax.swing.JButton();

        setBackground(new java.awt.Color(228, 239, 247));

        jPanel1.setBackground(new java.awt.Color(154, 201, 235));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 115, 160));
        jLabel1.setText("Income         : ");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(67, 115, 160));
        jLabel2.setText("Expenses      :");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(67, 115, 160));
        jLabel3.setText("Balance        :");
        jLabel3.setToolTipText("");

        incomeLbl.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        incomeLbl.setForeground(new java.awt.Color(111, 246, 123));
        incomeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        incomeLbl.setText("0.00");
        incomeLbl.setToolTipText("");

        balanceLbl.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        balanceLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        balanceLbl.setText("0.00");

        expenditureLbl.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        expenditureLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        expenditureLbl.setText("0.00");

        lblIcoExpenses.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblIcoIncome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIcoExpenses))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIcoBalance)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(expenditureLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balanceLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(incomeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(incomeLbl)
                    .addComponent(lblIcoIncome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(expenditureLbl)
                    .addComponent(lblIcoExpenses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(balanceLbl)
                    .addComponent(lblIcoBalance))
                .addGap(23, 23, 23))
        );

        jLabel2.getAccessibleContext().setAccessibleName("expenseLbl:");
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        tblExpensesList.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tblExpensesList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExpensesList.setGridColor(new java.awt.Color(255, 255, 255));
        tblExpensesList.setShowHorizontalLines(false);
        tblExpensesList.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblExpensesList);

        btnAddIncome.setBackground(new java.awt.Color(159, 199, 247));
        btnAddIncome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAddIncome.setForeground(new java.awt.Color(25, 144, 234));
        btnAddIncome.setText("Add Income");
        btnAddIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddIncomeActionPerformed(evt);
            }
        });

        btnAddExpenses.setBackground(new java.awt.Color(159, 199, 247));
        btnAddExpenses.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAddExpenses.setForeground(new java.awt.Color(25, 144, 234));
        btnAddExpenses.setText("Add Expenses");
        btnAddExpenses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExpensesActionPerformed(evt);
            }
        });

        btnStatics.setBackground(new java.awt.Color(159, 199, 247));
        btnStatics.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnStatics.setForeground(new java.awt.Color(25, 144, 234));
        btnStatics.setText("Statistics");
        btnStatics.setToolTipText("");
        btnStatics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 366, Short.MAX_VALUE)
                        .addComponent(btnAddExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStatics, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddIncome)
                    .addComponent(btnAddExpenses)
                    .addComponent(btnStatics))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddIncomeActionPerformed
        IncomeAddView addIncomeView = new IncomeAddView(null, true);
        addIncomeView.setLocationRelativeTo(null);
        addIncomeView.setVisible(true);
        calculateTotal(this.month);
    }//GEN-LAST:event_btnAddIncomeActionPerformed

    private void btnAddExpensesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExpensesActionPerformed
        ExpensesAddView addExpenditureView = new ExpensesAddView(null, true);
        addExpenditureView.setLocationRelativeTo(null);
        addExpenditureView.setVisible(true);
        calculateTotal(this.month);
    }//GEN-LAST:event_btnAddExpensesActionPerformed

    private void btnStaticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaticsActionPerformed

        StatisticsView d = new StatisticsView(this.month);
        d.setLocationRelativeTo(null);
        d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        d.setVisible(true);    }//GEN-LAST:event_btnStaticsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLbl;
    private javax.swing.JButton btnAddExpenses;
    private javax.swing.JButton btnAddIncome;
    private javax.swing.JButton btnStatics;
    private javax.swing.JLabel expenditureLbl;
    private javax.swing.JLabel incomeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcoBalance;
    private javax.swing.JLabel lblIcoExpenses;
    private javax.swing.JLabel lblIcoIncome;
    private java.awt.List list1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable tblExpensesList;
    // End of variables declaration//GEN-END:variables
}
