import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class FractalGenerator extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int MAX_ITERATIONS = 200;
    
    private enum FractalType {
        MANDELBROT,
        JULIA,
        BURNING_SHIP,
        TRICORN
    }
    
    private BufferedImage image;
    private FractalType currentFractal = FractalType.MANDELBROT;
    private double zoomFactor = 1.0;
    private double offsetX = 0.0;
    private double offsetY = 0.0;
    private double juliaRe = -0.7;
    private double juliaIm = 0.27015;
    private int colorScheme = 0;
    
    public FractalGenerator() {
        setTitle("Java Fractal Generator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Right-click to zoom out
                if (e.getButton() == MouseEvent.BUTTON3) {
                    zoomFactor /= 2;
                    drawFractal();
                    repaint();
                }
            }
        });
        
        panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    // Zoom in
                    zoomFactor *= 1.2;
                } else {
                    // Zoom out
                    zoomFactor /= 1.2;
                }
                drawFractal();
                repaint();
            }
        });
        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                double dx = e.getX() - WIDTH / 2;
                double dy = e.getY() - HEIGHT / 2;
                
                offsetX -= dx / (WIDTH * zoomFactor) * 4;
                offsetY -= dy / (HEIGHT * zoomFactor) * 4;
                
                drawFractal();
                repaint();
            }
        });
        
        // Control panel
        JPanel controlPanel = new JPanel();
        
        JComboBox<String> fractalSelector = new JComboBox<>(
            new String[]{"Mandelbrot Set", "Julia Set", "Burning Ship", "Tricorn"}
        );
        fractalSelector.addActionListener(e -> {
            String selected = (String)fractalSelector.getSelectedItem();
            switch (selected) {
                case "Mandelbrot Set":
                    currentFractal = FractalType.MANDELBROT;
                    break;
                case "Julia Set":
                    currentFractal = FractalType.JULIA;
                    break;
                case "Burning Ship":
                    currentFractal = FractalType.BURNING_SHIP;
                    break;
                case "Tricorn":
                    currentFractal = FractalType.TRICORN;
                    break;
            }
            resetView();
            drawFractal();
            repaint();
        });
        
        JButton colorButton = new JButton("Change Colors");
        colorButton.addActionListener(e -> {
            colorScheme = (colorScheme + 1) % 5;
            drawFractal();
            repaint();
        });
        
        JButton resetButton = new JButton("Reset View");
        resetButton.addActionListener(e -> {
            resetView();
            drawFractal();
            repaint();
        });
        
        // Add sliders for Julia set parameters
        JSlider juliaReSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, (int)(juliaRe * 100));
        juliaReSlider.addChangeListener(e -> {
            juliaRe = juliaReSlider.getValue() / 100.0;
            if (currentFractal == FractalType.JULIA) {
                drawFractal();
                repaint();
            }
        });
        
        JSlider juliaImSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, (int)(juliaIm * 100));
        juliaImSlider.addChangeListener(e -> {
            juliaIm = juliaImSlider.getValue() / 100.0;
            if (currentFractal == FractalType.JULIA) {
                drawFractal();
                repaint();
            }
        });
        
        JLabel juliaLabel = new JLabel("Julia Set Parameters (Re, Im):");
        JLabel juliaValueLabel = new JLabel(String.format("%.2f, %.2f", juliaRe, juliaIm));
        
        juliaReSlider.addChangeListener(e -> {
            juliaRe = juliaReSlider.getValue() / 100.0;
            juliaValueLabel.setText(String.format("%.2f, %.2f", juliaRe, juliaIm));
            if (currentFractal == FractalType.JULIA) {
                drawFractal();
                repaint();
            }
        });
        
        juliaImSlider.addChangeListener(e -> {
            juliaIm = juliaImSlider.getValue() / 100.0;
            juliaValueLabel.setText(String.format("%.2f, %.2f", juliaRe, juliaIm));
            if (currentFractal == FractalType.JULIA) {
                drawFractal();
                repaint();
            }
        });
        
        // Add controls to the panel
        controlPanel.add(fractalSelector);
        controlPanel.add(colorButton);
        controlPanel.add(resetButton);
        controlPanel.add(juliaLabel);
        controlPanel.add(juliaValueLabel);
        controlPanel.add(new JLabel("Re: "));
        controlPanel.add(juliaReSlider);
        controlPanel.add(new JLabel("Im: "));
        controlPanel.add(juliaImSlider);
        
        // Add components to the frame
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        drawFractal();
    }
    
    private void resetView() {
        zoomFactor = 1.0;
        offsetX = 0.0;
        offsetY = 0.0;
    }
    
    private void drawFractal() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx, zy, cX, cY;
                
                // Map pixel coordinates to complex plane
                cX = (x - WIDTH / 2.0) / (WIDTH * zoomFactor / 4.0) + offsetX;
                cY = (y - HEIGHT / 2.0) / (HEIGHT * zoomFactor / 4.0) + offsetY;
                
                int iterations = 0;
                
                switch (currentFractal) {
                    case MANDELBROT:
                        zx = 0;
                        zy = 0;
                        iterations = calculateMandelbrot(zx, zy, cX, cY);
                        break;
                    case JULIA:
                        zx = cX;
                        zy = cY;
                        iterations = calculateJulia(zx, zy, juliaRe, juliaIm);
                        break;
                    case BURNING_SHIP:
                        zx = 0;
                        zy = 0;
                        iterations = calculateBurningShip(zx, zy, cX, cY);
                        break;
                    case TRICORN:
                        zx = 0;
                        zy = 0;
                        iterations = calculateTricorn(zx, zy, cX, cY);
                        break;
                }
                
                image.setRGB(x, y, colorize(iterations));
            }
        }
    }
    
    private int calculateMandelbrot(double zx, double zy, double cX, double cY) {
        int iter = 0;
        double tmp;
        
        while (zx * zx + zy * zy < 4.0 && iter < MAX_ITERATIONS) {
            tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        
        return iter;
    }
    
    private int calculateJulia(double zx, double zy, double cX, double cY) {
        int iter = 0;
        double tmp;
        
        while (zx * zx + zy * zy < 4.0 && iter < MAX_ITERATIONS) {
            tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        
        return iter;
    }
    
    private int calculateBurningShip(double zx, double zy, double cX, double cY) {
        int iter = 0;
        double tmp;
        
        while (zx * zx + zy * zy < 4.0 && iter < MAX_ITERATIONS) {
            tmp = zx * zx - zy * zy + cX;
            zy = Math.abs(2.0 * zx * zy) + cY;
            zx = tmp;
            iter++;
        }
        
        return iter;
    }
    
    private int calculateTricorn(double zx, double zy, double cX, double cY) {
        int iter = 0;
        double tmp;
        
        while (zx * zx + zy * zy < 4.0 && iter < MAX_ITERATIONS) {
            tmp = zx * zx - zy * zy + cX;
            zy = -2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        
        return iter;
    }
    
    private int colorize(int iterations) {
        if (iterations == MAX_ITERATIONS) {
            return 0x000000; // Black for points inside the set
        }
        
        switch (colorScheme) {
            case 0: // Blue-purple gradient
                return Color.HSBtoRGB(0.7f + iterations / 200f, 0.8f, 
                    iterations / (iterations + 8f));
            case 1: // Rainbow gradient
                return Color.HSBtoRGB(iterations / 50f % 1, 0.7f, 1.0f);
            case 2: // Fire gradient
                return Color.HSBtoRGB(iterations / 100f % 0.3f + 0.7f, 1.0f, 
                    iterations / (iterations + 8f));
            case 3: // Green-blue
                return Color.HSBtoRGB(0.3f + 0.3f * iterations / MAX_ITERATIONS, 0.9f, 
                    iterations / (iterations + 8f));
            case 4: // Grayscale
                float brightness = iterations / (float)MAX_ITERATIONS;
                return new Color(brightness, brightness, brightness).getRGB();
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FractalGenerator app = new FractalGenerator();
            app.setVisible(true);
        });
    }
}
