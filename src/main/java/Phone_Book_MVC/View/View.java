package Phone_Book_MVC.View;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        System.out.println("Пример ввода:");
        System.out.println("Ivanov Ivan Ivanovich 01.01.2000 1234567890 m");
        String input = scanner.nextLine().trim(); // Удаляем начальные и конечные пробелы
        return input;
    }

    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void displaySuccessMessage(String fileName) {
        System.out.println("Данные успешно сохранены в файл " + fileName);
    }

    public void closeScanner() {
        scanner.close();
    }
}
