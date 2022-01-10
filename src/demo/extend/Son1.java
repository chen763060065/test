package demo.extend;

public class Son1 extends Father{

    private String firstName;


    public Son1(String lastName,String firstName) {
        super(lastName);
        this.firstName = firstName;
    }

    public Son1() {
        super();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Son1{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
