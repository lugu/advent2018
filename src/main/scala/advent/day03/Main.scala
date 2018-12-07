package advent.day03
import scala.io.Source

object Main extends App {
  val source = Source.fromResource("day03.txt").getLines.toList
  // #1 @ 146,196: 19x14
  case class Claim(id: Int, l: Int, t: Int, w: Int, h: Int) {
    def contains(x: Int, y: Int): Boolean = {
      (x >= l && x <= l + w) && (y >= t && y <= t + h)
    }
    def emits: Seq[Tuple2[Int,Int]] = {
      for (x <- l until l+w;
           y <- t until t+h) yield(x,y)
    }
  }
  def parse(str: String): Claim = {
    val pattern = raw"#(\d+) @ (\d+),(\d+): (\d+)x(\d+)".r
    val pattern(id, l, t, w, h) = str
    Claim(id.toInt, l.toInt, t.toInt, w.toInt, h.toInt)
  }
  val input = source.map(parse(_))

  val result = input.flatMap(_.emits).groupBy(a => a).count{
    case (a, l) => l.size >= 2
  }
  println(result)
}

