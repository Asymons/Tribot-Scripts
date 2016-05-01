package scripts.WaterFiller.data;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;

public class Helper {
	
	public static RSObject findNearest(int distance, int... ids) {
		RSObject[] objs = Objects.findNearest(distance, ids);
		if (objs.length > 0)
			return objs[0];
		return null;
	}
	
	public static Condition smartWaitCondition(boolean x){
		return new Condition(){
			@Override
			public boolean active() {
				General.sleep(100);
				return x;
			}
			
		};
	}
	
	public static void waitCondition(boolean x){
		Timing.waitCondition(smartWaitCondition(x), General.random(750,1000));
	}
	

}
