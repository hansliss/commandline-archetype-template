package ${package};

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import gnu.getopt.Getopt;

public class ${mainClass} {
	private String conffilename;
	void run() {

	}

	public void usage(String name) {
		System.err.println("Usage: " + name + " [-c <configuration file>]");
	}

	public ${mainClass}(String[] args) {
		int c;

		Getopt go = new Getopt("${artifactId}", args, "c:");
		while ((c = go.getopt()) != -1) {
			switch (c) {
			case 'c':
				conffilename = go.getOptarg();
				if (!readconf(conffilename)) {
					System.exit(-1);
				}
				break;
			default:
				usage("${artifactId}");
				System.exit(-1);
				break;
			}
		}

	}

	private static List<String> parseList(String ls) {
		List<String> r = new ArrayList<String>();
		for (String s : ls.split(",")) {
			if (s.contains("-")) {
				String[] ivl = s.split("-", 2);
				int start = Integer.parseInt(ivl[0]);
				int end = Integer.parseInt(ivl[1]);
				if (start > end) {
					int t = start;
					start = end;
					end = t;
				}
				for (Integer i = start; i <= end; i++) {
					r.add(i.toString());
				}
			} else {
				r.add(((Integer) Integer.parseInt(s)).toString());
			}
		}
		return r;
	}

	private boolean readconf(String conffilename) {
		Properties config = new Properties();
		InputStream infile;
		try {
			infile = new FileInputStream(conffilename);
			config.load(infile);
			// TODO Fetch parameter values here, and move to instance vars
			// i.e. if bletch is an instance variable used for configuration:
			// bletch = config.getProperty("foo.bar.bletch", bletch);
		} catch (FileNotFoundException e) {
			System.err.println("File " + conffilename + " doesn't exist.");
			return false;
		} catch (IOException e) {
			System.err.println("Error reading configuration from File " + conffilename + ".");
			return false;
		}
		return true;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		${mainClass} cmd = new ${mainClass}(args);
		cmd.run();
	}
}
