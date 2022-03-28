package com.harris.parttime.duplicate;

import org.apache.commons.collections4.map.HashedMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * 使用Scanner 实现文件的读取并分单词
 */
public class CodeFile {
    public static Map<String, Integer> ReadFile(String path) throws FileNotFoundException {
        Map<String, Integer> map = new HashedMap();
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] chars = str.split("[  . ,]");
            for (String ch : chars) {
                if (isCharacter(ch.toLowerCase())) {
                    if (map.containsKey(ch.toLowerCase())) {
                        map.put(ch.toLowerCase(), map.get(ch.toLowerCase()) + 1);
                    } else {
                        map.put(ch.toLowerCase(), 1);
                    }
                }
            }
        }
        return map;
    }


    public static boolean isCharacter(String str) {
        if (null == str || str.trim().equals("")) {
            return false;
        }
        String regex = "^[a-z]+$";
        return str.matches(regex);
    }


}
