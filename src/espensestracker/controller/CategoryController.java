/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.controller;

import espensestracker.util.ExpensesTrackerModelMapper;
import espensestracker.dto.CategoryDto;
import espensestracker.models.Category;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import espensestracker.controller.ICategoryController;

/**
 *
 * @author Aravinda
 */
public class CategoryController implements  ICategoryController{

    private Category category;
    private final ModelMapper modelMapper;

    public CategoryController() {
        category = new Category();
        modelMapper = ExpensesTrackerModelMapper.getModelMapper();
    }

    public ArrayList<CategoryDto> GetCategoryList() throws ClassNotFoundException, SQLException {
        Type listType = new TypeToken<ArrayList<CategoryDto>>() {
        }.getType();
        ArrayList<Category> categories = category.getCategoryList();
        return modelMapper.map(categories, listType);
    }
   @Override
    public int addNewCategory(CategoryDto categoryDto) throws SQLException, ClassNotFoundException {
        category = modelMapper.map(categoryDto, Category.class);
        return category.AddNewCategory();
    }
}
