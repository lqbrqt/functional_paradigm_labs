import scala.collection.mutable.ListBuffer

trait List[T]{
  def insert(e: T, pos: Int): Unit;
  def append(e: T): Unit;
  def delete(pos: Int): Unit;
  def print(): Unit;

  protected val __innerList: ListBuffer[T]
}

trait append[T] extends List[T]{
  override def append(e: T): Unit = {
    __innerList.append(e);
  }
}

trait insert[T] extends List[T]{
  override def insert(e: T, pos: Int): Unit = {
    __innerList.insert(pos, e);
  }
}

trait delete extends List[T]{
  override def delete(pos: Int): Unit = {
    __innerList.remove(pos);
  }
}

trait print extends List[T]{
  override def print(): Unit = {
    __innerList.remove(pos);
  }
}



class IntList extends List[Int]{
  override def append(e: Int): Unit = {
    __innerList.append(e);
  }

  override def insert(e: Int, pos: Int): Unit = {
    __innerList.insert(pos, e);
  }

  override def delete(pos: Int): Unit = {
    __innerList.remove(pos);
  }

  override def print(): Unit = {
    for(e <- __innerList){
      println(e);
    }
  }

  override protected val __innerList: ListBuffer[Int] = new ListBuffer[Int];
}


object Main extends App{

  val lst = new IntList;
  lst.append(3);
  lst.append(2);
  lst.delete(0);
  lst.print()

}