package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, которая выводит значения поля person всех элементов коллекции в порядке возрастания.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции вывода значений поля person.
 *
 * <p>Эта команда не принимает аргументов. После её выполнения в стандартный поток вывода
 * выводятся значения поля `person` всех элементов коллекции, отсортированные в порядке возрастания.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class PrintFieldAscendingPersonCommand implements CommandInterface {

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести значения поля person всех элементов в порядке возрастания";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "print_field_ascending_person ";
    }

    /**
     * Выполняет команду "print_field_ascending_person". Выводит значения поля person
     * всех элементов коллекции в порядке возрастания в стандартный поток вывода.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.printFieldAscendingPerson();
    }
}
