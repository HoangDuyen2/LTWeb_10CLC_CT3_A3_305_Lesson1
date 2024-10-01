package iostar.java.services.impl;

import iostar.java.daos.ICategoryDAO;
import iostar.java.daos.impl.CategoryDAOImpl;
import iostar.java.models.CategoryModel;
import iostar.java.services.ICategoryServices;

import java.util.List;

public class CategoryServices implements ICategoryServices {
    public ICategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public CategoryModel findByCategoryName(String categoryName) {
        return categoryDAO.findByCategoryName(categoryName);
    }

    @Override
    public List<CategoryModel> findByCategoryNameContaining(String keyword) {
        return categoryDAO.findByCategoryNameContaining(keyword);
    }

    @Override
    public boolean insert(CategoryModel category) {
        CategoryModel categoryModel = this.findByCategoryName(category.getCategoryname());
        if (categoryModel == null) {
            categoryDAO.insert(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(CategoryModel category) {
        CategoryModel categoryModel = this.findById(category.getCategoryid());
        if (categoryModel != null) {
            categoryDAO.update(category);
            return true;
        }
        return false;
    }

    @Override
    public void delete(int categoryid) {
        categoryDAO.delete(categoryid);
    }

    @Override
    public void updateStatus(int categoryid, int status) {
        categoryDAO.updateStatus(categoryid, status);
    }
}
