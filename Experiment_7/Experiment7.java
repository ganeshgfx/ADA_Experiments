package Experiment_7;
import java.util.Arrays;
class Experiment7{	
	static int minCoins(int n, int coins[], int ram[]) {
		if(n == 0) return 0;
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<coins.length; i++) {
			if(n-coins[i] >= 0) {
				int subAns = 0;
				if(ram[n-coins[i]] != -1) {
					subAns = ram[n-coins[i]];
				} else {
					subAns = minCoins(n-coins[i], coins, ram);
				}
				if(subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		ram[n] = ans;
		return ans;
	}
	public static void main(String[] args) {
		int n = 8  ;
		int coins[] = {1, 2, 5, 10};
		int ram[] = new int[n+1];
		Arrays.fill(ram, -1);
		ram[0] = 0;
		int ans = minCoins(n, coins, ram);
		System.out.println("\n"+ans+" Coins required"+"\n");
	}
}