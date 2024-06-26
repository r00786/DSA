package com.example.programs;

import java.util.Arrays;

public class MaxMeetingRoomsRequired {
    public static void main(String arr[]) {
        int[][] meetingTimes = new int[][]{
                {0, 10},
                {5, 20},
                {15, 40}
        };
        System.out.print(new MaxMeetingRoomsRequired().maxEvents(meetingTimes));

    }

    public int maxEvents(int[][] events) {
        int[] startTimes = new int[events.length];
        int[] endTimes = new int[events.length];
        for(int i=0;i<events.length;i++){
            startTimes[i]=events[i][0];
        }
        for(int i=0;i<events.length;i++){
            endTimes[i]=events[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int maxRoomsRequired = 1;
        int currentRooms = 0;
        int  j = 0;
        for (int i = 0; i < startTimes.length; i++) {
            if (startTimes[i] < endTimes[j]) {
                currentRooms+=1;
            } else {
                currentRooms-=1;
                j++;
            }
            maxRoomsRequired = Math.max(currentRooms, maxRoomsRequired);

        }


        return maxRoomsRequired;
    }


}
