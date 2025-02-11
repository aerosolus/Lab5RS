package utility;

/**
 * Управляет интерфейсом терминала для взаимодействия с пользователем.
 * Этот класс обрабатывает пользовательский ввод, делает вывод, реализует чтение скрипта и выполнение команд.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class TerminalManager {

    public static void printLn(Object argument) {
        System.out.println(argument);
    }

    public static void printError(Object argument) {
        System.out.println("Ошибка: " + argument + ".");
    }

    public static void readScript(String argument) {
        System.out.println("Чтение скрипта");
    }

    //реализовать выполнение команд через hashMap а не через if cases
}
