import java.io.*;
import java.util.Scanner;

public class Tester {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		int idList[] = null;
		double xList[] = null;
		double yList[] = null;

		File file = new File("C:\\Users\\anujp\\Desktop\\dj38.tsp.txt");
		// FileReader in = new FileReader (file);
		Scanner in;

		in = new Scanner(file);
		int count = 0;
		int DIMENSION = 0;
		boolean canRecord = false;
		while (in.hasNextLine()) {
			String nextLine = in.nextLine();
			// System.out.println(nextLine);
			String[] fields = nextLine.split(" ");
			if (fields[0].startsWith("DIMENSION")) {
				DIMENSION = Integer.parseInt(fields[1].trim());
				idList = new int[DIMENSION];
				xList = new double[DIMENSION];
				yList = new double[DIMENSION];
			} else if (nextLine.startsWith("NODE_COORD_SECTION")) {
				canRecord = true;
				continue;
			} else if (nextLine.startsWith("EOF")) {
				canRecord = false;
				break;
			}

			if (canRecord) {
				idList[count] = Integer.parseInt(fields[0].trim());
				xList[count] = Double.parseDouble(fields[1].trim());
				yList[count] = Double.parseDouble(fields[2].trim());
				;
				count++;
			}
		}
		for (int i = 0; i < idList.length; i++) {
			City city = new City(idList[i], xList[i], yList[i]);
			Repository.addCity(city);
		}

		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.Stimulation();
		System.out.println
		("Best Approximated distance: " + sa.getBest().getDistance());
		System.out.println("Tour ID: " + sa.getBest());
	
	}
}
