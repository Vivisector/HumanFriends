import java.util.Date;

public class Donkey extends Animal {
    public Donkey(String name, Date birthDate) {
        super(name, "осел", birthDate);
    }

    @Override
    public void listCommands() {
        // Реализация вывода списка команд для кошки
    }

    @Override
    public void teachCommand(String command) {
        // Реализация обучения кошки новой команде
    }
}

