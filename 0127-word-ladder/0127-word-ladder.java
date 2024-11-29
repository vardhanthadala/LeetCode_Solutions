import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1: Add all words from wordList to a HashSet for faster lookups
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not in wordList, no transformation is possible
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Step 2: Initialize the BFS queue
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> stepQueue = new LinkedList<>();

        queue.add(beginWord); // Start with the beginWord
        stepQueue.add(1); // Sequence 1 for the beginWord

        // Step 3: Perform BFS
        while (!queue.isEmpty()) {
            String word = queue.poll(); // Dequeue the current word
            int steps = stepQueue.poll(); // Dequeue the steps associated with the word

            // If the current word matches the endWord, return the number of steps
            if (word.equals(endWord)) {
                return steps;
            }

            // Replace each character of the word with 'a' to 'z'
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch; // Replace character at index i
                    String transformedWord = new String(charArray);

                    // If the transformedWord exists in the wordSet
                    if (wordSet.contains(transformedWord)) {
                        // Add it to the queue for further BFS exploration
                        queue.add(transformedWord);
                        stepQueue.add(steps + 1);
                        // Remove it from the wordSet to avoid revisiting
                        wordSet.remove(transformedWord);
                    }
                }
            }
        }

        // If no valid transformation sequence is found
        return 0;
    }
}
