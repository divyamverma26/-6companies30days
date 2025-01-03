import java.util.Arrays;

public class One {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ind = nums.length / 2;
        int ans = 0;
        for (int i : nums) {
            ans += Math.abs(i - nums[ind]);
        }
        return ans;
    }

    public int findTheWinner(int n, int k) {
        int win = 0;
        for (int i = 1; i <= n; i++) {
            win = (win + k) % i;
        }
        return win + 1;
    }

    public boolean checkOverlap(int radius, int x, int y, int x1, int y1, int x2, int y2) {
        int dist = 0;
        if (y >= y1 && y <= y2) {
            if (x >= x1 && x <= x2)
                return true;
            else {
                dist = Math.min((x1 - x) * (x1 - x), (x2 - x) * (x2 - x));
            }
        } else if (x >= x1 && x <= x2) {
            dist = Math.min((y1 - y) * (y1 - y), (y2 - y) * (y2 - y));
        } else {
            int a = (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
            int b = (x1 - x) * (x1 - x) + (y2 - y) * (y2 - y);
            int c = (x2 - x) * (x2 - x) + (y1 - y) * (y1 - y);
            int d = (x2 - x) * (x2 - x) + (y2 - y) * (y2 - y);
            dist = Math.min(Math.min(a, b), Math.min(c, d));
        }
        return (double) Math.sqrt(dist) <= radius;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}