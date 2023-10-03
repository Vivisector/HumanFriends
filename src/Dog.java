import java.util.Date;

public class Dog extends Animal {
    public Dog(String name, Date birthDate) {
        super(name, "собака", birthDate);
    }

    @Override
    public void listCommands() {
    }

    @Override
    public void teachCommand(String command) {

    }
}

