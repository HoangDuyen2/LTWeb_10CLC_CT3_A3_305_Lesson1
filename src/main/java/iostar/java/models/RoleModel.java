package iostar.java.models;

public class RoleModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int roleId;
    private String roleName;
    public RoleModel() {
        super();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleModel [roleId=" + roleId + ", roleName=" + roleName + "]";
    }
}
