import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class AnimalShelterUI extends Application implements Observer {
    public ComboBox cmbSpecies;
    public TextField txtName;
    public RadioButton radMale;
    public RadioButton radFemale;
    public TextField txtBadHabits;
    public Button btnAddAnimal;
    public ListView lstAnimals;
    public TextField txtReservor;
    public Button btnReserveAnimal;
    public ToggleGroup group = new ToggleGroup();

    private Reservation reservation = new Reservation();

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AnimalShelterUI.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void initialize() {

        //add items to combobox
        cmbSpecies.getItems().addAll("Cat", "Dog");


        //setup radiobuttons
        radMale.setUserData(Gender.Male);
        radMale.setToggleGroup(group);
        radMale.setSelected(true);

        radFemale.setUserData(Gender.Female);
        radFemale.setToggleGroup(group);

    }



    @FXML
    private void btnAddAnimalClicked() {
        Gender gender = (Gender) group.getSelectedToggle().getUserData();

        if (cmbSpecies.getValue().toString() == "Cat"){
            Cat cat = new Cat(txtName.getText(), gender, txtBadHabits.getText());
            reservation.NewCat(cat, this);
        }
        else if (cmbSpecies.getValue().toString() == "Dog"){
            Dog dog = new Dog(txtName.getText(), gender);
            reservation.NewDog(dog, this);
        }

        lstAnimals.setItems(reservation.Animals);
    }

    @FXML
    private void btnReserveAnimal_Clicked(){

        Animal animal = (Animal) lstAnimals.getSelectionModel().getSelectedItem();

        if (animal != null){
            animal.reserve(txtReservor.getText());
        }
    }

    public void update(Observable o, Object arg) {
        this.lstAnimals.refresh();
    }
}
