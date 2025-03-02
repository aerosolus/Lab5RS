package controller.commands;

import client.Main;
import controller.CommandInterface;

/**
 * Команда, которая выводит историю последних выполненных команд.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции вывода истории команд.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения в стандартный поток вывода
 * выводится список последних 5 выполненных команд (без их аргументов).</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class HistoryCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести последние 5 команд (без их аргументов)";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "history ";
    }

    /**
     * Выполняет команду "history". Выводит список последних 5 выполненных команд
     * (без их аргументов) в стандартный поток вывода.
     */
    @Override
    public void execute() {
        Main.terminalManager.printHistory();
    }
}
