/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.dto.CategoryDto;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aravinda
 */
public interface ICategoryController {

    ArrayList<CategoryDto> GetCategoryList() throws ClassNotFoundException, SQLException;

    int addNewCategory(CategoryDto categoryDto) throws SQLException, ClassNotFoundException;
}
