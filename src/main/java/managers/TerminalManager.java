package managers;

import client.Main;
import controller.CommandExecutor;
import data.*;
import exceptions.EmptyHistoryException;
import utility.TerminalInputValidator;
import utility.WorkerFieldsValuesGetter;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 * Класс представляет собой основной компонент управления терминальным интерфейсом приложения.
 * Он координирует работу между обработкой входных данных, выполнением команд и управлением выводом информации.
 *
 * @author Aerosolus
 * @version 1.1
 * @since 2.0
 */
public class TerminalManager {

    /**
     * Экземпляр исполнителя команд, отвечающий за выполнение всех команд терминала.
     */
    private final CommandExecutor commandExecutor;

    /**
     * Менеджер ввода данных, обеспечивающий чтение и валидацию входных данных от пользователя.
     */
    private final InputManager inputManager;

    /**
     * Менеджер вывода данных, отвечающий за форматирование и отображение информации пользователю.
     */
    private final OutputManager outputManager;

    /**
     * Конструктор, инициализирующий менеджер терминала с указанными компонентами.
     * Все передаваемые параметры обязательны и сохраняются как неизменяемые ссылки.
     *
     * @param commandExecutor исполнитель команд для обработки пользовательских запросов
     * @param inputManager менеджер для обработки ввода данных от пользователя
     * @param outputManager менеджер для форматирования и вывода информации
     */
    public TerminalManager(CommandExecutor commandExecutor,
                           InputManager inputManager,
                           OutputManager outputManager) {
        this.commandExecutor = commandExecutor;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    /**
     * Запускает основной цикл работы терминала.
     * В цикле происходит непрерывное чтение ввода пользователя и обработка команд до завершения программы.
     * Поддерживает как интерактивный режим, так и режим выполнения скриптов.
     */
    public void start() {
        while (true) {
            try {
                if (Main.script) {
                    if (!inputManager.scriptBox.isEmpty()) {
                        String[] readLine = inputManager.scriptBox.pop();
                        commandExecutor.prepareForShipment(readLine[0], readLine[1]);
                    } else {
                        Main.script = false;
                    }
                } else {
                    outputManager.printLnWriteCommand();
                    TerminalInputValidator readLine = inputManager.readTerminal();
                    commandExecutor.prepareForShipment(readLine.getCommandName(), readLine.getCommandArguments());
                }
            } catch (NullPointerException e) {
                OutputManager.printError("Введен некорректный формат данных");
            }
        }
    }

    /**
     * Создает новый объект {@link Worker} на основе пользовательского ввода.
     *
     * @return Новый объект {@link Worker}.
     */
    public Worker createWorker() {
        WorkerFieldsValuesGetter workerFieldsValuesGetter = new WorkerFieldsValuesGetter(
                    new InputManager(System.in, outputManager),
                    outputManager);
            return
                    new Worker.WorkerBuilder(ServerEntryPoint.collectionManager.generateId(),
                            workerFieldsValuesGetter.getWorkerName(),
                            new Coordinates(new Coordinates.CoordinatesBuilder(
                                    workerFieldsValuesGetter.getWorkerCoordinateX(),
                                    workerFieldsValuesGetter.getWorkerCoordinateY())),
                            Date.from(Instant.now()),
                            workerFieldsValuesGetter.getWorkerSalary(),
                            workerFieldsValuesGetter.getWorkerPosition())
                            .setStatus(workerFieldsValuesGetter.getWorkerStatus())
                            .setPerson(createPerson())
                            .build();
    }

    /**
     * Создает новый объект {@link Person} на основе пользовательского ввода.
     *
     * @return Новый объект {@link Person}.
     */
    public Person createPerson() {
            WorkerFieldsValuesGetter workerFieldsValuesGetter = new WorkerFieldsValuesGetter(
                    new InputManager(System.in, outputManager),
                    outputManager);
            return
                    new Person.PersonBuilder(workerFieldsValuesGetter.getWorkerHeight(),
                            workerFieldsValuesGetter.getWorkerEyeColor(),
                            workerFieldsValuesGetter.getWorkerHairColor(),
                            workerFieldsValuesGetter.getWorkerCountry()).build();
    }

    /**
     * Читает объект {@link Worker} из данных скрипта.
     *
     * @return Новый объект {@link Worker}.
     * @throws NoSuchElementException Если достигнут конец данных скрипта.
     */
    public Worker readWorker() {
        return
                new Worker.WorkerBuilder(ServerEntryPoint.collectionManager.generateId(),
                        inputManager.scriptBox.pop()[0],
                        new Coordinates(new Coordinates.CoordinatesBuilder(
                                Long.parseLong(inputManager.scriptBox.pop()[0]),
                                Long.parseLong(inputManager.scriptBox.pop()[0]))),
                        Date.from(Instant.now()),
                        Long.parseLong(inputManager.scriptBox.pop()[0]),
                        Position.valueOf(inputManager.scriptBox.pop()[0]))
                        .setStatus(Status.valueOf(inputManager.scriptBox.pop()[0]))
                        .setPerson(readPerson())
                        .build();
    }

    /**
     * Читает объект {@link Person} из данных скрипта.
     *
     * @return Новый объект {@link Person}.
     * @throws NoSuchElementException Если достигнут конец данных скрипта.
     */
    public Person readPerson() {
        return
            new Person.PersonBuilder(
                    Float.parseFloat(inputManager.scriptBox.pop()[0]),
                    Color.valueOf(inputManager.scriptBox.pop()[0]),
                    Color.valueOf(inputManager.scriptBox.pop()[0]),
                    Country.valueOf(inputManager.scriptBox.pop()[0])).build();
}

    /**
     * Выводит историю последних выполненных команд.
     * Если история содержит менее 5 команд, выбрасывается исключение {@link EmptyHistoryException}.
     * Если история команд пуста, выводится соответствующее сообщение.
     *
     * @throws EmptyHistoryException Если в истории менее 5 команд.
     * @throws NullPointerException Если история команд пуста.
     */
    public void printHistory() {
        try {
            LinkedList<String> history = commandExecutor.getLastCommands();
            if (history.size() < 5) throw new EmptyHistoryException();
            outputManager.printLn("Последние использованные команды:");
            history.forEach(cmd -> outputManager.printLn(" - " + cmd));
        } catch (EmptyHistoryException exception) {
            outputManager.printLn("Было использовано недостаточное количество команд.");
        } catch (NullPointerException exp) {
            outputManager.printLn("История команд пуста.");
        }
    }
}
