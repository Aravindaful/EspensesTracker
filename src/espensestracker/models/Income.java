/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.models;

import espensestracker.db.DBConnection;
import espensestracker.models.Category;
import espensestracker.models.Expenses;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aravinda
 */
public class Income {
    
    private long incomeId;
    
    private double amount;
    
    private Category category;
    
    private Date date;

    public long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(long expenditureId) {
        this.incomeId = expenditureId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
     public double getIncomeTotalByMonth(int month) throws SQLException, ClassNotFoundException {
        String query = "SELECT sum(Amount) as Total FROM income as I "
                + "WHERE MONTH(I.Date) = ? ";
        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setInt(1, month);
        try {
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
              return result.getDouble("Total");
            }
            return 0;
        } finally {
            preparedStatement.close();
        }
    }
     
     public ArrayList<Income> GetIncomeListByMonth(int month) throws SQLException, ClassNotFoundException {
        ArrayList<Income> incomes = new ArrayList<>();
        String query = "SELECT sum(Amount) as Total, C.CategoryName, IncomeId, Date FROM income as E "
                + "INNER JOIN category as C ON E.CategoryId = C.CategoryId "
                + "WHERE MONTH(E.Date) = ? group by C.CategoryName ";

        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setInt(1, month);
        try {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Income income = new Income();
                income.incomeId = result.getLong("IncomeId");
                income.amount = result.getDouble("Total");
                income.date = result.getDate("Date");
                income.category = new Category();
                income.category.setCategoryName(result.getString("CategoryName"));
                incomes.add(income);
            }
            return incomes;
            
        } finally {
            preparedStatement.close();
        }
    }
     
     public int AddNewIncome() throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO Income(Amount,Date,CategoryId) VALUES(?,?,?)";
        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setDouble(1, this.getAmount());
        preparedStatement.setDate(2, (java.sql.Date) this.getDate());
        preparedStatement.setLong(3, this.getCategory().getCategoryId());
        try {
            return preparedStatement.executeUpdate();
        } finally {
            preparedStatement.close();
        }

    }
     
      public int UpdateIncome() throws SQLException, ClassNotFoundException {

        String query = "UPDATE Income SET Amount=?,Date=?,CategoryId=? WHERE IncomeId=?";
        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setDouble(1, this.getAmount());
        preparedStatement.setDate(2, (java.sql.Date) this.getDate());
        preparedStatement.setLong(3, this.getCategory().getCategoryId());
        preparedStatement.setLong(4, this.getIncomeId());
        try {
            return preparedStatement.executeUpdate();
        } finally {
            preparedStatement.close();
        }

    }
      
      public int DeleteIncome(long incomeId) throws SQLException, ClassNotFoundException {

        String query = "DELETE from Income WHERE IncomeId=?";
        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setLong(1, incomeId);
          try {
            return preparedStatement.executeUpdate();
        } finally {
            preparedStatement.close();
        }

    }
}
