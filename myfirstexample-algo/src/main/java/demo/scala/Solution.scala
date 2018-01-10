//package demo.scala

/**
  * Created by anya on 5/10/17.
  */
object Solution {

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    //  Print "Hello World" on a new line 'n' times.
    if(n!=0){
      for (i <- 1 to n)
        println("Hello World")
    }
  }
}
