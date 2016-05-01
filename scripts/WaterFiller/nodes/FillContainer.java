package scripts.WaterFiller.nodes;

import org.tribot.api.General;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.ProgressiveMiner.api.Node;
import scripts.WaterFiller.data.*;

public class FillContainer extends Node {

//	private final int water = 5125;
//	private final int[] container = { 1923, 1925, 1923 }; // Bowl, Bucket, Jug
//	RSArea area = new RSArea(new RSTile(3190, 3471, 0), new RSTile(3193, 3470, 0));

	@Override
	public void execute() {

		if (Constants.Tiles.FOUTAINS.getArea().contains(Player.getPosition())) {
			RSObject source = findNearest(15, Constants.Objects.WATER_SOURCE.getNumVal());
			RSItem[] contain = Inventory.find(Constants.Items.BOWL.getNumVal());
			if (Inventory.find(Constants.Items.BOWL.getNumVal()).length == 0) {
				contain[0].click("Use");
				General.sleep(200, 800);
				source.click();
				General.sleep(1000, 2000);
			}
		}else{
			WebWalking.walkTo(Constants.Tiles.FOUTAINS.getArea().getRandomTile());
		}

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.getCount(Constants.Objects.WATER_SOURCE.getNumVal()) != 28;
	}

	private RSObject findNearest(int distance, int... ids) {
		RSObject[] objs = Objects.findNearest(distance, ids);
		if (objs.length > 0)
			return objs[0];
		return null;
	}
	
	private Condition smartWaitCondition(boolean x){
		return new Condition(){
			@Override
			public boolean active() {
				General.sleep(100);
				return x;
			}
			
		};
	}



}
