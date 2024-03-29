package src.programmers.archive.etc.Heap;

public class HeapSort {
    private static int number = 10;
    private static int[] data;

    public static void heap(int[] data, int number) {
        for (int i = 0; i < number; i++) {
            int child = i;
            while (child > 0) {
                int parent = (child - 1) / 2;
                if (data[child] > data[parent]) {
                    int temp = data[parent];
                    data[parent] = data[child];
                    data[child] = temp;
                }
                child = parent;
            }
        }
    }

    public static void main(String[] args) {
        data = new int[number];
        for (int i = 0; i < number; i++) {
            data[i] = (int) (Math.random() * 100);
        }
        System.out.println("Before Sort : ");
        for (int i = 0; i < number; i++) {
            System.out.println(data[i] + "");
        }

        heap(data, number);

        for (int i = number - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            heap(data, i);
        }

        System.out.println();
        System.out.println("After Sort : ");
        for (int i = 0; i < number; i++) {
            System.out.println(data[i] + "");
        }
    }
}