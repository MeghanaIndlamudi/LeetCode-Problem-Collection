class Solution {
    static String vowels = "aeiou";

    public long countOfSubstrings(String word, int k) {
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        long count = 0;
        int consonants = 0;
        int start = 0;
        int[] vowelSeen = new int[5];
        int tempI = start;
        int increment = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (isVowel(ch)) {
                vowelCount.put(ch, vowelCount.getOrDefault(ch, 0) + 1);
            } else {
                consonants++;
            }

            while (consonants > k) {
                char chRemoved = word.charAt(start++);

                if (isVowel(chRemoved)) {
                    int left = vowelCount.get(chRemoved) - 1;

                    if (left == 0) {
                        vowelCount.remove(chRemoved);
                    } else {
                        vowelCount.put(chRemoved, left);
                    }
                } else {
                    consonants--;
                }

                vowelSeen = new int[5];
                tempI = start;
                increment = 0;
            }

            if (consonants == k && vowelCount.size() == 5) {
                while (true) {
                    char chTemp = word.charAt(tempI);
                    int chIndex = vowels.indexOf(chTemp);

                    if (chIndex == - 1) {
                        count++;
                        break;
                    }

                    increment++;
                    vowelSeen[chIndex]++;

                    if (vowelCount.get(chTemp) == vowelSeen[chIndex]) {
                        increment--;
                        vowelSeen[chIndex]--;
                        count++;
                        break;
                    }

                    tempI++;
                }

                count += increment;
            }
        }

        return count;
    }

    private boolean isVowel(Character ch) {
        return vowels.indexOf(ch) > -1;
    }
}