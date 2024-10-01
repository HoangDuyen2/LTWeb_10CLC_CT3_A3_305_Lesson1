package iostar.java.services;

import iostar.java.models.CategoryModel;

import java.util.List;

public interface ICategoryServices {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    CategoryModel findByCategoryName(String categoryName);
    List<CategoryModel> findByCategoryNameContaining(String keyword);

    boolean insert(CategoryModel category);
    boolean update(CategoryModel category);
    void delete(int categoryid);
    void updateStatus(int categoryid, int status);
}
