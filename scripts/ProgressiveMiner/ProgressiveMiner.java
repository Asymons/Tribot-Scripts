package scripts.ProgressiveMiner;

import java.util.ArrayList;
import java.util.Collections;

import org.tribot.api.General;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;

import scripts.ProgressiveMiner.api.Node;
import scripts.ProgressiveMiner.nodes.DropOre;
import scripts.ProgressiveMiner.nodes.MineOre;

@ScriptManifest(authors = { "Xero" }, category = "Mining", name = "ProgressiveMiner")
public class ProgressiveMiner extends Script{
	public static ArrayList<Node> nodes = new ArrayList<>();
	 
	@Override
	public void run() {
		Collections.addAll(nodes, new MineOre(), new DropOre());
		loop(20, 40);
	}

	private void loop(int min, int max) {
		while (true) {
			for (final Node node : nodes) {
				if (node.validate()) {
					node.execute();
					sleep(General.random(min, max));	//time in between executing nodes
				}
			}
		}
	}
}
