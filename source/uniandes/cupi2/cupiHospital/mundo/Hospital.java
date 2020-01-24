/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiHospital
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiHospital.mundo;

import java.util.ArrayList;

import uniandes.cupi2.cupiHospital.mundo.Paciente.Motivo;
import uniandes.cupi2.cupiHospital.mundo.Unidad.Tipo;

/**
 * Clase que representa el hospital.
 */
public class Hospital {
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Cantidad de unidades del hospital.
	 */
	public final static int NUMERO_UNIDADES = 6;

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------
  
	/**
	 * Arreglo que contiente las unidades del hospital.
	 */
	// TODO Parte3 PuntoA: Declare el atributo unidades como contenedora de tamaño
	// fijo.
     Unidad unidades[]; 
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Construye el hospital con las siguientes unidades en el arreglo: unidades[0]
	 * - nombre: Unidad A, Tipo: Cuidados intensivos. unidades[1] - nombre: Unidad
	 * B, Tipo: Cuidados intermedios. unidades[2] - nombre: Unidad C, Tipo:
	 * Pediatría. unidades[3] - nombre: Unidad D, Tipo: Maternidad. unidades[4] -
	 * nombre: Unidad E, Tipo: Geriatría. unidades[5] - nombre: Unidad F, Tipo:
	 * Observación.
	 */
    
   
	public Hospital() {
		unidades= new Unidad[NUMERO_UNIDADES]; 
		Tipo t;
		
		unidades[0]= new Unidad("Unidad A",Tipo.CUIDADOS_INTENSIVOS );
		unidades[1]= new Unidad("Unidad B",Tipo.CUIDADOS_INTERMEDIOS);
		unidades[2]=new Unidad("Unidad C",Tipo.PEDIATRIA);
		unidades[3]=new Unidad("Unidad D",Tipo.MATERNIDAD);
		unidades[4]=new Unidad("Unidad E",Tipo.GERIATRIA);
		unidades[5]=new Unidad("Unidad F",Tipo.OBSERVACION);
		
		
		
		// TODO Parte3 PuntoB: Inicialice el atributo unidades con tamaño
		// NUMERO_UNIDADES e inicialice cada una da las unidades.
	
	}

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Devuelve el arreglo con las unidades del hospital.
	 * 
	 * @return El arreglo de unidades.
	 */
	public Unidad[] darUnidades() {
		
		return unidades;
		// TODO Parte3 PuntoC: Complete el método según la documentación dada.
	}

	/**
	 * Interna un nuevo paciente al hospital con los parámetros dados. No se permite
	 * internar un paciente si: - existe un paciente con el mismo número de
	 * identificación. - se desea internarlo en pediatría y tiene mas de 15 años
	 * (Unidad.EDAD_MAX_PEDIATRIA). - se desea internarlo en geriatría y tiene menos
	 * de 60 años (Unidad.EDAD_MIN_GERIATRIA).
	 * 
	 * @param pNombreUnidad         Nombre de la unidad a la que se ingresa el
	 *                              paciente.
	 * @param pNombrePaciente       Nombre del paciente. pNombrePaciente != null &&
	 *                              pNombrePaciente != "".
	 * @param pApellido             Apellido del paciente. pApellido != null
	 *                              &&pApellido != "".
	 * @param pNumeroIdentificacion ID del paciente. pNumeroidentificacion > 0.
	 * @param pEdad                 Edad del paciente. pEdad >= 0.
	 * @param pDiagnostico          Diagnóstico del paciente. pDiagnostico != null
	 *                              && pDiagnostico != "".
	 * @param pDiasHospitalizacion  Días de hospitalización del paciente.
	 *                              pDiasHospitalizacion >= 0.
	 * @param pMotivoIngreso        Motivo de ingreso del paciente en el hospital.
	 * @return true si logra ingresar el paciente, false en caso contrario.
	 */
	public boolean internarNuevoPaciente(String pNombreUnidad, String pNombrePaciente, String pApellido,
			int pNumeroIdentificacion, int pEdad, String pDiagnostico, int pDiasHospitalizacion,
			Motivo pMotivoIngreso) {
		
	if(buscarPaciente(pNumeroIdentificacion)==null) 
		return Boolean.FALSE;
	
		
	 if(pNombreUnidad.equalsIgnoreCase(unidades[2].darNombre()) && pEdad>Unidad.EDAD_MAX_PEDIATRIA) 
		 return Boolean.FALSE;
	 
	 
	 if(pNombreUnidad.equalsIgnoreCase(unidades[4].darNombre()) && pEdad<Unidad.EDAD_MIN_GERIATRIA) 
		 return Boolean.FALSE;
	
		Unidad u = buscarUnidad(pNombreUnidad); 
		if(u!=null) {
			u.agregarPaciente(pNombrePaciente, pApellido, pNumeroIdentificacion, pEdad, pDiagnostico, pDiasHospitalizacion, pMotivoIngreso);
		return Boolean.TRUE;
		}
		return Boolean.FALSE;
		
		

		
		// TODO Parte3 PuntoD: Complete el método según la documentación dada.
	}

