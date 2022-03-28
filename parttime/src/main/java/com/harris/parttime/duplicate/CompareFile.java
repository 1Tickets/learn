package com.harris.parttime.duplicate;

import java.io.FileNotFoundException;
import java.util.Map;

import static java.lang.Math.sqrt;

/**
 * 用来实现余弦的计算过程与比较
 */
public class CompareFile {
    public static double CompareF(String path1, String path2) throws FileNotFoundException {
        CodeFile cf1 = new CodeFile();
        CodeFile cf2 = new CodeFile();
        Map<String, Integer> map1 = cf1.ReadFile(path1);
        Map<String, Integer> map2 = cf2.ReadFile(path2);
        double molecule = 0;
        double Denominator = 0;
        double Denominator1 = 0;
        double Denominator2 = 0;
        int i = 0;
        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            int j = 0;
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
                if (entry1.getKey().equals(entry2.getKey()) && i == j) {
                    molecule += entry1.getValue() * entry2.getValue() * 2;
                } else if (entry1.getKey().equals(entry2.getKey())) {
                    molecule += entry1.getValue() * entry2.getValue();
                }
                j++;
            }
            i++;
        }
        molecule = molecule / 2;

        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            Denominator1 += entry1.getValue() * entry1.getValue();
        }
        for (Map.Entry<String, Integer> entry2 : map2.entrySet()) {
            Denominator2 += entry2.getValue() * entry2.getValue();
        }
        Denominator = sqrt(Denominator1 * Denominator2);

        return molecule / Denominator;
    }

    public static double CompareTwo(String path1, String path2) throws FileNotFoundException {
        double result = CompareF(path1, path2);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        CompareTwo("D:\\JavaLearning\\test1.txt", "D:\\JavaLearning\\test2.txt");
        return;
    }

}
