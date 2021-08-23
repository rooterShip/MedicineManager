package manager.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import  manager.model.Manager;
import  util.JdbcUtil;

public class ManagerDaoImpl implements ManagerDao{
    public List<Manager> queryByUsernamePassword(String uesrname,String password){
        List<Manager> managers = new ArrayList<>();
        String sql = "select * from manager m where m.username='"+uesrname+"'and password = '"+password+"'";
        List<Map<String,Object>> list = JdbcUtil.queryBysql(sql);
        for(Map<String,Object> map:list){
            String id=(String)map.get("ID");
            String fullname=(String)map.get("FULLNAME");
            String movephone=(String)map.get("MOVEPHONE");
            Integer managertype= Integer.valueOf(String.valueOf((BigDecimal)map.get("MANAGERTYPE")));
            Manager manager = new Manager( id, uesrname, password, fullname, movephone, managertype);
            managers.add(manager);

        }
        return managers;
    }


}
