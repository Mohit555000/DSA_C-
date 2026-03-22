//https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
//https://www.youtube.com/watch?v=HZOUwKCKF5o
import java.util.*;

class Meeting {
    int start;
    int end;
    int index;

    Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        
        ArrayList<Integer> result = new ArrayList<>();
        if (N == 0) return result;

        Meeting[] meetings = new Meeting[N];

        // Store meetings with index (1-based)
        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(S[i], F[i], i + 1);
        }

        // Sort by end time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));

        // Select first meeting
        result.add(meetings[0].index);
        int lastEnd = meetings[0].end;

        // Greedy selection
        for (int i = 1; i < N; i++) {
            if (meetings[i].start > lastEnd) {
                result.add(meetings[i].index);
                lastEnd = meetings[i].end;
            }
        }
        Collections.sort(result);

        return result;
    }
}