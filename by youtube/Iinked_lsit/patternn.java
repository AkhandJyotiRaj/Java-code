public class patternn {
    
    public static void main(String[] args) {
        int n = 7; // Size of the pattern
        
        System.out.println("=== Complex Diamond Pattern with Numbers ===\n");
        printDiamondPattern(n);
        
        System.out.println("\n=== Spiral Number Pattern ===\n");
        printSpiralPattern(5);
        
        System.out.println("\n=== Pascal's Triangle ===\n");
        printPascalsTriangle(6);
        
        System.out.println("\n=== Hollow Diamond Pattern ===\n");
        printHollowDiamond(7);
    }
    
    // 1. Diamond Pattern with Numbers
    public static void printDiamondPattern(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Numbers increasing
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            // Numbers decreasing
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Numbers increasing
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            // Numbers decreasing
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
    // 2. Spiral Number Pattern
    public static void printSpiralPattern(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            
            // Down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }
            
            // Up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        // Print spiral
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    // 3. Pascal's Triangle
    public static void printPascalsTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            // Spaces for formatting
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print("  ");
            }
            
            // Calculate and print coefficients
            int coefficient = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", coefficient);
                coefficient = coefficient * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
    
    // 4. Hollow Diamond Pattern
    public static void printHollowDiamond(int n) {
        // Upper half
        for (int i = 1; i <= n; i++) {
            // Spaces before
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            // Spaces before
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                if (j == 1 || j == 2 * i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
