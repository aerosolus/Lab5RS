package managers;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Управляет выводом данных в терминал, информированием пользователя.
 * Обеспечивает методы для вывода сообщений, ошибок и записи данных в выходной поток.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.3
 */
public class OutputManager {

    /**
     * Выходной поток для записи в терминал
     */
    private final OutputStream outputStream;

    /**
     * Конструктор, инициализирующий менеджер вывода с указанным выходным потоком.
     *
     * @param outputStream Выходной поток для записи данных (например, {@link System#out}).
     */
    public OutputManager(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Статический метод, который выводит объект в стандартный поток вывода без перевода строки.
     *
     * @param argument Объект для вывода (будет преобразован в строку через {@link Object#toString()}).
     */
    public static void print(Object argument) {
        System.out.println(argument);
    }

    /**
     * Выводит переданный объект в стандартный поток вывода с переводом строки.
     *
     * @param argument Объект для вывода (будет преобразован в строку через {@link Object#toString()}).
     */
    public void printLn(Object argument) {
        System.out.println(argument);
    }

    /**
     * Выводит сообщение об ошибке в стандартный поток вывода.
     *
     * @param argument Описание ошибки (будет дополнено предупреждением "Ошибка: ").
     */
    public static void printError(Object argument) {
        System.out.println("Ошибка: " + argument + ".");
    }

    /**
     * Выводит приглашение для ввода команды в стандартный поток вывода.
     */
    public void printLnWriteCommand(){
        System.out.println("Введите команду:");
    }

    /**
     * Записывает строку в указанный выходной поток с добавлением перевода строки.
     * В случае ошибки ввода-вывода выводит трассировку стека.
     *
     * @param string Строка для записи в поток.
     */
    public void printLnToTheOutputStream(String string)
    {
        try {
            outputStream.write((string+"\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
