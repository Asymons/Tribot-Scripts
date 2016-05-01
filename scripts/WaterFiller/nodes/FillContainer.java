package scripts.WaterFiller.nodes;

import org.tribot.api2007.Game;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSItem;
import org.tribot.api2007.types.RSObject;

import scripts.ProgressiveMiner.api.Node;
import scripts.WaterFiller.data.Constants;
import scripts.WaterFiller.data.Helper;

public class FillContainer extends Node {


	//TODO Check Animation if player is filling bowl, add to last condition  Animation:832
	
	@Override
	public void execute() {

		if (Constants.Tiles.FOUTAINS.getArea().contains(Player.getPosition())) {
			RSObject source = Helper.findNearest(15, Constants.Objects.WATER_SOURCE.getNumVal());
			RSItem[] contain = Inventory.find(Constants.Items.BOWL.getNumVal());
			if (Inventory.find(Constants.Items.FILLED_BOWL.getNumVal()).length == 0) {
				contain[0].click("Use");
				Helper.waitCondition(Game.getUptext().contains("Use->" + contain[0].getID()));  //TODO Check if this works, otherwise switch to static sleep
				source.click();
				Helper.waitCondition(Inventory.find(Constants.Items.FILLED_BOWL.getNumVal()).length > 0); //TODO Check if this works, otherwise switch to static sleep
			}
		}else{
			WebWalking.walkTo(Constants.Tiles.FOUTAINS.getArea().getRandomTile());
		}

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.getCount(Constants.Items.FILLED_BOWL.getNumVal()) != 28;
	}





}
