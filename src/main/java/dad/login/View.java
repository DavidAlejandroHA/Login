package dad.login;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class View extends GridPane {
	private Label usuarioLabel, contrasenaLabel;
	private TextField usuarioText;
	private PasswordField contrasenaText;
	private CheckBox usarLDAP;
	private Button accederButton, cancelarButton;
	
	public View() {
		super();
		
		usuarioLabel = new Label("Usuario:");
		
		contrasenaLabel = new Label("Contraseña:");
		
		usuarioText = new TextField();
		
		contrasenaText = new PasswordField();
		
		usarLDAP = new CheckBox("Usar LDAP");
		
		accederButton = new Button("Acceder");
		
		cancelarButton = new Button("Cancelar");
		accederButton.setDefaultButton(true);
		
		this.setHgap(5);
		this.setVgap(10);
		this.setPadding(new Insets(5, 40, 5, 40));
		
		HBox botones = new HBox();
		botones.setSpacing(5);
		botones.setAlignment(Pos.CENTER);
		botones.getChildren().addAll(accederButton, cancelarButton);
		
		this.addRow(0, usuarioLabel, usuarioText);
		this.addRow(1, contrasenaLabel, contrasenaText);
		this.addRow(2, usarLDAP);
		this.addRow(3, botones);
		this.setAlignment(Pos.CENTER); // alinea todo en el centro
		//this.setGridLinesVisible(true);
		
		ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
		};
		this.getColumnConstraints().setAll(cols);
		
		GridPane.setColumnSpan(botones, 2);
		cols[0].setHalignment(HPos.LEFT);
		cols[1].setHgrow(Priority.ALWAYS);
		
		GridPane.setColumnSpan(usarLDAP, 2);
		GridPane.setHalignment(usarLDAP, HPos.CENTER); /* esto es para que el elemento usarLDAP individualmente tenga otra posición respecto a los otros
		 														elementos de la columna*/
	}

	public Label getUsuarioLabel() {
		return usuarioLabel;
	}

	public Label getContrasenaLabel() {
		return contrasenaLabel;
	}

	public TextField getUsuarioText() {
		return usuarioText;
	}

	public PasswordField getContrasenaText() {
		return contrasenaText;
	}

	public CheckBox getUsarLDAP() {
		return usarLDAP;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}
}
