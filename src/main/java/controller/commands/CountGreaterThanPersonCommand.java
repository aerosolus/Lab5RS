package controller.commands;

import controller.CommandInterface;
import data.Person;
import managers.ServerEntryPoint;

/**
 * Команда, подсчитывающая количество элементов коллекции, у которых значение поля person
 * больше заданного объекта {@link Person}.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции подсчета.
 *
 * <p>Этот класс принимает объект {@link Person} и подсчитывает количество элементов в коллекции,
 * управляемой {@link ServerEntryPoint#collectionManager}, у которых значение поля `person`
 * больше заданного объекта.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class CountGreaterThanPersonCommand implements CommandInterface {

    /**
     * Объект {@link Person}, используемый для сравнения с полем `person` элементов коллекции.
     */
    private Person lowPerson;

    /**
     * Конструктор, который инициализирует команду с указанным объектом {@link Person}.
     *
     * @param argument Объект {@link Person}, который будет использоваться для сравнения.
     */
    public CountGreaterThanPersonCommand(Person argument){
        this.lowPerson = argument;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести количество элементов, значение поля person которых больше заданного";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "count_greater_than_person ";
    }

    /**
     * Выполняет операцию подсчета количества элементов коллекции, у которых значение поля `person`
     * больше заданного объекта {@link Person}. Результат выводится через {@link ServerEntryPoint#collectionManager}.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.countGreaterThanPerson(lowPerson);
    }
}
