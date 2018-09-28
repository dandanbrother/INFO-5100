package Assignment3;

public class Test {


    public static void main(String[] args) {
        Course algorithm = new Course("Algorithm");
        for (int i = 0; i < 10; i++) {
            algorithm.registerStudent(new Student("student"+i, i));
        }
        System.out.println("Now the following " + algorithm.getNumberOfStudent()+ " students have registered +" + algorithm.getName());
        for (Student student : algorithm.getStudents()) {
            System.out.println(student.getId() + " --> " + student.getName());
        }
        System.out.println(algorithm.getName() + " is full? " + algorithm.isFull());
        System.out.println("Student register in full course ? " + (algorithm.registerStudent(new Student("Fail", 10))?"Success":"Fail"));
    }
}
