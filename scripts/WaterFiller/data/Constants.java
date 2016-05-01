package scripts.WaterFiller.data;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

public class Constants {
	
	public enum Items{
		BOWL(1923),BUCKET(1925),JUG(1935),FILLED_BOWL(1921);
		
		private int numVal;
		
		Items(int numVal){
			this.numVal = numVal;
		}
		
		public int getNumVal(){
			return numVal;
		}
	}
	
	public enum Objects{
		WATER_SOURCE(7143);
		
		private int numVal;
		
		Objects(int numVal){
			this.numVal = numVal;
		}
		
		public int getNumVal(){
			return numVal;
		}
	}
	
	public enum Tiles{
		
		FOUNTAINS_X(new RSTile(3206, 3430, 0)), FOUNTAINS_Y(new RSTile(3209, 3427, 0)),
		FOUTAINS(new RSArea(FOUNTAINS_X.getTile(),FOUNTAINS_Y.getTile()));
		
		private RSTile tile;
		private RSArea area;
		
		Tiles(RSTile tile){
			this.tile = tile;
		}
		
		Tiles(RSArea area){
			this.area = area;
		}
		
		public RSTile getTile(){
			return tile;
		}
		
		public RSArea getArea(){
			return area;
		}
	}

}
