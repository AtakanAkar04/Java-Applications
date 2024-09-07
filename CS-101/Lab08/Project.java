/**
 * Project
 */
public class Project {
    private final double TAX = 13;
    private final int OVERHEAD = 50000;
    private final int EMP_HOURS_WEEK = 45;
    private static int projectCounter = 5000;

    private String projectId;
    private String projectName;
    private char projectType;
    private int personHours;
    private int ratePerHour;
    private int projectWeeks;

    public Project(String projectName, char projectType, int personHours, int ratePerHour, int projectWeeks){
        setProjectName(projectName);
        this.projectType = projectType;
        setPersonHours(personHours); 
        this.ratePerHour = ratePerHour;
        setProjectWeeks(projectWeeks);
        projectCounter++;
        setProjectId();
    }
    
    public String getProjectId(){
        return projectId;
    }
    public String getProjectName() {
        return projectName;
    }
    public char getProjectType() {
        return projectType;
    }
    public int getPersonHours() {
        return personHours;
    }
    public int getRatePerHour() {
        return ratePerHour;
    }
    public int getProjectWeeks() {
        return projectWeeks;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setPersonHours(int personHours){
        if ( personHours > 0){
            this.personHours = personHours;
        }
        else{
            this.personHours = 0;
        }
    }
    public void setProjectWeeks(int projectWeeks ){
        if ( projectWeeks > 0){
            this.projectWeeks = projectWeeks;
        }
        else{
            this.projectWeeks = 0;
        }
    }
    public void setRatePerHour(int ratePerHour){
        this.ratePerHour = ratePerHour;
    }
    private void setProjectId(){
        this.projectId = 2021 + " - " + projectCounter;
        
    }
    public void setProjectType(int cost){
        if ( cost > 1000000){
            this.projectType = 'm';
        }
        else if( cost > 5000000){
            this.projectType = 'l';
        }
        else if ( cost > 0){
            this.projectType = 's';
        }
        else {
            this.projectType = 'i';
        }
    }
    public void deactivateProject(){
        projectType='i';
        setPersonHours(0);
        setRatePerHour(0);
    }
    public void activateProject(int personHours, int ratePerHour){
        setPersonHours(personHours);
        setRatePerHour(ratePerHour);
        
    }
    public double calculateProjectCost(){
        double total;
        double increasedOverHead;
        increasedOverHead = (double)OVERHEAD + (double)OVERHEAD / 100.0 * (double)TAX;
        total = personHours * ratePerHour;
        if ( total >= 20000){
            total += increasedOverHead; 
        }
        return total;
    }
    public int calculatePersonResources(){
        int personNeed;
        personNeed = (personHours / projectWeeks) / EMP_HOURS_WEEK;
        return personNeed;
    }
    public String toString(){
        String projectData1 = "Project name: " + projectName + 
        "\nProjectId: " + projectId +
        "\nProject type: " + projectType +
        "\nTeam Size:" + calculatePersonResources() +
        "\nEstimated Project Cost: " + calculateProjectCost() + "\n";
        String projectData2 = "------- INACTIVE PROJECT -------" +
        "\nProject Name: " + projectName +
        "\nProject ID: " + projectId + "\n";
        if (projectType != 'i'){
            return projectData1;
        }
        else{
            return projectData2;
        }
        
    }




    
}