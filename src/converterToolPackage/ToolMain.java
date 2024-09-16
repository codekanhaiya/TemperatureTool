package converterToolPackage;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolMain extends Application{

	private ToolController control;

	public static void main(String[] args){
		System.out.println("main"); //It is not the part of JAVAFX Life Cycle.
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init"); //Initialize your application  (It is  the Ist part of JAVAFX Life Cycle)
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {   //Overwritten of this <start()> method is manadotery. due to this <primaryStage.show>

		System.out.println("start"); //start an application (It is  the IInd part of JAVAFX Life Cycle)

          FXMLLoader loader = new FXMLLoader(getClass().getResource("Tool.fxml"));
          VBox rootNode = loader.load(); //"Parent" is super class and "Pane" is a subclass

		  control =  loader.getController();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/icon/Temp.png"));
		primaryStage.show();

	}
	private MenuBar createMenu(){
		// File menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked.");
			control.eraseInput();
		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			System.out.println("Quit Menu Item Clicked.");
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		//Help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		
		aboutApp.setOnAction(event -> aboutApp());
		
		helpMenu.getItems().addAll(aboutApp);

		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;

	}

	private void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome java Games.");
		alertDialog.show();
	}


	@Override
	public void stop() throws Exception {
		System.out.println("stop");  //called when application is stopped and is about to shut down  (It is  the IIIrd part of JAVAFX Life Cycle)
		super.stop();
	}
}
