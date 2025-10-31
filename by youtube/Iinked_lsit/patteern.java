public class patteern {
    public static void main(String[] args) {
        int depth = 5; // Try values 1..7 depending on your console width
        if (args != null && args.length > 0) {
            try {
                depth = Math.max(1, Math.min(8, Integer.parseInt(args[0])));
            } catch (NumberFormatException ignored) {
            }
        }

        printSierpinski(depth);
    }

    private static void printSierpinski(int depth) {
        int height = 1 << depth; // 2^depth
        int width = (height << 1) - 1; // 2*height - 1

        char[][] canvas = new char[height][width];
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                canvas[r][c] = ' ';
            }
        }

        drawTriangle(canvas, 0, width / 2, height);

        StringBuilder line = new StringBuilder(width);
        for (int r = 0; r < height; r++) {
            line.setLength(0);
            for (int c = 0; c < width; c++) {
                line.append(canvas[r][c]);
            }
            System.out.println(line);
        }
    }

    private static void drawTriangle(char[][] canvas, int topRow, int topCol, int size) {
        if (size == 1) {
            canvas[topRow][topCol] = '*';
            return;
        }

        int half = size / 2;

        // Top sub-triangle
        drawTriangle(canvas, topRow, topCol, half);
        // Bottom-left sub-triangle
        drawTriangle(canvas, topRow + half, topCol - half, half);
        // Bottom-right sub-triangle
        drawTriangle(canvas, topRow + half, topCol + half, half);

        // Optional: outline the current triangle's edges for a denser look
        // drawEdges(canvas, topRow, topCol, size);
    }

    @SuppressWarnings("unused")
    private static void drawEdges(char[][] canvas, int topRow, int topCol, int size) {
        int baseRow = topRow + size - 1;
        // Draw left and right edges
        for (int i = 0; i < size; i++) {
            int r = topRow + i;
            int leftCol = topCol - i;
            int rightCol = topCol + i;
            if (inBounds(canvas, r, leftCol)) canvas[r][leftCol] = '*';
            if (inBounds(canvas, r, rightCol)) canvas[r][rightCol] = '*';
        }
        // Draw base
        for (int c = topCol - (size - 1); c <= topCol + (size - 1); c++) {
            if (inBounds(canvas, baseRow, c)) canvas[baseRow][c] = '*';
        }
    }

    private static boolean inBounds(char[][] canvas, int r, int c) {
        return r >= 0 && r < canvas.length && c >= 0 && c < canvas[0].length;
    }
}
