public class Dog implements Eatable {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    public static void main(String[] args) {
        Dog bosco = new Dog();
        bosco.eat();
    }

}
