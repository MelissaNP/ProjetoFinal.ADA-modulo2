package org.example;

public class TaskController {
    ViewerService viewerService = new ViewerServiceImplementation();
    
    public void run() {
        viewerService.load();
        
        int choice = viewerService.viewOptions();
        while (choice != 9) {
            switch (choice) {
                case 1:
                    viewerService.viewAll();
                    break;
                case 2:
                    viewerService.addTask();
                    break;
                case 3:
                    viewerService.editTask();
                    break;
                case 4:
                    viewerService.removeTask();
                    break;
                case 5:
                    viewerService.filterByCategory();
                    break;
            }
            choice = viewerService.viewOptions();
        }
     
    }
}
