package emad.ideas.org.tables

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

trait SqlTable extends Table {

  override def read(sparkSession: SparkSession): DataFrame = {
    val config: Map[String, String] = sparkSession
      .table("sql_options")
      .collect()
      .map { row =>
        (row.getAs[String]("key"), row.getAs[String]("value"))
      }
      .toMap
    // Esto es solo para probar la conexión a la base de datos, se puede eliminar después
    sparkSession.read
      .format("jdbc")
      .options(config)
      .load()
  }
}
