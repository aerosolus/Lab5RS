package controller;

import controller.handlers.*;
import exceptions.IncorrectArgumentException;
import client.Main;
import exceptions.InvalidScriptException;
import exceptions.RecursionScriptException;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Класс, отвечающий за выполнение команд и управление их историей.
 * Инициализирует обработчики команд, выполняет их и управляет историей выполненных команд.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class CommandExecutor {

    /**
     * Карта, содержащая обработчики команд, где ключ — имя команды, а значение — обработчик.
     */
    private HashMap<String, HandlerInterface> commands;

    /**
     * История выполненных команд, ограниченная последними 5 командами.
     */
    private final LinkedList<String> commandHistory = new LinkedList<>();

    /**
     * Конструктор по умолчанию. Инициализирует карту команд и регистрирует обработчики.
     */
    public CommandExecutor() {
        commands = new HashMap<>();
        initializeCommands();
    }

    /**
     * Инициализирует карту команд, добавляя обработчик для каждой команды.
     */
    private void initializeCommands() {
        commands.put("help", new HelpHandler());
        commands.put("info", new InfoHandler());
        commands.put("show", new ShowHandler());
        commands.put("add", new AddHandler());
        commands.put("update", new UpdateHandler());
        commands.put("remove_by_id", new RemoveByIdHandler());
        commands.put("clear", new ClearHandler());
        commands.put("save", new SaveHandler());
        commands.put("execute_script", new ExecuteScriptHandler());
        commands.put("exit", new ExitHandler());
        commands.put("add_if_max", new AddIfMaxHandler());
        commands.put("remove_lower", new RemoveLowerHandler());
        commands.put("history", new HistoryHandler());
        commands.put("count_greater_than_person", new CountGreaterThanPersonHandler());
        commands.put("filter_less_than_salary", new FilterLessThanSalaryHandler());
        commands.put("print_field_ascending_person", new PrintFieldAscendingPersonHandler());
    }

    /**
     * Подготавливает команду к выполнению, обрабатывает аргументы и выполняет команду.
     * Также добавляет команду в историю выполненных команд.
     *
     * @param commandName Имя команды для выполнения.
     * @param arguments Аргументы команды.
     */
    public void prepareForShipment(String commandName, String arguments){
        try {
            HandlerInterface handler = commands.get(commandName);
            handler.handle(arguments);
            Main.serverEntryPoint.accomplishCommand(handler);
            addToHistory(commandName);
        } catch (IncorrectArgumentException e) {
            Main.outputManager.printLnToTheOutputStream("Некорректный аргумент для команды!");
        } catch (InvalidScriptException | NumberFormatException e) {
            Main.outputManager.printLnToTheOutputStream("Файл скрипта содержит некорректные данные.");
        } catch (RecursionScriptException e) {
            Main.outputManager.printLnToTheOutputStream("Файл скрипта содержит рекурсию и не может быть корректно исполнен.");
        } catch (NullPointerException exp) {
            Main.outputManager.printLnToTheOutputStream("Команда введена некорректно!");
            Main.outputManager.printLnToTheOutputStream("Введите \"help\", чтобы получить все команды с их именами и описаниями.");
        }
    }

    /**
     * Добавляет команду в историю выполненных команд.
     * Если история превышает 5 команд, удаляет самую первую хранимую команду.
     *
     * @param commandName Имя команды для добавления в историю.
     */
    public void addToHistory(String commandName) {
        commandHistory.addLast(commandName);
        if (commandHistory.size() > 5) {
            commandHistory.removeFirst();
        }
    }

    /**
     * Возвращает историю выполненных команд.
     *
     * @return Список последних выполненных команд.
     */
    public LinkedList<String> getLastCommands() {
        LinkedList<String> history = commandHistory;
        return history;
    }
}
