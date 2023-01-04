package top100;

import java.util.*;

public class Top100_621 {

    /**
     * 通过率 61/71,有一定的道理但是找的规律还是有些问题，继续探索。
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {

        // 处理边界问题
        if (n == 0 || tasks == null || tasks.length == 0) {
            return tasks.length;
        }
        Map<Character, Integer> map = new HashMap<>();

        // 每个字母计数，找出字母数量最多的数
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                int count = map.get(tasks[i]);
                map.put(tasks[i], count + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        long max = map.values().stream().max(Integer::compare).get();
        long maxCount = map.values().stream().filter(item -> item == max).count();
        long tmp = (n + 1) * (max - 1) + maxCount;
        return (int) tmp;
    }


    public static void main(String[] args) {
        int n = 2;
        char[] task = {};
        System.out.println(leastInterval(task, n));
    }
}
