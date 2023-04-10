package ejercicio2;


public class Alumno<T> {

		private String dni;
		private String nombre;
		
		public Alumno (String dni,String nombre){
				
			setDni(dni);
			setNombre(nombre);
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dni == null) ? 0 : dni.hashCode());
			return result;
		}

		@Override
		public String toString() {
			return "Alumno con dni: " + dni + " y nombre: " + nombre ;
		}

		@Override
		public boolean equals(Object obj) {
			
			
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Alumno<T> other = (Alumno<T>) obj;
			if (dni == null) {
				if (other.dni != null)
					return false;
			} else if (!dni.equals(other.dni))
				return false;
			return true;
		}
	
}
