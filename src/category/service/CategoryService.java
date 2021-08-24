package category.service;

import category.model.Category;
import util.PageModel;

import java.util.List;

public interface CategoryService {
    public List<Category> selectByPage(PageModel pageModel);
}
