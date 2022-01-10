package entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    String name;
    Integer age;

    public void add(int a){
        this.age+=1;
    }

    public static void testNullPointer(){
        User u = new User();
        try{
            u.add(1);
        }catch (Exception e){
            e.getMessage();
            System.out.println(e.getMessage()==null);
            throw new NullPointerException("null");
        }

    }

    public static void main(String[] args) {
        testNullPointer();
    }
}
