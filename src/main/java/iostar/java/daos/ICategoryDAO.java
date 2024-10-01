package iostar.java.daos;


import iostar.java.models.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();
    CategoryModel findById(int id);
    CategoryModel findByCategoryName(String categoryName);
    List<CategoryModel> findByCategoryNameContaining(String keyword);

    void insert(CategoryModel category);
    void update(CategoryModel category);
    void delete(int categoryid);
    void updateStatus(int categoryid, int status);
}
