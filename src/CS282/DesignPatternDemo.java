/**
 * DESIGN PATTERNS DEMONSTRATION
 * 1. Singleton Pattern
 * 2. Abstract Factory Pattern
 * 
 * Both with concrete, practical examples
 */

// =================================================================
// PART 1: SINGLETON PATTERN
// =================================================================

/**
 * SINGLETON PATTERN
 * Purpose: Ensure a class has only ONE instance and provide global access to it
 * 
 * Use when:
 * - You need exactly one instance (database connection, logger, config manager)
 * - Instance must be accessible from anywhere in the application
 * - You want to control instance creation
 */

/**
 * Example 1: Database Connection Manager (Classic Singleton)
 * Only ONE database connection should exist in the application
 */
class DatabaseConnection {
    // Step 1: Private static instance variable
    private static DatabaseConnection instance = null;
    
    // Instance variables
    private String connectionString;
    private boolean isConnected;
    
    // Step 2: Private constructor - prevents external instantiation
    private DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        this.isConnected = false;
        System.out.println("DatabaseConnection: Creating new instance...");
        connect();
    }
    
    // Step 3: Public static method to get the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    // Business methods
    private void connect() {
        System.out.println("Connecting to database: " + connectionString);
        this.isConnected = true;
    }
    
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Executing query: " + query);
        } else {
            System.out.println("Not connected to database!");
        }
    }
    
    public void disconnect() {
        System.out.println("Disconnecting from database...");
        this.isConnected = false;
    }
}

/**
 * Example 2: Application Configuration Manager (Thread-Safe Singleton)
 * Thread-safe version using double-checked locking
 */
class ConfigurationManager {
    private String appName;
    private String version;
    private int maxConnections;
    private boolean debugMode;
    
    // Private constructor
    private ConfigurationManager() {
        System.out.println("ConfigurationManager: Loading configuration...");
        loadConfiguration();
    }
    
    // Initialization-on-demand holder idiom (thread-safe, no locking needed)
    private static class Holder {
        private static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }
    
    public static ConfigurationManager getInstance() {
        return Holder.INSTANCE;
    }
    
    private void loadConfiguration() {
        this.appName = "MyApplication";
        this.version = "1.0.0";
        this.maxConnections = 100;
        this.debugMode = true;
    }
    
    // Getters
    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public int getMaxConnections() { return maxConnections; }
    public boolean isDebugMode() { return debugMode; }
    
    public void displayConfig() {
        System.out.println("\n=== Application Configuration ===");
        System.out.println("App Name: " + appName);
        System.out.println("Version: " + version);
        System.out.println("Max Connections: " + maxConnections);
        System.out.println("Debug Mode: " + debugMode);
    }
}

/**
 * Example 3: Logger (Eager Initialization Singleton)
 * Instance created at class loading time
 */
class Logger {
    // Eagerly created instance (created when class is loaded)
    private static final Logger instance = new Logger();
    
    private int messageCount;
    
    // Private constructor
    private Logger() {
        this.messageCount = 0;
        System.out.println("Logger: Instance created at class loading time");
    }
    
    // Simple getInstance - instance already exists
    public static Logger getInstance() {
        return instance;
    }
    
    public void log(String level, String message) {
        messageCount++;
        System.out.println("[" + level + "] " + message + " (Total logs: " + messageCount + ")");
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    public void warning(String message) {
        log("WARNING", message);
    }
}

// =================================================================
// PART 2: ABSTRACT FACTORY PATTERN
// =================================================================

/**
 * ABSTRACT FACTORY PATTERN
 * Purpose: Provide an interface for creating families of related objects
 *          without specifying their concrete classes
 * 
 * Use when:
 * - System needs to be independent of how objects are created
 * - Need to create families of related objects
 * - Want to enforce that related objects are used together
 */

/**
 * EXAMPLE: UI Theme System
 * Different themes (Light, Dark) need different UI components
 * Each theme has its own Button, TextField, and Checkbox
 */

// Step 1: Define abstract products (UI components)

interface Button {
    void render();
    void onClick();
}

interface TextField {
    void render();
    void setText(String text);
    String getText();
}

interface Checkbox {
    void render();
    void setChecked(boolean checked);
    boolean isChecked();
}

// Step 2: Create concrete products for Light Theme

class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("  [Light Button] - White background, black text");
    }
    
    @Override
    public void onClick() {
        System.out.println("  Light Button clicked!");
    }
}

class LightTextField implements TextField {
    private String text = "";
    
    @Override
    public void render() {
        System.out.println("  [Light TextField] - White background, gray border");
        System.out.println("  Text: " + text);
    }
    
    @Override
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String getText() {
        return text;
    }
}

class LightCheckbox implements Checkbox {
    private boolean checked = false;
    
    @Override
    public void render() {
        System.out.println("  [Light Checkbox] - " + (checked ? "☑" : "☐") + " White box");
    }
    
    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Override
    public boolean isChecked() {
        return checked;
    }
}

// Step 3: Create concrete products for Dark Theme

