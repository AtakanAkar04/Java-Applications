public class Employee {
    private final int WORKING_DAYS = 261;

    private String employeeName;
    private double dailyRate;
    private Department department;
    private Project project;

    public Employee(String employeeName, double dailyRate, String deptName, String deptCode, Project project){
        this.employeeName = employeeName;
        this.dailyRate = dailyRate;
        this.project = project;
        this.department = new Department(deptName, deptCode);
    }
    public Employee(Employee employee){
        this.employeeName = employee.employeeName;
        this.dailyRate = employee.dailyRate;
        this.department = employee.department;
        this.project = employee.project;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    public double calculateYearlySalary(){
        double yearlySalary;
        yearlySalary = WORKING_DAYS * dailyRate;
        return yearlySalary;
    }
    public String toString(){
        String employeeData = "Employee name: " + employeeName + " Yearly salary: " + calculateYearlySalary() + "\n";
        employeeData += department.toString();
        employeeData += "Project name: " + project.getProjectName();
        employeeData += "\nProjectID: " + project.getProjectId() + "\n" + "Project Type: " + project.getProjectType() + "\n" + "Team size: " + project.calculatePersonResources() + 
        "\n" + "Estimated Project Cost: " + project.calculateProjectCost();
        
        return employeeData;
        
    }

}
