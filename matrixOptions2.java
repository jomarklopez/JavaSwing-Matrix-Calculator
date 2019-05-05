
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class matrixOptions2 extends JPanel implements ActionListener {

    int n;
    private final matrixInputs matrixinputs;

    GridBagConstraints gbc = new GridBagConstraints();

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public matrixOptions2(final matrixInputs matrixinputs) {
        this.matrixinputs = matrixinputs;
        setLayout(new GridBagLayout());
        findButtons();
    }

    public void findButtons() {
        gbc.ipady = 5;
        gbc.ipadx = 5;

        gbc.gridy = 0;
        JButton clear = new JButton("Clear");
        clear.setPreferredSize(new Dimension(150, 20));
        clear.addActionListener(this);
        add(clear, gbc);

        gbc.gridy++;
        JButton showSolution = new JButton("Show solution");
        showSolution.setPreferredSize(new Dimension(150, 20));
        showSolution.addActionListener(this);
        add(showSolution, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butclicked = (JButton) e.getSource();

        if (butclicked.getText().equals("Clear")) {

            matrixinputs.inputs[0].setText("");
            for (int n = 0; n < matrixinputs.elements; n++) {
                matrixinputs.inputs[n].setText("");
            }
            n = 0;
        }
    }
}
