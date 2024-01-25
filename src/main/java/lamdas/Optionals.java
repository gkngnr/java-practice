package lamdas;

import java.util.Optional;

public class Optionals {

    public static void main(String[] args) {
        final var defaultPerson = new Person("John Doe", 10);
        Person p = null;
        var op1 = Optional.ofNullable(p);

        System.out.println(op1.isEmpty());
        System.out.println(op1.orElse(defaultPerson));
        System.out.println(op1.orElseGet(Person::new));

        op1 = Optional.ofNullable(new Person("Gok Gun", 40));

        System.out.println(op1.isPresent());
        System.out.println(op1.orElse(defaultPerson));
        System.out.println(op1.orElseGet(Person::new));
        System.out.println(op1.filter(i -> i.age < 20).orElseGet(Person::new));
        System.out.println(op1.filter(i -> i.name.startsWith("Gok")).orElseGet(Person::new));
    }

    record Person(String name, Integer age) {
        Person() {
            this("John Doe DEF", 20);
        }
    }
}
