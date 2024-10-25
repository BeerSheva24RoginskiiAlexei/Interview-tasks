package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> map = new HashSet<>();
        int i = 0;
        boolean res = false;
        while (!res && i < array.length) {
            if (map.contains(sum - array[i])) {
                res = true;
            }

            map.add(array[i]);
            i++;
        }

        return res;
    }
    static public int getMaxWithNegativePresentation(int [] array) {
        HashSet<Integer> values = new HashSet<>();
        int max = -1;
        for (int num : array) {
            int absNum = Math.abs(num);
            if (values.contains(-num)) {
                max = Math.max(max, absNum);
            }
            values.add(num);
            }
        return max;
    }
public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory, List<LocalDate> dates) {
    List<DateRole> result = new ArrayList<>();
    int roleIndex = 0;
    for (LocalDate date : dates) {
        while (roleIndex < rolesHistory.size() - 1 && rolesHistory.get(roleIndex + 1).date().isBefore(date)) {
            roleIndex++;
        }
        String role = (rolesHistory.get(roleIndex).date().isBefore(date) || rolesHistory.get(roleIndex).date().isEqual(date))
                ? rolesHistory.get(roleIndex).role()
                : null;
        result.add(new DateRole(date, role));
    }
    return result;
}
public static boolean isAnagram(String word, String anagram) {
    boolean isAnagram = true;
    if (word.length() != anagram.length() || word == anagram) {
        isAnagram = false;
    } else {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : anagram.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                isAnagram = false;
                break;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
    }
    return isAnagram;
}
    
}