package com.hsalkade.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {

//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//		List<String> genes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//				.collect(Collectors.toList());
//
//		List<Integer> health = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//				.map(Integer::parseInt).collect(Collectors.toList());
//
//		int s = Integer.parseInt(bufferedReader.readLine().trim());
//
//		final int[] output = { 0, 0 };
//		IntStream.range(0, s).forEach(sItr -> {
//			try {
//				String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//				int first = Integer.parseInt(firstMultipleInput[0]);
//
//				int last = Integer.parseInt(firstMultipleInput[1]);
//
//				String d = firstMultipleInput[2];
//
//				int totHealth = getHealth(genes.subList(first, last), health.subList(first, last), d);
//				System.out.println("Total Health = " + totHealth);
//				output[0] = Math.min(totHealth, output[0]);
//				output[1] = Math.max(totHealth, output[1]);
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//		System.out.println(output[0] + " " + output[1]);
//		bufferedReader.close();

		List<Integer> arr = Arrays.asList(1, 1, 0, -1, -2);
		int[] counts = new int[3];
		arr.forEach(item -> {
			if (item == 0) {
				counts[2] = counts[2] + 1;
			} else if (item > 0) {
				counts[0] = counts[0] + 1;
			} else {
				counts[1] = counts[1] + 1;
			}
		});
		for (int i = 0; i < counts.length; i++) {
			System.out.println(String.format("%.6f", (double) counts[i] / arr.size()));
		}

		System.out.println(timeConversion("07:05:45PM"));
	}

	public static String timeConversion(String s) {
		// Write your code here
		String hourStr = s.substring(0, 2);
		int hour = Integer.parseInt(hourStr);
		if (s.endsWith("AM")) {
			if (hour == 12) {
				return s.replaceFirst(hourStr, "00").substring(0, 8);
			}
			return s.substring(0, 8);
		}

		if (hour == 12) {
			return s.substring(0, 8);
		}
		return s.replaceFirst(hourStr, String.valueOf(hour + 12)).substring(0, 8);
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here

		return grades.stream().map(grade -> {
			if (grade > 38) {
				return grade + 3;
			} else {
				return grade;
			}
		}).collect(Collectors.toList());
	}

	public static int getHealth(List<String> genes, List<Integer> health, String d) {
		int count = 0;
		for (int i = 0; i < genes.size(); i++) {
			String gene = genes.get(i);

			int index = -1;
			while (true) {
				index = d.indexOf(gene, index + 1);
				if (index == -1) {
					break;
				}
				count = count + health.get(i);
			}
		}
		return count;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * /* int[] arr = { 0, 3, 4 }; int[] arr2 = { 4, 6, 30 };
	 * 
	 * int[] output = mergeSortedArrays(arr, arr2);
	 * System.out.println(Arrays.toString(output));
	 * 
	 * int[] rotateArr = { 1, 2, 3, 4, 5, 6, 7 }; rotate(rotateArr, 4);
	 * 
	 * int[] nums = { 0, 1, 0, 0, 3, 12 }; moveZeroes(nums);
	 * 
	 * int[] nums1 = { 1, 2, 3, 4 }; System.out.println(containsDuplicate(nums1));
	 */

	/*
	 * List<Integer> arr = Arrays.asList(256741038, 623958417, 467905213, 714532089,
	 * 938071625); miniMaxSum(arr);
	 */

	/*
	 * assert
	 * 
	 * alternatingCharacters("AAAA") == 3;
	 * 
	 * assert alternatingCharacters("BBBBB") == 4; assert
	 * alternatingCharacters("ABABABAB") == 0; assert
	 * alternatingCharacters("BABABA") == 0; assert alternatingCharacters("AAABBB")
	 * == 4;
	 * 
	 * assert theLoveLetterMystery("abc") == 2; assert theLoveLetterMystery("abcba")
	 * == 0; assert theLoveLetterMystery("abcd") == 4; assert
	 * theLoveLetterMystery("cba") == 2; }
	 */

	public static int[] twoSum(int[] nums, int target) {
		int[] rem = new int[nums.length];
		int[] output = new int[2];

		for (int i = 0; i < nums.length; i++) {
			rem[i] = target - nums[i];
		}

		return output;

	}

	public static boolean containsDuplicate(int[] nums) {

		int orResult = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & orResult) > 0) {
				return true;
			}
			orResult = nums[i] | orResult;
		}
		return false;
	}

	public static void moveZeroes(int[] nums) {

		int shiftIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				shiftIndex++;
			} else {
				nums[i - shiftIndex] = nums[i];
			}
		}
		for (int i = nums.length - shiftIndex; i < nums.length; i++) {
			nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void rotate(int[] nums, int k) {
		int[] newArray = new int[nums.length];
		for (int i = 0; i < newArray.length; i++) {
			int startIndex = (k + i + 1) % nums.length;
			newArray[i] = nums[startIndex];
		}
		System.out.println(Arrays.toString(newArray));
	}

	public static int[] mergeSortedArrays(int[] array1, int[] array2) {

		int[] output = new int[array1.length + array2.length];
		int j = 0, k = 0;
		for (int i = 0; i < output.length; i++) {

			/*
			 * if(j == array1.length) { output[i] = array2[k++]; } else if(k ==
			 * array2.length) { output[i] = array1[j++]; }
			 */

			if (k == array2.length || (j != array1.length && array1[j] <= array2[k])) {
				output[i] = array1[j++];
			} else {
				output[i] = array2[k++];
			}
		}

		return output;
	}

	public static void miniMaxSum(List<Integer> arr) {
		// Write your code here
		int min = 0, max = 0;
		min = arr.stream().min(Comparator.comparing(Integer::valueOf)).get();
		max = arr.stream().max(Comparator.comparing(Integer::valueOf)).get();
		// int result = arr.stream().reduce(Integer::sum).get();

		long result = arr.stream().mapToLong(Long::valueOf).sum();

		System.out.println("Result : " + result + ", Min : " + min + ",Max : " + max);
		System.out.println((result - max) + " " + (result - min));

	}

	public static int alternatingCharacters(String s) {

		int count = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				count++;
			}
		}

		return count;
	}

	public static int theLoveLetterMystery(String s) {
		// Write your code here
		int count = 0;

		char[] characters = s.toCharArray();
		int i = 0, j = characters.length - 1;
		while (i < j) {
			count = count + Math.abs(characters[i] - characters[j]);
			i++;
			j--;
		}
		return count;
	}

}
