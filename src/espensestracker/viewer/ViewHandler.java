/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.viewer;

import espensestracker.util.ViewIndex;
import espensestracker.views.DashboardDataView;
import javax.swing.JPanel;

/**
 *
 * @author Aravinda
 */
public class ViewHandler {

    static JPanel currentContainer;
    static JPanel panel;

    public static void OpenViewer(ViewIndex viewIndex, int month, JPanel container) {
        clear();
        ICurrentViewer currentViewer;
        currentContainer = container;
        currentViewer = ViewerProvider.provideCurrentViewer("JPanel");
        panel = (JPanel) currentViewer.select(viewIndex, month);
        panel.setBounds(0, 0, container.getWidth(), container.getHeight());
        container.add(panel);
    }

    public static void clear() {
        if (currentContainer != null && panel != null) {
            currentContainer.remove(panel);
            currentContainer.revalidate();
            currentContainer.repaint();
        }
    }

    public static void monthOptionChange(int month, ViewIndex viewIndex, JPanel container) {
        if (panel != null) {
            clear();
        }
        OpenViewer(viewIndex, month, container);
    }
}
