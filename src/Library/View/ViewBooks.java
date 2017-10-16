package Library.View;

import Library.Controller.BookController;
import Library.Model.Author;
import Library.Model.MyExceptions.Empty;
import Library.Model.MyExceptions.Samedata;
import Library.Model.MyExceptions.WrongName;
import Library.Model.MyExceptions.WrongSymbols;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ViewBooks {

    private BookController controller;
    private Scanner in;

    public ViewBooks() {

        controller = new BookController();
        in = new Scanner(System.in);
    }

    public void start() { // обработать try catch
        try {
            initialDataLibrary();
            controller.saveData();
            controller.readData();
        } catch (Exception e) {
            System.err.println("Не удалось получить данные из библиотеки");
        }
        boolean flag = true;
        while (flag) {
            int choice = 0;
            Menu();
            choice = in.nextInt();
            try{
                switch (choice) {
                    case 1:
                        System.out.println(controller.getGenreList());
                        break;
                    case 2:
                        System.out.println(controller.getBookList());
                        break;
                    case 3:
                        System.out.println("Хотите получить список книг?" + "\n" + "1 - ДА" + "\n" + "2 - НЕТ");
                        int key = in.nextInt();
                        if (key == 1) {
                            System.out.println(controller.getBookList());
                            System.out.println("Введите ID книги:");
                            int ID = in.nextInt();
                            controller.deleteBookbyID(ID);
                        }
                        if (key == 2) {
                            System.out.println("Введите ID книги:");
                            int ID = in.nextInt();
                            controller.deleteBookbyID(ID);
                        }
                        break;
                    case 4:
                        System.out.println("Введите название жанра, которого хотите добавить:");
                        String name = in.next();
                        System.out.println("Введите возраст жанра:");
                        double age = in.nextDouble();
                        if (controller.addGenre(name, age)) {
                            System.out.println("Жанр успешно добавлен");
                        }
                        System.err.println("Некорректно введены данные");
                        break;
                    case 5:
                        System.out.println("Хотите получить список жанров?" + "\n" + "1 - ДА" + "\n" + "2 - НЕТ");
                        int key1 = in.nextInt();
                        if (key1 == 1) {
                            System.out.println(controller.getGenreList());
                            System.out.println("Введите название жанра, которого хотите удалить:");
                            String namegenre = in.next();
                            controller.deleteGenre(namegenre);
                            System.out.println("Удаление жанра произошло успешно");

                        }
                        if (key1 == 2) {
                            System.out.println("Введите название жанра, которого хотите удалить:");
                            String namegenre = in.next();
                            controller.deleteGenre(namegenre);
                            System.out.println("Удаление жанра прошло успешно");
                        }
                        break;
                    case 6:
                        System.out.println("Нажмите 1: если хотите добавить аудиокнигу;\nНажмите 2: если хотите добавить текстовую книгу");
                        int i = in.nextInt();
                        if (i == 1) {
                            System.out.println("Введите название книги:");
                            String namebook = in.next();
                            System.out.println("Введите автора книги:");
                            String authorbook = in.next();
                            System.out.println("Введите ID жанра, который соответствует книге:");
                            int genreID = in.nextInt();
                            System.out.println("Введите длительность книги в минутах:");
                            double duractionBook = in.nextDouble();
                            System.out.println("Введите размер книги в MB:");
                            double size = in.nextDouble();
                            if (controller.addBookAudio(namebook, controller.getAuthor(authorbook), genreID, duractionBook, size)) {
                                System.out.println("Книга успешно добавлена");
                            }
                        }
                        if (i == 2) {
                            System.out.println("Введите название книги:");
                            String namebook = in.next();
                            System.out.println("Введите автора книги:");
                            String authorbook = in.next();
                            System.out.println("Введите ID жанра, который соответствует книге:");
                            int genreID = in.nextInt();
                            System.out.println("Введите количество страниц книги:");
                            int pages = in.nextInt();
                            if (controller.addBookText(namebook, controller.getAuthor(authorbook), genreID, pages)) {
                                System.out.println("Книга успешно добавлена");
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Введите название книги, которое хотите получить:");
                        String nameBook = in.next();
                        controller.getBookbyName(nameBook);
                        break;
                    case 8:
                        System.out.println(controller.getAuthors());
                        break;
                    case 9:
                        System.out.println("Введите название книги для поиска по буквам:");
                        String nameBook1 = in.next();
                        if (controller.researchBooks(nameBook1).isEmpty()) {
                            System.err.println("Поиск не дал результатов");
                        } else {
                            System.out.println(controller.researchBooks(nameBook1));
                        }
                        break;
                    case 10:
                        System.out.println("Всего доброго, мы ждем вас сного");
                        flag = false;
                        controller.saveData();
                        break;
                    default:
                        System.out.println("Функции с таким номером не существует, пожалуйста введите заного номер функции");
                }}catch (Exception e){
                System.err.println("Ошибка с вводом данных, попробуйте еще раз");
            }
        }
    }

    public void initialDataLibrary() throws Samedata, WrongSymbols {

        controller.addGenre("Драма", 85); //1
        controller.addGenre("Мелодрама", 85); //2
        controller.addGenre("Путешествие", 120); //3
        controller.addGenre("Исторический", 500); //4
        controller.addGenre("Фантастика", 50); //5
        controller.addGenre("Фентези", 50); //6
        controller.addGenre("Документальный", 80); //7
        controller.addGenre("Научный", 40); //8

        controller.addBookAudio("Университет", controller.getAuthor("Чунихин"), 1, 250, 50);
        controller.addBookAudio("Мыло", controller.getAuthor("Пушкин"), 2, 560, 256.23);
        controller.addBookAudio("Сапог", controller.getAuthor("Лермантов"), 3, 2220, 512.32);
        controller.addBookAudio("Телевизор", controller.getAuthor("Михель"), 4, 25, 23.21);
        controller.addBookAudio("Туалет", controller.getAuthor("Суровикин"), 5, 600, 356.43);
        controller.addBookAudio("Звук", controller.getAuthor("Дудукин"), 6, 450, 234.22);
        controller.addBookAudio("Терминатор", controller.getAuthor("Хромов"), 7, 25, 24.23);
        controller.addBookAudio("Колонки", controller.getAuthor("Бузин"), 1, 57, 62.22);
        controller.addBookAudio("Ручка", controller.getAuthor("Липкин"), 2, 189, 163.33);
        controller.addBookAudio("Полка", controller.getAuthor("Садыков"), 3, 5, 11.11);
        controller.addBookText("Колобок", controller.getAuthor("Кирпичов"), 2, 35);
        controller.addBookText("Кот", controller.getAuthor("Прыганова"), 1, 25);
        controller.addBookText("Собака", controller.getAuthor("Самолетов"), 3, 55);
        controller.addBookText("Телега", controller.getAuthor("Шикин"), 5, 25);
        controller.addBookText("Муравей", controller.getAuthor("Куло"), 4, 15);
        controller.addBookText("Крокодил", controller.getAuthor("Коростелев"), 6, 25);
        controller.addBookText("Саранча", controller.getAuthor("Долотов"), 7, 75);
        controller.addBookText("Почемучка", controller.getAuthor("Кремнев"), 8, 28);
        controller.addBookText("Планета", controller.getAuthor("Зубенко"), 8, 25);
        controller.addBookText("Светильник", controller.getAuthor("Капустин"), 1, 29);

    }


    public void Menu() {
        System.out.println("Добро пожаловать гость, в электронную библиотеку! Выберите действие, которое хотите совершить: ");
        System.out.println("1 - Получить список жанров");
        System.out.println("2 - Получить список книг");
        System.out.println("3 - Удалить книгу по ID");
        System.out.println("4 - Добавить жанр по имени и возрасту");
        System.out.println("5 - Удалить жанр по имени");
        System.out.println("6 - Добавить книгу по названию, автору, жанру и типу книги(Audio или Text)");
        System.out.println("7 - Получить книгу по названию");
        System.out.println("8 - Получить список авторов");
        System.out.println("9 - Поиск книги по буквам в названии");
        System.out.println("10 - Выход");
    }
}
