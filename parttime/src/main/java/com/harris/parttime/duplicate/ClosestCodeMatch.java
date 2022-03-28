package com.harris.parttime.duplicate;

import org.apache.commons.collections4.map.HashedMap;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * 用于找一组代码文件中最接近的匹配项
	https://blog.csdn.net/u011992422/article/details/106943318/
 */
public class ClosestCodeMatch {
    public static String CompareAll(String[] paths) throws FileNotFoundException {
        Map<String, Double> m = new HashedMap();
        int i = 0;
        double max = 0;
        String resultPath = "";
        for (String path1 : paths) {
            int j = 0;
            for (String path2 : paths) {
                if (i == j) {
                    j++;
                    continue;
                }
                CompareFile file = new CompareFile();
                double tmp = file.CompareTwo(path1, path2);
                if (tmp > max) {
                    max = tmp;
                }
                String path = path1 + " " + path2;
                m.put(path, tmp);
                j++;
            }
            i++;
        }
        for (Map.Entry<String, Double> entry1 : m.entrySet()) {
            if (entry1.getValue().equals(max)) {
                resultPath = entry1.getKey();
            }
        }
        return resultPath;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path1 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup.java";
        String path2 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup1.java";
        String path3 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup2.java";
        String[] paths = {path1, path2, path3};
        CompareAll(paths);
        return;
    }
}
