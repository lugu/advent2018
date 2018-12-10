package advent.day04
import scala.io.Source
import com.github.nscala_time.time.Imports._

object Main extends App {
  val source = Source.fromResource("day04.txt").getLines.toList

  // 1. sort by date and time
  // 2. extract the event
  // 3. construct a night shift
  // 4. group by guards
  // 5. find the most sleeping guard
  // 6. find the minute of the most sleeping guard

  sealed trait Event {
    def dateTime: DateTime
    // def min: Int = dateTime.minute.toInt
  }

  final case class RawEvent(dateTime: DateTime, msg: String) extends Event

  final case class NewShift(dateTime: DateTime, guard: Int) extends Event
  final case class FallAsleep(dateTime: DateTime) extends Event
  final case class WakesUp(dateTime: DateTime) extends Event

  case class Nap(from: Int, to: Int)
  case class Shift(date: String, guard: Int, naps: Seq[Nap])
  case class Guard(guard: Int, naps: Seq[Nap])

  // [1518-09-17 23:48] Guard #1307 begins shift
  // [1518-04-09 00:22] wakes up
  // [1518-11-02 00:41] falls asleep
  def parse(str: String): Event = {

    val pattern = raw"\[(.*)\] (.*)".r
    var pattern(date, msg) = str

    import org.joda.time._
    import org.joda.time.format._
    import java.util.Locale

    val datePattern = "yyyy-MM-dd HH:mm"
    val format = DateTimeFormat.forPattern(datePattern).withLocale(Locale.ENGLISH)
    val dateTime = format.parseDateTime(date)

    RawEvent(dateTime, msg)
  }

  // val input = source.map(parse(_))
  // println(input.head)
}

