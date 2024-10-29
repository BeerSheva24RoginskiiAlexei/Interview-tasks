package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
        TreeMap<LocalDate, String> roleMap = new TreeMap<>();

        for (DateRole role : rolesHistory) {
            roleMap.put(role.date(), role.role());
        }

        List<DateRole> result = new ArrayList<>();
        for (LocalDate date : dates) {
            LocalDate floorDate = roleMap.floorKey(date);
            String role = (floorDate != null) ? roleMap.get(floorDate) : null;
            result.add(new DateRole(date, role));
        }

        return result;
    }

    public static boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length() || word.equals(anagram)) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        
        word.chars().forEach(c -> charCount.merge((char) c, 1, Integer::sum));
        
        for (char c : anagram.toCharArray()) {
            charCount.merge(c, -1, Integer::sum);
            if (charCount.get(c) < 0) { 
                return false;
            }
        }

        return charCount.values().stream().allMatch(count -> count == 0);
    }
    
}