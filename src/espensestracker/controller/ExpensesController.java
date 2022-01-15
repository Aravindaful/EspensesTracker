/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.util.ExpensesTrackerModelMapper;
import espensestracker.dto.ExpensesDto;
import espensestracker.dto.ExpensesListDto;
import espensestracker.models.Expenses;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import espensestracker.controller.IExpensesController;

/**
 *
 * @author Aravinda
 */
public class ExpensesController implements IExpensesController {

    private Expenses expense;
    private final ModelMapper modelMapper;

    public ExpensesController() {
        expense = new Expenses();
        modelMapper = ExpensesTrackerModelMapper.getModelMapper();
    }

    @Override
    public int addNewExpense(ExpensesDto expenseDto) throws SQLException, ClassNotFoundException {
        expense = modelMapper.map(expenseDto, Expenses.class);
        return expense.AddExpense();
    }

    public ArrayList<ExpensesListDto> getExpensesListByMonth(int month) throws SQLException, ClassNotFoundException {
        Type listType = new TypeToken<ArrayList<ExpensesListDto>>() {
        }.getType();        
         ArrayList<Expenses> expenditures = expense.GetAlExpensesListByMonth(month);
        return modelMapper.map(expenditures, listType);
    }

    @Override
    public int editExpense(ExpensesDto expenseDto) throws SQLException, ClassNotFoundException {
        expense = modelMapper.map(expenseDto, Expenses.class);
        return expense.EditExpense();
    }

    @Override
    public int deleteExpensesById(long categoryId) throws SQLException, ClassNotFoundException {
               return expense.DeleteExpenseByCategoryId(categoryId);
    }

}
