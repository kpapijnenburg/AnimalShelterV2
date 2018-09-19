import java.util.ArrayList;
import java.util.List;

public class Reservation {

    public List<Animal> getAnimals() {
        return Animals;
    }

    public List<Animal> Animals = new ArrayList<Animal>();

    public void NewCat(Cat cat){
        this.Animals.add(cat);
    }

    public void NewDog(Dog dog){
        this.Animals.add(dog);
    }
}
