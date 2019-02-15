
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img {
	// grid images
	public static BufferedImage playerP;// itemID---0
	public static BufferedImage juror1P;// itemID---1
	public static BufferedImage juror2P;// itemID---2
	public static BufferedImage juror3P;// itemID---3
	public static BufferedImage star1P;// itemID---4
	public static BufferedImage star2P;// itemID---5
	public static BufferedImage competitor1P;// itemID---6
	public static BufferedImage competitor2P;// itemID---7
	public static BufferedImage awardLookP;// itemID---8
	public static BufferedImage awardDanceP;// itemID---9
	public static BufferedImage blindLightP;// itemID---10
	public static BufferedImage slipFloorP;// itemID---11
	public static BufferedImage trophyP;// itemID---12

	// load
	public Img() {
		try {
			playerP = ImageIO.read(new File("src\\playerP.jpg"));
			juror1P = ImageIO.read(new File("src\\juror1P.jpg"));
			juror2P = ImageIO.read(new File("src\\juror2P.jpg"));
			juror3P = ImageIO.read(new File("src\\juror3P.jpg"));
			star1P = ImageIO.read(new File("src\\star1P.jpg"));
			star2P = ImageIO.read(new File("src\\star2P.jpg"));
			competitor1P = ImageIO.read(new File("src\\competitor1P.jpg"));
			competitor2P = ImageIO.read(new File("src\\competitor2P.jpg"));
			awardLookP = ImageIO.read(new File("src\\awardLookP.jpg"));
			awardDanceP = ImageIO.read(new File("src\\awardDanceP.jpg"));
			blindLightP = ImageIO.read(new File("src\\blindLightP.jpg"));
			slipFloorP = ImageIO.read(new File("src\\slipFloorP.jpg"));
			trophyP = ImageIO.read(new File("src\\trophyP.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
