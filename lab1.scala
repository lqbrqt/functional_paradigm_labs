/*import sun.security.provider.DSAKeyPairGenerator.Current

import scala.collection.IterableOnce.iterableOnceExtensionMethods*/
import scala.collection.mutable.ListBuffer

object Main extends App {

  //task1
  def nthRecursive(x: Int, arr: List[Int]): Int = {
    def recursive(current: Int): Int = {
      if (current == x) {
        arr(current);
      } else {
        recursive(current + 1);
      }
    }

    recursive(0)
  }

  def nthCyclic(x: Int, arr: List[Int]): Int = {
    var current = 0;
    while (current != x) {
      current += 1;
    }
    arr(current)
  }

  val arr = List[Int](1, 1, 2, 3, 5, 8);

  println(s"Recursive: ${nthRecursive(2, arr)}, iterable: ${nthCyclic(2, arr)} ");

  //task2

  def reverseRecursive(arr: List[Int]): List[Int] = {

    var tmp = ListBuffer[Int]();

    for (i <- arr) {
      tmp += i;
    }

    def recursive(arr: ListBuffer[Int]): ListBuffer[Int] = {
      if (arr.length == 1) {
        arr;
      } else {
        recursive(arr.slice(0, arr.length - 1)).prepend(arr.last);
      }
    }

    recursive(tmp).toList
  }

  def reverseCyclic(arr: List[Int]): List[Int] = {

    var tmp = ListBuffer[Int]();

    for (i <- arr) {
      tmp.prepend(i);
    }

    tmp.toList
  }

  println(s"Recursive: ${reverseRecursive(arr)}, iterable: ${reverseCyclic(arr)} ");

  //task3

  def sliceRecursive(begin: Int, end: Int, arr: List[Int]): List[Int] = {

    var tmp = ListBuffer[Int]();

    def recursive(i: Int): Unit = {
      if (i >= begin && i < end) {
        tmp += arr(i);
      }
      if(i < end) {
        recursive(i + 1)
      }
    }

    recursive(0)
    tmp.toList
  }

  def sliceCyclic(begin: Int, end: Int, arr: List[Int]): List[Int] = {
    var tmp = ListBuffer[Int]();


    for (i <- begin until end) {
      tmp += arr(i);
    }

    tmp.toList
  }

  println(s"Recursive: ${sliceRecursive(2, 4, arr)}, iterable: ${sliceCyclic(2, 4, arr)} ");


  //task4

  def rangeRecursive(min: Int, max: Int): List[Int] = {
    var outBuff = ListBuffer[Int]();
    def recursive(current: Int): Unit = {
      if (arr(current) >= min && arr(current) <= max ) {
        outBuff += (arr(current));
      }
      if (current < arr.length - 1){
        recursive(current + 1);
      }
    }
    recursive(0);
    outBuff.toList;
  }

  def rangeCyclic(min: Int, max: Int): List[Int] = {
    var outBuff = ListBuffer[Int]();
    for (current <- arr) {
      if (current >= min && current <= max ) {
        outBuff += (current);
      }
    }
    outBuff.toList
  }

  println(s"Recursive: ${rangeRecursive(4, 8)}, iterable: ${rangeCyclic(4, 9)} ");


  //task 5

  def gcdRecursive(a: Int, b: Int): Int = {
    if(b==0){
      a;
    }else if(a > b){
      gcdRecursive(b, a % b);
    }else{
      gcdRecursive(a, b % a);
    }
  }

  def gcdCyclic(a: Int, b: Int): Int = {

    var num1 = a;
    var num2 = b;

    while ( num2 != 0){
      if(num1 > num2){
        val tmp = num1;
        num1 = num2;
        num2 = tmp%num2;
      }else{
        num2 = num2%num1;
      }
    }
    num1
  }

  println(s"Recursive: ${gcdRecursive(36, 63)}, iterable: ${gcdCyclic(36, 63)} ");

  //task6

  def rotateRecursive(n: Int, arr: List[Int]): List[Int] = {
    var tmp = ListBuffer[Int]();

    def recursive(current: Int): Unit = {
      if(current>=arr.length){
        tmp += arr(current - arr.length);
      }else{
        tmp += arr(current);
      }
      if(current < arr.length - 1 + n){
        recursive(current+1);
      }
    }

    recursive(n);

    tmp.toList
  }

  def rotateCyclic(n: Int, arr: List[Int]): List[Int] = {
    var tmp = ListBuffer[Int]();


    for (i <- n until arr.length + n) {
      if(i>=arr.length){
        tmp += arr(i - arr.length);
      }else{
        tmp += arr(i);
      }
    }

    tmp.toList
  }

  println(s"Recursive: ${rotateRecursive(3, arr)}, iterable: ${rotateCyclic(3, arr)} ");

  //task7

  def f(x: Double): Double = {
    scala.math.pow(x, 3) + 18*x - 83;
  }

  def fi(x: Double): Double = {
    Math.exp(Math.log(-18*x + 83)/3);
  }

  def mpiRecursive(start: Double, prox: Double, func: (Double => Double), nmax: Int): Double = {
    val x = func(start);
    if(nmax==0) x
    else {

      if ((f(x)).abs >= prox) {
        mpiRecursive(x, prox, func, nmax - 1);
      } else {
        x;
      }
    }
  }

  def mpiCyclic(start: Double, prox: Double, func: (Double => Double), nmax: Int): Double = {
    var x = func(start);
    var n = 0;
    var delta = (f(x).abs);

    while (n < nmax && delta >= prox){
      x = func(x);
      n = n+1;
      delta = (f(x).abs);
    }

    x
  }

  println(s"Recursive: ${mpiRecursive(3, 0.01, fi, 15)}, iterable: ${mpiCyclic(3, 0.01, fi, 15)} ");

}
