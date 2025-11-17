package CS282_Fall25;
import java.util.*;

public class UnboundedWildcard {

    // Works for List<String>, List<Integer>, List<CustomClass>, etc.
    public static void printLogs(List<?> logs) {
        for (Object log : logs) {
            System.out.println(log);
        }
        // logs.add("New")  // Not allowed — type not known
    }

    public static void main(String[] args) {
        List<String> systemMessages = List.of("Boot OK", "Temp Stable", "Shutting Down");
        List<Integer> errorCodes = List.of(200, 404, 503);

        printLogs(systemMessages);
        printLogs(errorCodes);
    }
}

