/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.views;

import espensestracker.controller.CategoryController;
import espensestracker.controller.IncomeController;
import espensestracker.dto.CategoryDto;
import espensestracker.dto.IncomeDto;
import espensestracker.views.ExpensesAddView;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import espensestracker.controller.ICategoryController;
import espensestracker.controller.IIncomeController;
import espensestracker.dto.IncomeListDto;
import espensestracker.util.IconCreator;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author Aravinda
 */
public class IncomeAddView extends javax.swing.JDialog {

    private IIncomeController incomeController;
    private ICategoryController categoryController;
    IncomeListDto currentEditingRow;

    /**
     * Creates new form AddIncomeView
     *
     * @param parent
     * @param modal
     */
    public IncomeAddView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        loadIcon();
        initComponents();
        this.setTitle("Add New Income");
        incomeController = new IncomeController();
        categoryController = new CategoryController();
        numOnly(ammountTxt);
        loadCategories(-1, null);
    }

    private void loadIcon() {
        try {
            Image appIcon = new IconCreator().loadApplicationIcon();
            if (appIcon != null) {
                setIconImage(appIcon);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public IncomeAddView(java.awt.Frame parent, boolean modal, IncomeListDto editingRow, int index) {
        super(parent, modal);
        loadIcon();
        initComponents();
        this.setTitle("Edit Income");
        incomeController = new IncomeController();
        categoryController = new CategoryController();
        numOnly(ammountTxt);
        loadCategories(0, editingRow);
        currentEditingRow = editingRow;
    }

    private void loadCategories(int index, IncomeListDto editingRow) {
        try {
            Vector<CategoryDto> list = new Vector<>(categoryController.GetCategoryList());
            final DefaultComboBoxModel model = new DefaultComboBoxModel(list);
            categoryCmb.setModel(model);
            if (index > -1) {
                ArrayList<CategoryDto> arraylist = new ArrayList<CategoryDto>(list);
                Optional<CategoryDto> categoryd = arraylist.stream().filter((x) -> editingRow.getCategoryName().equals(x.getCategoryName()))
                        .findFirst();
                if (categoryd.isPresent()) {
                    CategoryDto aa = categoryd.get();
                    categoryCmb.setSelectedItem(aa);
                    ammountTxt.setText(editingRow.getAmount() + "");
                    datePicker.setDate(editingRow.getDate());
                }

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ExpensesAddView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void numOnly(Object objSource) {
        ((Component) objSource).addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                String filterStr = "0123456789.";
                char c = (char) e.getKeyChar();
                if (filterStr.indexOf(c) < 0) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        ammountTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryCmb = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Date : ");

        ammountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ammountTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Amount :");

        jLabel3.setText("Category : ");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ammountTxt)
                            .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ammountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(categoryCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ammountTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ammountTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ammountTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        IncomeDto incomeDto = new IncomeDto();

        try {
            try {
                incomeDto.setCategoryId(((CategoryDto) categoryCmb.getSelectedItem()).getCategoryId());
                incomeDto.setAmount(Double.parseDouble(ammountTxt.getText()));
                incomeDto.setDate(new java.sql.Date(datePicker.getDate().getTime()));

                if (this.currentEditingRow == null) {
                    incomeController.addNewIncome(incomeDto);
                } else {
                    incomeDto.setIncomeId(this.currentEditingRow.getIncomeId());
                    incomeController.updateIncome(incomeDto);
                }

                this.setVisible(false);
                this.dispose();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(IncomeAddView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter amount", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ammountTxt;
    private javax.swing.JComboBox<String> categoryCmb;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
