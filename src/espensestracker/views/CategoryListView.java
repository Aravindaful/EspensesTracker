/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.views;

import espensestracker.controller.CategoryController;
import espensestracker.dto.CategoryDto;
import espensestracker.models.Category;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import espensestracker.controller.ICategoryController;
import espensestracker.util.IconCreator;
import java.awt.Image;

/**
 *
 * @author Aravinda
 */
public class CategoryListView extends javax.swing.JPanel {

    private ICategoryController categoryController;

    /**
     * Creates new form CategoryView
     */
    public CategoryListView() {
        System.out.println("Category view called");
        initComponents();
        categoryController = new CategoryController();
        loadCategoryData();
    }

    private void loadCategoryData() {
        try {

            DefaultListModel<String> listModel = new DefaultListModel();
            ArrayList<CategoryDto> categories = categoryController.GetCategoryList();

            for (CategoryDto object : categories) {
                System.out.println(object);
                listModel.addElement(object.getCategoryName());
            }
            listCategories.setModel(listModel);
            listCategories.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            listCategories.setLayoutOrientation(JList.VERTICAL_WRAP);
            this.listCategories.setVisibleRowCount(-1);

            this.jScrollPane2.repaint();
            this.jScrollPane2.revalidate();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoryListView.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCategories = new javax.swing.JList();
        addButton = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(228, 239, 247));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Category");

        jLabel2.setText("Available Categories");

        listCategories.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listCategories);

        addButton.setBackground(new java.awt.Color(159, 199, 247));
        addButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addButton.setForeground(new java.awt.Color(25, 144, 234));
        addButton.setText("Add New");
        addButton.setToolTipText("");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 535, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        CategoryAddView addCategoryView = new CategoryAddView();
        addCategoryView.setLocationRelativeTo(null);
        addCategoryView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Espenses Edit closed");
                loadCategoryData();
            }
        });
        addCategoryView.setVisible(true);

    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listCategories;
    // End of variables declaration//GEN-END:variables
}
