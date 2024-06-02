interface Observers {

    fun transferenciaRealizada(monto: Double, proyecto: Proyecto) {    }
}

class MandarWpp : Observers{
    lateinit var wpp : SendWpp

    override fun transferenciaRealizada(monto: Double, proyecto: Proyecto) {
        if(monto > 2500) wpp.mandarWpp(proyecto, monto)
    }
}

class MandarMailInvolucrados: Observers{
    lateinit var sendMail: SendMail

    override fun transferenciaRealizada(monto: Double, proyecto: Proyecto) {
        val mail = Mail(proyecto.responsable.nombre, proyecto.responsable.email, proyecto.responsable.nombre, proyecto.responsable.nombre)
        sendMail.sendMail(mail)
    }
}

class Donacion (val sistema: Proceso): Observers{
    var registroDonaciones : MutableMap<Proyecto, Int> = mutableMapOf()

    override fun transferenciaRealizada(monto: Double, proyecto: Proyecto) {
        if(registroDonaciones.containsKey(proyecto)){
            registroDonaciones[proyecto] = registroDonaciones[proyecto]!! + 1
        }
        else{
            registroDonaciones[proyecto] = 1
        }

        if(registroDonaciones[proyecto]!! > 3){
            sistema.proyectos.remove(proyecto)
        }
    }
}


interface SendWpp{

    fun mandarWpp(proyecto: Proyecto, monto: Double)
}
