import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Observer;

public class Reservation {

    public List<Animal> getAnimals() {
        return Animals;
    }

    public ObservableList<Animal> Animals = FXCollections.observableArrayList();

    public void NewCat(Cat cat, Observer o){
        this.Animals.add(cat);
        cat.addObserver(o);
    }

    public void NewDog(Dog dog, Observer o){
        this.Animals.add(dog);
        dog.addObserver(o);
    }
}
