import java.util.Date;
// Дочерний класс для Вьючных животных
public class VyuchnyeZhivotnye extends DruzyaCheloveka {
    public VyuchnyeZhivotnye(String name, String classType, Date birthDate) {
        super(name, classType, birthDate);
    }

    @Override
    public void golos() {
        System.out.println("Вьючное животное издает звук.");
    }
}