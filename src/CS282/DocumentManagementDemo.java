package CS282;

/**
 * Document Management System - Abstract Class/Method Demo
 * 
 * Real-world scenario: A system that handles different types of documents
 * All documents share common properties and some behaviors, but each type
 * has its own specific way of opening, saving, and displaying content.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// =================================================================
// ABSTRACT CLASS: Document
// =================================================================

/**
 * Abstract base class representing any document in the system
 * Common features: filename, size, creation date, author
 * Different behaviors: how to open, save, render content
 */
abstract class Document {
    // Common properties for ALL documents
    protected String filename;
    protected double fileSizeKB;
    protected String author;
    protected LocalDateTime createdDate;
    protected LocalDateTime lastModified;
    protected boolean isEncrypted;
    
    // Constructor - common initialization for all documents
    public Document(String filename, String author) {
        this.filename = filename;
        this.author = author;
        this.createdDate = LocalDateTime.now();
        this.lastModified = LocalDateTime.now();
        this.fileSizeKB = 0.0;
        this.isEncrypted = false;
    }
    
    // CONCRETE METHOD - same for all documents
    public void displayMetadata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("┌─────────────────────────────────────┐");
        System.out.println("│ Document Metadata                   │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Filename: " + filename);
        System.out.println("│ Author: " + author);
        System.out.println("│ Size: " + String.format("%.2f", fileSizeKB) + " KB");
        System.out.println("│ Created: " + createdDate.format(formatter));
        System.out.println("│ Modified: " + lastModified.format(formatter));
        System.out.println("│ Encrypted: " + (isEncrypted ? "Yes" : "No"));
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // CONCRETE METHOD - common behavior
    public void rename(String newFilename) {
        System.out.println("Renaming '" + filename + "' to '" + newFilename + "'");
        this.filename = newFilename;
        updateModifiedDate();
    }
    
    // CONCRETE METHOD - shared functionality
    public void encrypt() {
        if (isEncrypted) {
            System.out.println("Document is already encrypted!");
        } else {
            System.out.println("Encrypting " + filename + "...");
            this.isEncrypted = true;
            updateModifiedDate();
        }
    }
    
    // CONCRETE METHOD - utility
    public void updateModifiedDate() {
        this.lastModified = LocalDateTime.now();
    }
    
    // CONCRETE METHOD - shared behavior
    public double getFileSizeKB() {
        return fileSizeKB;
    }
    
    // CONCRETE METHOD - conversion
    public double getFileSizeMB() {
        return fileSizeKB / 1024.0;
    }
    
    // ABSTRACT METHODS - Each document type implements differently
    
    /**
     * Opens the document in appropriate application
     * Different for each document type
     */
    public abstract void open();
    
    /**
     * Saves the document to disk
     * Different formats have different save procedures
     */
    public abstract void save();
    
    /**
     * Displays the content of the document
     * Each type renders content differently
     */
    public abstract void displayContent();
    
    /**
     * Gets the file extension
     * Each document type has its own extension
     */
    public abstract String getFileExtension();
    
    /**
     * Exports document to PDF
     * Implementation varies by document type
     */
    public abstract void exportToPDF(String outputPath);
}

// =================================================================
// CONCRETE CLASS: TextDocument
// =================================================================

class TextDocument extends Document {
    private StringBuilder content;
    private String encoding;
    
    public TextDocument(String filename, String author) {
        super(filename, author);
        this.content = new StringBuilder();
        this.encoding = "UTF-8";
        this.fileSizeKB = 1.5;  // Initial size
    }
    
    // Add text content
    public void addText(String text) {
        content.append(text).append("\n");
        // Update file size (rough estimate)
        this.fileSizeKB = content.length() / 1024.0;
        updateModifiedDate();
    }
    
    // MUST implement abstract methods
    
    @Override
    public void open() {
        System.out.println("Opening text document in Notepad/TextEdit...");
        System.out.println("Encoding: " + encoding);
    }
    
    @Override
    public void save() {
        System.out.println("Saving text document as " + filename + getFileExtension());
        System.out.println("Encoding: " + encoding);
        System.out.println("Content saved successfully!");
        updateModifiedDate();
    }
    
