/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question.
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        //write your code here
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        //write your code here
        return name;
    }

    public void setName(String name) {
        //write your code here
        this.name = name;
    }

    public void raiseSalary(double byPercent) {
        this.salary *= byPercent/100.0;
    }

}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * when employee becomes a member, so we can use the Class object to swap two employees
     */
    Employee employee;

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
        double tax = 0.0;
        if (employee.salary <= 8900)
            tax = employee.salary * 6.2/ 100;
        else
            tax = 106800 * 6.2 / 100;
        System.out.println("Employee's social security tax is : " + tax);
        return tax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {
        //write your code here
        double deduction = 0.0;
        if (employee.age < 35)
            deduction = 0.03;
        else if (employee.age <= 50)
            deduction = 0.04;
        else if (employee.age < 60)
            deduction = 0.05;
        else
            deduction = 0.06;
        System.out.println("The employee's contribution for insurance coverage is : " + deduction * employee.salary);
        return deduction * employee.salary;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
        String name1 = e1.name;
        String name2 = e2.name;
        String name3 = e3.name;
        String tmp = null;
        if (e1.salary > e2.salary) {
            tmp = name1;
            name1 = name2;
            name2 = tmp;
        }
        if (e1.salary > e3.salary) {
            tmp = name1;
            name1 = name3;
            name3 = tmp;
        }
        if (e2.salary > e3.salary) {
            tmp = name2;
            name2 = name3;
            name3 = tmp;
        }
        System.out.println(name1 + " " + name2 + " " + name3);
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
        //write your code here
        employee.raiseSalary(300);
    }



    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     The parameters are passed by value in Java. The addresses of parameters x and y in the swap function are the copy of addresses of a and b.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);

        Assignment2 A = new Assignment2();
        A.employee = a;
        Assignment2 B = new Assignment2();
        B.employee = b;

        System.out.println("Before: a=" + A.employee.getName());
        System.out.println("Before: b=" + B.employee.getName());

        swap(A, B);
        System.out.println("After: a=" + A.employee.getName());
        System.out.println("After: b=" + B.employee.getName());
    }

    public static void swap(Assignment2 x, Assignment2 y) {
        Employee temp = x.employee;
        x.employee = y.employee;
        y.employee = temp;

    }
}
