package lab6

import scala.collection.mutable.ListBuffer

object Main extends App{
  var generated = new ListBuffer[Int]();

  var listToWrite = new ListBuffer[Int];

  def generateNewDigit(start: Int, end: Int)(): Int ={


    val allDigitsUpToTen = (start to end).toSet

    if (allDigitsUpToTen.subsetOf(listToWrite.toSet)) {
      listToWrite += 0
      0
    } else {

      val rand = new scala.util.Random();
      var value = 0;
      do {
        value = rand.between(start, end+1);
      } while (listToWrite.contains(value))
       listToWrite += value
      value
    }
  }

  val generate = generateNewDigit(1, 5) _;


  for(i <- 1 until(100)){
    System.out.println(generate());
  }

}
