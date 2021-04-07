import java.lang.IndexOutOfBoundsException

class Paper(val __density: Double){
  def getDensity: Double = {
    __density
  }

  def sayClassName: Unit = {
    println(__className)
  }

  protected val __className = "Paper";
}

class Literature(private val __size: Int, val name: String, private val __materialDensity: Double) extends Paper(__density = __materialDensity){
  override val __className = "Literature";
}

class Paint(private val __length: Double, private val __width: Double, val name: String, private val __materialDensity: Double) extends Paper(__density = __materialDensity){
  override val __className = "Paint";
}

class Picture(private val __length: Double, private val __width: Double, override val name: String, private val __materialDensity: Double, private val painter: String) extends Paint(__length = __length, __width = __width, name = name, __materialDensity = __materialDensity){
  override val __className = "Picture";
}

class Poster(private val __length: Double, private val __width: Double, override val name: String, private val __materialDensity: Double, private val manufacturer: String) extends Paint(__length = __length, __width = __width, name = name, __materialDensity = __materialDensity){
  override val __className = "Poster";
}

class Book(private val __size: Int, override val name: String, val description: String, private val __materialDensity: Double) extends Literature(__size = __size, name = name, __materialDensity = __materialDensity) {
  def getSize: Int = {
    __size
  }

  def getDescription: String = {
    description
  }

  def getName: String = {
    name
  }

  override val __className = "Book";

}

class NewsPaper(private val __size: Int, override val name: String, val mainNews: String, private val __materialDensity: Double) extends Literature(__size = __size, name = name, __materialDensity = __materialDensity) {
  def getSize: Int = {
    __size
  }

  def getMainNews: String = {
    mainNews
  }

  def getName: String = {
    name
  }

  override val __className = "Newspaper";

}

class Storage(){
  def getSize: Int ={
    __storage.size;
  }

  def findOneByName(name: String): Literature ={
    __storage.find(_._1.name == name).toList(0)._1
  }

  def getQuantity(name: String): Int ={
    __storage.find(_._1.name == name).toList(0)._2
  }

  def add(literature: Literature): Unit ={
    if(__storage.exists(_._1.name == literature.name)){
      __storage(literature) += 1
    }else{
      __storage.addOne(literature, 1)
    }
  }

  def delete(literature: Literature): Unit ={
    if(__storage(literature) != 0){
      __storage(literature) -= 1
      if(__storage(literature) == 0){
        __storage.remove(literature)
      }
    }else{
      throw new Exception ("Argument exception")
    }
  }

  protected val __className = "Storage";

  def sayClassName(): Unit = {
    println(__className)
  }

  private val __storage = collection.mutable.Map[Literature, Int]();


}

class Library(val yearOfFoundation: Int) extends Storage {
  override protected val __className: String = "Library"
}

class NewsShop(val medialCost: Double) extends Storage {
  override protected val __className: String = "NewsShop"
}

object Main extends App{
  val book = new Book(100, "Sapiens", "A brief story of humankind", 100);
  val lib = new Library(1961)
  lib.add(book)
  lib.add(book)
  println(lib.getQuantity("Sapiens"));
  lib.sayClassName()
  println(lib.findOneByName("Sapiens").name)
  println(lib.getSize)
  lib.delete(book)
  println(lib.getQuantity("Sapiens"));
  lib.delete(book)
  try{
    println(lib.findOneByName("Sapiens").name)
  }catch{
    case e: IndexOutOfBoundsException => println("Not found");
  }
  println(lib.getSize)

}