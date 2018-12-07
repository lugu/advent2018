package advent.day03
import scala.io.Source

object Main extends App {
  val source = Source.fromResource("day03.txt").getLines.toList
  // #1 @ 146,196: 19x14
  case class Point(x: Int, y: Int)
  case class Claim(id: Int, l: Int, t: Int, w: Int, h: Int) {
    def emits: Seq[Point] = {
      for (x <- l until l+w;
           y <- t until t+h) yield Point(x,y)
    }
  }
  def parse(str: String): Claim = {
    val pattern = raw"#(\d+) @ (\d+),(\d+): (\d+)x(\d+)".r
    val pattern(id, l, t, w, h) = str
    Claim(id.toInt, l.toInt, t.toInt, w.toInt, h.toInt)
  }
  val input = source.map(parse(_))

  val groupped = input.flatMap(claim => claim.emits.map(Tuple2(claim, _))).groupBy(a => a._2)
  val dups = groupped.flatMap{ case (p, list) =>
    if (list.size >= 2) list.map(_._1) else List()
  }.toSeq.distinct
  val result = input.find(claim => !dups.contains(claim))
  println(result)
}

