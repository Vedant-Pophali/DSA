package DAA;

public class StrassensMatrixMultiplication {
        public static int[][] performStrassensMatrixMultiplication(int[][] matrixA, int[][] matrixB) {
            int sizeOfMatrix = matrixA.length;
            int[][] resultMatrix = new int[sizeOfMatrix][sizeOfMatrix];

            if (sizeOfMatrix == 1) {
                resultMatrix[0][0] = matrixA[0][0] * matrixB[0][0];
            } else {
                int newSize = sizeOfMatrix / 2;
                int[][][] subMatrices = createSubMatrices(matrixA, matrixB, newSize);

                int[][] M1 = performStrassensMatrixMultiplication(add(subMatrices[0], subMatrices[3]), add(subMatrices[8], subMatrices[11]));
                int[][] M2 = performStrassensMatrixMultiplication(add(subMatrices[4], subMatrices[5]), subMatrices[0]);
                int[][] M3 = performStrassensMatrixMultiplication(subMatrices[0], subtract(subMatrices[9], subMatrices[11]));
                int[][] M4 = performStrassensMatrixMultiplication(subMatrices[3], subtract(subMatrices[10], subMatrices[8]));
                int[][] M5 = performStrassensMatrixMultiplication(add(subMatrices[0], subMatrices[1]), subMatrices[11]);
                int[][] M6 = performStrassensMatrixMultiplication(subtract(subMatrices[4], subMatrices[0]), add(subMatrices[8], subMatrices[9]));
                int[][] M7 = performStrassensMatrixMultiplication(subtract(subMatrices[1], subMatrices[3]), add(subMatrices[10], subMatrices[11]));

                int[][] C11 = add(subtract(add(M1, M4), M5), M7);
                int[][] C12 = add(M3, M5);
                int[][] C21 = add(M2, M4);
                int[][] C22 = add(subtract(add(M1, M3), M2), M6);

                combineQuadrantsIntoFinalMatrix(resultMatrix, C11, C12, C21, C22);
            }

            return resultMatrix;
        }

        private static int[][][] createSubMatrices(int[][] A, int[][] B, int size) {
            int[][][] blocks = new int[12][size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    blocks[0][i][j] = A[i][j];
                    blocks[1][i][j] = A[i][j + size];
                    blocks[2][i][j] = A[i + size][j];
                    blocks[3][i][j] = A[i + size][j + size];

                    blocks[4][i][j] = B[i][j];
                    blocks[5][i][j] = B[i][j + size];
                    blocks[6][i][j] = B[i + size][j];
                    blocks[7][i][j] = B[i + size][j + size];

                    blocks[8][i][j] = blocks[4][i][j];
                    blocks[9][i][j] = blocks[5][i][j];
                    blocks[10][i][j] = blocks[6][i][j];
                    blocks[11][i][j] = blocks[7][i][j];
                }
            }

            return blocks;
        }

        private static int[][] add(int[][] firstMatrix, int[][] secondMatrix) {
            int size = firstMatrix.length;
            int[][] resultMatrix = new int[size][size];
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            return resultMatrix;
        }

        private static int[][] subtract(int[][] firstMatrix, int[][] secondMatrix) {
            int size = firstMatrix.length;
            int[][] resultMatrix = new int[size][size];
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    resultMatrix[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            return resultMatrix;
        }

        private static void combineQuadrantsIntoFinalMatrix(int[][] result, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
            int size = C11.length;
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++) {
                    result[i][j] = C11[i][j];
                    result[i][j + size] = C12[i][j];
                    result[i + size][j] = C21[i][j];
                    result[i + size][j + size] = C22[i][j];
                }
        }

        public static void main(String[] args) {
            int[][] exampleMatrixOne = { {1, 2}, {3, 4} };
            int[][] exampleMatrixTwo = { {5, 6}, {7, 8} };

            int[][] resultMatrix = performStrassensMatrixMultiplication(exampleMatrixOne, exampleMatrixTwo);

            System.out.println("Result of Strassen's Multiplication:");
            for (int[] row : resultMatrix) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
