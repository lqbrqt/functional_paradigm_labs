package lab5

sealed trait Position{}

case class Worker3 (firstName: String, middleName: String, lastName: String){
};

case class Worker2 (firstName: String, middleName: String){
};

object Main extends App
{

  val Petr = new Worker3("Petr");
  val PetrIvanov = new Worker2("Petr","Ivanov");

  System.out.println(PetrIvanov match {
    case Worker3(x,y,z)=> System.out.println(x, y, z);
    case Worker2(x, y) => "Firstname and lastname";
    case _ => "Full name";
  })

}
