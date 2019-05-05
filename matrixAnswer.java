
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class matrixAnswer extends JPanel {

    GridBagConstraints gbc = new GridBagConstraints();
    String det = "|A| = ";
    String adj = "Adj A = ";
    int elements;
    int row = 2;
    int col = 2;
    int divider = 3;
    int it;
    JLabel[] answerlabel = new JLabel[2];
    JTextField[] adjFields,invFields;
    JTable j;
    JButton minusrowcol,addrowcol;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    matrixAnswer() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("Answer"), new EmptyBorder(5, 5, 5, 5)));
        incdecFields();
        answerAdjFields();
        answerInvFields();
    }

    public void showDet(double det) {
        this.det += Double.toString(det);
        answerlabel[0].setText(this.det);
        this.det = "|A| = ";
    }

    public void showAdj(double[][] m) {
        int counter = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m.length; col++) {
                adjFields[counter].setText(Double.toString(m[row][col]));
                counter++;
            }
        }
    }
    
    public void showInv(double[][] m) {
        int counter = 0;
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m.length; col++) {
                invFields[counter].setText(Double.toString(m[row][col]));
                counter++;
            }
        }
    }

    public void incdecFields() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        answerlabel[0] = new JLabel(det);
        add(answerlabel[0], gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Adj: "), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = row+2;
        answerlabel[1] = new JLabel("Inverse: ");
        add(answerlabel[1], gbc);
    }

    public void answerAdjFields() {
        gbc.weighty = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        elements = row * col;
        
        adjFields = new JTextField[elements];

        for (int i= 0; i < elements; i++) {
            
            adjFields[i] = new JTextField();
            adjFields[i].setPreferredSize(new Dimension(50, 30));
            Color superlightgray = new Color(238,238,238);
            adjFields[i].setBackground(superlightgray);
            add(adjFields[i], gbc);
            if (gbc.gridx == divider) {
                gbc.gridx = 1;
                gbc.gridy++;

            } else {
                gbc.gridx += 2;
            }
        }
    }
    
    public void deleteAdjField() {
        for (it = 0; it < elements; it++) {
            remove(adjFields[it]);
        }
        it = 0;
        revalidate();
    }
    
    public void deleteincdecLabel() {
        remove(answerlabel[1]);
        revalidate();
    }
    
    public void answerInvFields() {
        gbc.gridx = 1;
        gbc.gridy = row+2;
        elements = row * col;
        
        invFields = new JTextField[elements];

        for (int i= 0; i < elements; i++) {
            
            invFields[i] = new JTextField();
            invFields[i].setPreferredSize(new Dimension(50, 30));
            Color superlightgray = new Color(238,238,238);
            invFields[i].setBackground(superlightgray);
            add(invFields[i], gbc);
            if (gbc.gridx == divider) {
                gbc.gridx = 1;
                gbc.gridy++;

            } else {
                gbc.gridx += 2;
            }
        }
    }
    
    public void deleteInvField() {
        for (it = 0; it < elements; it++) {
            remove(invFields[it]);
        }
        it = 0;
        revalidate();
    }

}
