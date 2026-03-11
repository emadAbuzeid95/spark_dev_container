package emad.ideas.org.tables

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType

trait Table {
  val alias: String
  def schema: StructType
  def read(sparkSession: SparkSession): DataFrame

  def write(df: DataFrame, mode: String): Unit
  def castDataFrame(df: DataFrame): DataFrame = {
    val notNullableFields: Array[String] = schema.fields.filterNot(_.nullable).map(f => f.name)
    df.select(schema.fields.map(f => df.col(f.name).cast(f.dataType).as(f.name)): _*).na.drop(notNullableFields)
  }
}
