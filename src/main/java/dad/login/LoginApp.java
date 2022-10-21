package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Controller controller = new Controller();
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(new Scene(controller.getView(), 320, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		LoginApp.launch(args);
	}

}
