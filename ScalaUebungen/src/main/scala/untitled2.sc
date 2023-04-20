def calcWeeklyDeviationFromMonthlyAverage(l:List[(String, Int, Int, List[Int])]):Map[(Int,Int),Double] = {
  l
    .map(X => (X._2, X._3) -> X._4.sum.asInstanceOf[Double]./(X._4.size)) //get weekly averages
    .map(X => X._1 -> X._2.-(
      l.map(X => X._1 -> X._4) //get monthly averages
        .groupBy(_._1)
        .map(X => X._1 -> X._2.flatMap(X => X._2))
        .map(X => X._1 -> X._2.sum/X._2.size)
        .filter(X => X._1=="Juni")
        .map(_._2).sum)
      .abs)
    .toMap
}

