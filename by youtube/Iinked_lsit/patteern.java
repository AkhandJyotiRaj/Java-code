public class patteern {
    public static void main(String[] args) {
        // Usage:
        //  - No args: prints Sierpinski triangle with default depth
        //  - One numeric arg: prints Sierpinski triangle with given depth
        //  - "mandelbrot" [width height [maxIter]]: prints Mandelbrot set

        if (args != null && args.length > 0 &&
                ("mandelbrot".equalsIgnoreCase(args[0]) || "mb".equalsIgnoreCase(args[0]))) {
            int width = 120;
            int height = 40;
            int maxIter = 200;
            if (args.length >= 3) {
                try { width = Math.max(20, Integer.parseInt(args[1])); } catch (NumberFormatException ignored) {}
                try { height = Math.max(10, Integer.parseInt(args[2])); } catch (NumberFormatException ignored) {}
            }
            if (args.length >= 4) {
                try { maxIter = Math.max(50, Integer.parseInt(args[3])); } catch (NumberFormatException ignored) {}
            }
            printMandelbrot(width, height, maxIter);
            return;
        }

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

    private static void printMandelbrot(int width, int height, int maxIter) {
        // Complex plane bounds
        double minRe = -2.0;
        double maxRe = 1.0;
        double minIm = -1.0;
        double maxIm = 1.0;

        // Respect aspect ratio for characters (roughly 2:1 height to width)
        double imHeight = maxIm - minIm;
        double reWidth = maxRe - minRe;
        double aspectFix = 0.5; // squish rows to compensate terminal cell ratio

        String gradient = "@#%*+=-:. ";
        int shades = gradient.length() - 1; // last is space for inside set

        StringBuilder line = new StringBuilder(width + 8);
        for (int y = 0; y < height; y++) {
            double cIm = maxIm - (y / (double) height) * imHeight;
            cIm *= aspectFix;
            line.setLength(0);
            for (int x = 0; x < width; x++) {
                double cRe = minRe + (x / (double) width) * reWidth;

                double zRe = 0.0, zIm = 0.0;
                int iter = 0;
                while (zRe * zRe + zIm * zIm <= 4.0 && iter < maxIter) {
                    double zReNew = zRe * zRe - zIm * zIm + cRe;
                    double zImNew = 2.0 * zRe * zIm + cIm;
                    zRe = zReNew;
                    zIm = zImNew;
                    iter++;
                }

                if (iter >= maxIter) {
                    line.append(gradient.charAt(shades));
                } else {
                    // Smooth coloring
                    double mu = iter - Math.log(Math.log(Math.hypot(zRe, zIm))) / Math.log(2.0);
                    double t = Math.max(0.0, Math.min(1.0, mu / maxIter));
                    int idx = (int) Math.floor(t * shades);
                    line.append(gradient.charAt(idx));
                }
            }
            System.out.println(line);
        }
    }
}

