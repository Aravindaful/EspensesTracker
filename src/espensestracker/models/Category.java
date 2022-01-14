/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espensestracker.models;

import espensestracker.db.DBConnection;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aravinda
 */
public class Category {

    private long categoryId;

    private String categoryName;

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Category> getCategoryList() throws SQLException, ClassNotFoundException {
        ArrayList<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category order by CategoryName";
        Statement statement = DBConnection.GetConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            Category category = new Category();
            category.categoryId = result.getInt("CategoryId");
            category.categoryName = result.getString("CategoryName");
            categories.add(category);
        }        
        return categories;
    }
    
        public int AddNewCategory() throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO category(CategoryId,CategoryName) VALUES(?,?)";
        PreparedStatement preparedStatement = DBConnection.GetConnection().prepareStatement(query);
        preparedStatement.setLong(1, this.getCategoryId());
        preparedStatement.setString(2, this.getCategoryName());
        try {
            return preparedStatement.executeUpdate();
        } finally {
            preparedStatement.close();
        }

    }
}
