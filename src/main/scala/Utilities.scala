import scala.io.Source

object Utilities {
  def getLinesFromFile(srcPath: String, encoding:String="UTF8"): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath, enc=encoding)
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close
    lines
  }
}
