name := "SparkApp"
version := "0.1"
scalaVersion := "2.12.18"

val sparkVersion = "3.3.4"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql"  % sparkVersion % "provided"
)