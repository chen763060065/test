package demo.extend;

public class Father {

    private String lastName;

    public Father(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Father() {
    }

    @Override
    public String toString() {
        return "Father{" +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
