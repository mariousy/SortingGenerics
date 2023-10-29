public class SortingGenerics {

    // BubbleSort class
    public static class BubbleSort<T extends Comparable<T>> {

        public T[] sort(T[] array) {
            int n = array.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        // swap array[j] and array[j+1]
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            return array;
        }
    }

    // MergeSort class
    public static class MergeSort<T extends Comparable<T>> {

        public T[] sort(T[] array) {
            if (array.length <= 1) {
                return array;
            }

            int middle = array.length / 2;
            T[] left = (T[]) new Comparable[middle];
            T[] right = (T[]) new Comparable[array.length - middle];

            System.arraycopy(array, 0, left, 0, middle);
            System.arraycopy(array, middle, right, 0, array.length - middle);

            sort(left);
            sort(right);

            merge(array, left, right);
            return array;
        }

        private void merge(T[] result, T[] left, T[] right) {
            int leftPointer = 0, rightPointer = 0, resultPointer = 0;

            while (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer].compareTo(right[rightPointer]) <= 0) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }

            while (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }
            while (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
    }

    // Test method
    public static void main(String[] args) {
        Integer[] array1 = {5, 3, 2, 4, 1};
        Integer[] array2 = {5, 3, 2, 4, 1};

        BubbleSort<Integer> bubbleSorter = new BubbleSort<>();
        MergeSort<Integer> mergeSorter = new MergeSort<>();

        bubbleSorter.sort(array1);
        mergeSorter.sort(array2);

        System.out.print("BubbleSort output: ");
        for (int val : array1) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.print("MergeSort output: ");
        for (int val : array2) {
            System.out.print(val + " ");
        }
    }
}
