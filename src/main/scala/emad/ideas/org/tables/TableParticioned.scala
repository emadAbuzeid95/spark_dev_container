package emad.ideas.org.tables

import org.apache.spark.sql.types.StructType

trait TableParticioned extends Table {
  val columns: StructType
  val partitionColumns: StructType
  lazy val schema: StructType = StructType(columns.fields ++ partitionColumns.fields)
}
