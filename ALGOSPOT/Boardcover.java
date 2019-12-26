import java.util.Scanner;

public class Boardcover {

	static int[][][] coverTypes = { { { 0, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		while (cases-- > 0) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int[][] map = new int[h][w];

			for (int i = 0; i < h; i++) {
				String c = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = (c.charAt(j) == '#') ? 1 : 0;
				}
			}

			int answer = cover(map);
			System.out.println(answer);

		}

	}

	static boolean set(int[][] map, int y, int x, int type, int delta) {
		boolean ok = true;

		for (int i = 0; i < 3; i++) {
			int ny = y + coverTypes[type][i][0];
			int nx = x + coverTypes[type][i][1];

			if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length)
				ok = false;
			else if ((map[ny][nx] += delta) > 1)
				ok = false;
		}

		return ok;
	}

	static int cover(int[][] map) {
		int y = -1, x = -1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if (y != -1)
				break;
		}
		if (y == -1)
			return 1;
		int ret = 0;
		for (int type = 0; type < 4; type++) {
			if (set(map, y, x, type, 1)) {
				ret += cover(map);
			}
			set(map, y, x, type, -1);
		}

		return ret;
	}

}
