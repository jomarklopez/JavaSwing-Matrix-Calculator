
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class matrixInputs extends JPanel implements ActionListener {
    
    private final matrixAnswer matrixanswer;
    JTextField[] inputs;
    double[][] matrix;
    JButton addrowcol;
    JButton minusrowcol;
    GridBagConstraints gbc = new GridBagConstraints();
    int row = 2;
    int col = 2;
    int i, m, n, p, it, rowi, elements, temp;
    int divider = 3;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public matrixInputs(final matrixAnswer matrixanswer) {
        this.matrixanswer = matrixanswer;
        setLayout(new GridBagLayout());
        incdecMatrix();
        inputFields();
    }

    public void incdecMatrix() {
        add(new JLabel("Matrix A: "), gbc);

        gbc.gridwidth = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        minusrowcol = new JButton("-");
        minusrowcol.setPreferredSize(new Dimension(21, 21));
        minusrowcol.addActionListener(this);
        add(minusrowcol, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        addrowcol = new JButton("+");
        addrowcol.setPreferredSize(new Dimension(22, 21));
        addrowcol.addActionListener(this);
        add(addrowcol, gbc);
    }

    public void inputFields() {
        gbc.gridx = 1;
        gbc.gridy = 0;
        elements = row * col;

        inputs = new JTextField[elements];

        for (i = 0; i < elements; i++) {
            inputs[i] = new JTextField();
            inputs[i].setPreferredSize(new Dimension(50, 30));
            add(inputs[i], gbc);
            if (gbc.gridx == divider) {
                gbc.gridx = 1;
                gbc.gridy++;

            } else {
                gbc.gridx += 2;
            }
        }
    }

    public void deleteField() {
        for (it = 0; it < elements; it++) {
            remove(inputs[it]);
        }
        it = 0;
        revalidate();
    }

    public double[][] getMatrix() {
        matrix = new double[row][col];

        for (p = 0; p < elements;) {
            for (m = 0; m < row; m++) {
                for (n = 0; n < col; n++) {
                    matrix[m][n] = Double.parseDouble(inputs[p].getText());
                    p++;
                }
            }
        }
        return matrix;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton butclicked = (JButton) e.getSource();

        if (butclicked.getText().equals("+")) {
            deleteField();
            row++;
            col++;
            divider += 2;
            inputFields();
            matrixanswer.deleteincdecLabel();
            matrixanswer.deleteAdjField();
            matrixanswer.deleteInvField();
            matrixanswer.row++;
            matrixanswer.col++;
            matrixanswer.divider += 2;
            matrixanswer.answerAdjFields();
            matrixanswer.answerInvFields();
            matrixanswer.incdecFields();

        } else if (butclicked.getText().equals("-") && row != 2 && col != 2) {
            deleteField();
            row--;
            col--;
            divider -= 2;
            inputFields();
            matrixanswer.deleteincdecLabel();
            matrixanswer.deleteAdjField();
            matrixanswer.deleteInvField();
            matrixanswer.row--;
            matrixanswer.col--;
            matrixanswer.divider -= 2;
            matrixanswer.answerAdjFields();
            matrixanswer.answerInvFields();
            matrixanswer.incdecFields();
        }

    }
}
