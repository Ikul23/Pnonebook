package Phone_Book_MVC;

import Phone_Book_MVC.Controller.Controller;
import Phone_Book_MVC.View.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        View view = new View();


        Controller controller = new Controller(view);


        try {
            controller.startSaveLoadMode();
        } catch (IOException e) {
            System.err.println("Произошла ошибка ввода-вывода: " + e.getMessage());
        }


        view.closeScanner();
    }
}