    @Override
    public void displayContent() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   TEXT DOCUMENT CONTENT            ║");
        System.out.println("╠════════════════════════════════════╣");
        if (content.length() == 0) {
            System.out.println("║   (Document is empty)              ║");
        } else {
            String[] lines = content.toString().split("\n");
            for (String line : lines) {
                System.out.println("║ " + line);
            }
        }
        System.out.println("╚════════════════════════════════════╝");
    }
    
    @Override
    public String getFileExtension() {
        return ".txt";
    }
    
    @Override
    public void exportToPDF(String outputPath) {
        System.out.println("Converting text document to PDF...");
        System.out.println("Applying basic text formatting...");
        System.out.println("Exported to: " + outputPath);
    }
    
    // Additional method specific to TextDocument
    public void changeEncoding(String newEncoding) {
        this.encoding = newEncoding;
        System.out.println("Changed encoding to: " + newEncoding);
    }
}

// =================================================================
// CONCRETE CLASS: SpreadsheetDocument
// =================================================================

class SpreadsheetDocument extends Document {
    private int rows;
    private int columns;
    private String[][] data;
    
    public SpreadsheetDocument(String filename, String author, int rows, int columns) {
        super(filename, author);
        this.rows = rows;
        this.columns = columns;
        this.data = new String[rows][columns];
        this.fileSizeKB = (rows * columns * 8) / 1024.0;  // Rough estimate
        
        // Initialize with empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = "";
            }
        }
    }
    
    // Set cell value
    public void setCellValue(int row, int col, String value) {
        if (row >= 0 && row < rows && col >= 0 && col < columns) {
            data[row][col] = value;
            updateModifiedDate();
        }
    }
    
    // Calculate sum of a column
    public double calculateColumnSum(int col) {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            try {
                sum += Double.parseDouble(data[i][col]);
            } catch (NumberFormatException e) {
                // Skip non-numeric values
            }
        }
        return sum;
    }
    
    @Override
    public void open() {
        System.out.println("Opening spreadsheet in Excel/Google Sheets...");
        System.out.println("Grid size: " + rows + " rows × " + columns + " columns");
    }
    
    @Override
    public void save() {
        System.out.println("Saving spreadsheet as " + filename + getFileExtension());
        System.out.println("Saving " + rows + "×" + columns + " grid with formulas...");
        System.out.println("Spreadsheet saved successfully!");
        updateModifiedDate();
    }
    
    @Override
    public void displayContent() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   SPREADSHEET CONTENT              ║");
        System.out.println("╠════════════════════════════════════╣");
        
        // Display column headers
        System.out.print("║     ");
        for (int j = 0; j < columns; j++) {
            System.out.printf("  Col%d  ", j);
        }
        System.out.println("║");
        System.out.println("╠════════════════════════════════════╣");
        
        // Display data
        for (int i = 0; i < Math.min(rows, 5); i++) {  // Show first 5 rows
            System.out.printf("║ R%d  ", i);
            for (int j = 0; j < columns; j++) {
                String value = data[i][j].isEmpty() ? "-" : data[i][j];
                System.out.printf(" %6s ", value.length() > 6 ? value.substring(0, 6) : value);
            }
            System.out.println("║");
        }
        if (rows > 5) {
            System.out.println("║   ... (" + (rows - 5) + " more rows)");
        }
        System.out.println("╚════════════════════════════════════╝");
    }
    
    @Override
    public String getFileExtension() {
        return ".xlsx";
    }
    
    @Override
    public void exportToPDF(String outputPath) {
        System.out.println("Converting spreadsheet to PDF...");
        System.out.println("Rendering " + rows + "×" + columns + " grid...");
        System.out.println("Applying cell formatting and borders...");
        System.out.println("Exported to: " + outputPath);
    }
}

// =================================================================
// CONCRETE CLASS: PresentationDocument
// =================================================================

class PresentationDocument extends Document {
    private int slideCount;
    private String[] slideTitles;
    private String theme;
    
    public PresentationDocument(String filename, String author, int initialSlides) {
        super(filename, author);
        this.slideCount = initialSlides;
        this.slideTitles = new String[initialSlides];
        this.theme = "Default";
        this.fileSizeKB = initialSlides * 150.0;  // ~150KB per slide
        
        // Initialize slide titles
        for (int i = 0; i < initialSlides; i++) {
            slideTitles[i] = "Slide " + (i + 1);
        }
    }
    
    public void setSlideTitle(int slideIndex, String title) {
        if (slideIndex >= 0 && slideIndex < slideCount) {
            slideTitles[slideIndex] = title;
            updateModifiedDate();
        }
    }
    
    public void setTheme(String theme) {
        this.theme = theme;
        System.out.println("Applied theme: " + theme);
        updateModifiedDate();
    }
    
