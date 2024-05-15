package Phone_Book_MVC.Controller;

import Phone_Book_MVC.Model.Model;
import Phone_Book_MVC.View.View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Controller {
    private View view;
    private final String PHONEBOOK_PATH = "Phonebook.txt";

    public Controller(View view) {
        this.view = view;
    }

    public void savePersonData(Model.Person person) throws IOException {
        String fileName = PHONEBOOK_PATH;
        String formattedData = String.format("%s %s %s %s %d %c",
                person.getLastName(), person.getFirstName(), person.getMiddleName(),
                person.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                person.getPhoneNumber(), person.getGender());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(formattedData);
            writer.newLine();
            view.displaySuccessMessage(fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл:");
            e.printStackTrace();
            throw e;
        }
    }

    public void startSaveLoadMode() throws IOException {
        String inputData = view.getUserInput();
        String[] data = inputData.split(" ");

        if (data.length != 6) {
            view.displayErrorMessage("Неверное количество данных. Ожидалось 6 значений.");
            return;
        }

        Model.Person person = new Model.Person(data[0], data[1], data[2], data[3], Long.parseLong(data[4]), data[5].charAt(0));
        try {
            savePersonData(person);
        } catch (IOException e) {
            view.displayErrorMessage("Произошла ошибка при сохранении данных в файл.");
            throw e;
        }
    }
}
