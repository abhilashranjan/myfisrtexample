package demo.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anya on 20/7/17.
 */
public final class Metrix {

    public static void main(String[] args) {
        System.out.println(mergesort(Arrays.asList(5,4,6,3,2,9,8,1,7)));
        System.out.println(quicksort(Arrays.asList(5,4,6,3,2,9,8,1,7)));
    }


    public static List<Integer> mergesort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
        final List<Integer> leftHalf =
                values.subList(0, values.size() / 2);
        final List<Integer> rightHalf =
                values.subList(values.size() / 2, values.size());
        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left,
                                       final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;
        final List<Integer> merged = new ArrayList<>(left.size() + right.size());
        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }

    public static List<Integer> quicksort(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return numbers;
        }
        final Integer pivot = numbers.get(0);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < pivot) {
                lower.add(numbers.get(i));
            } else {
                higher.add(numbers.get(i));}
        }
        final List<Integer> sorted = quicksort(lower);
        sorted.add(pivot);
        sorted.addAll(quicksort(higher));
        return sorted;
    }

}
