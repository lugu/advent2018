package advent.day01
import scala.io.Source

object Main extends App {
  val source = Source.fromResource("day01.txt").getLines.map(_.toInt).toList
  // val source = List(-6, +3, +8, +5, -6)
  // val source = List(+7, +7, -2, -7, -4)
  // val source = List(+3, +3, +4, -2, -4)
  // val source = List(+1, -1)
  val input = Stream.continually(source.toStream).flatten

  case class State(current: Int, passed: Set[Int], stream: Stream[Int]) {
    def done = passed.contains(current)
    def next: State = {
      State(current + stream.head, passed + current, stream.tail)
    }
    @scala.annotation.tailrec
    final def last: State = if (done) this else next.last
  }

  var init = State(0, Set(), input)
  println(init.last.current)
}
