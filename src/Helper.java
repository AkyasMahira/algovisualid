// Fungsi bantu: parsing input dan penyusun teks penjelasan (String function)
public class Helper {

    // "5, 3,8 ,1" -> {5,3,8,1}; return null jika tidak valid
    static int[] parseInput(String input) {
        if (input == null || input.trim().equals("")) return null;
        String[] parts = input.trim().split(",");
        if (parts.length < 2 || parts.length > 15) return null;
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                result[i] = Integer.parseInt(parts[i].trim());
            } catch (NumberFormatException e) {
                return null;
            }
            if (result[i] < 1 || result[i] > 99) return null;
        }
        return result;
    }

    static String explainCompare(int x, int y) {
        if (x > y) return "Bandingkan " + x + " dan " + y + ": " + x + " lebih besar, maka ditukar.";
        return "Bandingkan " + x + " dan " + y + ": urutan sudah benar, tidak ditukar.";
    }
}
