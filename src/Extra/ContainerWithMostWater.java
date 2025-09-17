package Extra;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            max = Math.max(max, area);

            //Main game changer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}

//Optimised solution as well
class Solution {
    public static int maxArea(int[] height) {

        int maxSizeContainer=0;
        int l=0,r=height.length-1;

        while(l<r){
            int currH= Math.min(height[l],height[r]);
            int area = (r-l)*currH;
            maxSizeContainer= Math.max(maxSizeContainer,area);

            while(l<r && height[l]<=currH) l++;
            while(l<r && height[r]<=currH) r--;
        }

        return maxSizeContainer;

    }
}