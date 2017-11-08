
package nd4j_plugin;

import net.imagej.ImageJ;

import org.nd4j.linalg.factory.Nd4j;
import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = "Plugins>ND4J Plugin")
public class ND4JPlugin implements Command {

	@Parameter(type = ItemIO.OUTPUT)
	private Object result;

	@Override
	public void run() {
		System.setProperty("org.bytedeco.javacpp.logger.debug", "true");
		System.out.println("Creating ND4J thing");
		result = Nd4j.create(1, 100);
		System.out.println("Created ND4J thing");
	}

	public static void main(String... args) {
		final ImageJ ij = new ImageJ();
		ij.launch(args);
		ij.command().run(ND4JPlugin.class, true);
	}
}
