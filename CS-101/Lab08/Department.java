public class Department {
    private String deptName;
    private String deptCode;

    public Department(String deptName, String deptCode){
        this.deptName = deptName;
        this.deptCode = deptCode;
    }
    public String getDeptName(){
        return deptName;
    }
    public String getDeptCode(){
        return deptCode;
    }
    public boolean equals(Object o){
        if ( o instanceof Department){
            Department obj = (Department)o;
            if ( obj.deptCode.equals(this.deptCode) && obj.deptName.equals(this.deptName) ){
                return true;
            }
        }
        return false;
    }
    public String toString(){
        String depData = "DeptName: " + deptName + " Dept Code: " + deptCode;
        return depData;
    }
}
