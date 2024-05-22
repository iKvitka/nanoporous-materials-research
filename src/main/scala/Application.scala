import services.DataReaderImpl

object Application {
  def main(args: Array[String]): Unit = {
    // Simple file reading

    val experimentData = new DataReaderImpl().readData()

    // Checking the data
    println(experimentData)
  }
}
