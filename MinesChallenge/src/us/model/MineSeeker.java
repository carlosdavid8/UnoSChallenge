package us.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import us.util.LoadUtil;

public class MineSeeker {
	int max = 1;
	boolean activated = false;

	public int calculateMaximumExplosion(ArrayList<Integer> list) throws IOException {

		
		// checking that the coordinates are well format
		if (!(list.size() % 3 == 0)) {
			throw new IllegalArgumentException("Please include only numbers in the format \n (x,  y,  r) - "
					+ "where x is x coordinate, y is y coordinate and r is blast radius, Example:\r\n" + "  1   2  53"
					+ "\r\n" + "-32  40 100\r\n" + " 10  15  25\r\n" + "-15 -15 200\n");
		}
		ArrayList<Mine> mineList = new ArrayList<Mine>();
		// obtaining and ArrayList of Mine objects
		for (int i = 0; i < list.size(); i += 3) {
			Mine mine = new Mine();
			mine.setX(list.get(i));
			mine.setY(list.get(i + 1));
			mine.setBlastRadius(list.get(i + 2));
			mine.setExploted(false);
			mineList.add(mine);
		}

		if (mineList.size() > 1) {
			/*
			 * Due to the compare Method was override in Mine, now we will obtain a Mine
			 * ArrayList ordered by BlastRadios
			 */
			Collections.sort(mineList);
			int total = exploidCount(mineList);
			System.out.println("\nMaximal number of mines exploited: " + total);
			if(!activated) {
				System.out.println("There was not Chain reaction");
			}
		} else {
			System.out.println("please put more than 1 Mine in the File");
		}
	return max;

	}

	int exploidCount(ArrayList<Mine> m) {
		Exploder e = new Exploder();

		Mine pivot = new Mine();
		pivot.setX(m.get(0).getX());
		pivot.setY(m.get(0).getY());
		pivot.setBlastRadius(m.get(0).getBlastRadius());

		m.remove(0);

		for (int i = 0; i < m.size(); i++) {

			if (m.get(i).isExploted())
				continue;

			if (e.mine_exploded((float) pivot.getX(), (float) pivot.getY(), (float) pivot.getBlastRadius(),
					(float) m.get(i).getX(), (float) m.get(i).getY())) {
				if (!activated) {
					activated = true;
					System.out.println("The Mine exploited manually is: (" + pivot.getX() + ", " + pivot.getY() + ", "
							+ pivot.getBlastRadius() + ")\n");
					System.out.println("Chain Reaction");
				}
				System.out.println("Mine (" + pivot.getX() + ", " + pivot.getY() + ", " + pivot.getBlastRadius()
						+ ") exploded the Mine: (" + m.get(i).getX() + ", " + m.get(i).getY() + ", "
						+ m.get(i).getBlastRadius() + ")");

				max++;

				m.get(i).setExploted(true);

			}
		}
		if (m.size() >= 2) {
			/*
			 * hey we have a Recursion technique!!!!
			 */
			this.exploidCount(m);
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		LoadUtil load = new LoadUtil();
		// loading the information from file
		myList = load.loadInfoFromFile("src/mines.txt");
		MineSeeker seek = new MineSeeker();
		seek.calculateMaximumExplosion(myList);

	}

}

final class Exploder {

	boolean mine_exploded(Float x1, Float y1, Float r, Float x2, Float y2) {

		return r >= Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

	}

}