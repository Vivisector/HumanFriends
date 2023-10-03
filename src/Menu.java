import java.util.Scanner;

public class Menu {
    private AnimalRegistry registry = new AnimalRegistry();
    private Scanner scanner = new Scanner(System.in);

    public void start() throws CounterException {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Завести новое животное");
            System.out.println("2. Посмотреть список животных");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listAnimals();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private void addAnimal() throws CounterException {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите породу животного:");
        String breed = scanner.nextLine();
        System.out.println("Введите возраст животного:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки

        DomesticAnimal animal = new DomesticAnimal(name, breed, age) {
            @Override
            public void listCommands() {
                // Реализация вывода списка команд животного
            }

            @Override
            public void teachCommand(String command) {
                // Реализация обучения животного новой команде
            }
        };

        registry.addAnimal(animal);
        System.out.println("Животное добавлено.");
    }

    private void listAnimals() {
        registry.listAnimals();
        System.out.println("Общее количество животных: " + registry.getTotalCount());
    }
}
