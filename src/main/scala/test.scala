/**
  * Created by mjiang on 7/31/17.
  */
import org.scalatest.FunSuite

class test extends  FunSuite{
  import org.apache.spark.sql.SparkSession

  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  import spark.implicits._

  //val df = spark.read.json("data/people.json")
  import org.apache.spark.sql.SQLContext


  val df = spark.read
    .format("com.databricks.spark.csv")
    .option("header", "true") //reading the headers
    .option("inferSchema", "true")
    .load("data/train.csv");

  df.show()


}
