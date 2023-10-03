import java.util.Date;

public class Horse extends Animal {
    public Horse(String name, Date birthDate) {
        super(name, "лошадь", birthDate);
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

