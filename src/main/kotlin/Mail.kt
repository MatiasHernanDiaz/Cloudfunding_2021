
data class Mail(val to:String, val from:String, val subject: String, val body: String) {

}

interface SendMail{
    fun sendMail(mail: Mail)
}
