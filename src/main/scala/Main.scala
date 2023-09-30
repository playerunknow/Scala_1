object Main
{
  def main(args: Array[String]): Unit =
  {
    val list = List(4, -8, 1, 9, 10, 3, -6, 18, 2, -5)

    println("Max: " + list.max)
    println("Min: " + list.min)
    println("Filter: " + list.filter(_ > 0))
    println("FindElement: " + list.find(_ == 9))
    println("Exist: " + list.exists(_ / 4 == 1))
    println("IsEmpty: " + list.isEmpty)
    println("HeadOfList: " + list.head)
    println("TailOfList: " + list.tail)
    println("FindAverage: " + list.sum.toDouble / list.length)
    println("FindProduct: " + list.product)
    println("OutputList: " + list)
    println("Enter element which you want to find in list: " )

    val userInput = scala.io.StdIn.readInt()
    val result = findElement(list, userInput)
    println("result:" + result)

    //Task2

    case class Address(city: String, region: String)

    case class Human(name: String, age: Int, address: Address)
    {
      def isAdult: Boolean = age >= 18
      def greet: String = s"Hello, my name is $name."
    }

    val namePeople = Human("Mykhail", 19, Address("Kherson", "Kherson Region"))
    println(s"Name: ${namePeople.name}\nAge: ${namePeople.age}\nAddress: ${namePeople.address.city}, ${namePeople.address.region}")
    namePeople.isAdult

    //task 3

    class ListHuman {
      var humans: List[Human] = List()

      def addHuman(name: String, age: Int, address: String): Unit = {
        val newAddress = Address(address, "") // Create an Address object with the provided address string
        val newHuman = Human(name, age, newAddress) // Pass the Address object to the Human constructor
        humans = humans :+ newHuman
      }

      def deleteHuman(name: String): Unit = {
        humans = humans.filterNot(_.name == name)
      }

      def findByName(name: String): Option[Human] = {
        humans.find(_.name == name)
      }

      def filterByAge(minAge: Int): List[Human] = {
        humans.filter(_.age >= minAge)
      }

      def printHumans(): Unit = {
        humans.foreach(human => println(s"Name: ${human.name}, Age: ${human.age}, Address: ${human.address}"))
      }
    }

    val humanList = new ListHuman()
    humanList.addHuman("John", 25, "123 Main St")
    humanList.addHuman("Alice", 30, "456 Elm St")
    humanList.addHuman("Bob", 22, "789 Oak St")

    println("Initial List:")
    humanList.printHumans()

    humanList.deleteHuman("Alice")
    println("\nList after deleting Alice:")
    humanList.printHumans()

    val foundHuman = humanList.findByName("John")
    println("\nFound Human:")
    foundHuman.foreach(human => println(s"Name: ${human.name}, Age: ${human.age}, Address: ${human.address}"))

    val filteredHumans = humanList.filterByAge(25)
    println("\nFiltered List (age >= 25):")
    filteredHumans.foreach(human => println(s"Name: ${human.name}, Age: ${human.age}, Address: ${human.address}"))
  }

  def findElement(list: List[Int], target: Int): Option[Int] =
  {
    list.find(_ == target)
  }
}

