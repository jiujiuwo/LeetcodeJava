package top100;

import java.util.*;

public class Top100_621 {

    /**
     * 通过率 61/71,有一定的道理但是找的规律还是有些问题，继续探索。
     *
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
        return (int) Math.max(tmp, tasks.length);
    }

    /**
     * 通过率 100%
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval1(char[] tasks, int n) {
        //统计每个任务出现的次数，找到出现次数最多的任务
        int[] hash = new int[26];
        for(int i = 0; i < tasks.length; ++i) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        //因为相同元素必须有n个冷却时间，假设A出现3次，n = 2，任务要执行完，至少形成AXX AXX A序列（X看作预占位置）
        //该序列长度为
        int minLen = (n+1) *  (hash[25] - 1) + 1;

        //此时为了尽量利用X所预占的空间（贪心）使得整个执行序列长度尽量小，将剩余任务往X预占的空间插入
        //剩余的任务次数有两种情况：
        //1.与A出现次数相同，比如B任务最优插入结果是ABX ABX AB，中间还剩两个空位，当前序列长度+1
        //2.比A出现次数少，若还有X，则按序插入X位置，比如C出现两次，形成ABC ABC AB的序列
        //直到X预占位置还没插满，剩余元素逐个放入X位置就满足冷却时间至少为n
        for(int i = 24; i >= 0; --i){
            if(hash[i] == hash[25]) ++ minLen;
        }
        //当所有X预占的位置插满了怎么办？
        //在任意插满区间（这里是ABC）后面按序插入剩余元素，比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件
        //因此，当X预占位置能插满时，最短序列长度就是task.length，不能插满则取最少预占序列长度
        return Math.max(minLen, tasks.length);
    }

    public static void main(String[] args) {
        int n = 2;
        char[] task = {};
        System.out.println(leastInterval(task, n));
    }
}
