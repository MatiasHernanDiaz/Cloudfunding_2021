interface Idea {
    fun elegirProyecto(proyectos: MutableList<Proyecto>): MutableList<Proyecto>
}

class ImpactoSocial() : Idea{
    override fun elegirProyecto(proyectos: MutableList<Proyecto>): MutableList<Proyecto> =
        proyectos.sortedBy { it.impactoSocial() }.take(3).toMutableList()

}

class MontoMasMenos() : Idea{
    override fun elegirProyecto(proyectos: MutableList<Proyecto>): MutableList<Proyecto> {
        val max = proyectos.maxBy { it.montoNecesario }
        val min = proyectos.minBy { it.montoNecesario }
        return mutableListOf(max, min)
    }
}

class Nacionales() : Idea{
    override fun elegirProyecto(proyectos: MutableList<Proyecto>): MutableList<Proyecto> =
        proyectos.filter { it.origen }.toMutableList()

}

class Combinatoria(val listaCombinada: MutableList<Idea>) : Idea{
    override fun elegirProyecto(proyectos: MutableList<Proyecto>): MutableList<Proyecto> {
        return listaCombinada.map({ idea -> idea.elegirProyecto(proyectos)}).flatten().toSet().toMutableList()
    }
}

