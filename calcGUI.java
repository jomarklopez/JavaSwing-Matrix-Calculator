
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;

public class calcGUI {

    private matrixInputs inputs;
    private matrixOptions1 options1;
    private matrixOptions2 options2;
    private matrixAnswer answers;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public calcGUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(4, 4, 4, 4);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add((answers = new matrixAnswer()), gbc);
        
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add((inputs = new matrixInputs(answers)), gbc);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add((options1 = new matrixOptions1(inputs, answers)), gbc);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add((options2 = new matrixOptions2(inputs)), gbc);
        
        JFrame frame = new JFrame("Inverse Matrix Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
