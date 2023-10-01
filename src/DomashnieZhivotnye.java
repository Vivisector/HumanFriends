import java.util.Date;
// Дочерний класс для Домашних животных
public class DomashnieZhivotnye extends DruzyaCheloveka {
    public DomashnieZhivotnye(String name, String classType, Date birthDate) {
        super(name, classType, birthDate);
    }

    @Override
    public void golos() {
        System.out.println("Домашнее животное издает звук.");
    }
}

