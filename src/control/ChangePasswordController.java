package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import main.Main;
public class ChangePasswordController {

	@FXML
    private PasswordField d1PF;

    @FXML
    private PasswordField d2PF;

    @FXML
    private PasswordField d3PF;

    @FXML
    private PasswordField d4PF;

    @FXML
    private PasswordField d5PF;

    @FXML
    private PasswordField d6PF;

    @FXML
    private PasswordField v1PF;

    @FXML
    private PasswordField v2PF;

    @FXML
    private PasswordField v3PF;

    @FXML
    private PasswordField v4PF;

    @FXML
    private PasswordField v5PF;

    @FXML
    private PasswordField v6PF;

    @FXML
    void changePassword(ActionEvent event) {

    	String passActual = InitController.getPassword();
    	boolean flag=false;
        char one = d1PF.getText().charAt(0);
        char two = d2PF.getText().charAt(0);
        char three = d3PF.getText().charAt(0);
        char four = d4PF.getText().charAt(0);
        char five = d5PF.getText().charAt(0);
        char six = d6PF.getText().charAt(0);
        if(one!=passActual.charAt(0)) {
        	flag=true;
        }
        if(two!=passActual.charAt(1)) {
        	flag=true;
        }
        if(three!=passActual.charAt(2)) {
        	flag=true;
        }
        if(four!=passActual.charAt(3)) {
        	flag=true;
        }
        if(five!=passActual.charAt(4)) {
        	flag=true;
        }
        if(six!=passActual.charAt(5)) {
        	flag=true;
        }
        if(flag==false) {
      String newPassword= v1PF.getText()+v2PF.getText()+v3PF.getText()+v4PF.getText()+v5PF.getText()+v6PF.getText();
      InitController.setPassword(newPassword);
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(null);
      alert.setTitle("PASSWORD INFORMATION");
      alert.setContentText("The Password has been changed");
      alert.showAndWait();
        }else {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("THE CURRENT PASSWORD ISN'T CORRECT");
            alert.showAndWait();
            d1PF.setText("");
            d2PF.setText("");
            d3PF.setText("");
            d4PF.setText("");
            d5PF.setText("");
            d6PF.setText("");
            v1PF.setText("");
            v2PF.setText("");
            v3PF.setText("");
            v4PF.setText("");
            v5PF.setText("");
            v6PF.setText("");
        }
    }

    @FXML
    void closeBox(ActionEvent event) {
    	try {
    		initScreen();
    		Node source = (Node) event.getSource();     
    		Stage old = (Stage) source.getScene().getWindow();    
    		old.close(); 
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    public void initScreen()throws Exception {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/InitWindow.fxml"));		
		loader.setController(new InitController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show(); 
    }
}
