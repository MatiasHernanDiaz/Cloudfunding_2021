interface Banco {
    fun transferir(datos : DatosBanco) : String{
        return ""
    }

}

data class DatosBanco(val cuentaDestinoId: String,
                      val cuentaOrigenId: String,
                      val montoDecimales: Int,
                      val montoEntero: Int,
                      val deposito24hs: Boolean,
                      val depositoInmediato: Boolean){}