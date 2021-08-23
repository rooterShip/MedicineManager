package manager.service;

import manager.dao.ManagerDao;
import manager.dao.ManagerDaoImpl;
import manager.model.Manager;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    ManagerDao managerDao = new ManagerDaoImpl();
    @Override
    public List<Manager> queryByUsernamePassword(String username, String password) {
       return managerDao.queryByUsernamePassword(username,password);
    }
}
