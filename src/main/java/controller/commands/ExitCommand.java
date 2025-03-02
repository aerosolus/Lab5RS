package controller.commands;

import controller.CommandInterface;

import static client.Main.outputManager;

/**
 * Команда, которая завершает работу программы без сохранения данных в файл.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции завершения программы.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения программа завершает свою работу
 * без сохранения текущего состояния коллекции в файл.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class ExitCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "завершить программу (без сохранения в файл)";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "exit ";
    }

    /**
     * Выполняет операцию завершения программы. После выполнения команды программа завершает свою работу
     * с выводом соответствующего сообщения.
     */
    @Override
    public void execute() {
        outputManager.printLn("Работа программы завершена.");
        System.exit(0);
    }
}
