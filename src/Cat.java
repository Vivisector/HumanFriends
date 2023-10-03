import java.util.Date;

public class Cat extends Animal {
    public Cat(String name, Date birthDate) {
        super(name, "кошка", birthDate);
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

