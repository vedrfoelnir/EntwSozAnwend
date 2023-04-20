def getMonthlyAverages(dataSet:List[(String, Int, Int, List[Int])]): Map[String, Int] =
  dataSet.map(X => X._1 -> X._4)
    .groupBy(_._1)
    .map(X => X._1 -> X._2
      .flatMap(X => X._2))
    .map(X => X._1 -> X._2.sum/X._2.size)

def getWeeklyAverages(dataSet: List[(String, Int, Int, List[Int])]): List[((Int, Int), Double)] = {
  dataSet.map(X => (X._2, X._3) ->
    X._4.sum.asInstanceOf[Double]
      ./(X._4.size))
}

def calculateWeeklyDeviation(monthlyAverages: Map[String, Int], weeklyAverages:List[((Int, Int), Double)]):Map[(Int,Int),Double] =
  weeklyAverages.map(X => X._1 -> X._2
    .-(
      monthlyAverages
        .filter(X => X._1=="Juni")
        .map(_._2)
        .sum)
    .abs).toMap

def calculateWeeklyDeviationFromMonthlyAverage(l:List[(String, Int, Int, List[Int])]):Map[(Int,Int),Double] = {
  val monthlyAvg = getMonthlyAverages(l)
  val weeklyAvg = getWeeklyAverages(l)
  return calculateWeeklyDeviation(monthlyAvg, weeklyAvg)
}