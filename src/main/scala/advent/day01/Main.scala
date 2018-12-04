package advent.day01
import scala.io.Source

object Main extends App {
  val source =
    Source.fromResource("day01.txt").getLines.map(_.toInt)
  val result = source.reduce(_ + _)
  println(result)
}
