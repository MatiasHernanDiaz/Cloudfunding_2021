class Proceso(
    val proyectos: MutableList<Proyecto> = mutableListOf(),
    val idea: Idea,
    val manerasDeDistribucionDinero: MutableList<DistribucionDinero>,
    val observersTransferir: MutableList<Observers>
) {
    fun elegirProyecto(): MutableList<Proyecto> = idea.elegirProyecto(proyectos)

    fun hayProyectosParaContinuar(): Boolean = elegirProyecto().size >= 2

    fun validarDineroMinimo(monto: Double) : Boolean = monto > 1000

    fun empezarOperacion(monto: Double, distriDinero: DistribucionDinero, datos : DatosBanco): Unit{
        elegirProyecto().forEach({ proyecto ->
            if(proyecto.banco.transferir(datos) == ""){
                observersTransferir.forEach({ it.transferenciaRealizada(monto, proyecto) })
            }
        })
    }

}