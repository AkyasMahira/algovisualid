// Menjalankan Bubble Sort sekali, mencatat setiap langkah ke array
public class BubbleSort {

    private static Step[] push(Step[] steps, int count, Step step) {
        if (count == steps.length) {
            Step[] bigger = new Step[steps.length * 2];
            System.arraycopy(steps, 0, bigger, 0, count);
            steps = bigger;
        }
        steps[count] = step;
        return steps;
    }

    static Step[] generate(int[] input) {
        Step[] steps = new Step[4];
        int count = 0;
        int[] data = input.clone();
        int n = data.length;

        steps = push(steps, count, new Step(data, -1, -1, false, n, "Data awal. Tekan Next Step untuk memulai."));
        count++;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                boolean swap = data[j] > data[j + 1];
                String text = Helper.explainCompare(data[j], data[j + 1]);
                if (swap) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                steps = push(steps, count, new Step(data, j, j + 1, swap, n - i, text));
                count++;
            }
        }
        steps = push(steps, count, new Step(data, -1, -1, false, 0, "Selesai! Semua data sudah terurut."));
        count++;

        Step[] result = new Step[count];
        System.arraycopy(steps, 0, result, 0, count);
        return result;
    }
}
