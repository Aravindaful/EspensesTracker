/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.models;

import espensestracker.db.DBConnection;
import espensestracker.models.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aravinda
 */
public class Expenses {

    private long expenseId;

    private double amount;

    private Category category;

    private Date date;

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expenditureId) {
        this.expenseId = expenditureId;
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

    public int AddExpense() throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO expense(Amount,Date,CategoryId) VALUES(?,?,?)";
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

    public ArrayList<Expenses> GetAlExpensesListByMonth(int month) throws SQLException, ClassNotFoundException {
        ArrayList<Expenses> expenses = new ArrayList<>();
        String query = "SELECT sum(Amount) as Total, C.CategoryName FROM expense as E "
                + "INNER JOIN category as C ON E.CategoryId = C.CategoryId "
                + "WHERE MONTH(E.Date) = ? group by C.CategoryName ";

        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setInt(1, month);
        try {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Expenses expenditure = new Expenses();
                expenditure.amount = result.getDouble("Total");
                expenditure.category = new Category();
                expenditure.category.setCategoryName(result.getString("CategoryName"));
                expenses.add(expenditure);
            }
            return expenses;
            
        } finally {
            preparedStatement.close();
        }
    }

}
