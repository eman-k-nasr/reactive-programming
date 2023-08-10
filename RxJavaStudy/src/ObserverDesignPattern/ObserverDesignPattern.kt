package ObserverDesignPattern

fun main(){
    val bookStore = BookStore(authorName = "hamada",bookName = "lalaland",inStock = Availability.SOLD_OUT)
    val customer1 = Customer(name = "customer1",bookStore)
    val customer2 = Customer(name = "customer2",bookStore)
    val customer3 = Customer(name = "customer3",bookStore)
    println(bookStore.inStock.name)
    bookStore.restocked()
}