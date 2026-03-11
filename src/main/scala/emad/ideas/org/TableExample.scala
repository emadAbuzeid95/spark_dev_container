package emad.ideas.org

import emad.ideas.org.tables.HiveTable
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType

object TableExample extends HiveTable {
  override val alias: String = "table_example"
  override val columns: StructType = StructType(Seq(
    StructField("id", IntegerType, nullable = false),
    StructField("name", StringType, nullable = false)
  ))
  override val partitionColumns: StructType = StructType(Seq(
    StructField("year", IntegerType, nullable = false),
    StructField("month", IntegerType, nullable = false)
  ))
  
}
