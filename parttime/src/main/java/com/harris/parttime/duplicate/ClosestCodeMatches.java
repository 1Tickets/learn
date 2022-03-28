package com.harris.parttime.duplicate;

import org.apache.commons.collections4.map.HashedMap;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Vector;

/**
 * 找出每个代码文件最相似接近的文件
 */
public class ClosestCodeMatches {
    public static Vector<String> CompareEach(String[] paths) throws FileNotFoundException {
        int i = 0;
        Vector<String> vet = new Vector<String>();
        for (String path1 : paths) {
            int j = 0;
            double max = 0;
            Map<String, Double> m = new HashedMap();
            for (String path2 : paths) {
                if (i == j) {
                    j++;
                    continue;
                }
                CompareFile file = new CompareFile();
                double tmp = file.CompareTwo(path1, path2);
                if (tmp > max) {
                    max = tmp;
                    String path = path1 + " " + path2;
                    m.put(path, tmp);
                }
                j++;
            }
            for (Map.Entry<String, Double> entry1 : m.entrySet()) {
                if (entry1.getValue().equals(max)) {
                    String resultPath = entry1.getKey();
                    vet.add(resultPath);
                }
            }
            i++;
        }
        return vet;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path1 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup.java";
        String path2 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup1.java";
        String path3 = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest\\TurtleSoup2.java";
        String[] paths = {path1, path2, path3};
        CompareEach(paths);
        return;
    }
}
