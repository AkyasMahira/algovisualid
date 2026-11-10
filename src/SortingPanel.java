import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Panel modul Sorting: input, kontrol, gambar bar, penjelasan
public class SortingPanel extends JPanel {
    private JTextField inputField = new JTextField("5,3,8,1,9,2", 20);
    private JLabel infoLabel = new JLabel("Masukkan angka dipisah koma (1-99), lalu klik Mulai.");
    private JLabel counterLabel = new JLabel("Langkah: 0");
    private JButton startBtn = new JButton("Mulai");
    private JButton nextBtn = new JButton("Next Step");
    private JButton autoBtn = new JButton("Auto Play");
    private Canvas canvas = new Canvas();

    private ArrayList<Step> steps = new ArrayList<Step>();
    private int current = 0;
    private Timer timer;

    public SortingPanel() {
        setLayout(new BorderLayout(5, 5));

        JPanel top = new JPanel();
        top.add(new JLabel("Data:"));
        top.add(inputField);
        top.add(startBtn);
        top.add(nextBtn);
        top.add(autoBtn);
        add(top, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(2, 1));
        bottom.add(infoLabel);
        bottom.add(counterLabel);
        add(bottom, BorderLayout.SOUTH);

        nextBtn.setEnabled(false);
        autoBtn.setEnabled(false);

        startBtn.addActionListener(e -> start());
        nextBtn.addActionListener(e -> next());
        autoBtn.addActionListener(e -> toggleAuto());
        timer = new Timer(600, e -> next());
    }

    private void start() {
        int[] data = Helper.parseInput(inputField.getText());
        if (data == null) {
            infoLabel.setText("Input tidak valid! Contoh: 5,3,8,1 (2-15 angka, nilai 1-99).");
            return;
        }
        timer.stop();
        autoBtn.setText("Auto Play");
        steps = BubbleSort.generate(data);
        current = 0;
        nextBtn.setEnabled(true);
        autoBtn.setEnabled(true);
        tampilkanLangkah();
    }

    private void next() {
        if (current < steps.size() - 1) {
            current++;
            tampilkanLangkah();
        }
        if (current >= steps.size() - 1) {
            timer.stop();
            nextBtn.setEnabled(false);
            autoBtn.setEnabled(false);
        }
    }

    private void toggleAuto() {
        if (timer.isRunning()) {
            timer.stop();
            autoBtn.setText("Auto Play");
        } else {
            timer.start();
            autoBtn.setText("Pause");
        }
    }

    private void tampilkanLangkah() {
        infoLabel.setText(steps.get(current).text);
        counterLabel.setText("Langkah: " + current + " / " + (steps.size() - 1));
        canvas.repaint();
    }

    // Menggambar bar array
    private class Canvas extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (steps.isEmpty()) return;
            Step s = steps.get(current);
            int n = s.data.length;
            int w = getWidth() / n;
            for (int i = 0; i < n; i++) {
                int h = s.data[i] * (getHeight() - 40) / 99;
                if (i >= s.sortedFrom) g.setColor(new Color(120, 200, 120));      // terurut
                else if (i == s.a || i == s.b) g.setColor(s.swapped ? new Color(230, 90, 90) : new Color(240, 200, 60));
                else g.setColor(new Color(100, 150, 220));
                g.fillRect(i * w + 4, getHeight() - h - 20, w - 8, h);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(s.data[i]), i * w + w / 2 - 5, getHeight() - 5);
            }
        }
    }
}
