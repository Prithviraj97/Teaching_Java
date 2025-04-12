package CS281_S25;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class FractalGenerator extends JPanel {

    private static final int WIDTH = 800; // Increased for better resolution
    private static final int HEIGHT = 600;
    private static final int MAX_ITERATIONS = 2000; // Increased for more detail
    private static final double ZOOM_FACTOR = 1.5;
    private static final Color[] COLOR_PALETTE = createPalette();

    private double zoomLevel = 1;
    private double xOffset = -0.7; // Centered for Mandelbrot
    private double yOffset = 0.0;
    private BufferedImage fractalImage;

    public FractalGenerator() {
        fractalImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        calculateFractal();
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                handleMouseClicked(e);
            }
        });
    }

    private static Color[] createPalette() {
        // Create a more visually appealing color palette
        Color[] palette = new Color[MAX_ITERATIONS];
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (i < MAX_ITERATIONS / 4) {
                palette[i] = Color.getHSBColor(i / (float) (MAX_ITERATIONS / 4) * 0.3f, 1, 1); // Blueish
            } else if (i < MAX_ITERATIONS / 2) {
                palette[i] = Color.getHSBColor(0.3f + (i - MAX_ITERATIONS / 4) / (float) (MAX_ITERATIONS / 4) * 0.2f, 1, 1); // Greenish
            } else if (i < MAX_ITERATIONS * 3 / 4) {
                palette[i] = Color.getHSBColor(0.5f + (i - MAX_ITERATIONS / 2) / (float) (MAX_ITERATIONS / 4) * 0.2f, 1, 1); // Yellowish
            }
             else {
                palette[i] = Color.getHSBColor(0.7f + (i - MAX_ITERATIONS * 3/4) / (float) (MAX_ITERATIONS / 4) * 0.3f, 1, 1); // Reddish
            }
        }
        return palette;
    }

    private void calculateFractal() {
        double xStart = xOffset - 2.0 / zoomLevel;
        double xEnd = xOffset + 2.0 / zoomLevel;
        double yStart = yOffset - 1.5 / zoomLevel;
        double yEnd = yOffset + 1.5 / zoomLevel;

        double xStep = (xEnd - xStart) / WIDTH;
        double yStep = (yEnd - yStart) / HEIGHT;

        // Use threads for faster calculation
        int numThreads = Runtime.getRuntime().availableProcessors(); // Get number of cores
        final int rowsPerThread = HEIGHT / numThreads;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int startRow = i * rowsPerThread;
            final int endRow = (i == numThreads - 1) ? HEIGHT : (i + 1) * rowsPerThread;

            threads[i] = new Thread(() -> {
                for (int y = startRow; y < endRow; y++) {
                    double cIm = yStart + y * yStep;
                    for (int x = 0; x < WIDTH; x++) {
                        double cRe = xStart + x * xStep;
                        int iterations = calculateMandelbrot(cRe, cIm);
                        fractalImage.setRGB(x, y, COLOR_PALETTE[iterations % COLOR_PALETTE.length].getRGB());
                    }
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        repaint(); // Trigger a repaint to display the updated image
    }

    private int calculateMandelbrot(double cRe, double cIm) {
        double zRe = cRe;
        double zIm = cIm;
        int iterations = 0;

        while (iterations < MAX_ITERATIONS && zRe * zRe + zIm * zIm < 4) {
            double newRe = zRe * zRe - zIm * zIm + cRe;
            double newIm = 2 * zRe * zIm + cIm;
            zRe = newRe;
            zIm = newIm;
            iterations++;
        }
        return iterations;
    }

     private void handleMouseClicked(java.awt.event.MouseEvent e) {
        // Calculate the clicked position in the complex plane
        double xStart = xOffset - 2.0 / zoomLevel;
        double xEnd = xOffset + 2.0 / zoomLevel;
        double yStart = yOffset - 1.5 / zoomLevel;
        double yEnd = yOffset + 1.5 / zoomLevel;

        double clickedX = xStart + (e.getX() / (double) WIDTH) * (xEnd - xStart);
        double clickedY = yStart + (e.getY() / (double) HEIGHT) * (yEnd - yStart);

        // Zoom in and center on the clicked point
        zoomLevel *= ZOOM_FACTOR;
        xOffset = clickedX;
        yOffset = clickedY;
        calculateFractal(); // Recalculate and display the fractal
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fractalImage, 0, 0, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mandelbrot Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false); // Prevent resizing for consistent rendering
        FractalGenerator fractalGenerator = new FractalGenerator();
        frame.getContentPane().add(fractalGenerator);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}

