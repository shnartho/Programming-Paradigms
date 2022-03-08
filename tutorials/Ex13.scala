object Ex13 extends App {

  // Duck typing
  def makeNoise(duck: {def makeNoise(value: String): String}) {
    println (duck.makeNoise("Noise!"))
  }

  object Cat {
    def makeNoise(value: String): String = {
      "Meow"
    }
  }

  makeNoise(Cat)

  // Structural typing
  class Foo {
    def method(input: String): String = input
  }

  class Bar extends Foo {
    override def method(input: String): String = input
  }

  var foo: Foo = new Bar()

  // Sort
  case class Person(firstName : String, lastName : String) extends Ordered[Person] {
    override def compare(that: Person): Int =
      (lastName compare that.lastName) match {
        case 0 =>
          (firstName compare that.firstName) match {
            case res => res
          }
        case res => res
      }
    def getName : String = firstName
  }

  var person1 : Person = Person("Adam", "Johnson")
  var person2 : Person = Person("Michael", "De Santa")
  var person3 : Person = Person("Adam", "Brown")
  var person4 : Person = Person("Trevor", "Philips")

  val personList = List(person1, person2, person3, person4)
  println(personList)
  println(personList.sorted)

  // Word counting
  def wordCounter(text: String) = {
    var tempMap = Map[String, Int]().withDefaultValue(0)
    val textArray = text.split(' ')
    // Create array from text for each word
    textArray.foreach((x : String) => {
      // If word exists in map increment it instead
      if (tempMap.contains(x)) {
        tempMap = tempMap.updatedWith(x)({
          case Some(count) => Some(count + 1)
        })
      } else {
        // Otherwise just add it as is
        tempMap += (x -> 1)
      }
    })
    tempMap
  }

  var randomText = "hello hello there my name is not a real name word word word"
  var countedText = wordCounter(randomText)
  println(countedText)

}