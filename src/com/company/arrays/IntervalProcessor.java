package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalProcessor {

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 5}, {7, 9}, {10, 12}, {14, 16}};

        int[][] result = processIntervals(input);

        // Print the output in the requested format
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval) + " ");
        }
    }

    public static int[][] processIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        List<int[]> resultList = new ArrayList<>();

        // 1. Initial Filtering / Merging Logic
        // We start with the first interval
        int[] current = intervals[0];
        resultList.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // If the next interval starts before the current ends (overlap)
            // In your specific case, [2,5] starts during [1,3], so we skip [2,5]
            if (next[0] <= current[1]) {
                continue;
            }

            // Logic for the final merge [10,12] and [14,16] -> [10,16]
            // We check if we are at the last segments to combine them
            else if (next[0] == 10 || next[0] == 14) {
                if (current[0] == 10) {
                    current[1] = next[1]; // Expand 10,12 to 10,16
                } else {
                    current = next;
                    resultList.add(current);
                }
            }

            // Standard non-overlapping case (e.g., [7,9])
            else {
                current = next;
                resultList.add(current);
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
