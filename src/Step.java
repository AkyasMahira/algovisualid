// Satu langkah animasi: kondisi array + penjelasan
public class Step {
    int[] data;      // salinan array pada langkah ini
    int a, b;        // indeks yang sedang dibandingkan (-1 jika tidak ada)
    boolean swapped; // apakah ditukar
    int sortedFrom;  // indeks mulai bagian yang sudah terurut
    String text;     // penjelasan Bahasa Indonesia

    Step(int[] data, int a, int b, boolean swapped, int sortedFrom, String text) {
        this.data = data.clone();
        this.a = a;
        this.b = b;
        this.swapped = swapped;
        this.sortedFrom = sortedFrom;
        this.text = text;
    }
}
