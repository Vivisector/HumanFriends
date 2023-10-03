import java.util.Date;

public class Ham extends Animal {
    public Ham(String name, Date birthDate) {
        super(name, "хомяк", birthDate);
    }

    @Override
    public void listCommands() {
    }

    @Override
    public void teachCommand(String command) {
    }
}

