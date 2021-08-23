package manager.model;

public class Manager {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String movephone;
    private Integer managertype;

    public Manager(String id,String username,String password,String fullname,String movephone,Integer managertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.movephone = movephone;
        this.managertype = managertype;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMovephone() {
        return movephone;
    }

    public void setMovephone(String movephone) {
        this.movephone = movephone;
    }

    public Integer getManagertype() {
        return managertype;
    }

    public void setManagertype(Integer managertype) {
        this.managertype = managertype;
    }

}