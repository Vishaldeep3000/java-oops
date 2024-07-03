import java.util.ArrayList;

abstract class Employee{

    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){ //using Encapsulation, improving security
        return this.name;
    }

    public int getId(){
        return this.id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name = "+name+" Id = "+id+" Salary = "+calculateSalary()+"]";
    }


} 

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, int monthlySalary) { //here name and id are inherited from parent class

        super(name, id);
        this.monthlySalary = monthlySalary;

    }

    @Override
    public double calculateSalary(){       
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int woringHours;
    private double hourelyRate;


    public PartTimeEmployee(String name, int id, int woringHours, double hourelyRate){

        super(name, id);
        this.woringHours = woringHours;
        this.hourelyRate = hourelyRate;

    }

    @Override
    public double calculateSalary(){
        return hourelyRate * woringHours;
    }
}

class PayrollSystem{

    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee emp){
        employeeList.add(emp);
    }

    public void removeEmployee(int empId){

        Employee empToRemove = null;

        for(Employee emp : employeeList){
            if(emp.getId() == empId){
                empToRemove = emp;
                break;
            }
        }

        if(empToRemove != null){
            employeeList.remove(empToRemove);
        }
    }

    public void displayEmployee(){

        for(Employee emp : employeeList){
            System.out.println(emp);
        }

    }
    

}

public class EmployeePayroll {

    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 =  new FullTimeEmployee("Aryan", 12, 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Manas", 112, 4, 500);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        
        payrollSystem.displayEmployee();

        System.out.println("Removing employee...");

        payrollSystem.removeEmployee(112);

        System.out.println("Update List : ");

        payrollSystem.displayEmployee();
    }

    

}
