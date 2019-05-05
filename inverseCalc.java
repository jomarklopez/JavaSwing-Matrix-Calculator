
public class inverseCalc {

    private final matrixInputs matrixinputs;
    double[][] invMatrix, adjMatrix, submatrix, matrix;
    int row,col;

    public inverseCalc(final matrixInputs matrixinputs) {
        this.matrixinputs = matrixinputs;
    }

    //DETERMINANT CALCULATOR
    public double getDeterminant(double[][] m) {
        double[][] submatrix;
        double det = 0;
        int counter = 0;

        changeSigns(m);

        if (m.length == 1) {
            det = m[0][0];
            return det;
        }

        while (counter < m.length) { //about row 1
            submatrix = new double[m.length - 1][m.length - 1];

            for (int l = 1; l < m.length; l++) { //submatrices for cofactors
                for (int n = 0; n < m.length; n++) {
                    if (n < counter) {
                        submatrix[l - 1][n] = m[l][n];
                    } else if (n > counter) {
                        submatrix[l - 1][n - 1] = m[l][n];
                    }
                }
            }
            det += m[0][counter] * getDeterminant(submatrix);

            counter++;
        }
        return det;
    }
    
    //ADJOINT CALCULATOR
    public double[][] getMinor(int m, int n) {
        double[][] cmat = new double[this.row - 1][this.col - 1];
        int i = 0, j = 0;
        for (int r = 0; r < this.row; r++) {
            j = 0;
            for (int c = 0; c < this.col; c++) {
                if (r != m && c != n) {
                    cmat[i][j++] = matrix[r][c];
                }
            }
            if (r != m) {
                i++;
            }
        }
        return cmat;
    }

    public double[][] changeSignsCofac(double[][] m) {
        double[][] cofac = new double[this.row][this.col];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        cofac[i][j] = m[i][j];
                    } else {
                        cofac[i][j] = m[i][j] * -1;
                    }
                } else {
                    if (j % 2 == 0) {
                        cofac[i][j] = m[i][j] * -1;
                    } else {
                        cofac[i][j] = m[i][j];
                    }
                }
            }
        }
        return cofac;
    }

    public double[][] getCofacMat(double[][] a) {

        double[][] end = new double[this.row][this.col];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                end[i][j] = getDeterminant(this.getMinor(i, j));
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        end[i][j] = end[i][j];
                    } else {
                        end[i][j] = end[i][j] * -1;
                    }
                } else {
                    if (j % 2 == 0) {
                        end[i][j] = end[i][j] * -1;
                    } else {
                        end[i][j] = end[i][j];
                    }
                }
            }
        }
        return end;
    }

    public double[][] transpose(double m[][]) {
        double[][] temp = new double[this.row][this.col];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                temp[i][j] = m[j][i];
            }
        }
        return temp;
    }

    public double[][] getAdjoint(double[][] m) {
        this.matrix = m;
        this.row = m.length;
        this.col = m.length;
        return transpose(getCofacMat(m));
    }
    
    //INVERSE CALCULATOR
    public double[][] getInverse(double[][] adjm, double det) {
        invMatrix = new double[adjm.length][adjm.length];
        try {
            for (int i = 0; i < adjm.length; i++) {
                for (int j = 0; j < adjm.length; j++) {
                    invMatrix[i][j] = ((1 / det) * adjm[i][j]);
                    System.out.print(invMatrix[i][j] + " ");
                    if (j == adjm.length - 1) {
                        System.out.println("");
                    }
                }
            }
        } catch (ArithmeticException e) {
            System.out.println("No Inverse since determinant is Zero");
        }
        return invMatrix;
    }

    public double[][] changeSigns(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            if ((i) % 2 == 0) {
                m[0][i] *= 1;
            } else {
                m[0][i] *= -1;
            }

        }
        return m;
    }
}
