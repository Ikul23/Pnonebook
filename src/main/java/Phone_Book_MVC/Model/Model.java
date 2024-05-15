package Phone_Book_MVC.Model;


import java.time.LocalDate;

public class Model {
    public static class Person {
        private String lastName;
        private String firstName;
        private String middleName;
        private LocalDate dateOfBirth;
        private long phoneNumber;
        private char gender;

        public Person(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber, char gender) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.dateOfBirth = LocalDate.parse(dateOfBirth, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            this.phoneNumber = phoneNumber;
            this.gender = gender;
        }

        // Геттеры и сеттеры
        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public long getPhoneNumber() {
            return phoneNumber;
        }

        public char getGender() {
            return gender;
        }
    }
}
