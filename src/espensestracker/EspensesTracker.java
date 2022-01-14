/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker;

import espensestracker.views.DashboardView;

/**
 *
 * @author Aravinda
 */
public class EspensesTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            DashboardView dasboard = new DashboardView();
            dasboard.setLocationRelativeTo(null);
            dasboard.setResizable(false);
            dasboard.setVisible(true);
        });
    }

}
