package Proyecto1;
import javax.swing.JOptionPane;

public class ModeloLogin {
    public static boolean iniciarSesion(String nickname, String contrasena) {
        boolean usuarioEncontrado = false;
        boolean exitoso = false;
        for (ModeloRegistro registro : ModeloRegistro.getListaClientes()) {
            if (registro.getNickname().equals(nickname) && registro.getContrasena().equals(contrasena)) {
                JOptionPane.showMessageDialog(null, "Bienvenido de nuevo: " + registro.getNombre());
                if (registro.getAdministrador(registro) == true) {
					MenuAdministrador windowAdmin = new MenuAdministrador();
					windowAdmin.abrirVista();
				}else if (registro.getAdministrador(registro) == false) {
					MenuUsuario windowUsusario = new MenuUsuario();
	                windowUsusario.abrirVista();

				}
                usuarioEncontrado = true;
                exitoso = true;
                break;
            }
        }
        // En caso de no encontrar al usuario
        if (!usuarioEncontrado) {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            exitoso = false;
        }
		return exitoso;
    }
}