class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("  [Dark Button] - Dark gray background, white text");
    }
    
    @Override
    public void onClick() {
        System.out.println("  Dark Button clicked!");
    }
}

class DarkTextField implements TextField {
    private String text = "";
    
    @Override
    public void render() {
        System.out.println("  [Dark TextField] - Dark background, light border");
        System.out.println("  Text: " + text);
    }
    
    @Override
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String getText() {
        return text;
    }
}

class DarkCheckbox implements Checkbox {
    private boolean checked = false;
    
    @Override
    public void render() {
        System.out.println("  [Dark Checkbox] - " + (checked ? "☑" : "☐") + " Dark box");
    }
    
    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Override
    public boolean isChecked() {
        return checked;
    }
}

// Step 4: Create the Abstract Factory interface

interface UIFactory {
    Button createButton();
    TextField createTextField();
    Checkbox createCheckbox();
}

// Step 5: Create Concrete Factories

class LightThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        System.out.println("Creating Light Theme Button");
        return new LightButton();
    }
    
    @Override
    public TextField createTextField() {
        System.out.println("Creating Light Theme TextField");
        return new LightTextField();
    }
    
    @Override
    public Checkbox createCheckbox() {
        System.out.println("Creating Light Theme Checkbox");
        return new LightCheckbox();
    }
}

class DarkThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        System.out.println("Creating Dark Theme Button");
        return new DarkButton();
    }
    
    @Override
    public TextField createTextField() {
        System.out.println("Creating Dark Theme TextField");
        return new DarkTextField();
    }
    
    @Override
    public Checkbox createCheckbox() {
        System.out.println("Creating Dark Theme Checkbox");
        return new DarkCheckbox();
    }
}

// Step 6: Client code that uses the factory

class Application {
    private Button button;
    private TextField textField;
    private Checkbox checkbox;
    
    // Constructor takes a factory - doesn't know which concrete theme
    public Application(UIFactory factory) {
        this.button = factory.createButton();
        this.textField = factory.createTextField();
        this.checkbox = factory.createCheckbox();
    }
    
    public void renderUI() {
        System.out.println("\nRendering Application UI:");
        button.render();
        textField.render();
        checkbox.render();
    }
    
    public void interactWithUI() {
        System.out.println("\nInteracting with UI:");
        button.onClick();
        textField.setText("Hello, Design Patterns!");
        checkbox.setChecked(true);
        
        System.out.println("TextField contains: " + textField.getText());
        System.out.println("Checkbox is checked: " + checkbox.isChecked());
    }
}

// =================================================================
// ANOTHER ABSTRACT FACTORY EXAMPLE: Database Connection Factory
// =================================================================
/**
 * ABSTRACT FACTORY PATTERN
 * Purpose: Provide an interface for creating families of related objects
 *          without specifying their concrete classes
 * 
 * Use when:
 * - System needs to be independent of how objects are created
 * - Need to create families of related objects
 * - Want to enforce that related objects are used together
 */

/**
 * EXAMPLE: UI Theme System
 * Different themes (Light, Dark) need different UI components
 * Each theme has its own Button, TextField, and Checkbox
 */

/**
 * Different database types need different connections and commands
 */

// Abstract Products
interface Connection {
    void connect();
    void disconnect();
    String getConnectionType();
}

interface Command {
    void execute(String query);
    String getCommandType();
}

// Concrete Products for MySQL
class MySQLConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("  Connecting to MySQL database...");
    }
    
    @Override
    public void disconnect() {
        System.out.println("  Disconnecting from MySQL database...");
    }
    
    @Override
    public String getConnectionType() {
        return "MySQL Connection";
    }
}

class MySQLCommand implements Command {
    @Override
    public void execute(String query) {
        System.out.println("  Executing MySQL query: " + query);
    }
    
    @Override
    public String getCommandType() {
        return "MySQL Command";
    }
}

// Concrete Products for PostgreSQL
class PostgreSQLConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("  Connecting to PostgreSQL database...");
    }
    
    @Override
    public void disconnect() {
        System.out.println("  Disconnecting from PostgreSQL database...");
    }
    
    @Override
    public String getConnectionType() {
        return "PostgreSQL Connection";
    }
}

class PostgreSQLCommand implements Command {
    @Override
    public void execute(String query) {
        System.out.println("  Executing PostgreSQL query: " + query);
    }
    
    @Override
    public String getCommandType() {
        return "PostgreSQL Command";
    }
}

// Abstract Factory
interface DatabaseFactory {
    Connection createConnection();
    Command createCommand();
}

// Concrete Factories
class MySQLFactory implements DatabaseFactory {
    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }
    
    @Override
    public Command createCommand() {
        return new MySQLCommand();
    }
}

class PostgreSQLFactory implements DatabaseFactory {
    @Override
    public Connection createConnection() {
        return new PostgreSQLConnection();
    }
    
    @Override
    public Command createCommand() {
        return new PostgreSQLCommand();
    }
}

// Client
class DatabaseClient {
    private Connection connection;
    private Command command;
    
