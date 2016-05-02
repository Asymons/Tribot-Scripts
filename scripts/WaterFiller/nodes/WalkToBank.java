package scripts.WaterFiller.nodes;

import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.WebWalking;

import scripts.ProgressiveMiner.api.Node;
import scripts.WaterFiller.data.Constants;
import scripts.WaterFiller.data.Helper;

public class WalkToBank extends Node {

	@Override
	public void execute() {

		if (WebWalking.walkToBank()) {
			Constants.CURRENT_STATE = Constants.States.WALKING_TO_BANK;
			if (Banking.isInBank()) {
				Constants.CURRENT_STATE = Constants.States.BANKING;
				Banking.openBankBanker();
				Helper.waitCondition(Banking.isBankScreenOpen());
				Banking.depositAll();
				Helper.waitCondition(!Inventory.isFull());
				Banking.withdraw(28, Constants.SELECTED_ITEM.getNumVal());
				Helper.waitCondition(Inventory.isFull());
				Banking.close();
				Helper.waitCondition(!Banking.isBankScreenOpen());
			}

		}

	}

	@Override
	public boolean validate() {
		return Inventory.isFull() && Inventory.getCount(Constants.FILLED_SELECTED_ITEM.getNumVal()) == 28;
	}

}
