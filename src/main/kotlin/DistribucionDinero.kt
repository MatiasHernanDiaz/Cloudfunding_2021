interface DistribucionDinero {
    fun distribuirDinero(monto : Double, proyectos: MutableList<Proyecto>) : Unit
}

class PartesIguales : DistribucionDinero{

    override fun distribuirDinero(monto: Double, proyectos: MutableList<Proyecto>): Unit {
        val cantidad = proyectos.size.toDouble()
        proyectos.forEach({ it.montoNecesario = (monto / cantidad)})
    }

}

class CincuentaYResto: DistribucionDinero{
    override fun distribuirDinero(monto: Double, proyectos: MutableList<Proyecto>) {
        val cantidad = monto / 2
        val resto = (monto/2) / (proyectos.size - 1)
        proyectos.first().montoNecesario = cantidad
        proyectos.filter { it != proyectos.first() }.forEach({ it.montoNecesario = resto})
    }
}

class Alazar: DistribucionDinero{
    override fun distribuirDinero(monto: Double, proyectos: MutableList<Proyecto>) {
        val segundoAzar = monto - 500
        proyectos.random().montoNecesario = 500.00
        proyectos.random().montoNecesario = segundoAzar
    }
}

