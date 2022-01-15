/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.util.ExpensesTrackerModelMapper;
import espensestracker.dto.ExpensesListDto;
import espensestracker.dto.IncomeDto;
import espensestracker.dto.IncomeListDto;
import espensestracker.models.Expenses;
import espensestracker.models.Income;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import espensestracker.controller.IIncomeController;

/**
 *
 * @author Aravinda
 */
public class IncomeController implements IIncomeController {

    private Income income;
    private final ModelMapper modelMapper;

    public IncomeController() {
        modelMapper = ExpensesTrackerModelMapper.getModelMapper();
        income = new Income();
    }

    @Override
    public double getIncomeTotalByMonth(int month) throws SQLException, ClassNotFoundException {
        return income.getIncomeTotalByMonth(month);
    }

    @Override
    public int addNewIncome(IncomeDto incomeDto) throws SQLException, ClassNotFoundException {
        income = modelMapper.map(incomeDto, Income.class);
        return income.AddNewIncome();
    }

    public ArrayList<IncomeListDto> getIncomeListByMonth(int month) throws SQLException, ClassNotFoundException {
        Type listType = new TypeToken<ArrayList<IncomeListDto>>() {
        }.getType();
        ArrayList<Income> incomeSet = income.GetIncomeListByMonth(month);
        return modelMapper.map(incomeSet, listType);
    }

    @Override
    public int updateIncome(IncomeDto incomeDto) throws SQLException, ClassNotFoundException {
        income = modelMapper.map(incomeDto, Income.class);
        return income.UpdateIncome();
    }

    @Override
    public int deleteIncome(long incomeId) throws SQLException, ClassNotFoundException {
        return income.DeleteIncome(incomeId);
    }

}
