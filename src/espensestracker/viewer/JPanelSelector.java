/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.viewer;

import espensestracker.util.ViewIndex;
import espensestracker.views.CategoryListView;
import espensestracker.views.ExpensesListView;
import espensestracker.views.IncomeListView;
import espensestracker.views.DashboardDataView;
import javax.swing.JPanel;

/**
 *
 * @author Aravinda
 */
public class JPanelSelector implements ICurrentViewer<JPanel> {

    @Override
    public JPanel select(ViewIndex viewIndex, int month) {
       switch (viewIndex) {
           case SUMMARY_VIEW:
                return new DashboardDataView(month);
             case EXPENSES_VIEW:
                return new ExpensesListView(month);
            case INCOME_VIEW:
                return new IncomeListView(month);
            case CATEGORY_VIEW:
                return new CategoryListView();
            default:
              return new DashboardDataView(month);
        }
    }
    
}
