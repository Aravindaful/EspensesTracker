/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.dto;

import java.util.Date;

/**
 *
 * @author Aravinda
 */
public class ExpensesDto {
    
    private long expenseId;
    
    private double amount;
    
    private long categoryId;
    
    private Date date;

    public long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(long expensId) {
        this.expenseId = expensId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