    public void addSlide(String title) {
        slideCount++;
        String[] newTitles = new String[slideCount];
        System.arraycopy(slideTitles, 0, newTitles, 0, slideTitles.length);
        newTitles[slideCount - 1] = title;
        slideTitles = newTitles;
        this.fileSizeKB = slideCount * 150.0;
        updateModifiedDate();
    }
    
    @Override
    public void open() {
        System.out.println("Opening presentation in PowerPoint/Google Slides...");
        System.out.println("Number of slides: " + slideCount);
        System.out.println("Theme: " + theme);
    }
    
    @Override
    public void save() {
        System.out.println("Saving presentation as " + filename + getFileExtension());
        System.out.println("Saving " + slideCount + " slides with theme: " + theme);
        System.out.println("Embedding media and animations...");
        System.out.println("Presentation saved successfully!");
        updateModifiedDate();
    }
    
    @Override
    public void displayContent() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   PRESENTATION SLIDES              ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Theme: " + theme);
        System.out.println("║ Total Slides: " + slideCount);
        System.out.println("╠════════════════════════════════════╣");
        
        for (int i = 0; i < Math.min(slideCount, 5); i++) {
            System.out.println("║ " + (i + 1) + ". " + slideTitles[i]);
        }
        if (slideCount > 5) {
            System.out.println("║   ... (" + (slideCount - 5) + " more slides)");
        }
        System.out.println("╚════════════════════════════════════╝");
    }
    
    @Override
    public String getFileExtension() {
        return ".pptx";
    }
    
    @Override
    public void exportToPDF(String outputPath) {
        System.out.println("Converting presentation to PDF...");
        System.out.println("Rendering " + slideCount + " slides...");
        System.out.println("Converting animations to static images...");
        System.out.println("Exported to: " + outputPath);
    }
    
    public void startSlideshow() {
        System.out.println("Starting slideshow presentation...");
        System.out.println("Press → for next slide, ← for previous slide");
    }
}

// =================================================================
// CONCRETE CLASS: ImageDocument
// =================================================================

class ImageDocument extends Document {
    private int widthPixels;
    private int heightPixels;
    private String format;
    private int colorDepth;
    
    public ImageDocument(String filename, String author, int width, int height, String format) {
        super(filename, author);
        this.widthPixels = width;
        this.heightPixels = height;
        this.format = format.toUpperCase();
        this.colorDepth = 24;  // 24-bit color
        // Calculate file size based on format
        calculateFileSize();
    }
    
    private void calculateFileSize() {
        long pixels = (long) widthPixels * heightPixels;
        if (format.equals("PNG") || format.equals("BMP")) {
            this.fileSizeKB = (pixels * colorDepth / 8) / 1024.0;
        } else if (format.equals("JPG") || format.equals("JPEG")) {
            this.fileSizeKB = (pixels * colorDepth / 8) / 1024.0 * 0.1;  // 10:1 compression
        }
    }
    
    public void resize(int newWidth, int newHeight) {
        System.out.println("Resizing from " + widthPixels + "×" + heightPixels + 
                          " to " + newWidth + "×" + newHeight);
        this.widthPixels = newWidth;
        this.heightPixels = newHeight;
        calculateFileSize();
        updateModifiedDate();
    }
    
    public void applyFilter(String filterName) {
        System.out.println("Applying " + filterName + " filter to image...");
        updateModifiedDate();
    }
    
    @Override
    public void open() {
        System.out.println("Opening image in default image viewer...");
        System.out.println("Resolution: " + widthPixels + "×" + heightPixels + " pixels");
        System.out.println("Format: " + format);
    }
    
    @Override
    public void save() {
        System.out.println("Saving image as " + filename + getFileExtension());
        System.out.println("Format: " + format + " (" + colorDepth + "-bit color)");
        System.out.println("Image saved successfully!");
        updateModifiedDate();
    }
    
    @Override
    public void displayContent() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   IMAGE PREVIEW                    ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ [Image cannot be displayed in      ║");
        System.out.println("║  text console]                     ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Dimensions: " + widthPixels + "×" + heightPixels + " px");
        System.out.println("║ Format: " + format);
        System.out.println("║ Color Depth: " + colorDepth + "-bit");
        System.out.println("║ Aspect Ratio: " + String.format("%.2f", (double)widthPixels/heightPixels));
        System.out.println("╚════════════════════════════════════╝");
    }
    
    @Override
    public String getFileExtension() {
        return "." + format.toLowerCase();
    }
    
