package category.dao;

import category.model.Category;
import util.PageModel;

import java.util.List;

public interface CategoryDao {
    //分页查询
    public List<Category> selectByPage(PageModel pageModel);
    //根据id查询
    //新增一条记录
    public int addOne(Category category);
    //修改一条记录
    public int updateOne(Category category);
    //删除一条记录
    public int deleteByCategoryId(String categoryId);
    //根据类别ID查询是否有药品与之关联
    public int queryDrugByCategoryId(String categoryId);
}
