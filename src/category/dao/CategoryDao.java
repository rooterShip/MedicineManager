package category.dao;

import category.model.Category;
import util.PageModel;

import java.util.List;

public interface CategoryDao {
    //分页查询
    public List<Category> selectByPage(PageModel pageModel);
    //根据id查询
    //新增一条记录
    //修改一条记录
    //删除一条记录
    //根据用户名和密码查询
}
