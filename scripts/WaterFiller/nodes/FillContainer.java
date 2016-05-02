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
	
	public static int TOTAL_COUNT = 0;


	//TODO Check Animation if player is filling bowl, add to last condition  Animation:832
	
	@Override
	public void execute() {

		if (Constants.Tiles.FOUTAINS.getArea().contains(Player.getPosition())) {
			Constants.CURRENT_STATE = Constants.States.FILLING;
			RSObject source = Helper.findNearest(15, Constants.Objects.WATER_SOURCE.getNumVal());
			RSItem[] contain = Inventory.find(Constants.SELECTED_ITEM.getNumVal());
			if (Inventory.find(Constants.FILLED_SELECTED_ITEM.getNumVal()).length == 0) {
				contain[0].click("Use");
				Helper.waitCondition(Game.getUptext().contains("Use->" + contain[0].getID()));  //TODO Check if this works, otherwise switch to static sleep
				source.click();
				Helper.waitCondition(Inventory.find(Constants.FILLED_SELECTED_ITEM.getNumVal()).length > 0); //TODO Check if this works, otherwise switch to static sleep
			}
			
			if(Inventory.find(Constants.FILLED_SELECTED_ITEM.getNumVal()).length == 28){
				TOTAL_COUNT = TOTAL_COUNT + 28;
			}
			
			
		}else{
			Constants.CURRENT_STATE = Constants.States.WALKING_TO_FOUNTAIN;
			WebWalking.walkTo(Constants.Tiles.FOUTAINS.getArea().getRandomTile());
		}

	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.getCount(Constants.FILLED_SELECTED_ITEM.getNumVal()) != 28;
	}





}
