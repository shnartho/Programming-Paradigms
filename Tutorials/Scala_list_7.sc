import scala.annotation.tailrec
case class Set[A](array : List[A])

def contains[A, B](set : Set[A], e: B): Boolean = {
  def cnt(list: List[A], e: B): Boolean = {
    list match {
      case Nil => false
      case head :: tail => if(head == e) true else cnt(tail, e)
    }
  }
  cnt(set.array, e)
}

def add[A](s : Set[A], e: A): Set[A] ={
  if(!contains(s, e)) {
    Set(s.array.appended(e))
  } else{
    s
  }
}

def remove[A](set: Set[A], element: A): (Set[A], Option[A]) = {
  def rmv(list: List[A]): (Set[A], Option[A]) = {
    list match {
      case Nil => (Set(List[A]()), None)
      case head :: tail => if(head == element){ (rmv(tail)._1, Some(head)) }
      else{val temp = rmv(tail); (add(temp._1, head), temp._2)}
    }
  }
  rmv(set.array)
}



def intersection[A](s1: Set[A], s2: Set[A]): Set[A] = {
  def hlpin(l: List[A]): Set[A] = l match {
    case Nil => Set(List[A]())
    case h :: t => if(contains(s2, h)) add(hlpin(t), h) else hlpin(t)
  }
  hlpin(s1.array)
}

def union[A](s1: Set[A], s2: Set[A]): Set[A] = {
  val uset = intersection(s1, s2)
  def hlpunion(list: List[A]): Set[A] = list match {
    case Nil => s2
    case h :: t => if(contains(uset, h)) hlpunion(t) else add(hlpunion(t), h)
  }
  hlpunion(s1.array)
}

def difference[A](set1: Set[A], set2: Set[A]): Set[A] = {
  def rdiff(list: List[A], s: Set[A]): Set[A] = list match {
    case Nil => Set(List[A]())
    case h :: t => if(!contains(s, h)) add(rdiff(t, s), h) else rdiff(t, s)
  }
  union(rdiff(set1.array, set2), rdiff(set2.array, set1))
}

def printSet[A](set: Set[A]): Unit = {
  def hlpPrint[A](list: List[A]): Unit = list match {
    case Nil =>
    case head :: tail => { print(head + ", "); hlpPrint(tail) }
  }
  print("\n"+"[")
  hlpPrint(set.array)
  print("]\n")
}

var set = Set(List[Int]())
printSet(set)
set = add(set, 1)
set = add(set, 2)
set = add(set, 3)
set = add(set, 4)
set = add(set, 5)
printSet(set)
var set2 = Set(List[Int]())
set2 = add(set2, 6)
set2 = add(set2, 7)
set2 = add(set2, 8)
set2 = add(set2, 9)
set2 = add(set2, 10)
printSet(set2)
//Test
printSet(intersection(set, set2))
printSet(union(set, set2))
printSet(difference(set, set2))
set2 = remove(set2, 3)._1
printSet(set2)
printSet(intersection(set, set2))
printSet(union(set, set2))
printSet(difference(set, set2))

 case class Map[A, B](func: A => B) {
   var map = List[(B, A)]()

  def add(v: A): Boolean = {
    val a = func(v)
    if (!containMap(a)) {
      map= (a, v)::map
      true
    } else {
      false
    }
  }

  def remove(v: A): Boolean = {
    if (contains(v)) {
      map=map.filter(_._2!=v)
      true
    }
    else false
  }

  def get(b: B): Option[A] = {
    var bool = true
    def hlpget(l: List[(B, A)]): Option[A] = {
      if (l.isEmpty) {
        bool = false
        None
      } else if (l.head._1==b)
        Some(l.head._2)
      else
        hlpget(l.tail)
    }
    val result = hlpget(map)
    result
  }

  def contains(a: A): Boolean = {
    def iterator(list: List[(B, A)]): Boolean = {
      if (list.isEmpty)
        false
      else if (list.head._2==a)
        true
      else
        iterator(list.tail)
    }
    iterator(map)
  }

  def containMap(b: B): Boolean = {
    def iterator(list: List[(B, A)]): Boolean = {
      if (list.isEmpty){
        false
      }
      else if (list.head._1==b) true
      else iterator(list.tail)
    }
    iterator(map)
  }

  def deleteMap(v: B): Boolean = {
    if (containMap(v)) {
      map=map.filter(_._1!=v)
      true
    }
    else{
      false
    }
  }
}

//test
val m = new Map[Int, Int]((x:Int) => x*x+2)
m.add(1)
m.add(2)
m.add(3)
m.contains(1)
m.contains(4)
m.containMap(0)
m.containMap(-2)
m.containMap(4)
m.get(9)
/*
// Array list vs Linkedlist
//Array List
1) ArrayList internally uses a dynamic array to store the elements.	
2) Manipulation with ArrayList is slow because it internally uses an array.If any element is removed from the array, all the bits are shifted in memory.	
3) An ArrayList class can act as a list only because it implements List only.	
4) ArrayList is better for storing and accessing data.

//LinkedList
1)LinkedList internally uses a doubly linked list to store the elements.
2)Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.
3)LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
4)LinkedList is better for manipulating data. */