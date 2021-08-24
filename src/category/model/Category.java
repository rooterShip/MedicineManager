package category.model;

public class Category {
    private String id;
    private String cname;
    private String createtime;
    private String description;

    public Category(){

    }

    public Category(String id, String cname, String createtime, String description) {
        this.id = id;
        this.cname = cname;
        this.createtime = createtime;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
