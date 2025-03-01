package client;

import controller.CommandExecutor;
import managers.InputManager;
import managers.OutputManager;
import managers.ServerEntryPoint;
import managers.TerminalManager;

import java.util.StringJoiner;

/**
 * Главный класс клиентского приложения, отвечающий за запуск программы и инициализацию основных компонентов.
 * Управляет входными и выходными данными, а также взаимодействием с компонентами программы.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.0
 */
public class Main {

    /**
     * Флаг, указывающий, работает ли программа в режиме скрипта.
     */
    public static boolean script = false;

    /**
     * Менеджер для обработки вывода в терминал.
     */
    public static OutputManager outputManager;

    /**
     * Менеджер для обработки ввода из терминала.
     */
    public static InputManager inputManager;

    /**
     * Точка входа для операций сервера.
     */
    public static ServerEntryPoint serverEntryPoint;

    /**
     * Менеджер для обработки взаимодействия с терминалом и выполнения команд.
     */
    public static TerminalManager terminalManager;

    /**
     * Основной метод, запускающий клиентское приложение.
     *
     * @param args Аргумент командной строки должен содержать путь к файлу.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            OutputManager.print("Введите путь к файлу в качестве аргумента командной строки.");
            System.exit(1);
        } else {
            StringJoiner filePath = new StringJoiner(" ");
            for (String arg : args) {
                filePath.add(arg);
            }
            serverEntryPoint = new ServerEntryPoint(filePath.toString());
            outputManager = new OutputManager(System.out);
            inputManager = new InputManager(System.in, outputManager);
            CommandExecutor commandExecutor = new CommandExecutor();
            terminalManager = new TerminalManager(commandExecutor, inputManager, outputManager);
            terminalManager.start();
        }
    }
}