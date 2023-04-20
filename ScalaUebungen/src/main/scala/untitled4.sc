def calcWeeklyDeviationFromMonthlyAverage(l:List[(String, Int, Int, List[Int])]):Map[(Int,Int),Double] = {
  val monthlyAverages = l.map(X => X._1 -> X._4).groupBy(_._1).map(X => X._1 -> X._2.flatMap(X => X._2)).map(X => X._1 -> X._2.sum/X._2.size)
  val weeklyAverages = l.map(X => (X._2, X._3) -> X._4.sum.asInstanceOf[Double]./(X._4.size))
  val weeklyDeviation = weeklyAverages.map(X => X._1 -> X._2.-(monthlyAverages.filter(X => X._1=="Juni").map(_._2).sum).abs).toMap
  return weeklyDeviation
}