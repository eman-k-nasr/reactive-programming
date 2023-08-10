package ObserverDesignPattern

data class BookStore(
    val bookName: String,
    val authorName: String,
    var inStock: Availability,
): Subject {
    private val subscribers: ArrayList<Observer> = arrayListOf()

    fun restocked(){
        this.inStock = Availability.IN_STOCK
        notifyObserver()
    }
    override fun registerObserver(observer: Observer) {
        subscribers.add(observer)
    }

    override fun unRegisterObserver(observer: Observer) {
        subscribers.remove(observer)
    }

    override fun notifyObserver() {
        for(observer in subscribers){
            observer.update()
        }
    }
}