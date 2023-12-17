package fardev.vergil.core_ui

class OneTimeEffect<out T>(private val content: T) {

    var alreadyHandled: Boolean = false

    fun getContent(): T? {
        return if(alreadyHandled) {
            null
        } else {
            alreadyHandled = true
            content
        }
    }

    fun peekContent(): T = content

}