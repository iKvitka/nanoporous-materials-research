package models

case class SensorData(timePoint: Double, value: Double)

case class DataSample(values: List[SensorData])
