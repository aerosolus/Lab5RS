package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая сохраняет текущее состояние коллекции в файл.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции сохранения коллекции.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения текущее состояние коллекции
 * записывается в файл с использованием предоставленного {@link utility.CSVWriter}.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class SaveCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "сохранить коллекцию в файл";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "save ";
    }

    /**
     * Выполняет команду "save". Сохраняет текущее состояние коллекции в файл.
     * Управление коллекцией осуществляется через {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute() {
        ServerEntryPoint.collectionManager.save();
    }
}
