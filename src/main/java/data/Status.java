package data;

/**
 * Перечисление, представляющее различные статусы.
 * Каждая константа перечисления соответствует определённому статусу.
 *
 * <p> Это перечисление может использоваться для представления статусов в различных контекстах, например,
 * выбор статуса пользователем. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.1
 */
public enum Status {

    /**
     * Уволенный сотрудник
     */
    FIRED,

    /**
     * Нанятый сотрудник
     */
    HIRED,

    /**
     * Штатный сотрудник
     */
    REGULAR,

    /**
     * Сотрудник на испытательном сроке
     */
    PROBATION;

    /**
     * Преобразует все значения перечисления в строку, разделённую запятыми.
     * Используется для отображения или логирования всех доступных статусов.
     *
     * @return строка, содержащая все значения перечисления, разделённые запятыми.
     */
    public static String nameToString() {
        StringBuilder nameToString = new StringBuilder();
        for (Status status : values()) {
            nameToString.append(status.name()).append(", ");
        }
        return nameToString.substring(0, nameToString.length()-2);
    }
}
