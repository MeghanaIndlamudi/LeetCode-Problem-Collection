class Solution {
    private String build(StringBuilder left, int[] cnt, char mid) {
        StringBuilder half = new StringBuilder(left);

        for (int c = 25; c >= 0; --c) {
            for (int j = 0; j < cnt[c]; ++j)
                half.append((char) ('a' + c));
        }

        StringBuilder res = new StringBuilder(half);

        if (mid != 0)
            res.append(mid);

        res.append(new StringBuilder(half).reverse());

        return res.toString();
    }

    public String lexPalindromicPermutation(
        String s,
        String target
    ) {
        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int odd = 0;
        char mid = 0;

        for (int c = 0; c < 26; ++c) {
            if ((cnt[c] & 1) != 0) {
                odd++;
                mid = (char) ('a' + c);
            }
        }

        if (odd > 1)
            return "";

        int[] halfCnt = new int[26];

        for (int c = 0; c < 26; ++c)
            halfCnt[c] = cnt[c] / 2;

        String calendrix = s;

        int m = s.length() / 2;
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < m; ++i) {
            boolean found = false;

            for (int c = 0; c < 26; ++c) {
                if (halfCnt[c] == 0)
                    continue;

                halfCnt[c]--;
                left.append((char) ('a' + c));

                if (build(left, halfCnt, mid).compareTo(target) > 0) {
                    found = true;
                    break;
                }

                left.deleteCharAt(left.length() - 1);
                halfCnt[c]++;
            }

            if (!found)
                return "";
        }

        StringBuilder ans = new StringBuilder(left);

        if (mid != 0)
            ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString().compareTo(target) > 0
            ? ans.toString()
            : "";
    }
}