package com.lyh.day8;

import java.util.*;

public class HashMapCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String article = scanner.nextLine();

        // 1. 清洗数据：去除非字母字符并转小写
        String cleanStr = article.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // 2. 切割单词并统计
        HashMap<String, Integer> wordMap = new HashMap<>();
        String[] words = cleanStr.split(" +"); // 处理多个空格

        for (String word : words) {
            if (!word.isEmpty()) { // 过滤空字符串
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // 3. 转换为List并排序
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // 降序排列

        // 4. 格式化输出
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
