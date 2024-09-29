package iostar.java.models;

public class Roles {
    private int role_id;
    private String roleName;

    public Roles() {}
    public Roles(String roleName) {
        this.roleName = roleName;
    }

    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
