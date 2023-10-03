import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;

public class Menu {
    private AnimalRegistry registry = new AnimalRegistry();
    private Scanner scanner = new Scanner(System.in);

    private Connection connection;

    public Menu(Connection connection) {
        this.connection = connection;
    }

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
            System.out.println("Введите вид животного:");
            String species = scanner.nextLine();
            System.out.println("Введите команды, которые знает животное:");
            String commands = scanner.nextLine();
            System.out.println("Введите дату рождения животного (гггг-мм-дд):");
            String birthDate = scanner.nextLine();

            try {
                AnimalManager.addAnimal(connection, name, species, commands, birthDate);
                System.out.println("Животное добавлено.");
            } catch (SQLException e) {
                System.err.println("Ошибка при добавлении животного: " + e.getMessage());
            }
        }

    private void listAnimals() {
        try {
            List<Animal> animals = AnimalManager.getAllAnimals();

            // Вывод списка животных
            System.out.println("Список животных:");
            for (Animal animal : animals) {
                System.out.println(animal); // Возможно, вам понадобится реализовать toString() для Animal
            }

            System.out.println("Общее количество животных: " + animals.size());
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка животных: " + e.getMessage());
        }
    }

}