	/**
	 * Devuelve un paciente dado su ID.
	 * 
	 * @param pNumeroIdentificacion ID del paciente. pNumeroIdentificacion > 0.
	 * @return El paciente que tiene el ID dado por parámetro, null en caso de no
	 *         encontrarlo.
	 */
	public Paciente buscarPaciente(int pNumeroIdentificacion) {
		
		for(Unidad unidad:unidades) {
			Paciente p= unidad.buscarPaciente(pNumeroIdentificacion); 
			
			if(p!=null)
				return p; 				
			}
		return null;
		}
	
		
	
	
	

	/**
	 * Determina si el paciente, dado su ID por parámetro, es dado de alta.
	 * 
	 * @param pNumeroIdentificacion ID del paciente.
	 * @return True si el paciente es dado de alta, false en caso de no encontrarlo.
	 */
	public boolean darDeAltaPaciente(int pNumeroIdentificacion) {
		
		for(Unidad unidad:unidades) {
			if(unidad.buscarPaciente(pNumeroIdentificacion)!=null) {
				unidad.darDeAltaPaciente(pNumeroIdentificacion);
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
		// TODO Parte3 PuntoF: Complete el método según la documentación dada.
	}

	/**
	 * Cambia de unidad a un paciente dado su ID por parámetro, si se cumplen las
	 * siguiente condiciones. - Si la unidad destino es de tipo PEDIATRIA y el
	 * paciente no supera la edad máxima. - Si la unidad destino es de tipo
	 * GERIATRIA y el paciente no está por debajo de la edad mínima. - Si la unidad
	 * de destino no es la misma en la que se encuentra actualmente el paciente.
	 * post:<br>
	 * Se retira de la unidad original solo si es posible reasignarlo en la unidad
	 * destino.
	 * 
	 * @param pNumeroIdentificacion ID del paciente.
	 * @param pNuevaUnidad          Unidad a la que será trasferido el paciente.
	 * @return True si pudo reubicar el paciente, false en caso contrario.
	 */
	public boolean reubicarPaciente(int pNumeroIdentificacion, String pNuevaUnidad) {

		Paciente paciente = buscarPaciente(pNumeroIdentificacion);

		if (paciente == null)
			return Boolean.TRUE;

		else {
			Unidad unidadPaciente = buscarUnidadPaciente(pNumeroIdentificacion);

			if (unidadPaciente == null)
				return Boolean.FALSE;
			else {

				if (unidadPaciente.darNombre().equalsIgnoreCase(pNuevaUnidad))
					return Boolean.FALSE;
				else {

					if (internarNuevoPaciente(pNuevaUnidad, paciente.darNombre(), paciente.darApellido(),
							paciente.darNumeroIdentificacion(), paciente.darEdad(), paciente.darDiagnostico(),
							paciente.darDiasHospitalizacion(), paciente.darMotivoIngreso())) {
						
						unidadPaciente.darDeAltaPaciente(pNumeroIdentificacion);
						return Boolean.TRUE;
					}

				}

			}
		}
		return Boolean.FALSE;
	

	}

	/**
	 * Busca la unidad a la que pertenece un paciente.
	 * 
	 * @param pNumeroIdentificacion ID del paciente.
	 * @return La unidad a la que pertenece el paciente, null en caso de no
	 *         encontrar el paciente.
	 */
	public Unidad buscarUnidadPaciente(int pNumeroIdentificacion) {
		
		for(Unidad unidad:unidades) {
			if(unidad.buscarPaciente(pNumeroIdentificacion)!=null) {
				return unidad;
				
			}
		}
		return null;
	 
		
		
		}
	

	/**
	 * Busca una unidad dado su nombre.
	 * 
	 * @param pNombreUnidad Nombre de la unidad.
	 * @return La unidad cuyo nombre es dado por parámetro, null en caso de no
	 *         encontrarla.
	 */
	public Unidad buscarUnidad(String pNombreUnidad) {
		
		for(Unidad unidad:unidades) {
			if(unidad.darNombre().equalsIgnoreCase(pNombreUnidad)) {
				return unidad;
			}
		}
		return null;
		
		// TODO Parte3 PuntoI: Complete el método según la documentación dada.
	}

	/**
	 * Calcula la cantidad total de pacientes en el hospital.
	 * 
	 * @return Cantidad total de pacientes en el hospital.
	 */
	public int darCantidadTotalPacientes() {
		int paciente =0;
		for(Unidad unidad:unidades) {
			paciente +=unidad.darPacientes().size();
		}
		
		return paciente;
		// TODO Parte3 PuntoJ: Complete el método según la documentación dada.
	}

	/**
	 * Retorna el paciente de mayor edad en el hospital. Si hay dos o más pacientes
	 * con la edad máxima, retorna cualquiera de los dos.
	 * @param max 
	 * 
	 * @return Paciente de mayor edad, null si no hay pacientes en el hospital.
	 */
	public Paciente darPacienteMayorEdad() {
		
		Paciente p = new Paciente(null, null, 0, 0, null, 0, null);
		
		for(Unidad unidad:unidades) {
			for(Paciente paciente:unidad.darPacientes()) {
				if(paciente.darEdad()>= p.darEdad()) {
					p=paciente;
				}
				
			}
		}
		if(p.darEdad()!=0) {
			return p;
		}else
			return null;

		/*ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Paciente max = new Paciente(null, null, 0, 0, null, 0, null);

		for (Unidad unidad : unidades) {

			for (Paciente pac : unidad.darPacientes()) {
				pacientes.add(pac);

			}
		}

		for (Paciente pac : pacientes) {

			if (pac.darEdad() >= max.darEdad()) {
				max = pac;
			}
		}
		
		
		if (max.darEdad() != 0)
			return max;
		return null;
		
		*/

	}
		
	
	
		

		
      

		

	   

	/**
	 * Asigna el encargado con los valores dados por parámetro a la unidad dada por
	 * parámetro, si la unidad ya tenía encargado no lo asigna.
	 * 
	 * @param pNombre           Nombre del encargado. pNombre != null && pNombre !=
	 *                          "".
	 * @param pAniosExperiencia Años de experiencia del encargado. pAniosExperiencia
	 *                          > 0.
	 * @param pUnidad           Nombre de la unidad para asignar enccargado. pUnidad
	 *                          != null && pUnidad != "".
	 * @return True si el encargado se pudo asignar, false si la unidad ya tenía
	 *         encargado o si no existe una unidad con el nombre dado.
	 */
	public boolean asignarEncargado(String pNombre, int pAniosExperiencia, String pUnidad) {

		if (buscarUnidad(pUnidad) != null) {
			for (Unidad unidad : unidades) {
				if (unidad.darNombre().equalsIgnoreCase(pUnidad)) {
					if (unidad.asignarEncargado(pNombre, pAniosExperiencia)) {
						return Boolean.TRUE;
					}

				}

			}
		} else
			return Boolean.FALSE;
		return Boolean.FALSE;
	}

	// -----------------------------------------------------------------
	// Puntos de Extensión
	// -----------------------------------------------------------------

	/**
	 * Método para la extensión 1.
	 * 
	 * @return Respuesta1.
	 */
	public String metodo1() {
		return "Respuesta 1.";
	}

	/**
	 * Método para la extensión 2.
	 * 
	 * @return Respuesta2.
	 */
	public String metodo2() {
		return "Respuesta 2.";
	}

}