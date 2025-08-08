package dependencyInjection;

public class Student {
    private String name; // make sure property name is 'name'

    // setter for name
    public void setName(String name) {
        this.name = name;
    }

    // getter for name (optional)
    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("Student name: " + name);
    }
}
