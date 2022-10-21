package dad.login;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	private StringProperty textoUsuario = new SimpleStringProperty();
	private StringProperty textoContrasena = new SimpleStringProperty();
	private BooleanProperty ldapBoolean = new SimpleBooleanProperty();
	
	public final StringProperty textoUsuarioProperty() {
		return this.textoUsuario;
	}
	
	public final String getTextoUsuario() {
		return this.textoUsuarioProperty().get();
	}
	
	public final void setTextoUsuario(final String textoUsuario) {
		this.textoUsuarioProperty().set(textoUsuario);
	}
	
	public final StringProperty textoContrasenaProperty() {
		return this.textoContrasena;
	}
	
	public final String getTextoContrasena() {
		return this.textoContrasenaProperty().get();
	}
	
	public final void setTextoContrasena(final String textoContrasena) {
		this.textoContrasenaProperty().set(textoContrasena);
	}
	
	public final BooleanProperty ldapBooleanProperty() {
		return this.ldapBoolean;
	}
	
	public final boolean isLdapBoolean() {
		return this.ldapBooleanProperty().get();
	}
	
	public final void setLdapBoolean(final boolean ldapBoolean) {
		this.ldapBooleanProperty().set(ldapBoolean);
	}
	
}
