package top100;

import java.util.*;

public class Top100_621 {

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
        List<Character> result = new LinkedList<>();
        Set<Character> keyset = map.keySet();
        while (!map.isEmpty()) {
            keyset.forEach(item -> {
                // 如果map中还有这个元素，将其取出，放置在结果集
                if (map.containsKey(item)) {
                    int count = map.get(item);
                    if (count == 0) {
                        map.remove(item);
                    } else {
                        result.add(item);
                    }
                }else{// 如果结果集中没有该字母了，名

                }
            });
        }

        int max = map.values().stream().max(Integer::compare).get();
        int tmp = (n + 1) * (max - 1);
        return 0;
    }


    public static void main(String[] args) {
        int n = 2;
        char[] task = {};
        System.out.println(leastInterval(task, n));
    }
}
