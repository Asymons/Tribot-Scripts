package scripts.WaterFiller.nodes;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Banking;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.NPCs;
import org.tribot.api2007.Objects;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSNPC;
import org.tribot.api2007.types.RSObject;

import scripts.ProgressiveMiner.api.Node;

public class WalkToBank extends Node{
	
	

	@Override
	public void execute() {
		
		
		if(WebWalking.walkToBank()){
			Banking.openBankBanker();
			Timing.waitCondition(smartWaitCondition(Banking.isBankScreenOpen()), General.random(750,1000));
			Banking.depositAll();
			Timing.waitCondition(smartWaitCondition(!Inventory.isFull()), General.random(750,1000));
			Banking.withdraw(28, 1923);
			Timing.waitCondition(smartWaitCondition(Inventory.isFull()), General.random(750,1000));
			Banking.close();
			Timing.waitCondition(smartWaitCondition(!Banking.isBankScreenOpen()), General.random(750,1000));
			
		}
//		walk.walkToBank();
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return Inventory.isFull() && Inventory.getCount(1921) == 28;
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
