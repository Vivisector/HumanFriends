import java.time.LocalDate;
import java.util.Calendar;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public abstract class Animal {
    private String name;
    private String breed;
    private Date birthDate;

    public Animal(String name, String breed,  Date birthDate) {
        this.name = name;
        this.breed = breed;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

//    public int getAge() {
//        LocalDate currentDate = LocalDate.now();
//        LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        Period period = Period.between(birthLocalDate, currentDate);
//        return period.getYears(); // Возвращаем возраст в годах
//    }
public int calculateAgeInYears() {
    Calendar birthCalendar = Calendar.getInstance();
    birthCalendar.setTime(birthDate);

    Calendar currentCalendar = Calendar.getInstance();

    int years = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

    // Проверяем, если текущая дата меньше даты рождения по дню и месяцу, уменьшаем возраст на 1 год
    if (currentCalendar.get(Calendar.MONTH) < birthCalendar.get(Calendar.MONTH) ||
            (currentCalendar.get(Calendar.MONTH) == birthCalendar.get(Calendar.MONTH) &&
                    currentCalendar.get(Calendar.DAY_OF_MONTH) < birthCalendar.get(Calendar.DAY_OF_MONTH))) {
        years--;
    }

    return years;
}
    public abstract void listCommands();

    public abstract void teachCommand(String command);

    @Override
    public String toString() {
        int age = calculateAgeInYears();
        String animalClass = AnimalManager.determineAnimalClass(breed); // Определите класс животного здесь
        return "Имя: " + name + ", Порода: " + breed + ", Возраст: " + age + " лет, Класс: " + animalClass;
    }

}
