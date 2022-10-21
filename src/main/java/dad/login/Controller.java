package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Controller {
	
	private View view = new View();
	private Model model = new Model();
	
	public Controller() throws Exception {
		
		view.getUsuarioText().textProperty().bindBidirectional(model.textoUsuarioProperty());
		view.getContrasenaText().textProperty().bindBidirectional(model.textoContrasenaProperty());;
		view.getUsarLDAP().selectedProperty().bindBidirectional(model.ldapBooleanProperty());
		
		view.getAccederButton().setOnAction(this::onAccederAction);
		view.getCancelarButton().setOnAction(this::onCancelarAction);
	}

	public View getView() {
		return view;
	}
	
	public Model getModel() {
		return model;
	}
	
	private void onAccederAction(ActionEvent e) {
		
		AuthService log = model.isLdapBoolean() ? new LdapAuthService() : new FileAuthService();
		
		try {
			if(log.login(model.getTextoUsuario(), model.getTextoContrasena())) {
				
				Alert alertaBoxSucces = new Alert(AlertType.INFORMATION);
				alertaBoxSucces.setTitle("Inicio de sesión");
				alertaBoxSucces.setHeaderText("Acceso permitido");
				alertaBoxSucces.setContentText("Se ha iniciado sesión exitosamente como \"" + model.getTextoUsuario() + "\".");
				alertaBoxSucces.showAndWait();
				//cerrar ventana principal
				onCancelarAction(e);
			} else {
				Alert alertaBoxFail = new Alert(AlertType.ERROR);
				alertaBoxFail.setTitle("Inicio de sesión");
				alertaBoxFail.setHeaderText("Acceso fallido");
				alertaBoxFail.setContentText("La contraseña es incorrecta o el usuario \"" + model.getTextoUsuario() +
						"\" no existe en el servidor " + new String(model.isLdapBoolean() ? "LDAP." : "local."));
				alertaBoxFail.showAndWait();
				view.getContrasenaText().setText("");
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private void onCancelarAction(ActionEvent e) {
		Stage AppWindow = (Stage) view.getCancelarButton().getScene().getWindow();
		AppWindow.close();
	}
}
