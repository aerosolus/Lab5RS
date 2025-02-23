package utility;

import data.Color;
import data.Country;
import data.Position;
import data.Status;
import inputOutput.TerminalInputManager;
import inputOutput.TerminalOutputManager;

/**
 * @since 1.2
 */
public class WorkerFieldsValuesGetter {

    private final TerminalInputManager terminalInputManager;

    /**
     * Manager for handling terminal output.
     */
    private final TerminalOutputManager terminalOutputManager;

    /**
     * Constructs a HumanBeingFieldValuesGetter with the given terminal input and output managers.
     *
     * @param terminalInputManager Manager for handling terminal input.
     * @param terminalOutputManager Manager for handling terminal output.
     */
    public WorkerFieldsValuesGetter(TerminalInputManager terminalInputManager, TerminalOutputManager terminalOutputManager) {
        this.terminalInputManager = terminalInputManager;
        this.terminalOutputManager = terminalOutputManager;
    }

    public String getWorkerName() {
        while (true) {
            TerminalOutputManager.printLn("Введите имя работника.");
            String name = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerName(name)) {
                return name;
            } else
                TerminalOutputManager.printLn("Поле name объекта Worker не может быть null и не может быть пустой строкой!");
        }
    }

    public Long getWorkerCoordinateX() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите координату X работника.");
            String stringX = terminalInputManager.getNextLine();
            Long x = 0L;
            try {
                x = Long.parseLong(stringX);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printLnToTheOutputStream("Координата x должна быть типом Long!");
                continue;
            }
            if (ValuesValidator.validateWorkerCoordinateX(stringX)) {
                return x;
            }
            else {
                terminalOutputManager.printLnToTheOutputStream("Значение координаты должно быть больше -975.");
            }
        }
    }

    public long getWorkerCoordinateY() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите координату Y работника.");
            String stringY = terminalInputManager.getNextLine();
            long y = 0;
            try {
                y = Long.parseLong(stringY);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printLnToTheOutputStream("Координата y должна быть примитивным типом long!");
                continue;
            }
            if (ValuesValidator.validateWorkerCoordinateY(stringY))
                return y;
        }
    }

    public long getWorkerSalary() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите заработную плату работника.");
            String stringSalary = terminalInputManager.getNextLine();
            long salary = 0;
            try {
                salary = Long.parseLong(stringSalary);
            } catch (NumberFormatException numberFormatException) {
                terminalOutputManager.printLnToTheOutputStream("Заработная плата должна быть типом Long!");
                continue;
            }
            if (ValuesValidator.validateWorkerSalary(stringSalary))
                return salary;
            else {
                terminalOutputManager.printLnToTheOutputStream("Значение заработной платы должно быть больше 0.");
            }
        }
    }

    public Position getWorkerPosition() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите позицию - выберете одно из значений:" + Position.nameToString() + ".");
            String position = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerPosition(position)) {
                return Position.valueOf(position);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    public Status getWorkerStatus() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите статус - выберете одно из значений:" + Status.nameToString() + ".");
            String status = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerStatus(status)) {
                return Status.valueOf(status);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    public Float getWorkerHeight() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите рост работника.");
            String height = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerPersonHeight(height)) {
                return Float.valueOf(height);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    public Color getWorkerEyeColor() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите цвет глаз - выберете одно из значений:" + Color.nameToString() + ".");
            String eyeColor = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerColor(eyeColor)) {
                return Color.valueOf(eyeColor);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    public Color getWorkerHairColor() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите цвет волос - выберете одно из значений:" + Color.nameToString() + ".");
            String hairColor = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerColor(hairColor)) {
                return Color.valueOf(hairColor);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }

    public Country getWorkerCountry() {
        while (true) {
            terminalOutputManager.printLnToTheOutputStream("Введите национальность - выберете одно из значений:" + Country.nameToString() + ".");
            String country = terminalInputManager.getNextLine();
            if (ValuesValidator.validateWorkerCountry(country)) {
                return Country.valueOf(country);
            } else
                terminalOutputManager.printLnToTheOutputStream("Данные введены некорректно. Повторите ввод!");
        }
    }
}
