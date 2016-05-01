package scripts.WaterFiller.nodes;

import org.tribot.api.General;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;

import scripts.ProgressiveMiner.api.Node;

public class FillContainer extends Node {

	private final int water = 5125;
	private final int[] container = { 1923, 1925, 1923 }; // Bowl, Bucket, Jug
	RSArea area = new RSArea(new RSTile(3190, 3471, 0), new RSTile(3193, 3470, 0));

	@Override
	public void execute() {

		if (area.contains(Player.getPosition())) {
			RSObject source = findNearest(15, water);
			RSItem[] contain = Inventory.find(1923);
			if (Inventory.find(1921).length == 0) {
				contain[0].click("Use");
				General.sleep(200, 800);
				source.click();
				General.sleep(1000, 2000);
			}
		}else{
			WebWalking.walkTo(area.getRandomTile());
		}

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.getCount(1921) != 28;
	}

	private RSObject findNearest(int distance, int... ids) {
		RSObject[] objs = Objects.findNearest(distance, ids);
		if (objs.length > 0)
			return objs[0];
		return null;
	}

	// InventoryItem[] tinderbox = Inventory.find(590);
	// InventoryItem[] log = Inventory.find(2511);
	// if(tinderbox.length>0&&log.length>0)
	// {
	// tinderbox[0].click("Use");
	// sleep(100, 200);
	// log[0].click("Use");
	// }

}
