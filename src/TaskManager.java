import java.util.ArrayList;
import javax.swing.*;

public class TaskManager {

    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        ImageIcon taskIcon = new ImageIcon("task_icon.png");

        while (true) {
            String[] options = {"Add Task", "View Tasks", "Mark Task Complete", "Delete Task", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, 
                                                      "<html><h2>Task Manager</h2><p>Select an option:</p></html>", 
                                                      "Task Manager", 
                                                      JOptionPane.DEFAULT_OPTION, 
                                                      JOptionPane.PLAIN_MESSAGE, 
                                                      taskIcon, 
                                                      options,   
                                                      options[0]);

            switch (choice) {
                case 0: // Add Task
                    addTask(taskIcon);
                    break;
                case 1: // View Tasks
                    viewTasks(taskIcon);
                    break;
                case 2: // Mark Task Complete
                    markTaskComplete(taskIcon);
                    break;
                case 3: // Delete Task
                    deleteTask(taskIcon);
                    break;
                case 4: // Exit
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static void addTask(ImageIcon taskIcon) {
        String task = JOptionPane.showInputDialog(null, 
                                                  "<html><h3>Enter a new task:</h3></html>", 
                                                  "Add Task", 
                                                  JOptionPane.PLAIN_MESSAGE, 
                                                  taskIcon, 
                                                  null, 
                                                  "").toString();
        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task);
            JOptionPane.showMessageDialog(null, 
                                          "<html><h3>Task added successfully!</h3></html>", 
                                          "Task Added", 
                                          JOptionPane.INFORMATION_MESSAGE, 
                                          taskIcon);
        } else {
            JOptionPane.showMessageDialog(null, 
                                          "<html><h3>No task entered. Please try again.</h3></html>", 
                                          "Input Error", 
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void viewTasks(ImageIcon taskIcon) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                                          "<html><h3>No tasks available.</h3></html>", 
                                          "View Tasks", 
                                          JOptionPane.INFORMATION_MESSAGE, 
                                          taskIcon);
        } else {
            StringBuilder taskList = new StringBuilder("<html><h3>Your Tasks:</h3><ul>");
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append("<li>").append(tasks.get(i)).append("</li>");
            }
            taskList.append("</ul></html>");
            JOptionPane.showMessageDialog(null, 
                                          taskList.toString(), 
                                          "View Tasks", 
                                          JOptionPane.INFORMATION_MESSAGE, 
                                          taskIcon);
        }
    }

    private static void markTaskComplete(ImageIcon taskIcon) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                                          "<html><h3>No tasks available to mark as complete.</h3></html>", 
                                          "Mark Task Complete", 
                                          JOptionPane.INFORMATION_MESSAGE, 
                                          taskIcon);
        } else {
            String[] taskArray = tasks.toArray(new String[0]);
            String task = (String) JOptionPane.showInputDialog(null, 
                                                               "<html><h3>Select a task to mark as complete:</h3></html>", 
                                                               "Mark Task Complete", 
                                                               JOptionPane.QUESTION_MESSAGE, 
                                                               taskIcon, 
                                                               taskArray, 
                                                               taskArray[0]);
            if (task != null) {
                tasks.remove(task);
                JOptionPane.showMessageDialog(null, 
                                              "<html><h3>Task marked as complete!</h3></html>", 
                                              "Task Complete", 
                                              JOptionPane.INFORMATION_MESSAGE, 
                                              taskIcon);
            }
        }
    }

    private static void deleteTask(ImageIcon taskIcon) {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                                          "<html><h3>No tasks available to delete.</h3></html>", 
                                          "Delete Task", 
                                          JOptionPane.INFORMATION_MESSAGE, 
                                          taskIcon);
        } else {
            String[] taskArray = tasks.toArray(new String[0]);
            String task = (String) JOptionPane.showInputDialog(null, 
                                                               "<html><h3>Select a task to delete:</h3></html>", 
                                                               "Delete Task", 
                                                               JOptionPane.QUESTION_MESSAGE, 
                                                               taskIcon, 
                                                               taskArray, 
                                                               taskArray[0]);
            if (task != null) {
                tasks.remove(task);
                JOptionPane.showMessageDialog(null, 
                                              "<html><h3>Task deleted successfully!</h3></html>", 
                                              "Task Deleted", 
                                              JOptionPane.INFORMATION_MESSAGE, 
                                              taskIcon);
            }
        }
    }
}
