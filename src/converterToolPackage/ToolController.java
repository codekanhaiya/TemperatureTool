package converterToolPackage;

//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class ToolController implements Initializable {

	@FXML
	public Label welcomeLabel;
	public ChoiceBox <String> choiceBox;
	public TextField userInput;
	public Button convertButton;

	private static final String C_TO_F = "Celsius to Fahrenheit";
	private static final String F_TO_C = "Fahrenheit to Celsius";
	private static final String C_TO_R = "Celsius to Reaumur";
	private static final String R_TO_C = "Reaumur to Celsius";
	private static final String F_TO_R = "Fahrenheit to Reaumur";
	private static final String R_TO_F = "Reaumur to Fahrenheit";
	private static final String C_TO_K = "Celsius to Kelvin";
	private static final String K_TO_C = "Kelvin to Celsius";
	private static final String F_TO_K = "Fahrenheit to Kelvin";
	private static final String K_TO_F = "Kelvin to Fahrenheit";
	private static final String R_TO_K = "Reaumur to Kelvin";
	private static final String K_TO_R = "Kelvin to Reaumur";
	private static final String scale = "Choose Scale";

	//private boolean isC_TO_F = true;
	private int flag;
	private String unit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox.getItems().add(scale);
		choiceBox.getItems().add(C_TO_F);
		choiceBox.getItems().add(F_TO_C);
		choiceBox.getItems().add(C_TO_R);
		choiceBox.getItems().add(R_TO_C);
		choiceBox.getItems().add(F_TO_R);
		choiceBox.getItems().add(R_TO_F);
		choiceBox.getItems().add(C_TO_K);
		choiceBox.getItems().add(K_TO_C);
		choiceBox.getItems().add(F_TO_K);
		choiceBox.getItems().add(K_TO_F);
		choiceBox.getItems().add(R_TO_K);
		choiceBox.getItems().add(K_TO_R);

		choiceBox.setValue(scale);




		choiceBox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {

//			if(newValue.equals(C_TO_F)){
//				isC_TO_F = true;
//			} else{
//				isC_TO_F = false;
//			}
			switch (newValue)
			{
				case C_TO_F:        flag=1;                          break;

				case F_TO_C:        flag=2;                          break;

				case C_TO_R:        flag=3;                          break;

				case R_TO_C:        flag=4;                          break;

				case F_TO_R:        flag=5;                          break;

				case R_TO_F:        flag=6;                          break;

				case C_TO_K:        flag=7;                          break;

				case K_TO_C:        flag=8;                          break;

				case F_TO_K:        flag=9;                          break;

				case K_TO_F:        flag=10;                         break;

				case R_TO_K:        flag=11;                         break;

				case K_TO_R:        flag=12;                         break;
			}
		});
		
		convertButton.setOnAction(event -> convert());

	}

	private void warning() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning Message");
		alert.setContentText("Please choose valid scale.");
		alert.show();
	}

	float newTemperature = 0.0f;
	private void convert() {

		String input = userInput.getText();
		String sc = choiceBox.getValue();
		if(sc.equals(scale))
		{ warning(); return;}

		float enteredTemperature = 0.0f;
		try{
			 enteredTemperature = Float.parseFloat(input);
		} catch (Exception exception) {
			warnUser();
			return; // no code executed by this line
		}



//        if(isC_TO_F){
//			newTemperature = (enteredTemperature * 9/5) + 32;
//        } else{
//      	newTemperature = (enteredTemperature - 32) * 5/9;
//        }

		switch (flag)
		{
			case 1:   newTemperature = (enteredTemperature * 9/5) + 32;    unit="F";      break;

			case 2:   newTemperature = (enteredTemperature - 32) * 5/9;    unit="C";      break;

			case 3:   newTemperature = (enteredTemperature *4/5);          unit="R";      break;

			case 4:   newTemperature = (enteredTemperature *5/4);          unit="C";      break;

			case 5:   newTemperature = (enteredTemperature - 32)*4/9;      unit="R";      break;

			case 6:   newTemperature = (enteredTemperature *9/4)+32;       unit="F";      break;

			case 7:   newTemperature = (enteredTemperature +273.15f);      unit="K";      break;

			case 8:   newTemperature = (enteredTemperature - 273.15f);     unit="C";      break;

			case 9:   newTemperature = ((enteredTemperature -32)*5/9)+273.15f;  unit="K"; break;

			case 10:  newTemperature = ((enteredTemperature -273.15f )*9/5)+32; unit="F"; break;

			case 11:  newTemperature = (enteredTemperature *5/4)+273.15f;       unit="K"; break;

			case 12:  newTemperature = (enteredTemperature - 273.15f)*4/5;      unit="R"; break;


		}

		display(newTemperature,unit);
	}

	private void warnUser() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();

	}

	private void display(float newTemp, String un) {

//		String unit = isC_TO_F ? " F" : " C";

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is:  " +newTemp+" °"+un);
		alert.show();
	}

	public void eraseInput()
	{
		userInput.clear();
		choiceBox.setValue(scale);
	}

}
