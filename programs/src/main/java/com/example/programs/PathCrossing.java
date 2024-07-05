package com.example.programs;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * Example 2:
 *
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 104
 * path[i] is either 'N', 'S', 'E', or 'W'.
 */

public class PathCrossing {
    public static void main(String[] arr){
        System.out.println(new PathCrossing().isPathCrossing("NSEW"));
    }

        public boolean isPathCrossing(String path) {
            Set<String> uniquePoints= new HashSet();
            int xCord=0;
            int yCord=0;
            String point= xCord+","+yCord;
            uniquePoints.add(point);
            for(int i=0;i<path.length();i++){
                switch(path.charAt(i)){
                    case 'N':
                        yCord++;
                        break;
                    case 'S':
                        yCord--;
                        break;
                    case 'E':
                        xCord++;
                        break;
                    default:
                        xCord--;
                        break;
                }
                String uniqueCordKey=xCord+","+yCord;
                if(uniquePoints.contains(uniqueCordKey)){
                    return true;
                }
                uniquePoints.add(uniqueCordKey);
            }
            return false;
        }

}
