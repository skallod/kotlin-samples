package ru.galuzin.kotlinsamples.collections

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all { it.city==city }

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any { it.city == city }

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customers.count{ it.city == city}

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find { it.city == city }

//Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = customers.maxBy { it.orders.size }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? = orders.flatMap { it.products }.maxBy { it.price }

// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortedBy { it.orders.size }

// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double = orders.flatMap { it.products }.sumByDouble { it.price }

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer>
= customers.partition {
    val notD = it.orders.count { !it.isDelivered }
    notD > it.orders.size-notD
}.first.toSet()


fun intersectTest() {
    val intersect = listOf(1, 2, 3, 4).intersect(listOf(1, 2, 3))
    println("intersect = ${intersect}")
}

// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val allProd = customers.flatMap { it.orders }.flatMap { it.products }.toSet()
    return customers.fold(allProd
        , {orderedByAll,customer->
            orderedByAll.intersect(customer.orders.flatMap { it.products })}).toSet()
}

// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? =
    orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }


// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int =
    customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.count()
