import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AnimalManager {
    public static void addAnimal(Connection connection, String name, String species, String commands, String birthDateStr) throws SQLException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = null;
        try {
            birthDate = (Date) dateFormat.parse(birthDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Обработка исключения, если преобразование не удалось
            return; // Или другая логика обработки
        }


        // Определить класс животного на основе вида (по вашим правилам)
        String animalClass = determineAnimalClass(species);

        // SQL-запрос для вставки данных в таблицу "Все_животные"
        String sql = "INSERT INTO Все_животные (имя, вид, команда, дата_рождения, класс) VALUES (?, ?, ?, ?, ?)";

            // В зависимости от вида (species) создаем экземпляр нужного класса
            if ("собака".equalsIgnoreCase(species)) {
                new Dog(name, birthDate);
            } else if ("кошка".equalsIgnoreCase(species)) {
                new Cat(name, birthDate);
            } else if ("хомяк".equalsIgnoreCase(species)) {
                new Ham(name, birthDate);
            } else if ("лошадь".equalsIgnoreCase(species)) {
                new Horse(name, birthDate);
            } else if ("осел".equalsIgnoreCase(species)) {
                new Donkey(name, birthDate);
            } else {
                // В случае неизвестного вида животного можно вернуть null или выбрать другую стратегию
//                return null;
            }

    }

    private static String determineAnimalClass(String species) {
        if ("кошка".equalsIgnoreCase(species) || "собака".equalsIgnoreCase(species) || "хомяк".equalsIgnoreCase(species)) {
            return "домашние";
        } else {
            return "вьючные";
        }
    }

    public static List<Animal> getAllAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();

        // Выполните SQL-запрос для выбора всех животных из таблицы
        String sql = "SELECT * FROM Все_животные";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                // Извлекаем значения из ResultSet
                String name = resultSet.getString("имя");
                String species = resultSet.getString("вид");
                String commands = resultSet.getString("команда");
                Date birthDate = resultSet.getDate("дата_рождения");
//                String birthDateStr = resultSet.getString("дата_рождения");

                // Создайте экземпляр животного и добавьте его в список
                Animal animal = AnimalManager.createAnimal(name, species, commands, birthDate);

                if (animal != null) {
                    animals.add(animal);
                }
            }
        }

        return animals;
    }

    public static Animal createAnimal(String name, String species, String commands, Date birthDateStr) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = null;
//        try {
//            birthDate = (Date) dateFormat.parse(birthDateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // Обработка исключения, если преобразование не удалось
//            return; // Или другая логика обработки
//        }
        // В зависимости от вида (species) создаем экземпляр нужного класса
        if ("собака".equalsIgnoreCase(species)) {
            return new Dog(name, birthDateStr);
        } else if ("кошка".equalsIgnoreCase(species)) {
            return new Cat(name, birthDateStr);
        } else if ("хомяк".equalsIgnoreCase(species)) {
            return new Ham(name, birthDateStr);
        } else if ("лошадь".equalsIgnoreCase(species)) {
            return new Horse(name, birthDateStr);
        } else if ("осел".equalsIgnoreCase(species)) {
            return new Donkey(name, birthDateStr);
        } else {
            // В случае неизвестного вида животного можно вернуть null или выбрать другую стратегию
            return null;
        }
    }
}

