package controller.commands;

import client.Main;
import controller.CommandInterface;

import java.util.ArrayList;

/**
 * Команда, которая выводит справку по доступным командам.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции вывода информации о командах.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения в стандартный поток вывода
 * выводится список всех доступных команд с их описанием.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.0
 */
public class HelpCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести справку по доступным командам";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "help ";
    }

    /**
     * Выполняет команду "help". Выводит список всех доступных команд с их описанием
     * в стандартный поток вывода.
     */
    @Override
    public void execute() {
        ArrayList<String> help_out = new ArrayList<>();
        help_out.add("help : вывести справку по доступным командам");
        help_out.add("info : вывести в стандартный поток вывода информацию о коллекции");
        help_out.add("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        help_out.add("add : добавить новый элемент в коллекцию");
        help_out.add("update : обновить значение элемента коллекции, id которого равен заданному");
        help_out.add("remove_by_id : удалить элемент из коллекции по его id");
        help_out.add("clear : очистить коллекцию");
        help_out.add("save : сохранить коллекцию в файл");
        help_out.add("execute_script : считать и исполнить скрипт из указанного файла");
        help_out.add("exit : завершить программу (без сохранения в файл)");
        help_out.add("add_if_max : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        help_out.add("remove_lower : удалить из коллекции все элементы, меньшие, чем заданный");
        help_out.add("history : вывести последние 5 команд (без их аргументов)");
        help_out.add("count_greater_than_person : вывести количество элементов, значение поля person которых больше заданного");
        help_out.add("filter_less_than_salary : вывести элементы, значение поля salary которых меньше заданного");
        help_out.add("print_field_ascending_person : вывести значения поля person всех элементов в порядке возрастания");
        String output = "";
        output += "Список доступных команд:\n";
        for (String comhelp : help_out) {
            output += comhelp + "\n";
        }
        Main.outputManager.printLn(output);
        }
}
