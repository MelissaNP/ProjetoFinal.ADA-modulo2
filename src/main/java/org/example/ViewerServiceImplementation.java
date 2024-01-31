package org.example;

import java.util.List;
import java.util.Scanner;

public class ViewerServiceImplementation implements ViewerService {
    TaskService<Task> taskService = new TaskServiceImplementation();
    private List<Task> tasks;
    private Scanner sc = new Scanner(System.in);
    
  
    @Override
    public void load() {
        tasks = taskService.loadAll();
        
        if (tasks.size() > 0)
            System.out.printf("Loaded [%d] tasks into the task manager.\n", tasks.size());
        else
            System.out.println("There aren't any tasks available to load.");
    }
  
    
    @Override
    public int viewOptions() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("\n===== Task Manager =====\n\n");
        sb.append("\t1) View all tasks \n");
        sb.append("\t2) Add a task \n");
        sb.append("\t3) Edit a task \n");
        sb.append("\t4) Remove a task \n");
        sb.append("\t5)  Filter tasks by categories \n");
        sb.append("Choose [1-5]: ");
        
        System.out.print(sb);
        
        String selection = sc.next();
        while (!selection.matches("[1-5]")) {
            System.out.print("Please choose correct choice [1-6]: ");
            selection = sc.next();
        }
        
        int choice = Integer.parseInt(selection);
        return choice;
    }
    
  
    @Override
    public void viewAll() {
        System.out.println("\n===== View Tasks =====\n");
        if (tasks.size() > 0) {
            for (Task task : tasks) {
                System.out.println("\t[" + task.getId() + "] " + task.getTitle());
            }
        } else {
            System.out.println("\tThere aren't any tasks available.");
        }
    }
    
  
    @Override
    public void addTask() {
        System.out.println("\n===== Add a Task =====");
        int category;
        while (true) {
            System.out.println("Enter the category of the task");
            System.out.println("1 for HomeTask");
            category = sc.nextInt();
            sc.nextLine();
            
            if (category == 1) {
                break;
            } else {
                System.out.println("Invalid category.");
            }
        }
        
        Task newTask;
        switch (category) {
            case 1:
                newTask = new HomeTask();
                break;
            default:
                System.out.println("Invalid category. Creating a default task.");
                newTask = new Task();
                break;
        }
        
        System.out.println("Enter the title of the task: ");
        String title = sc.nextLine();
        
        newTask.setTitle(title);
      
        String status = taskService.save(newTask);
        
    
        System.out.println(status);
    }
  
    @Override
    public void editTask() {
        System.out.println("\n===== Edit a Task =====\n");
        
        System.out.println("===== View Tasks =====\n");
        if (tasks.size() > 0) {
            for (Task task : tasks) {
                System.out.println("\t[" + task.getId() + "] " + task.getTitle());
            }
        } else {
            System.out.println("\tThere aren't any tasks available to edit.");
            return;
        }
        
        // Input ID of the task to edit
        System.out.print("\n Enter the ID of the task you want to edit: ");
        int id = sc.nextInt();
        sc.nextLine();
        
      
        Task task = taskService.get(id);
        if (task != null) {
            System.out.print("Enter the new title of the task or press enter to leave unchanged: ");
            String newTitle = sc.nextLine();
            if (!newTitle.isEmpty()) {
                String status = taskService.update(id, newTitle);
                System.out.println("\n" + status);
            } else {
                System.out.println("\n No changes were made to the task.");
            }
        } else {
            System.out.println("\n Task with ID [" + id + "] not found.");
        }
    }
    @Override
    public void removeTask() {
        System.out.println("\n===== Remove a Task =====\n");
        System.out.print("Enter the ID of the task you want to remove: ");
        int id = sc.nextInt();
        Task task = taskService.get(id);
        if (task != null) {
            System.out.print("Are you sure you want to remove task [" + task + "]? (y/n): ");
            String confirmation = sc.next();
            if (confirmation.equalsIgnoreCase("y")) {
                String status = taskService.delete(id);
                System.out.println("\n" + status);
            } else {
                System.out.println("\nTask removal cancelled.");
            }
        } else {
            System.out.println("\nTask with ID [" + id + "] not found.");
        }
    }
    
    public void filterByCategory() {
        System.out.println("\n===== Filter by Category =====");
        System.out.println("Enter the category to filter (1 for HomeTask): ");
        int category = sc.nextInt();
        sc.nextLine();
        
        System.out.println("\n===== Tasks in Category " + getCategoryName(category) + " =====");
        for (Task task : tasks) {
            if (task instanceof HomeTask && category == 1) {
                System.out.println("\t[" + task.getId() + "] " + task.getTitle());
            }
        }
    }
    
    private String getCategoryName(int category) {
        switch (category) {
            case 1:
                return "HomeTask";
            default:
                return "Unknown";
        }
    }
   
}
