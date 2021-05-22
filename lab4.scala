package lab4

import java.util
import scala.collection.mutable.ListBuffer

object Main extends App{


  System.out.printf("Enter x: ");
  val x = scala.io.StdIn.readInt();

  val y = x match {
    case x if(x>=0 && x < 1) => 2 - 2 * x;
    case x if(x>=1 && x < 2) => 0;
    case x if(x>=2 && x <= 3) => x - 2;
  }

  System.out.println(y);

  System.out.printf("Enter w: ");
  var w = scala.io.StdIn.readInt();

  w = w match {
    case 0 => 1;
    case w if(Math.pow(Math.tan(w), -1) < 0.5) => -w;
  }

  System.out.println(w);

  var intlist = new ListBuffer[Int]();

  def input(v : Any): Unit ={
    v match {
      case x : Int => intlist.append(x);
      case _ => System.out.println("It's not a int!");
    }
  }

  input(10)
  input("ASFAWF")
  input(new ListBuffer[String]())
  input(24)

  System.out.println(intlist)

}


