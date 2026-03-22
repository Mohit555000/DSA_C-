//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//https://www.youtube.com/watch?v=HZOUwKCKF5o
import java.util.*;

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        
        // Edge case
        if (n == 0) return 0;

        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        // Safe sorting
        Arrays.sort(meetings, (a, b) -> Integer.compare(a.end, b.end));

        int count = 1;
        int lastEnd = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > lastEnd) {
                count++;
                lastEnd = meetings[i].end;
            }
        }

        return count;
    }
}