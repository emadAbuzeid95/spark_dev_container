package emad.ideas.org.processes

import emad.ideas.org.tables.Table
import emad.ideas.org.tables.Table
import org.apache.spark.sql.DataFrame
import emad.ideas.org.tables.HiveTable

trait ModelProcess extends MainProcess {
  val tablesToRead: Seq[Table]
  override def read(): Map[String,DataFrame] = {
    tablesToRead.map(table => table.alias -> table.read(sparkSession)).toMap
  }
}