    public DatabaseClient(DatabaseFactory factory) {
        this.connection = factory.createConnection();
        this.command = factory.createCommand();
    }
    
    public void performDatabaseOperations() {
        System.out.println("\nPerforming database operations:");
        System.out.println("Using: " + connection.getConnectionType());
        System.out.println("Using: " + command.getCommandType());
        
        connection.connect();
        command.execute("SELECT * FROM users");
        command.execute("INSERT INTO logs VALUES (1, 'test')");
        connection.disconnect();
    }
}

// =================================================================
// MAIN DEMONSTRATION
// =================================================================

public class DesignPatternDemo {
    
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   DESIGN PATTERNS DEMONSTRATION               ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");
        
        // ============================================================
        // PART 1: SINGLETON PATTERN DEMONSTRATION
        // ============================================================
        
        System.out.println("═".repeat(50));
        System.out.println("PART 1: SINGLETON PATTERN");
        System.out.println("═".repeat(50));
        
        System.out.println("\n--- Example 1: Database Connection ---");
        
        // Try to get multiple instances - should get same one
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        DatabaseConnection db3 = DatabaseConnection.getInstance();
        
        System.out.println("\nAre all references the same object?");
        System.out.println("db1 == db2: " + (db1 == db2));
        System.out.println("db2 == db3: " + (db2 == db3));
        System.out.println("db1 == db3: " + (db1 == db3));
        
        db1.executeQuery("SELECT * FROM users");
        db2.executeQuery("UPDATE users SET name='John' WHERE id=1");
        
        System.out.println("\n--- Example 2: Configuration Manager ---");
        
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();
        
        System.out.println("config1 == config2: " + (config1 == config2));
        config1.displayConfig();
        
        System.out.println("\n--- Example 3: Logger ---");
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        
        logger1.info("Application started");
        logger2.warning("Low memory detected");
        logger1.error("Connection failed");
        
        System.out.println("\n✓ SINGLETON KEY POINTS:");
        System.out.println("  • Only ONE instance exists throughout application");
        System.out.println("  • Private constructor prevents external instantiation");
        System.out.println("  • Global access point via getInstance()");
        System.out.println("  • All references point to same object");
        
        // ============================================================
        // PART 2: ABSTRACT FACTORY PATTERN DEMONSTRATION
        // ============================================================
        
        System.out.println("\n\n" + "═".repeat(50));
        System.out.println("PART 2: ABSTRACT FACTORY PATTERN");
        System.out.println("═".repeat(50));
        
        System.out.println("\n--- Example 1: UI Theme System ---");
        
        // Create Light Theme Application
        System.out.println("\n▶ Creating application with LIGHT theme:");
        UIFactory lightFactory = new LightThemeFactory();
        Application lightApp = new Application(lightFactory);
        lightApp.renderUI();
        lightApp.interactWithUI();
        
        // Create Dark Theme Application
        System.out.println("\n▶ Creating application with DARK theme:");
        UIFactory darkFactory = new DarkThemeFactory();
        Application darkApp = new Application(darkFactory);
        darkApp.renderUI();
        darkApp.interactWithUI();
        
        System.out.println("\n--- Example 2: Database System ---");
        
        // Create MySQL Database Client
        System.out.println("\n▶ Creating client with MySQL:");
        DatabaseFactory mysqlFactory = new MySQLFactory();
        DatabaseClient mysqlClient = new DatabaseClient(mysqlFactory);
        mysqlClient.performDatabaseOperations();
        
        // Create PostgreSQL Database Client
        System.out.println("\n▶ Creating client with PostgreSQL:");
        DatabaseFactory postgresFactory = new PostgreSQLFactory();
        DatabaseClient postgresClient = new DatabaseClient(postgresFactory);
        postgresClient.performDatabaseOperations();
        
        System.out.println("\n✓ ABSTRACT FACTORY KEY POINTS:");
        System.out.println("  • Creates families of related objects");
        System.out.println("  • Client code doesn't know concrete classes");
        System.out.println("  • Easy to switch between families (themes, databases)");
        System.out.println("  • Ensures related objects are used together");
        System.out.println("  • Follows Open/Closed Principle (add new families without changing client)");
        
        // ============================================================
        // COMPARISON
        // ============================================================
        
        System.out.println("\n\n" + "═".repeat(50));
        System.out.println("SINGLETON VS ABSTRACT FACTORY");
        System.out.println("═".repeat(50));
        
        System.out.println("\nSINGLETON:");
        System.out.println("  Purpose: Ensure only ONE instance exists");
        System.out.println("  Use: Database connections, loggers, configs");
        System.out.println("  Key: Control instance creation");
        
        System.out.println("\nABSTRACT FACTORY:");
        System.out.println("  Purpose: Create FAMILIES of related objects");
        System.out.println("  Use: UI themes, cross-platform components, database systems");
        System.out.println("  Key: Abstract object creation");
        
        System.out.println("\n" + "═".repeat(50));
        System.out.println("END OF DEMONSTRATION");
        System.out.println("═".repeat(50));
    }
}