package advent.day02
import scala.io.Source

object Main extends App {
  val source = Source.fromResource("day02.txt").getLines.toList
  // val source = List( "abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
  val input = source.map(_.toList)

  def count(list: Seq[Char], n: Int): Int = {
    return list.distinct.count(c => list.count(_ == c) == n)
  }

  def has(list: Seq[Char], n: Int): Int = {
    if (count(list, n) == 0) return 0 else return 1
  }

  val twos = input.map(has(_, 2)).reduce(_ + _)
  val threes = input.map(has(_, 3)).reduce(_ + _)
  println(twos * threes)
}
