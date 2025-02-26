package Datos;

public class UsuarioAlumno implements UsuarioGettersYSetters{
	
	private String dni;
	private String nombre;
	private String apellido;
	private String nombreDeUsuario;
	private String email;
	private String contrasenia;
	private String tipo;
	
	public UsuarioAlumno() {
		
	}
	
	public UsuarioAlumno(String dni, String nombre, String apellido, String nombreDeUsuario, String email, String contrasenia, String tipo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombreDeUsuario = nombreDeUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
		this.tipo = tipo;
	}
	
	@Override
	public String getDni() {
		return dni;
	}

	@Override
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getApellido() {
		return apellido;
	}

	@Override
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	@Override
	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}
	
	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getContrasenia() {
		return contrasenia;
	}

	@Override
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
