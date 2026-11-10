import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AlgoVisual ID - Prototype");
            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("Sorting", new SortingPanel());
            // TODO: tab Searching, Stack/Queue, Kuis
            frame.add(tabs);
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
