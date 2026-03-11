import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StructType

object Main {
  def main(args: Array[String]): Unit = {
    val mySchema = StructType(Seq(StructField("value", StringType), StructField("count", IntegerType)))
// Generate DDL format
    println(mySchema.toDDL)
// Generate SQL DDL format
    println(mySchema.sql)
// Generate Simple String DDL format
    println(mySchema.simpleString)
// Generate JSON format
    println(mySchema.json)
  }
}
