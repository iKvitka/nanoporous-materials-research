package services

import models.{DataSample, SensorData}

import scala.io.Source
import scala.util.Using

trait DataReader {
  def readData(): DataSample
}

class DataReaderImpl extends DataReader {
  override def readData(): DataSample = {
    val standardTestingSampleDirectory = "./data-assets/initial-testing-sample"
    val defaultTestingDataFile = s"$standardTestingSampleDirectory/1 (72 seconds).dat"

    // TODO: add various handling in case of incorrect data
    Using(Source.fromFile(defaultTestingDataFile)){ sampleFile =>
      val dataSample = sampleFile.getLines().map{ line => 
        val tsvData = line.split("\\s+")
        SensorData(tsvData.head.toDouble, tsvData.last.toDouble)
      }.toList
      
      DataSample(dataSample)
    }.toOption.get
  }
}
