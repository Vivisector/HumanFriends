import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AnimalManager {
    public static void addAnimal(Connection connection, String name, String species, String commands, String birthDateStr) throws SQLException {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthDate = null;
//        try {
//            // Преобразование строки в объект java.sql.Date
//            java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDateStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // Обработка исключения, если преобразование не удалось
//            return; // Или другая логика обработки
//        }

        // Определить класс животного на основе вида (по вашим правилам)
        String animalClass = determineAnimalClass(species);

        // Преобразуйте строку с датой рождения в объект java.sql.Date перед добавлением в базу данных
        java.sql.Date sqlBirthDate = java.sql.Date.valueOf(birthDateStr);

        // SQL-запрос для вставки данных в таблицу "Все_животные"
        String sql = "INSERT INTO Все_животные (имя, вид, команда, дата_рождения) VALUES (?, ?, ?, ?)";

//            // В зависимости от вида (species) создаем экземпляр нужного класса
//            if ("собака".equalsIgnoreCase(species)) {
//                new Dog(name, birthDate);
//            } else if ("кошка".equalsIgnoreCase(species)) {
//                new Cat(name, birthDate);
//            } else if ("хомяк".equalsIgnoreCase(species)) {
//                new Ham(name, birthDate);
//            } else if ("лошадь".equalsIgnoreCase(species)) {
//                new Horse(name, birthDate);
//            } else if ("осел".equalsIgnoreCase(species)) {
//                new Donkey(name, birthDate);
//            }

//        String sql = "INSERT INTO Все_животные (имя, вид, команда, дата_рождения) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, species);
            preparedStatement.setString(3, commands);
            preparedStatement.setDate(4, sqlBirthDate);
            preparedStatement.executeUpdate();
        }

    }

    public static String determineAnimalClass(String species) {
        if ("Кошки".equalsIgnoreCase(species) || "Собаки".equalsIgnoreCase(species) || "Хомяки".equalsIgnoreCase(species)) {
            return "домашние";
        } else {
            return "вьючные";
        }
    }

    public static List<Animal> getAllAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();

        // Выполните SQL-запрос для выбора всех животных из таблицы
        String sql = "SELECT * FROM все_животные";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                // Создайте экземпляр животного и добавьте его в список
                Animal animal = AnimalManager.createAnimal(
                        resultSet.getString("имя"),
                        resultSet.getString("вид"),
                        resultSet.getString("команда"),
                        resultSet.getDate("дата_рождения")
                );

                if (animal != null) {
                    animals.add(animal);
                }
            }
        }

        return animals;
    }

    public static Animal createAnimal(String name, String species, String commands, Date birthDateStr) {

        // В зависимости от вида (species) создаем экземпляр нужного класса
        if ("Собаки".equalsIgnoreCase(species) || "собака".equalsIgnoreCase(species)) {
            return new Dog(name, species, commands, birthDateStr);
        } else if ("Кошки".equalsIgnoreCase(species) || "кошка".equalsIgnoreCase(species)) {
            return new Cat(name, species, commands, birthDateStr);
        } else if ("Хомяки".equalsIgnoreCase(species) || "хомяк".equalsIgnoreCase(species)) {
            return new Ham(name, species, commands, birthDateStr);
        } else if ("Лошади".equalsIgnoreCase(species) || "лошадь".equalsIgnoreCase(species)) {
            return new Horse(name, species, commands, birthDateStr);
        } else if ("Лошади_и_Ослы".equalsIgnoreCase(species) || "лошадь".equalsIgnoreCase(species) || "осел".equalsIgnoreCase(species)) {
            return new Donkey(name, species, commands, birthDateStr);
        } else {
            // В случае неизвестного вида животного можно вернуть null или выбрать другую стратегию
            return null;
        }


    }
}

