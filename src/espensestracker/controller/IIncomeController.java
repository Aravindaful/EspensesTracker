/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.dto.IncomeDto;
import espensestracker.dto.IncomeListDto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravinda
 */
public interface IIncomeController {

    double getIncomeTotalByMonth(int month) throws SQLException, ClassNotFoundException;

    int addNewIncome(IncomeDto incomeDto) throws SQLException, ClassNotFoundException;

    ArrayList<IncomeListDto> getIncomeListByMonth(int month) throws SQLException, ClassNotFoundException;

}
