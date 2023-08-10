package ObserverDesignPattern

interface Subject {
    fun registerObserver(observer: Observer)
    fun unRegisterObserver(observer: Observer)
    fun notifyObserver()
}