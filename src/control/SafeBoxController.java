package control;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import main.Main;
public class SafeBoxController implements Initializable{

	private static String containBox="My Bank password is \n 1234 \n\n My Netflix password is \n Netflix 123";
	
	@FXML
    private TextArea containBoxTA;

    @FXML
    void changePassword(ActionEvent event) {
    	containBox = containBoxTA.getText();
      try {
		changePassScreen();
		Node source = (Node) event.getSource();     
		Stage old = (Stage) source.getScene().getWindow();    
		old.close(); 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    @FXML
    void closeBox(ActionEvent event) {
     containBox = containBoxTA.getText();
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
    public SafeBoxController() {
    	
    }
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		containBoxTA.setText(containBox);
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
    public void changePassScreen()throws Exception {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ChangePasswordWindow.fxml"));		
		loader.setController(new ChangePasswordController());
		Parent parent = (Parent) loader.load();
		
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
		stage.show(); 
    }
    

}
