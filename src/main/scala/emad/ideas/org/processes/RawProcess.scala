package emad.ideas.org.processes

import org.apache.spark.sql.DataFrame

trait RawProcess extends MainProcess {
  val format: String
  val sparkReadOptions: Map[String, String] = Map()
  val path: String
  override def read(): Map[String, DataFrame] = {
    val dfReaded: DataFrame = sparkSession.read.format(format).options(sparkReadOptions).load(path)
    Map(
      tableToWrite.alias -> dfReaded
    )
  }
}
