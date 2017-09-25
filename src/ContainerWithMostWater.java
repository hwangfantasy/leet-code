/**
 * Created by hwangfantasy on 2017/9/25.
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * 题意：在二维坐标系中，(i, ai) 表示 从 (i, 0) 到 (i, ai) 的一条线段，任意两条这样的线段和 x 轴组成一个木桶，找出能够盛水最多的木桶，返回其容积。
 */
public class ContainerWithMostWater {

    //传入的为这些竖线的高度
    public int maxArea(int[] height) {
        if (height.length < 2)
            return 0;
        int area = 0;
        int x = 0;//横坐标
        int xi = height.length - 1;

        while (x < xi) {
            int tempArea = (xi - x) * Math.min(height[x], height[xi]);
            if (tempArea > area)
                area = tempArea;
            if (height[x] < height[xi])
                x++;
            else xi--;
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,5,2,3,7,2,3};

        System.out.println(new ContainerWithMostWater().maxArea(height));
    }
}
