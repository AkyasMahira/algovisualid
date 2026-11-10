import java.util.ArrayList;

// Menjalankan Bubble Sort sekali, mencatat setiap langkah ke list
public class BubbleSort {

    static ArrayList<Step> generate(int[] input) {
        ArrayList<Step> steps = new ArrayList<Step>();
        int[] data = input.clone();
        int n = data.length;
        steps.add(new Step(data, -1, -1, false, n, "Data awal. Tekan Next Step untuk memulai."));

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                boolean swap = data[j] > data[j + 1];
                String text = Helper.explainCompare(data[j], data[j + 1]);
                if (swap) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                steps.add(new Step(data, j, j + 1, swap, n - i, text));
            }
        }
        steps.add(new Step(data, -1, -1, false, 0, "Selesai! Semua data sudah terurut."));
        return steps;
    }
}
