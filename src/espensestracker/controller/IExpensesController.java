/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.dto.ExpensesDto;
import espensestracker.dto.ExpensesListDto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravinda
 */
public interface IExpensesController {

    int addNewExpense(ExpensesDto expenseDto) throws SQLException, ClassNotFoundException;

    int editExpense(ExpensesDto expenseDto) throws SQLException, ClassNotFoundException;

    ArrayList<ExpensesListDto> getExpensesListByMonth(int month) throws SQLException, ClassNotFoundException;

    int deleteExpensesById(long expenseId) throws SQLException, ClassNotFoundException;
}
