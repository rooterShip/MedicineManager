package category.service;

import category.dao.CategoryDao;
import category.dao.CategoryDaoImpl;
import category.model.Category;
import util.PageModel;

import java.util.List;

/**
 * @author Rooter
 */

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> selectByPage(PageModel pageModel){
        return categoryDao.selectByPage(pageModel);
    }

    @Override
    public int addOne(Category category) {
        return categoryDao.addOne(category);
    }

    @Override
    public int updateOne(Category category) {
        return categoryDao.updateOne(category);
    }
}
