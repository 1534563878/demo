package com.zyq.demo.test;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        System.out.println(nowTime());
    }
    public static String nowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String updateTime = simpleDateFormat.format(new Date());
        return updateTime;
    }
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                else{
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
class Test{
    public static void main(String[] args) {
        Map<String , Integer> map = Maps.newHashMap();
        if (map.size()<40_00){
            System.out.println("是");
        }
        Pair<String, String> pair = Pair.of("aku", "female");

    }
}









