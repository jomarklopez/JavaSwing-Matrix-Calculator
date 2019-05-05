
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class matrixOptions1 extends JPanel implements ActionListener {

    GridBagConstraints gbc = new GridBagConstraints();
    private final matrixInputs matrixinputs;
    private final matrixAnswer matrixanswer;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public matrixOptions1(final matrixInputs matrixinputs, final matrixAnswer matrixanswer) {
        this.matrixinputs = matrixinputs;
        this.matrixanswer = matrixanswer;

        setLayout(new GridBagLayout());
        findButtons();
    }

    public void findButtons() {
        gbc.ipady = 5;
        gbc.ipadx = 5;

        gbc.gridy = 0;
        JButton finddet = new JButton("Find the determinant");
        finddet.setPreferredSize(new Dimension(150, 20));
        finddet.addActionListener(this);
        add(finddet, gbc);

        gbc.gridy++;
        JButton findadj = new JButton("Find the adjoint");
        findadj.setPreferredSize(new Dimension(150, 20));
        findadj.addActionListener(this);
        add(findadj, gbc);

        gbc.gridy++;
        JButton findinv = new JButton("Find the inverse");
        findinv.setPreferredSize(new Dimension(150, 20));
        findinv.addActionListener(this);
        add(findinv, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butclicked = (JButton) e.getSource();

        if (butclicked.getText().equals("Find the determinant")) {
            inverseCalc inverseCalc = new inverseCalc(matrixinputs);
            double det = inverseCalc.getDeterminant(matrixinputs.getMatrix());
            matrixanswer.showDet(det);

        }
        
        if (butclicked.getText().equals("Find the adjoint")) {
            inverseCalc inverseCalc = new inverseCalc(matrixinputs);
            matrixanswer.showAdj(inverseCalc.getAdjoint(matrixinputs.getMatrix()));
        }
        
        if (butclicked.getText().equals("Find the inverse")) { 
            inverseCalc inverseCalc = new inverseCalc(matrixinputs);
            double det = inverseCalc.getDeterminant(matrixinputs.getMatrix());
            double[][] adj = inverseCalc.getAdjoint(matrixinputs.getMatrix());
            matrixanswer.showInv(inverseCalc.getInverse(adj, det));
        }
    }
}
