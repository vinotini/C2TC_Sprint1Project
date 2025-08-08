package dependencyInjection;

public class Student1 {
    private String name;

    // No-arg constructor (required by Spring)
    public Student1() {
    }

    // Setter for name property
    public void setName(String name) {
        this.name = name;
    }

    // Optional getter
    public String getName() {
        return name;
    }

    // Method to display info
    public void showInfo() {
        System.out.println("Student1 name: " + name);
    }
}
