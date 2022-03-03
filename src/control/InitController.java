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
public class InitController {
	private static String password="999999";
	@FXML
    private PasswordField digit1PT;

    @FXML
    private PasswordField digit2PT;

    @FXML
    private PasswordField digit3PT;

    @FXML
    private PasswordField digit4PT;

    @FXML
    private PasswordField digit5PT;

    @FXML
    private PasswordField digit6PT;

    @FXML
    void clickEnter(ActionEvent event) {
    	boolean flag=false;
        char one = digit1PT.getText().charAt(0);
        char two = digit2PT.getText().charAt(0);
        char three = digit3PT.getText().charAt(0);
        char four = digit4PT.getText().charAt(0);
        char five = digit5PT.getText().charAt(0);
        char six = digit6PT.getText().charAt(0);
        if(one!=password.charAt(0)) {
        	flag=true;
        }
        if(two!=password.charAt(1)) {
        	flag=true;
        }
        if(three!=password.charAt(2)) {
        	flag=true;
        }
        if(four!=password.charAt(3)) {
        	flag=true;
        }
        if(five!=password.charAt(4)) {
        	flag=true;
        }
        if(six!=password.charAt(5)) {
        	flag=true;
        }
        if(flag==false) {
        	try {
        	initSafeBox();
        	Node source = (Node) event.getSource();     
    		Stage old = (Stage) source.getScene().getWindow();    
    		old.close(); 
        	}catch(Exception ex) {
        		ex.printStackTrace();
        	}
        }else {
        	Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("THE PASSWORD ISN'T CORRECT");
            alert.showAndWait();
            digit1PT.setText("");
            digit2PT.setText("");
            digit3PT.setText("");
            digit4PT.setText("");
            digit5PT.setText("");
            digit6PT.setText("");
        }
    }
    public void initSafeBox()throws Exception {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SafeBoxWindow.fxml"));		
		loader.setController(new SafeBoxController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show(); 
    }
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		InitController.password = password;
	}
    

}
