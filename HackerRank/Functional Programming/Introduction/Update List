def f(arr:List[Int]):List[Int] = {
  var result: List[Int] = Nil
  var these = arr
  while (!these.isEmpty) {
      if(these.head<0) result = (these.head * -1)::result
          else result=these.head::result
    these = these.tail
  }
  result.reverse
}
