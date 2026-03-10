import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Test Spark")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val data = Seq(("Scala", 1), ("Spark", 2), ("Docker", 3)).toDF("Tecnologia", "ID")
    
    data.show()
    println(s"Versión de Spark: ${spark.version}")
    spark.read.option("header", "true").option("delimiter", ";").csv("username.csv").show()
    
    
    spark.stop()
  }
}