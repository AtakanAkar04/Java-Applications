public class EmployeeApp {
    public static void main(String[] args) {
        int counter;

        Project project1 = new Project("America",'m',2000,15,4);
        Employee employee1 = new Employee("Emre",10,"Human Resources","HR",project1);
        Employee employee2 = new Employee("Emre",5,"Health","HL",project1);
        Employee employee3 = new Employee("Emre",15,"Health","HL",project1);
        Employee employee4 = new Employee(employee1);

        Employee[] list = {employee1,employee2,employee3,employee4};

        System.out.println(employee1);
        System.out.println();
        System.out.println(employee2);
        System.out.println();
        System.out.println(employee3);
        System.out.println();
        System.out.println(employee4);
        System.out.println();
        System.out.println("-------end employee list-------");

        counter = 1;
        for ( int i= 0; i < list.length; i++){
            for(int k=i;k< list.length;k++){
                if(list[i].getDepartment().equals(list[k].getDepartment()) && i!=k){
                    System.out.println("-------Employees with matching departments (" + counter + ")");
                    counter++;
                    System.out.println();
                    System.out.println();
                    System.out.println(list[i]);
                    System.out.println();
                    System.out.println(list[k]);
                    System.out.println();
                }
            }
        }

    }
}
