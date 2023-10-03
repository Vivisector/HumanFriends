import java.time.LocalDate;
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

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthLocalDate, currentDate);
        return period.getYears(); // Возвращаем возраст в годах
    }

    public abstract void listCommands();

    public abstract void teachCommand(String command);

    @Override
    public String toString() {
        return "Имя: " + name + ", Порода: " + breed + ", Возраст: "; // + period.getYears(); //age;
    }
}
