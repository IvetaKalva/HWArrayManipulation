import scala.collection.mutable.ArrayBuffer

//https://www.hackerrank.com/challenges/crush/problem
object ArrayManipulation extends App {
  val arraySize = 10
  val queries = List((1,5,3), (4,8,7), (6,9,1))
  var myArray = ArrayBuffer.fill[Int](arraySize)(0)
  //println(myArray)

  queries.foreach (query => {
    val start:Int = query._1
    val end:Int = query._2
    val value:Int = query._3
    myArray(start-1) += value
    if(end < arraySize) myArray(end) -= value
  })
  //println(myArray)

  var max:Long = 0
  var current:Long = 0
  myArray.foreach (operation => {
    current += operation
    if(operation > 0)
      if (max < current) max = current
  })
  println(s"The maximum value in the array is $max.")
}
