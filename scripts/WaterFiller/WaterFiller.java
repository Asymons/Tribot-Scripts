package scripts.WaterFiller;

import java.util.ArrayList;
import java.util.Collections;

import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

import scripts.ProgressiveMiner.api.Node;
import scripts.WaterFiller.data.Constants;
import scripts.WaterFiller.nodes.FillContainer;
import scripts.WaterFiller.nodes.GUI;
import scripts.WaterFiller.nodes.WalkToBank;

@ScriptManifest(authors = { "Xero" }, category = "Money", name = "WaterFiller")
public class WaterFiller extends Script {
	public static ArrayList<Node> nodes = new ArrayList<>();
	GUI frame = new GUI();
	public boolean first = true;

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
		if(onStart(first)){
			if(frame.getButton(frame.BowlButton)){
				Constants.setItem(Constants.Items.BOWL, Constants.Items.FILLED_BOWL);
			}else if(frame.getButton(frame.JugButton)){
				
			}else if(frame.getButton(frame.BucketButton)){
				
			}
		}

//		if (!frame.isVisible()) {
			Collections.addAll(nodes, new FillContainer(), new WalkToBank());
			println("ayylmao");
//		}
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
}
