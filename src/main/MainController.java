package main;

import com.mahdi_abdurrahman.model.Calculator;
import com.mahdi_abdurrahman.model.Validator;
import com.mahdi_abdurrahman.model.ValidatorHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import java.text.NumberFormat;

public class MainController {
    @FXML private TextField milesField;
    @FXML private TextField gallonsField;
    @FXML private TextField mpgField;
    @FXML private Button calculateButton;

    /**
     * calculateButtonAction Method - validates the input and calculates the miles per gallon
     * @return void
     */
    @FXML
    private void calculateButtonAction() {
        Window window = calculateButton.getScene().getWindow();
        Validator validation = new Validator();
        String errorMsg = "";
        errorMsg += validation.isDouble(milesField.getText(), "In the miles field there");
        errorMsg += validation.isDouble(gallonsField.getText(), "In the gallons field there");

        if (errorMsg.isEmpty()) {
            double miles = Double.parseDouble(milesField.getText());
            double gallons = Double.parseDouble(gallonsField.getText());

            double milesPerGallon = Calculator.calculateMilesPerGallon(miles, gallons);

            NumberFormat mileFormat = NumberFormat.getNumberInstance();
            mpgField.setText(mileFormat.format(milesPerGallon));

        } else {
            ValidatorHelper.showAlertHelper(Alert.AlertType.ERROR, window, " Invalid Data", errorMsg);

        }
    }//end of the calculateButtonClicked Method

    /**
     * resetButtonAction Method - resets the milesField, gallonsField, and mpgField
     * @return void
     */
    @FXML
    private void resetButtonAction() {
        milesField.clear();
        gallonsField.clear();
        mpgField.clear();

    }//end of the resetButtonClicked Method
}//end of the MainController Class
