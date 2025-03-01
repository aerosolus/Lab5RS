package utility;

import data.Color;
import data.Country;
import data.Position;
import data.Status;
import managers.InputManager;
import managers.OutputManager;

/**
 * Класс, предназначенный для получения и валидации значений полей объекта {@link data.Worker} через терминал.
 * Использует {@link InputManager} для ввода данных и {@link OutputManager} для вывода сообщений.
 * Каждый метод запрашивает у пользователя значение определенного поля и проверяет его корректность с помощью {@link ValuesValidator}.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.2
 */
public class WorkerFieldsValuesGetter {

    /**
     * Менеджер для обработки ввода в терминал.
     */
    private final InputManager inputManager;

    /**
     * Менеджер для обработки вывода в терминал.
     */
    private final OutputManager outputManager;

    /**
     * Конструктор, инициализирующий объект с указанными менеджерами ввода и вывода.
     *
     * @param inputManager Менеджер для обработки ввода в терминал.
     * @param outputManager Менеджер для обработки вывода в терминал.
     */
    public WorkerFieldsValuesGetter(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    /**
     * Запрашивает и возвращает имя работника.
     *
     * @return Корректное имя работника.
     */
    public String getWorkerName() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите имя работника.");
            String name = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerName(name)) {
                return name;
            } else
                outputManager.printLnToTheOutputStream("Поле name объекта Worker не может быть null и не может быть пустой строкой!");
        }
    }

    /**
     * Запрашивает и возвращает координату X работника.
     *
     * @return Корректное значение координаты X.
     */
    public Long getWorkerCoordinateX() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите координату X работника.");
            String stringX = inputManager.getNextLine();
            Long x = 0L;
            try {
                x = Long.parseLong(stringX);
            } catch (NumberFormatException numberFormatException) {
                outputManager.printLnToTheOutputStream("Координата x должна быть типом Long!");
                continue;
            }
            if (ValuesValidator.validateWorkerCoordinateX(stringX)) {
                return x;
            }
            else {
                outputManager.printLnToTheOutputStream("Значение координаты должно быть больше -975.");
            }
        }
    }

    /**
     * Запрашивает и возвращает координату Y работника.
     *
     * @return Корректное значение координаты Y.
     */
    public long getWorkerCoordinateY() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите координату Y работника.");
            String stringY = inputManager.getNextLine();
            long y = 0;
            try {
                y = Long.parseLong(stringY);
            } catch (NumberFormatException numberFormatException) {
                outputManager.printLnToTheOutputStream("Координата y должна быть примитивным типом long!");
                continue;
            }
            if (ValuesValidator.validateWorkerCoordinateY(stringY))
                return y;
        }
    }

    /**
     * Запрашивает и возвращает зарплату работника.
     *
     * @return Корректное значение зарплаты.
     */
    public long getWorkerSalary() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите заработную плату работника.");
            String stringSalary = inputManager.getNextLine();
            long salary = 0;
            try {
                salary = Long.parseLong(stringSalary);
            } catch (NumberFormatException numberFormatException) {
                outputManager.printLnToTheOutputStream("Заработная плата должна быть типом Long!");
                continue;
            }
            if (ValuesValidator.validateWorkerSalary(stringSalary))
                return salary;
            else {
                outputManager.printLnToTheOutputStream("Значение заработной платы должно быть больше 0.");
            }
        }
    }

    /**
     * Запрашивает и возвращает должность работника.
     *
     * @return Корректное значение должности.
     */
    public Position getWorkerPosition() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите позицию - выберете одно из значений:" + Position.nameToString() + ".");
            String position = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerPosition(position)) {
                return Position.valueOf(position);
            } else
                outputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    /**
     * Запрашивает и возвращает статус работника.
     *
     * @return Корректное значение статуса.
     */
    public Status getWorkerStatus() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите статус - выберете одно из значений:" + Status.nameToString() + ".");
            String status = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerStatus(status)) {
                return Status.valueOf(status);
            } else
                outputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    /**
     * Запрашивает и возвращает рост работника.
     *
     * @return Корректное значение роста.
     */
    public Float getWorkerHeight() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите рост работника.");
            String height = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerPersonHeight(height)) {
                return Float.valueOf(height);
            } else {
                outputManager.printLnToTheOutputStream("Значение роста должно быть больше 0.");
            }
        }
    }

    /**
     * Запрашивает и возвращает цвет глаз работника.
     *
     * @return Корректное значение цвета глаз.
     */
    public Color getWorkerEyeColor() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите цвет глаз - выберете одно из значений:" + Color.nameToString() + ".");
            String eyeColor = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerColor(eyeColor)) {
                return Color.valueOf(eyeColor);
            } else
                outputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    /**
     * Запрашивает и возвращает цвет волос работника.
     *
     * @return Корректное значение цвета волос.
     */
    public Color getWorkerHairColor() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите цвет волос - выберете одно из значений:" + Color.nameToString() + ".");
            String hairColor = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerColor(hairColor)) {
                return Color.valueOf(hairColor);
            } else
                outputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    /**
     * Запрашивает и возвращает национальность работника.
     *
     * @return Корректное значение национальности.
     */
    public Country getWorkerCountry() {
        while (true) {
            outputManager.printLnToTheOutputStream("Введите национальность - выберете одно из значений:" + Country.nameToString() + ".");
            String country = inputManager.getNextLine();
            if (ValuesValidator.validateWorkerCountry(country)) {
                return Country.valueOf(country);
            } else
                outputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }
}
