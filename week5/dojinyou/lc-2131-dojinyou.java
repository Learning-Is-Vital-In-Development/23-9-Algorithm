import java.util.HashMap;
import java.util.Map;

public class LongestPalindromebyConcatenatingTwoLetterWords {

	public int longestPalindrome(String[] words) {
		var result = 0;
		Map<String, Integer> wordSet = new HashMap<>();
		var countDuplicatedCharacters = 0;

		for(var word: words) {
			var isDuplicatedCharacters = word.charAt(0) == word.charAt(1);

			var reversedWord = String.copyValueOf(new char[] {word.charAt(1), word.charAt(0)});
			if (wordSet.containsKey(reversedWord) && wordSet.get(reversedWord) > 0) {
				result += 4;
				wordSet.put(reversedWord, wordSet.get(reversedWord) - 1);
				if (isDuplicatedCharacters) countDuplicatedCharacters--;
				continue;
			}

			wordSet.put(word, wordSet.getOrDefault(word, 0) + 1);
			if (isDuplicatedCharacters) countDuplicatedCharacters++;
		}

		if (countDuplicatedCharacters > 0) result += 2;

		return result;
	}
}
