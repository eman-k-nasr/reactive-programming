package ObserverDesignPattern

data class Customer(val name: String,val bookStore: BookStore) : Observer{
    init {
        bookStore.registerObserver(this)
    }

    override fun update() {
        println("Hello $name , Now the book is ${bookStore.inStock.name}")
    }
}