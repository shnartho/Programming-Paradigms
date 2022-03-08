package Laboratories.Class_4

object CombineListsNonTail_2 extends App {
  def combine(listA: List[Int], listB: List[Int]): List[Int] = {
    def loopThrough(remainingA: List[Int], remainingB: List[Int]): List[Int] = {
      if(remainingA.isEmpty && remainingB.isEmpty) {
        return List()
      }

      var appendedVal = 0

      if(remainingA.isEmpty) {
        appendedVal += remainingB.head
      } else if(remainingB.isEmpty) {
        appendedVal += remainingA.head
      } else {
        // both non-empty
        appendedVal += remainingA.head + remainingB.head
      }

      val newRemainingA = if (remainingA.isEmpty) List() else remainingA.tail
      val newRemainingB = if (remainingB.isEmpty) List() else remainingB.tail

      appendedVal :: loopThrough(newRemainingA, newRemainingB)
    }

    loopThrough(listA, listB)
  }

  println(combine(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6)))

  assert(combine(List(5, 4, 3, 2), List(1, 2, 3, 4, 5, 6)) == List(6, 6, 6, 6, 5, 6))
  assert(combine(List(5, 4, 3, 2), List()) == List(5, 4, 3, 2))
  assert(combine(List(), List(1, 2, 3, 4)) == List(1, 2, 3, 4))
  assert(combine(List(), List()) == List())
}