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
    
    private long expenditureId;
    
    private double amount;
    
    private long categoryId;
    
    private Date date;

    public long getExpenditureId() {
        return expenditureId;
    }

    public void setExpenditureId(long expenditureId) {
        this.expenditureId = expenditureId;
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
