package utility;

/**
 * Класс, содержащий методы для валидации значений полей объектов {@link data.Worker}.
 * Каждый метод проверяет корректность значения определенного поля и возвращает {@code true},
 * если значение соответствует требованиям, и {@code false} в противном случае.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.2
 */
public class ValuesValidator {

    /**
     * Проверяет корректность значения поля ID работника.
     *
     * @param workerID Строка, содержащая значение ID.
     * @return {@code true}, если значение является положительным числом типа {@code Long}, иначе {@code false}.
     */
    public static boolean validateWorkerId(String workerID) {
        try {
            Long x = Long.parseLong(workerID);
            if (x > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    /**
     * Проверяет корректность значения поля имени работника.
     *
     * @param workerName Строка, содержащая имя работника.
     * @return {@code true}, если строка не пуста и не равна {@code null}, иначе {@code false}.
     */
    public static boolean validateWorkerName(String workerName)
    {
        return (workerName != null && !workerName.isEmpty());
    }

    /**
     * Проверяет корректность значения координаты X работника.
     *
     * @param stringX Строка, содержащая значение координаты X.
     * @return {@code true}, если значение является числом типа {@code Long} и больше -975, иначе {@code false}.
     */
    public static boolean validateWorkerCoordinateX(String stringX)
    {
        try {
            Long x = Long.parseLong(stringX);
            if (x > -975) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    /**
     * Проверяет корректность значения координаты Y работника.
     *
     * @param stringY Строка, содержащая значение координаты Y.
     * @return {@code true}, если значение является числом типа {@code Long}, иначе {@code false}.
     */
    public static boolean validateWorkerCoordinateY(String stringY) {
        try {
            long y = Long.parseLong(stringY);
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return true;
    }

    /**
     * Проверяет корректность значения зарплаты работника.
     *
     * @param workerSalary Строка, содержащая значение зарплаты.
     * @return {@code true}, если значение является положительным числом типа {@code Long}, иначе {@code false}.
     */
    public static boolean validateWorkerSalary(String workerSalary) {
        try {
            long salary = Long.parseLong(workerSalary);
            if (salary > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    /**
     * Проверяет корректность значения должности работника.
     *
     * @param workerPosition Строка, содержащая значение должности.
     * @return {@code true}, если значение соответствует одному из допустимых в перечислении:
     * {@code "ENGINEER"}, {@code "HEAD_OF_DEPARTMENT"}, {@code "DEVELOPER"}, иначе {@code false}.
     */
    public static boolean validateWorkerPosition(String workerPosition) {
        return workerPosition.equals("ENGINEER") ||
                workerPosition.equals("HEAD_OF_DEPARTMENT") ||
                workerPosition.equals("DEVELOPER");
    }

    /**
     * Проверяет корректность значения статуса работника.
     *
     * @param workerStatus Строка, содержащая значение статуса.
     * @return {@code true}, если значение соответствует одному из допустимых в перечислении:
     * {@code "FIRED"}, {@code "HIRED"}, {@code "REGULAR"}, {@code "PROBATION"}, иначе {@code false}.
     */
    public static boolean validateWorkerStatus(String workerStatus) {
        return workerStatus.equals("FIRED") ||
                workerStatus.equals("HIRED") ||
                workerStatus.equals("REGULAR") ||
                workerStatus.equals("PROBATION");
    }

    /**
     * Проверяет корректность значения роста работника.
     *
     * @param workerHeight Строка, содержащая значение роста.
     * @return {@code true}, если значение является положительным числом типа {@code Float}, иначе {@code false}.
     */
    public static boolean validateWorkerPersonHeight(String workerHeight)
    {
        try {
            Float x = Float.parseFloat(workerHeight);
            if (x > 0) {
                return true;
            }
        }
        catch (NumberFormatException numberFormatException){
            return false;
        }
        return false;
    }

    /**
     * Проверяет корректность значения цвета.
     *
     * @param workerColor Строка, содержащая значение цвета.
     * @return {@code true}, если значение соответствует одному из допустимых в перечислении:
     * {@code "RED"}, {@code "BLACK"}, {@code "YELLOW"}, {@code "GREEN"}, {@code "BLUE"}, {@code "WHITE"}, иначе {@code false}.
     */
    public static boolean validateWorkerColor(String workerColor) {
        return (workerColor.equals("RED")
                || workerColor.equals("BLACK")
                || workerColor.equals("YELLOW")
                || workerColor.equals("GREEN")
                || workerColor.equals("BLUE")
                || workerColor.equals("WHITE"));
    }

    /**
     * Проверяет корректность значения национальности работника.
     *
     * @param workerCountry Строка, содержащая значение национальности.
     * @return {@code true}, если значение соответствует одному из допустимых в перечислении:
     * {@code "ITALY"}, {@code "THAILAND"}, {@code "NORTH_KOREA"}, иначе {@code false}.
     */
    public static boolean validateWorkerCountry(String workerCountry)
    {
        return workerCountry.equals("ITALY") ||
                workerCountry.equals("THAILAND") ||
                workerCountry.equals("NORTH_KOREA");
    }

}
