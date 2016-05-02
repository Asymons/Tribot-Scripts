package scripts.WaterFiller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Skills;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import scripts.ProgressiveMiner.api.Node;
import scripts.WaterFiller.data.Constants;
import scripts.WaterFiller.nodes.FillContainer;
import scripts.WaterFiller.nodes.GUI;
import scripts.WaterFiller.nodes.WalkToBank;

@ScriptManifest(authors = { "Xero" }, category = "Money", name = "WaterFiller")
public class WaterFiller extends Script implements Painting {
	public static ArrayList<Node> nodes = new ArrayList<>();
	
	private static final long startTime = System.currentTimeMillis();


	Font font = new Font("Verdana", Font.BOLD, 14);
	
	public boolean first = true;
	public boolean GUI_COMPLETE = false;

	public boolean onStart(boolean x) {
		if (first == true) {
			first = false;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void run() {
		GUI frame = new GUI();
		frame.setVisible(true);
		while(!GUI_COMPLETE){
			if(frame.getButton(frame.BowlButton)){
				Constants.setItem(Constants.Items.BOWL, Constants.Items.FILLED_BOWL);
				println("is here");
//				first = false;
			}else if(frame.getButton(frame.JugButton)){
				
			}else if(frame.getButton(frame.BucketButton)){
				
			}
			
			if(frame.getButton(frame.btnStart)){
				frame.setVisible(false);
				GUI_COMPLETE = true;
			}
			sleep(300);
		}
		frame.setVisible(false);
		
//		
//		if(first){
//			if(frame.getButton(frame.BowlButton)){
//				Constants.setItem(Constants.Items.BOWL, Constants.Items.FILLED_BOWL);
//				first = false;
//			}else if(frame.getButton(frame.JugButton)){
//				
//			}else if(frame.getButton(frame.BucketButton)){
//				
//			}
//		}

		if (!frame.isVisible()) {
			Collections.addAll(nodes, new FillContainer(), new WalkToBank());
			println("ayylmao");
		}
		loop(20, 40);
	}

	private void loop(int min, int max) {
		while (true) {
			for (final Node node : nodes) {
				if (node.validate()) {
					node.execute();
					sleep(General.random(min, max)); // time in between
														// executing nodes
				}
			}
		}
	}

	@Override
	public void onPaint(Graphics g) {
		long timeRan = System.currentTimeMillis() - startTime;
		g.setFont(font);
		g.setColor(new Color(44, 44, 44));
		g.drawString("Runtime: " + Timing.msToString(timeRan), 300, 370);
		g.drawString("Containers Filled: " + FillContainer.TOTAL_COUNT,300,390);
		g.drawString("State: " + Constants.CURRENT_STATE, 300, 410);

		
	}
}
