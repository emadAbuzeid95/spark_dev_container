package emad.ideas.org.tables

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.types.StructType

trait HiveTable extends TableParticioned {
  override def read(sparkSession: SparkSession): DataFrame = sparkSession.table(alias)
  override def write(df: DataFrame, mode: String): Unit = {
    df.write.mode(mode).insertInto(alias)
  }

}
