package category.service;

import category.dao.CategoryDao;
import category.dao.CategoryDaoImpl;
import category.model.Category;
import util.PageModel;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> selectByPage(PageModel pageModel){
        return categoryDao.selectByPage(pageModel);
    }
}
