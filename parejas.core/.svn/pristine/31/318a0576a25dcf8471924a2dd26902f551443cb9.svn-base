package parejas.modelo;

import java.io.Serializable;
import static java.lang.Math.abs;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Persona implements Serializable {
	private static final float DIFF_ALTURA = 0.10f;
	private static final int DIFF_EDAD = 10;
	private static final long serialVersionUID = 1791371811752915349L;
	public static final char HOMBRE = 'H';
	public static final char MUJER = 'M';
	private Long id;
	private String nombre;
	private int edad;
	private float altura;
	private char sexo;

	public Persona() {

	}

	public Persona(Long id, String nombre, int edad, float altura, char sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
//		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
//				+ ", altura=" + altura + ", sexo=" + sexo + "]";
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Persona other = (Persona) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	public boolean esIdeal(Persona usuario) {
		return abs(usuario.getEdad()-this.edad)<DIFF_EDAD
		&& Math.abs(usuario.getAltura()-this.altura)<DIFF_ALTURA;
	}

	public boolean esAfin(Persona usuario) {
		return abs(usuario.getEdad()-this.edad)<DIFF_EDAD
		|| Math.abs(usuario.getAltura()-this.altura)<0.10f;
	}
}
