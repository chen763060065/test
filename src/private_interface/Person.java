package private_interface;

import lombok.Builder;

@Builder
public class Person {
    private Animal animal;

    public void animalEat(){
        this.animal.eat();
    }
    public static void main(String[] args) {
        Person person = Person.builder().animal(new Cat()).build();
        person.animal.eat();
    }

}
