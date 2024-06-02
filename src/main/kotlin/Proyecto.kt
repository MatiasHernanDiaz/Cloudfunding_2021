import java.time.LocalDate

abstract class Proyecto(
    val nombre: String,
    val descripcion: String,
    val responsable: Persona,
    val origen: Boolean,
    var montoNecesario: Double,
    )
{
    lateinit var banco: Banco

    fun impactoSocial(): Double = montoNecesario + 0.1 + montoEspecifico()

    abstract fun montoEspecifico(): Double
}

class ProyectoSocial(
    val fechaInicia: LocalDate,
    nombre: String,
    descripcion: String,
    responsable: Persona,
    origen: Boolean,
    montoNecesario: Double
) : Proyecto(nombre, descripcion, responsable, origen, montoNecesario,
) {
    override fun montoEspecifico(): Double = LocalDate.now().year - fechaInicia.year * 100.00 - 1
}

class ProyectoCooperativas(
    val socios: MutableList<Persona> = mutableListOf<Persona>(),
    nombre: String,
    descripcion: String,
    responsable: Persona,
    origen: Boolean,
    montoNecesario: Double
) :
    Proyecto(nombre, descripcion, responsable, origen, montoNecesario,) {

    override fun montoEspecifico(): Double =
        if(cantidadSociosDobleApellido() != 0 ) cantidadSociosDobleApellido() * 45.00
        else 30.00

    private fun cantidadSociosDobleApellido() : Int = socios.filter{ it.dobleApellido() }.size
}

class ProyectoEcologico(
    val metrosCuadrados: Int,
    nombre: String,
    descripcion: String,
    responsable: Persona,
    origen: Boolean,
    montoNecesario: Double) :
    Proyecto(nombre, descripcion, responsable, origen, montoNecesario,) {

    override fun montoEspecifico(): Double = metrosCuadrados * 10.00
}