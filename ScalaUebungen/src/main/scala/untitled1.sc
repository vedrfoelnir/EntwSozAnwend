val temperaturen:List[(String, Int, Int, List[Int])]= List(("Juni", 2022, 22, List(18, 19, 17, 17, 15, 19,14)), ("Juni", 2022, 23, List(19, 18, 17, 28, 14, 20)),("Juni", 2022, 24, List(20, 21, 20, 28, 15, 18,17)), ("Juni", 2022, 25, List(18, 19, 17, 17, 15, 19,14)), ("Juni", 2022, 26, List(18, 19, 17, 17, 15, 19,14)),("Juli", 2022, 27, List(21, 24, 28, 29, 30, 29,28)),("Juli", 2022, 27, List(28, 21, 19, 18, 22, 29,33)), ("Juni", 2021, 22, List(12, 17, 13, 15, 11, 18,17)),("Juni", 2021, 23, List(24, 27, 32, 31, 35, 33,28)))


val monthlyAverages = temperaturen.map(X => X._1 -> X._4).groupBy(_._1).map(X => X._1 -> X._2.flatMap(X => X._2)).map(X => X._1 -> X._2.sum/X._2.size)

val weeklyDeviation = temperaturen.map(X => (X._1, X._3) -> X._4.sum./(X._4.size)).map(X => X._1 -> X._2.-(monthlyAverages.filter(X => X._1=="Juni").map(_._2).sum).abs)
val weeklyDeviation = temperaturen.map(X => (X._2, X._3) -> X._4.sum.asInstanceOf[Double]./(X._4.size)).map(X => X._1 -> X._2.-(monthlyAverages.filter(X => X._1=="Juni").map(_._2).sum).abs).toMap