package commands;

import exceptions.IncorrectAmountOfArgumentsException;
import utility.TerminalManager;

import java.util.ArrayList;


/**
 * Команда, выводящая справку по доступным командам.
 *
 * <p> Эта команда не принимает аргументов и выводит список всех доступных команд
 * с их описанием в стандартный поток вывода. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class HelpCommand extends AbstractCommand {

    /**
     * Конструктор для создания команды "help".
     * Устанавливает имя команды и её описание.
     */
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Выполняет команду "help".
     * Команда не принимает аргументов. Если аргумент передан, выбрасывается исключение
     * {@link IncorrectAmountOfArgumentsException}.
     *
     * @param argument аргумент команды (должен быть пустым).
     * @return {@code true}, если команда выполнена успешно, {@code false} в случае ошибки.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IncorrectAmountOfArgumentsException();
            TerminalManager.printLn("Работа с коллекцией завершена.");
            ArrayList<String> help_out = new ArrayList<>();
            help_out.add("help : вывести справку по доступным командам");
            help_out.add("info : вывести в стандартный поток вывода информацию о коллекции");
            help_out.add("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("update : обновить значение элемента коллекции, id которого равен заданному");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("clear : очистить коллекцию");
            help_out.add("save : сохранить коллекцию в файл");
            help_out.add("execute_script : считать и исполнить скрипт из указанного файла");
            help_out.add("exit : завершить программу (без сохранения в файл)");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            help_out.add("КОМАНДА : ДЕЙСТВИЕ КОМАНДЫ");
            String output = "";
            output += "Список доступных команд:\n";
            for (String comhelp : help_out) {
                output += "   " + comhelp + "\n";
            }
            TerminalManager.printLn(output);
            return true;
        } catch (IncorrectAmountOfArgumentsException e) {
            TerminalManager.printError("Использование команды '" + getName() + "' с аргументом '" + argument + "'");
        }
        return false;
    }
}
