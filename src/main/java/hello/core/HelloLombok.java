package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class HelloLombok {
    private String name;
    private final int age;

    public static void main(String[] args) {
       HelloLombok helloLombok = new HelloLombok(142);
       helloLombok.setName("chan");
       String name = helloLombok.getName();
       System.out.println("name = " + name);
       System.out.println("helloLombok = " + helloLombok);
    }
}
