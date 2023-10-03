import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    private List<DomesticAnimal> animals = new ArrayList<>();
    private Counter counter = new Counter();

    public void addAnimal(DomesticAnimal animal) throws CounterException {
        try (Counter counter = new Counter()) {
            animals.add(animal);
            counter.add();
        } catch (Exception e) {
            // Ловим исключение, если что-то пошло не так
            throw new CounterException("Ошибка при работе с счетчиком.");
        }
    }

    public void listAnimals() {
        for (DomesticAnimal animal : animals) {
            System.out.println(animal);
        }
    }

    public int getTotalCount() {
        return counter.getCount();
    }

    public DomesticAnimal findAnimalByName(String name) {
        for (DomesticAnimal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }
}
