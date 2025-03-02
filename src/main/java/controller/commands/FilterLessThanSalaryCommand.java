package controller.commands;

import controller.CommandInterface;
import managers.ServerEntryPoint;

/**
 * Команда, отображающая элементы коллекции, значение поля salary которых меньше заданного значения.
 * Реализует интерфейс {@link CommandInterface} для выполнения операции фильтрации.
 *
 * <p>Эта команда принимает числовое значение в качестве аргумента и выводит все элементы коллекции,
 * у которых значение поля `salary` меньше указанного значения.</p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class FilterLessThanSalaryCommand implements CommandInterface {

    /**
     * Максимальное значение поля salary, используемое для фильтрации элементов коллекции.
     */
    private long maxSalary;

    /**
     * Конструктор, который инициализирует команду с указанным значением для фильтрации.
     *
     * @param argument Значение, используемое для сравнения с полем salary элементов коллекции.
     */
    public FilterLessThanSalaryCommand(long argument){
        this.maxSalary = argument;
    }

    /**
     * Возвращает описание команды, объединяя имя команды с ее действием.
     *
     * @return Строка, описывающая назначение команды.
     */
    @Override
    public String getDescription() {
        return getName() + "вывести элементы, значение поля salary которых меньше заданного";
    }

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
    @Override
    public String getName() {
        return "filter_less_than_salary ";
    }

    /**
     * Выполняет операцию фильтрации элементов коллекции, управляемой {@link ServerEntryPoint#collectionManager}.
     * Выводит элементы, у которых значение поля salary меньше заданного значения.
     */
    @Override
    public void execute(){
        ServerEntryPoint.collectionManager.filterLessThanSalary(maxSalary);
    }
}
