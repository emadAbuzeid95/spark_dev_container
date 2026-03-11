package emad.ideas.org.processes

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import scala.io.Source
import emad.ideas.org.tables.Table

trait MainProcess extends App {

  val sparkSession: SparkSession = SparkSession.builder().getOrCreate()
  val tableToWrite: Table
  val writeMode: String = "overwrite"
  val development: Boolean = false

  /** Lee los archivos de entrada y devuelve un mapa con el nombre del archivo como clave y el DataFrame como valor. El
    * formato de los archivos puede ser CSV, JSON, Parquet, etc. El método debe manejar diferentes formatos de archivo y
    * devolver un DataFrame adecuado para cada uno de ellos. El método también debe manejar errores en caso de que el
    * archivo no exista o tenga un formato incorrecto.
    *
    * @return
    *   Un mapa con el nombre del archivo como clave y el DataFrame como valor.
    */
  def read(): Map[String, DataFrame]

  /** Toma el mapa de DataFrames generado por el método read() y realiza las transformaciones necesarias para preparar
    * los datos para su análisis. El método debe aplicar las transformaciones adecuadas a cada DataFrame según su
    * formato y contenido. El método también debe manejar errores en caso de que los datos no sean válidos o no se
    * puedan transformar correctamente.
    *
    * @param input
    *   Un mapa con el nombre del archivo como clave y el DataFrame como valor.
    * @return
    *   Un DataFrame con los datos transformados y listos para su análisis.
    */
  def trasform(input: Map[String, DataFrame]): DataFrame

  /** Toma el DataFrame transformado por el método trasform() y lo escribe en un formato de salida específico, como CSV,
    * JSON, Parquet, etc. El método debe manejar diferentes formatos de salida y escribir el DataFrame en el formato
    * adecuado. El método también debe manejar errores en caso de que el DataFrame no se pueda escribir correctamente o
    * que el formato de salida no sea válido.
    *
    * @param df
    *   Un DataFrame con los datos transformados y listos para su análisis.
    */
  def write(df: DataFrame): Unit =
    if (development) {
      df.show(10, truncate = false)
    } else {
      tableToWrite.write(df, writeMode)
    }

  override def main(args: Array[String]): Unit = {
    super.main(args)
    val inputData: Map[String, DataFrame] = read()
    val transformedData: DataFrame = trasform(inputData)
    write(transformedData)
  }

}
