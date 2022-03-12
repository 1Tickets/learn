package com.harris.test;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 两数之和<力扣第一题>
 * @date 2022/2/17 12:31
 * <p>给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * </p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * </p>
 */
public class TwoSumDemo {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		//int[] indexs = twoSum1(nums, target);
		int[] indexs = twoSum2(nums, target);
		for (int index : indexs) {
			System.out.println(index);
		}
	}

	/**
	 * 暴力破解
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				// 判断数组元素相加是否等于目标值
				if ((nums[i] + nums[j]) == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{};
	}

	/**
	 * 利用HashMap 查找
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// 利用目标值从头开始循环减去数组元素值
			int num = target - nums[i];
			if (hashMap.containsKey(num)) {
				Integer firstIndex = hashMap.get(num);
				return new int[]{firstIndex, i};
			}
			hashMap.put(nums[i], i);
		}
		return new int[]{};
	}

}
