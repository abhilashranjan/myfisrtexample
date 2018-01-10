package demo.scala

/**
  * Created by anya on 12/9/17.
  */
object Test {

  def main(args: Array[String]): Unit = {
//    val value=readLine();
    val ret= readLine()
                .map(f=>if(f > 64 && f< 91) (f+32) else(f-32))
                .map(i=>i.toChar)
                .mkString
    println(ret);
  }
}
