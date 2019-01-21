package application;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.*;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Label label1 = new Label("Zrodlo");
			label1.setLayoutX(0);
			label1.setLayoutY(-20);

			Label label2 = new Label("Wynik operacji");
			label2.setLayoutX(0);
			label2.setLayoutY(80);

			Label label3 = new Label("Operacja:");
			label3.setLayoutX(200);
			label3.setLayoutY(20);

			TextField wpisz = new TextField();
			wpisz.setLayoutX(0);
			wpisz.setLayoutY(0);
			wpisz.getStyleClass().add("my-field");
			wpisz.setPromptText("Wprowadz znaki");

			TextField pokaz = new TextField();
			pokaz.setLayoutX(0);
			pokaz.setLayoutY(100);
			pokaz.getStyleClass().add("my-field");
			pokaz.setPromptText("Pokaze Wynik");

			Button kopiuj = new Button("Kopiuj");
			kopiuj.setLayoutX(0);
			kopiuj.setLayoutY(40);
			kopiuj.setId("button");

			Button licz = new Button("Wykonaj");
			licz.setLayoutX(0);
			licz.setLayoutY(150);
			licz.setId("button");

			RadioButton r1 = new RadioButton("kodowanie");

			r1.setLayoutX(200);
			r1.setLayoutY(40);

			RadioButton r2 = new RadioButton("dekodowanie");
			r2.setLayoutX(200);
			r2.setLayoutY(60);

			ToggleGroup tgroup = new ToggleGroup();
			r1.setToggleGroup(tgroup);
			r2.setToggleGroup(tgroup);

			Group center_group = new Group();
			center_group.getChildren().add(wpisz);
			center_group.getChildren().add(pokaz);
			center_group.getChildren().add(label1);
			center_group.getChildren().add(label2);
			center_group.getChildren().add(label3);
			center_group.getChildren().add(kopiuj);
			center_group.getChildren().add(licz);
			center_group.getChildren().add(r1);
			center_group.getChildren().add(r2);
			root.setCenter(center_group);

			kopiuj.setOnAction(event -> {

				wpisz.setText(pokaz.getText());
				pokaz.clear();

			});

			licz.setOnAction(event -> {

				if (r1.isSelected()) {

					System.out.println("Wybrano kodowanie");

					Obliczenia o = new Obliczenia();

					// trzeba ustawic zmienna i pozniej ustawic ja zeby wyswietlalo w polu textowym

					String wynik = o.encode(wpisz.getText());

					pokaz.setText(wynik);

				} else {

					r2.isSelected();
					System.out.println("Wybrano odkodowanie");

					Obliczenia o = new Obliczenia();

					String wynik2 = o.decode(wpisz.getText());

					pokaz.setText(wynik2);
					System.out.println(wynik2);
				}

			});

			primaryStage.setTitle("Run Length Encoding");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
