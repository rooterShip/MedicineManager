package manager.service;

import manager.model.Manager;

import java.util.List;

public interface ManagerService {
    /*分页查询*/

    /*根据id查询一条记录*/

    /*新增一条记录*/

    /*删除一条记录*/

    /*根据用户名和密码查询*/
    public List<Manager> queryByUsernamePassword(String username,String password);
}
