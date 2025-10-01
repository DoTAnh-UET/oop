import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int n = str.length();
        if (n == 0) {
            return 0;
        }
        char cur = str.charAt(0);
        int curRun = 1;
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (str.charAt(i) == cur) {
                ++curRun;
            } else {
                cur = str.charAt(i);
                curRun = 1;
            }
            ans = Math.max(ans, curRun);
        }
        return ans;
    }


    /**
     * "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        int n = str.length();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                if (i + 1 < n) {
                    for (int j = 0; j < str.charAt(i) - '0'; ++j) {
                        s.append(str.charAt(i + 1));
                    }
                }
            } else {
                s.append(str.charAt(i));
            }
        }
        return s.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        int n = a.length();
        int m = b.length();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= n - len; ++i) {
            set.add(a.substring(i, i + len));
        }
        for (int j = 0; j <= m - len; ++j) {
            if (set.contains(b.substring(j, j + len))) {
                return true;
            }
        }
        return false;
    }
}
