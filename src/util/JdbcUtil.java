package util;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import  java.util.List;

/**
 * @author Rooter
 *
 */

public class JdbcUtil {
    static Connection conn = null;
    static Statement stat = null;
    static ResultSet res = null;
    static ResultSetMetaData remd = null;

    //获得数据库连接
    private static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@192.168.77.100:1521:helowin", "scott",
                "123456");
    }

    //关闭资源
    private static void closeJdbc() {
        try {
            if (res != null)
                res.close();
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提供一个统一的查询方法
    public static List<Map<String, Object>> queryBysql(String sql) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            conn = getConnection();
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            remd = res.getMetaData();
            while (res.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= remd.getColumnCount(); i++) {
                    map.put(remd.getColumnName(i), res.getObject(i));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeJdbc();
        }
        return list;
    }

    //统一的增删改方法
    public static int updateBysql(String sql) {
        int updatecount = 0;

        try {
            conn = getConnection();
            stat = conn.createStatement();
            updatecount = stat.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeJdbc();

        }
        return updatecount;
    }
}


