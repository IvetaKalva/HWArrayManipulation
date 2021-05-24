import scala.collection.mutable.ArrayBuffer

object CrushTest extends App {

  val startTime = System.nanoTime

  val crush = Utilities.getLinesFromFile("src/resources/crush4.txt")
  val arraySize = crush.slice(0,1).mkString.split(" ")(0).toInt
  val numberOfOperations = crush.slice(0,1).mkString.split(" ")(1).toInt
  //println(arraySize)
  //println(numberOfOperations)

  var myArray = ArrayBuffer.fill[Int](arraySize)(0)
  //println(myArray)

  for (cycleVariable <- 1 to numberOfOperations) {
    val queries = crush.slice(cycleVariable,cycleVariable + 1).mkString.split(" ")
    val start = queries(0).toInt
    val end = queries(1).toInt
    val value = queries(2).toInt
    myArray(start - 1) += value
    if (end < arraySize) myArray(end) -= value
  }
  //println(myArray)

  var max:Long = 0 //(Long: -9223372036854775808 to 9223372036854775807) (Int:  -2147483648 to 2147483647)
  var current:Long = 0
  myArray.foreach (operation => {
    current += operation
    if(operation > 0)
      if (max < current) max = current
  })
  println(s"The maximum value in the array is $max.")

  val endTime = System.nanoTime
  val elapsedSeconds = (endTime - startTime) / 1e9d
  println(s"Time: $elapsedSeconds")
}
