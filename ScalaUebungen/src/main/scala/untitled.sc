val config=Map[String, Any]("port"->1000, "address"->"superservice@htw", "delay"→5.5)
//[String, Any]
val configF=Map[String, Any]().withDefaultValue("NotFound")


config("port")
configF("port")

config.get("port").get
configF.get("port").getOrElse("NotFound")


val (port, address):(Int,String) =
  config.get("port").get.asInstanceOf[Int] match {
    case x => (x, config.get("address").get.asInstanceOf[String])
  }

val calories: List[(String, String, List[(String, Int)])] = List(("Donald Duck", "2022-01-01",List(("Frühstück",800), ("Mittag", 700), ("Snack",200), ("Abendbrot", 500))), ("Donald Duck", "2022-01-02",List(("Frühstück",700), ("Mittag", 650), ("Abendbrot", 520))), ("Donald Duck", "2022-01-03",List(("Frühstück",800), ("Mittag", 700), ("Snack",200), ("Abendbrot", 500), ("Snack",150))),("Donald Duck", "2022-01-04",List(("Frühstück",850), ("Mittag", 900), ("Snack",500), ("Snack", 400))),("Donald Duck", "2022-01-05",List(("Frühstück",600), ("Mittag", 700), ("Snack",200), ("Abendbrot", 100))), ("Dagobert Duck", "2022-01-01",List(("Frühstück",300), ("Mittag", 500), ("Snack",100), ("Abendbrot", 200))), ("Dagobert Duck", "2022-01-02", List( ("Frühstück",200), ("Mittag", 300), ("Snack",400), ("Abendbrot", 200))), ("Dagobert Duck", "2022-01-03",List(("Frühstück",800), ("Mittag", 700), ("Snack",200), ("Snack", 200))), ("Dagobert Duck", "2022-01-04",List(("Frühstück",200), ("Mittag", 300), ("Snack",200), ("Snack", 500))), ("Dagobert Duck", "2022-01-05",List(("Frühstück",200), ("Mittag", 700), ("Abendbrot", 500))))

val res1 = calories.flatMap(X => X._3).groupBy(_._1).map(X => X._1 -> X._2.map(V => V._2).sum/X._2.size)

val res2 = calories.map(X => X._1->X._3).groupBy(_._1).flatMap(X => X._2.groupBy(_._1)).map(X => X._1 -> X._2.flatMap(_._2).groupBy(_._1).map(X => X._1 -> X._2.map(V => V._2).sum/X._2.size))

val res3 = calories.map(X => X._1 -> X._3.map(_._2).sum).groupBy(_._1).map(X => X._1 -> X._2.map(_._2).reduce(_+_)/X._2.size)
