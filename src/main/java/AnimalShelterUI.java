import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class AnimalShelterUI extends Application {
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

    private void RefreshControls() {
        lstAnimals.getItems().removeAll();

        ObservableList<Animal> observableList = FXCollections.observableList(reservation.getAnimals());
        lstAnimals.setItems(observableList);

        System.out.println(observableList);
    }

    @FXML
    private void btnAddAnimalClicked() {
        Gender gender = (Gender) group.getSelectedToggle().getUserData();

        if (cmbSpecies.getValue().toString() == "Cat"){
            Cat cat = new Cat(txtName.getText(), gender, txtBadHabits.getText());
            reservation.NewCat(cat);
        }
        else if (cmbSpecies.getValue().toString() == "Dog"){
            Dog dog = new Dog(txtName.getText(), gender);
            reservation.NewDog(dog);
        }

        RefreshControls();

    }

    @FXML
    private void btnReserveAnimal_Clicked(){

        Animal animal = (Animal) lstAnimals.getSelectionModel().getSelectedItem();

        if (animal != null){
            animal.reserve(txtName.getText());
            //control refresh werkt alleen wanneer er een dier word toegevoegd.
            //Dit zal opgelost worden door het observer pattern toe te passen.
            this.RefreshControls();
        }
    }
}
