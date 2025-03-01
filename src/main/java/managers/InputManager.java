package managers;

import client.Main;
import exceptions.InvalidScriptException;
import exceptions.RecursionScriptException;
import utility.TerminalInputValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для управления вводом данных из терминала и скриптов.
 * Обеспечивает чтение команд, их парсинг и обработку, а также чтение скриптов из файлов.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.3
 */
public class InputManager {

    /**
     * Входной поток для чтения данных (например, {@link Scanner}).
     */
    public InputStream inputStream;

    /**
     * Очередь для хранения команд, считанных из скрипта.
     */
    ArrayDeque<String[]> scriptBox = new ArrayDeque<>();

    /**
     * Менеджер для обработки вывода в терминал.
     */
    private final OutputManager outputManager;

    /**
     * Максимальная глубина рекурсии при чтении скриптов.
     */
    private static final int recursion_depth = 5;

    /**
     * Текущая глубина рекурсии при чтении скриптов.
     */
    private static int recursion_count = 0;

    /**
     * Конструктор, инициализирующий менеджер ввода с указанным входным потоком и менеджером вывода.
     *
     * @param inputStream Входной поток для чтения данных.
     * @param outputManager Менеджер для обработки вывода в терминал.
     */
    public InputManager(InputStream inputStream, OutputManager outputManager) {
        this.inputStream = inputStream;
        this.outputManager = outputManager;
    }

    /**
     * Читает ввод из терминала и парсит его в объект {@link TerminalInputValidator}.
     *
     * @return Объект {@link TerminalInputValidator}, представляющий прочитанную команду.
     * @throws NoSuchElementException Если достигнут конец входного потока.
     */
    public TerminalInputValidator readTerminal() {
        try {
            Scanner scanner = new Scanner(inputStream);
            String readLine = scanner.nextLine();
            if (readLine.trim().contains(" ")) {
                return
                        new TerminalInputValidator(readLine.trim().split(" ")[0],
                                readLine.trim().split(" ")[readLine.trim().split(" ").length - 1]);
            } else {
                return
                        new TerminalInputValidator(readLine.trim().split(" ")[0], "");
            }
        } catch (NoSuchElementException e) {
            outputManager.printLnToTheOutputStream("Строка по некой причине не была прочитана!");
            outputManager.printLnToTheOutputStream("Вероятно использовано сочетание Ctrl + D, которое приводит к завершению работы программы.");
            System.exit(1);
        } catch (Exception e) {
            outputManager.printLnWriteCommand();
        }
        return null;
    }

    /**
     * Читает скрипт из файла и сохраняет распарсенные команды в очередь {@code scriptBox}.
     *
     * @param scriptPath Путь к файлу скрипта.
     */
    public void readScript(String scriptPath) {
        if (recursion_count++ >= recursion_depth) {
            recursion_count = 0;
            throw new RecursionScriptException();
        }
        Main.script = true;
        File scriptFile = new File(scriptPath);
        Scanner scriptScanner = null;
        try {
            scriptScanner = new Scanner(scriptFile);
        } catch (FileNotFoundException e) {
            Main.script = false;
            System.out.println("Файл не найден");
        }
        if (scriptScanner != null) {
            while (scriptScanner.hasNextLine()) {
                String readLine = scriptScanner.nextLine();
                if (readLine.isEmpty()) {
                    throw new InvalidScriptException();
                }
                if (readLine.trim().contains(" ")) {
                    scriptBox.add(readLine.trim().split(" "));
                } else {
                    scriptBox.add(new String[]{readLine, ""});
                }
            }
        }
    }

    /**
     * Возвращает следующую строку ввода из терминала.
     *
     * @return Следующая строка ввода или {@code null}, если достигнут конец входного потока.
     * @throws NoSuchElementException Если достигнут конец входного потока.
     */
    public String getNextLine() {
        try {
            Scanner scanners = new Scanner(inputStream);
            return scanners.nextLine();
        } catch (NoSuchElementException e) {
            outputManager.printLnToTheOutputStream("Строка по некой причине не была прочитана!");
            outputManager.printLnToTheOutputStream("Вероятно использовано сочетание Ctrl + D, которое приводит к завершению работы программы.");
            System.exit(1);
        }
        return null;
    }
}
