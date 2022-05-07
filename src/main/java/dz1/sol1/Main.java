package dz1.sol1;

public class Main {
    public static void main(String[] args) {
        Person person = new Person()
                .firstName("Василий")
                .middleName("Петрович")
                .lastName("Марцешкевич")
                .country("Гвинея")
                .gender("М")
                .address("г.Фарана")
                .phone("8-10-224-3081-874-597")
                .age(38);

        System.out.println(person);
    }
}
