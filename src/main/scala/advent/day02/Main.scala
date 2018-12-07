package advent.day02
import scala.io.Source

object Main extends App {
  val source = Source.fromResource("day02.txt").getLines.toList
  // val source = List( "abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
  val input = source.map(_.toList)

  def count(list: Seq[Char], n: Int): Int = {
    return list.distinct.count(c => list.count(_ == c) == n)
  }

  def has(list: Seq[Char], n: Int): Boolean = !(count(list, n) == 0)

  def diff(l1: Seq[Char], l2: Seq[Char]): Int = {
    l1.zip(l2).map({ case (a, b) => a == b}).count(_ == false)
  }
  def common(l1: Seq[Char], l2: Seq[Char]): Seq[Char] = {
    l1.zip(l2).flatMap({ case (a, b) => if (a == b) List(a) else List() })
  }

  val fabrics = input.filter(l => has(l, 2) || has(l, 3))
  val result = fabrics.flatMap(l1 => fabrics.filter(l2 => diff(l1, l2) == 1))
  result.foreach(println(_))
  println(common(result(0), result(1)).mkString)
}
