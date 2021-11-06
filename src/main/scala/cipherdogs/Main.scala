package cipherdogs

import java.awt.Color
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO

object Main extends App {
  println("Starting")
  val canvas = new BufferedImage(24, 24, BufferedImage.TYPE_INT_RGB);
  val g      = canvas.getGraphics;

  g.setColor(Color.WHITE);
  g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

  val parts: List[String] = List("face", "mouth", "nose", "eyes", "ears", "beard", "hair");

  try {
    parts
      .zip(0 until parts.size)
      .foreach(tuple => {
        val image: Image = new ImageIcon(getClass.getResource("/parts/" + tuple._1 + "/" + tuple._1 + args(tuple._2) + ".png")).getImage;
        g.drawImage(image, 0, 0, 24, 24, null);
      });

    ImageIO.write(canvas, "png", new java.io.File("punk.png"));
    println("Done!")
  } catch {
    case _: Throwable => println("Invalid code for generation\nRun: java -jar punk-generator-assembly-0.1.0.jar")
  }
}
