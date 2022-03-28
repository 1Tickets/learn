package com.harris.parttime.duplicate;

import org.apache.commons.collections4.map.HashedMap;

import org.apache.http.util.TextUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LabClosestMatches {
    public static Map<String, List<String>> pathMap;
    public static Map<Double, String> resultMap;

    public static void closestCodes(String path, String fileNameMatches) throws FileNotFoundException {
        resultMap = new HashedMap();
        pathMap = new HashedMap();
        File file = new File(path);
        String[] names = file.list();
        for (String name : names) {
            String pname = path + "\\" + name;
            findTargetFile(name, pname, fileNameMatches);
        }

        int count = 0;
        for (Map.Entry<String, List<String>> entry : pathMap.entrySet())//合并某位同学的所有java文件
        {
            String p = "D:\\test\\" + entry.getKey() + ".txt";
            List<String> list = entry.getValue();
            int s = list.size();
            String[] f = new String[s];
            for (String item : list) {
                f[count] = item;
                count++;
            }
            mergeFiles(f, p);
            count = 0;
        }

        int i = 0;
        String head = "D:\\test\\";
        File f = new File(head);
        String[] paths = f.list();
        for (String path1 : paths) {
            int j = 0;
            for (String path2 : paths) {
                if (i == j) {
                    j++;
                    continue;
                }
                CompareFile tempfile = new CompareFile();
                double tmp = tempfile.CompareTwo(head + path1, head + path2);
                String finalpath = path1 + "   " + path2;
                resultMap.put(tmp, finalpath);
                j++;
            }
            i++;
        }
        return;
    }


    public static void findTargetFile(String projectName, String pname, String fileNameMatches) {
        File file = new File(pname);
        while (!file.isFile()) {
            String[] names = file.list();
            for (String name : names) {
                if (pname.indexOf("~") == -1) {
                    String tname = pname + "\\" + name;
                    findTargetFile(projectName, tname, fileNameMatches);
                }
            }
            return;
        }
        if (pname.indexOf(fileNameMatches) != -1) {

            if (pathMap.containsKey(projectName)) {
                List<String> list = pathMap.get(projectName);
                list.add(pname);
                pathMap.put(projectName, list);
            } else {
                List<String> list = new LinkedList<>();
                list.add(pname);
                pathMap.put(projectName, list);
            }
        } else {
            return;
        }
    }

    public static boolean mergeFiles(String[] fpaths, String resultPath) {
        if (fpaths == null || fpaths.length < 1 || TextUtils.isEmpty(resultPath)) {
            return false;
        }
        if (fpaths.length == 1) {
            return new File(fpaths[0]).renameTo(new File(resultPath));
        }

        File[] files = new File[fpaths.length];
        for (int i = 0; i < fpaths.length; i++) {
            files[i] = new File(fpaths[i]);
            if (TextUtils.isEmpty(fpaths[i]) || !files[i].exists() || !files[i].isFile()) {
                return false;
            }
        }

        File resultFile = new File(resultPath);

        try {
            FileChannel resultFileChannel = new FileOutputStream(resultFile, true).getChannel();
            for (int i = 0; i < fpaths.length; i++) {
                FileChannel blk = new FileInputStream(files[i]).getChannel();
                resultFileChannel.transferFrom(blk, resultFileChannel.size(), blk.size());
                blk.close();
            }
            resultFileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\JavaLearning\\lab3-2020\\lab1-codes-fortest";
        String fileNameMatches = ".java";
        closestCodes(path, fileNameMatches);
        String fileName = "D:\\result.txt";//最终输出路径
        try {
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            String head = "相似度              子目录1              子目录2\r\n";
            randomFile.write(head.getBytes());
            // 文件长度，字节数
            for (Map.Entry<Double, String> entry : resultMap.entrySet()) {
                String content = entry.getKey() + "   " + entry.getValue();
                long fileLength = randomFile.length();
                randomFile.seek(fileLength);
                randomFile.write(content.getBytes());
                randomFile.write(" ".getBytes());
                randomFile.write("\r\n".getBytes());
            }
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
