class Test{
    String name;
    int age;

    public Test(String n, int x){
        this.name = n;
        this.age = x;
    }
}
class Task extends Test{
    int salary;
    public Task(String n, int x, int salary){
        super(n, x);
        this.salary = salary;
        System.out.println("here are the details:\n");
        System.out.println("name:" + this.name);
        System.out.println("salary:"+ this.salary);
        System.out.println("Age:"+ this.age + "\tyears");

    }
    public static void main(String[] args) {
        //implicit casting
        Test test =new Task("Marvin", 21, 1200000);

    }
}