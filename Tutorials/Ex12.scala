import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}

class MyActor extends Actor {
  val log: LoggingAdapter = Logging(context.system, this)

  var pingPongScore = 0;

  def receive: Receive = {
    case "ping" =>
      if (pingPongScore >= 10) {
        // If won, reset score and stop sending pings
        log.info("\t[" + self.path.name + "] I Win!")
        pingPongScore = 0
      } else {
        log.info("\t[" + self.path.name + "] Ping!")
        // 80% chance to hit ball
        if (tossCoin(80)) {
          pingPongScore += 1
          log.info("\t[" + self.path.name + "] Pong!")
        }
        sender().tell("ping", self)
      }

    case ball : Ball =>
      log.info("\t[" + self.path.name + "] I caught the ball!")
      if (ball.count != 10) {
        ball.touch()
        ball.getPlayers.filter(_ != self)(scala.util.Random.nextInt(ball.getPlayers.length - 1)).tell(ball, self)
        log.info("\t[" + self.path.name + "] I threw the ball!")
      } else {
        log.info("\t[" + self.path.name + "] Ball game ended with me!")
      }

    case str : String => log.info("Hello, " + str)
    case _ => log.info("Unknown name received")
  }

  def tossCoin(chance : Int): Boolean = {
    val randVal = scala.util.Random.nextInt(100)
    if (randVal < chance) {
      true
    } else {
      false
    }
  }

}

class Ball(actors : List[ActorRef]) {
  var count = 0
  def touch(): Unit = {
    count += 1
  }
  def getPlayers: List[ActorRef] = {
    actors
  }
}

object Main extends App {
  val system = ActorSystem("MySystem")

  val mainActor = system.actorOf(Props[MyActor], name = "main");
  val secondActor = system.actorOf(Props[MyActor], name = "second");
  val thirdActor = system.actorOf(Props[MyActor], name = "third");

  val actorList = List(mainActor, secondActor, thirdActor)

  // Names
  mainActor.tell("James", secondActor);
  mainActor.tell(123, secondActor);

  // Ping-Pong
  secondActor.tell("ping", mainActor);

  // Ball throw
  val ball = new Ball(actorList);
  mainActor.tell(ball, secondActor);

}
