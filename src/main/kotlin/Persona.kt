data class Persona(val nombre: String, val apellido: String,val email: String) {
    fun dobleApellido(): Boolean = apellido.split(" ").size == 2
}
