import java.util.*;

public class Two {
    public int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (mp.containsKey(sum - k)) {
                ans += mp.get(sum - k);
            }
            if (mp.containsKey(sum)) {
                mp.put(sum, mp.get(sum) + 1);
            } else {
                mp.put(sum, 1);
            }
        }
        return ans;
    }

    public String getHint(String secret, String guess) {
        char a[] = secret.toCharArray();
        char b[] = guess.toCharArray();
        Map<Character, Integer> st1 = new HashMap<>();
        Map<Character, Integer> st2 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            char x = a[i];
            char y = b[i];
            st1.put(x, st1.getOrDefault(x, 0) + 1);
            st2.put(y, st2.getOrDefault(y, 0) + 1);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                bulls++;
                st1.put(a[i], st1.get(a[i]) - 1);
                st2.put(a[i], st2.get(a[i]) - 1);
                if (st1.get(a[i]) == 0)
                    st1.remove(a[i]);
                if (st2.get(a[i]) == 0)
                    st2.remove(a[i]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (st1.containsKey(b[i])) {
                    cows++;
                    if (st1.get(b[i]) == 1) {
                        st1.remove(b[i]);
                        st2.remove(b[i]);
                    } else {
                        st1.put(b[i], st1.get(b[i]) - 1);
                        st2.put(b[i], st2.get(b[i]) - 1);
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(bulls);
        ans.append('A');
        ans.append(cows);
        ans.append('B');
        return ans.toString();
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> al = new ArrayList<>();
        if (s.length() < 10)
            return al;
        Map<String, Integer> mp = new HashMap<>();
        StringBuilder st = new StringBuilder(s.substring(0, 10));
        mp.put(st.toString(), 1);
        for (int i = 10; i < s.length(); i++) {
            st.deleteCharAt(0);
            st.append(s.charAt(i));
            mp.put(st.toString(), mp.getOrDefault(st.toString(), 0) + 1);
        }
        for (String k : mp.keySet()) {
            if (mp.get(k) > 1)
                al.add(k);
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
