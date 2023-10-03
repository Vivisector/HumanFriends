public abstract class DomesticAnimal {
    private String name;
    private String breed;
    private int age;

    public DomesticAnimal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public abstract void listCommands();

    public abstract void teachCommand(String command);

    @Override
    public String toString() {
        return "Имя: " + name + ", Порода: " + breed + ", Возраст: " + age;
    }
}