    @Override
    public void exportToPDF(String outputPath) {
        System.out.println("Converting image to PDF...");
        System.out.println("Embedding " + widthPixels + "×" + heightPixels + " image...");
        System.out.println("Maintaining original quality...");
        System.out.println("Exported to: " + outputPath);
    }
}

// =================================================================
// MAIN DEMONSTRATION
// =================================================================

public class DocumentManagementDemo {
    
    /**
     * Utility method that works with ANY document (polymorphism)
     */
    public static void processDocument(Document doc) {
        System.out.println("\n" + "=".repeat(50));
        doc.displayMetadata();
        doc.open();
        doc.displayContent();
        doc.save();
    }
    
    /**
     * Batch export multiple documents to PDF
     */
    public static void batchExportToPDF(Document[] documents, String outputFolder) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BATCH EXPORT TO PDF");
        System.out.println("=".repeat(50));
        
        for (Document doc : documents) {
            String outputPath = outputFolder + "/" + doc.filename + ".pdf";
            doc.exportToPDF(outputPath);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  DOCUMENT MANAGEMENT SYSTEM                    ║");
        System.out.println("║  Abstract Class & Methods Demo                 ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // Create different types of documents
        TextDocument report = new TextDocument("QuarterlyReport", "Alice Johnson");
        report.addText("Executive Summary");
        report.addText("This quarter showed 15% growth in revenue.");
        report.addText("Customer satisfaction increased by 8%.");
        
        SpreadsheetDocument budget = new SpreadsheetDocument("Budget2024", "Bob Smith", 10, 4);
        budget.setCellValue(0, 0, "Item");
        budget.setCellValue(0, 1, "Q1");
        budget.setCellValue(0, 2, "Q2");
        budget.setCellValue(0, 3, "Q3");
        budget.setCellValue(1, 0, "Revenue");
        budget.setCellValue(1, 1, "50000");
        budget.setCellValue(1, 2, "55000");
        budget.setCellValue(1, 3, "60000");
        
        PresentationDocument pitch = new PresentationDocument("ProductPitch", "Carol White", 8);
        pitch.setSlideTitle(0, "Welcome to Our Product");
        pitch.setSlideTitle(1, "Problem Statement");
        pitch.setSlideTitle(2, "Our Solution");
        pitch.setTheme("Modern Blue");
        
        ImageDocument logo = new ImageDocument("CompanyLogo", "Design Team", 1920, 1080, "PNG");
        
        // Demonstrate polymorphism - all treated as Documents
        System.out.println("\n1. PROCESSING DOCUMENTS (Polymorphism)");
        processDocument(report);
        processDocument(budget);
        processDocument(pitch);
        processDocument(logo);
        
        // Demonstrate shared concrete methods
        System.out.println("\n\n2. USING SHARED CONCRETE METHODS");
        System.out.println("=".repeat(50));
        
        report.rename("Q4_Report_2024");
        report.encrypt();
        System.out.println("File size: " + String.format("%.2f", report.getFileSizeMB()) + " MB");
        
        // Demonstrate document-specific methods
        System.out.println("\n\n3. DOCUMENT-SPECIFIC FEATURES");
        System.out.println("=".repeat(50));
        
        System.out.println("\nText Document Features:");
        report.changeEncoding("UTF-16");
        
        System.out.println("\nSpreadsheet Features:");
        double total = budget.calculateColumnSum(1);
        System.out.println("Q1 Total: $" + total);
        
        System.out.println("\nPresentation Features:");
        pitch.addSlide("Thank You!");
        pitch.startSlideshow();
        
        System.out.println("\nImage Features:");
        logo.resize(1280, 720);
        logo.applyFilter("Sharpen");
        
        // Batch operations using polymorphism
        System.out.println("\n\n4. BATCH OPERATIONS");
        Document[] allDocuments = {report, budget, pitch, logo};
        batchExportToPDF(allDocuments, "/exports/pdf");
        
        // Show the power of abstract class
        System.out.println("\n\n5. WHY ABSTRACT CLASS IS POWERFUL");
        System.out.println("=".repeat(50));
        System.out.println("✓ Common properties: All documents have filename, author, dates");
        System.out.println("✓ Shared behavior: rename(), encrypt(), displayMetadata() work for all");
        System.out.println("✓ Forced implementation: All must implement open(), save(), displayContent()");
        System.out.println("✓ Polymorphism: Can treat all documents uniformly in collections/methods");
        System.out.println("✓ Code reuse: Don't repeat metadata logic in each document type");
        
        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║  END OF DEMONSTRATION                          ║");
        System.out.println("╚════════════════════════════════════════════════╝");
    }
}