package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML ListView listView;
    private ArrayList<Person> persons;

    @FXML private void onSortAction() {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        ObservableList<Person> namesList = FXCollections.observableArrayList(persons);
        listView.setItems(namesList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Person person1 = new Person("Jakub", "Grzęda", 501123123);
        Person person2 = new Person("Adam", "Małysz", 23125657);
        Person person3 = new Person("Jan", "Adamski", 4234234);
        persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        ObservableList<Person> namesList = FXCollections.observableArrayList(persons);
        listView.setItems(namesList);
        listView.setCellFactory(param -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getLastName() == null) {
                    setText(null);
                } else {
                    setText(item.getLastName() + " : " + item.getNumber());
                }
            }
        });
    }
}
