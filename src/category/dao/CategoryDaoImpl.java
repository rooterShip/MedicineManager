package category.dao;

import category.model.Category;
import util.JdbcUtil;
import util.PageModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public List<Category> selectByPage(PageModel pageModel) {
        List<Category> categories = new ArrayList<>();
        int pageSize = pageModel.getPageSize();
        int pageNo = pageModel.getPageNo();
        String likeValue = pageModel.getLikeValue();
        //查询总条数
        StringBuffer sqlrecordCount = new StringBuffer("select ID,CNAME,to_char(c.CREATETIME,'yyyy-mm-dd') CREATETIME,DESCRIPTION  from category c ");
        if(likeValue!=null&&!"".equals(likeValue))
            sqlrecordCount.append("where c.ID like'%"+likeValue+"%' or c.CNAME like '%"+likeValue+"%' or c.DESCRIPTION like '%"+likeValue+"%'");
        int rcordCount = JdbcUtil.queryBysql(sqlrecordCount.toString()).size();
        pageModel.setRecordCount(rcordCount);
        //查询分页数据
        StringBuffer sql = new StringBuffer( "select * from(" +
                "select t.*,rownum rn from(" +
                "select ID,CNAME,to_char(c.CREATETIME,'yyyy-mm-dd') CREATETIME,DESCRIPTION  from category c ");
        if(likeValue!=null&&!"".equals(likeValue))
            sql.append("where c.ID like'%"+likeValue+"%' or c.CNAME like '%"+likeValue+"%' or c.DESCRIPTION like '%"+likeValue+"%'");
        sql.append(" order by c.id desc) t) a " +
                "where a.rn >" + pageSize + "*(" + pageNo + "-1) and a.rn <=" + pageSize + "*" + pageNo);
        List<Map<String,Object>> list = JdbcUtil.queryBysql(sql.toString());
        for(Map<String,Object> map : list){
            String id = (String) map.get("ID");
            String cname = (String) map.get("CNAME");
            String createtime = (String) map.get("CREATETIME");
            String description = (String) map.get("DESCRIPTION");
            Category category = new Category(id,cname,createtime,description);
            categories.add(category);
        }

        return categories;
    }

    @Override
    public int addOne(Category category) {
        String cname = category.getCname();
        String description = category.getDescription();
        String sql = "insert into category values(medicineseq.nextval,'"+cname+"',sysdate,'"+description+"')";
        return JdbcUtil.updateBysql(sql);
    }

    @Override
    public int updateOne(Category category) {
        String id = category.getId();
        String cname = category.getCname();
        String description = category.getDescription();
        String sql = "update category set cname='"+cname+"',description='"+description+"' where id='"+id+"'";
        return JdbcUtil.updateBysql(sql);
    }

    @Override
    public int deleteByCategoryId(String categoryId) {
        String sql = "delete from category c where c.id = '"+categoryId+"'";
        return JdbcUtil.updateBysql(sql);
    }

    @Override
    public int queryDrugByCategoryId(String categoryId) {
        String sql = "select count(*) cou from drug d where d.categoryid='"+categoryId+"'";
        List<Map<String,Object>> list = JdbcUtil.queryBysql(sql);
        Map<String,Object> map = list.get(0);
        Integer count = Integer.valueOf(String.valueOf((BigDecimal) map.get("COU")));
        return count;
    }

}
