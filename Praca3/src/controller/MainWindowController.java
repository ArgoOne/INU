package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn.SortType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person; //zaimportowanie do listy danych o typie Person z package model

public class MainWindowController {

	private Main main;
	private Stage primaryStage;

	private ObservableList<Person> personList = FXCollections.observableArrayList();

	@FXML
	private TableView<Person> tableView;
	@FXML
	private TableColumn firstNameColumn;
	@FXML
	private TableColumn lastNameColumn;
	@FXML
	private TableColumn roomColumn;

	Scanner in = null;
	PrintWriter out = null;
	PrintWriter raport = null;

	String firstName;
	String lastName;
	String room;
	String rozp;
	String zak;

	@FXML
	private TextField TextFieldImie;
	@FXML
	private TextField TextFieldNazwisko;
	@FXML
	private TextField TextFieldPokoj;
	@FXML
	private TextField TextFieldRozp;
	@FXML
	private TextField TextFieldZak;

	public void setMain(Main main, Stage primaryStage) {
		this.main = main;
		this.primaryStage = primaryStage;
		tableView.setItems(personList);
	}

	public void initialize() {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		// wziete z dokumentacji oracle, ustalamy powiazanie z kolumna ktora ma
		// wyswietlac z kolumna klasy person
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		roomColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("room"));

		tableView.getSelectionModel().selectedItemProperty().addListener((ov, oldVal, newVal) -> {
			// ustawienie co ma sie robic addListener -> kiedy kliknie sie myszka na dany
			// rekord
			TextFieldImie.setText(newVal.getFirstName());
			// pole ustawia nowa wartosc ktora czyta z tego co zaznaczyl Listener
			TextFieldNazwisko.setText(newVal.getLastName());
			TextFieldPokoj.setText(newVal.getRoom());
			TextFieldRozp.setText(newVal.getRozp());
			TextFieldZak.setText(newVal.getZak());
			// System.out.println(newVal.getFirstName() + " " + newVal.getLastName());
		});
	}

	@FXML
	public void entranceFile() {
		try {
			in = new Scanner(Paths.get("C:\\Users\\Asia\\Documents\\infile.txt"));

			while (in.hasNext()) // jezeli to jest prawda
			{
				firstName = in.next();
				lastName = in.next();
				room = in.next();
				rozp = in.next();
				zak = in.next();

				personList.add(new Person(firstName, lastName, room, rozp, zak));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void safeFile() {
		try {
			out = new PrintWriter("C:\\Users\\Asia\\Documents\\infile.txt");

			for (int i = 0; i < personList.size(); i++) {

				out.printf("%s %s %s %s %s%n", // %n na wszystkich systemach windows linux etc

						personList.get(i).getFirstName(), personList.get(i).getLastName(), personList.get(i).getRoom(),
						personList.get(i).getRozp(), personList.get(i).getZak());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}

	@FXML
	protected void addPerson() {

		personList.add(new Person(TextFieldImie.getText(), TextFieldNazwisko.getText(), TextFieldPokoj.getText(),
				TextFieldRozp.getText(), TextFieldZak.getText()));

	}
	
	
	@FXML
	
	public void raportfile() {
		
		try {
			
			raport = new PrintWriter("C:\\Users\\Asia\\Documents\\raportfile.txt");
			
		for (int i = 0; i < personList.size(); i++) {
		

				raport.printf("%s %s %s %s %s%n", // %n na wszystkich systemach windows linux etc
					
						personList.get(i).getFirstName(), personList.get(i).getLastName(), personList.get(i).getRoom(),
						personList.get(i).getRozp(), personList.get(i).getZak());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			if (in != null)
//				in.close();
			if (raport != null)
				raport.close();
		}
	}

}

//field.clear(); //czyszczenie pola
