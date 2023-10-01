import java.util.Date;
public abstract class DruzyaCheloveka {
    private String name; // имя
    private String classType; // класс
    private Date birthDate; // дата рождения
    private String command; // команда

    public DruzyaCheloveka(String name, String classType, Date birthDate) {
        this.name = name;
        this.classType = classType;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getClassType() {
        return classType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public abstract void golos(); // голос
}