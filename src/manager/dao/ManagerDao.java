package manager.dao;
import manager.model.Manager;
import java.util.List;

public interface ManagerDao {
    //分页查询
    //根据id查询
    //新增一条记录
    //修改一条记录
    //删除一条记录
    //根据用户名和密码查询
    public List<Manager> queryByUsernamePassword(String uesrname,String password);

}