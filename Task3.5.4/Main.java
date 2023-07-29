/*
Написать программу «Книжный магазин», расположенную в специальном пакете.
В программе создать класс «книга», состояние которого описывается параметрами:
«название книги» (строковый), «цена» (целочисленный), «дата издания» (целочисленный).
В основном классе создать «картотеку книг», представленную массивом «книг».
В основном или отдельном классе создать статический метод/методы, который будет осуществлять проверку по параметрам
«название книги» и «год выпуска». Есть ли такая книга в картотеке: если есть — выдавать соответствующее сообщение),
если нет — добавлять книгу в картотеку (выдавать сообщения о добавлении книги).
Если массив (картотека) заполнен — выдавать сообщение об этом.
Проверку строчных параметров («название книги») можно организовать встроенным методом String equals.
⭐ Добавить метод, который выводит в консоль (на печать) всю информацию о всех книгах (название, год издания, цену)
без конкатенации, при помощи форматирования.
Пример вывода:
книга №1: название: "The Hobbit", год издания: 1937г., цена - 999usd
книга №2: название: "......", год издания: …...г., цена - ….usd
 */

import shop.Book;

public class Main {
    static int n = 10;
    static Book[] books = new Book[n];
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.setName("The Hobbit");
        book1.setPrice(999);
        book1.setData(1937);

        bookAdd(books, book1);

        Book book2 = new Book();
        book2.setName("The Hobbit2");
        book2.setPrice(999);
        book2.setData(1938);

        bookAdd(books, book2);

        Book book3 = new Book();
        book3.setName("The Hobbit2");
        book3.setPrice(999);
        book3.setData(1938);

        bookAdd(books, book3);

        booksPrint(books);
    }

    public static boolean bookCheck(Book[] books, Book book) {
        for (Book value : books) {
            if (value == null) return false;
                if (value.getName().equals(book.getName()) && value.getData() == book.getData()) {
                    return true;
                }
            }
        return false;
    }

    public static void bookAdd(Book[] books, Book book) {
        if (!bookCheck(books, book)) {
            for (int i = 0; i < books.length; i++) {
                if (books[i] == null) {
                    books[i] = book;
                    System.out.printf("Книга %s добавлена в картотеку\n", book.getName());
                    break;
                }
            }
        } else {
            System.out.printf("Книга %s уже есть в картотеке\n", book.getName());
        }
    }

    public static void booksPrint(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.printf("Книга №%d: название: %s, год издания: %dг., цена - %dusd\n", (i+1), books[i].getName(), books[i].getData(), books[i].getPrice());
            } else {
                break;
            }
        }
    }
}