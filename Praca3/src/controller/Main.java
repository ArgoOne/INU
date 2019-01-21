package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	private Stage primaryStage; //bedzie przechowywalo informacje o oknie programu
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage; //trzeba zainicjowac to pole
		mainWindow (); //trzeba bedzie wywolac jak powstanie na pozniejszym etapie pracy
		
	}
	
	//funkcja odpowiedzialna za utworzenie okna programu
	public void mainWindow (){
		FXMLLoader loader = new FXMLLoader (
				Main.class.getResource("/view/MainWindowView.fxml") 
				//wskazanie sciezki zrodla, wielkie i male litery w jednym ciagu, zaczynamy od wielkiej litery
				);
		try {
			AnchorPane pane = loader.load(); //wywwolanie, zaladowaie
			
			primaryStage.setMinWidth(700.0); //wartosci szerokosc
			primaryStage.setMinHeight(600.0); //wysokosc
			
			Scene scene = new Scene (pane); //zeby chcialo zadzialac
			MainWindowController mainWindowController = loader.getController();//wywolany przez metode getcontroller
			mainWindowController.setMain(this,primaryStage); //wywolanie skladowej Main-a this
	
			primaryStage.setScene(scene); //ustawienie sceny
			primaryStage.show();//wyswietlenie okna
			
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
