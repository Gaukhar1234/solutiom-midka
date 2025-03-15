import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeFactory factory = new AdvancedSmartHomeFactory();
        SmartHomeController controller = new SmartHomeController();

        // Адаптер для устаревшего дверного замка
        LegacyDoor legacyDoorLock = new LegacyDoor();
        Device doorLock = new DoorLockAdapter(legacyDoorLock);

        while (true) {
            System.out.println("\n--- Управление Умным домом ---");
            System.out.println("1. Включить все лампы");
            System.out.println("2. Выключить все лампы");
            System.out.println("3. Установить глобальную температуру");
            System.out.println("4. Получить статус системы");
            System.out.println("5. Управление дверным замком");
            System.out.println("6. Добавить новое устройство");
            System.out.println("7. Управление отдельным устройством");
            System.out.println("8. Удалить устройство");
            System.out.println("9. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    controller.turnAllLightsOn();
                    break;

                case 2:
                    controller.turnAllLightsOff();
                    break;

                case 3:
                    System.out.print("Введите температуру: ");
                    int temperature = scanner.nextInt();
                    controller.setGlobalTemperature(temperature);
                    break;

                case 4:
                    System.out.println("--- Статус системы ---");
                    System.out.println(controller.getSystemStatusReport());
                    break;

                case 5:
                    System.out.println("\n--- Управление дверным замком ---");
                    System.out.println("1. Открыть замок");
                    System.out.println("2. Закрыть замок");
                    System.out.println("3. Получить статус замка");
                    System.out.print("Выберите действие: ");
                    int lockChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (lockChoice) {
                        case 1:
                            doorLock.turnOn();
                            System.out.println("Замок открыт.");
                            break;

                        case 2:
                            doorLock.turnOff();
                            System.out.println("Замок закрыт.");
                            break;

                        case 3:
                            System.out.println(doorLock.getStatus());
                            break;

                        default:
                            System.out.println("Неверный выбор.");
                            break;
                    }
                    break;

                case 6:
                    System.out.println("\n--- Добавление нового устройства ---");
                    System.out.println("1. Добавить лампу");
                    System.out.println("2. Добавить термостат");
                    System.out.println("3. Добавить камеру");
                    System.out.print("Выберите тип устройства: ");
                    int deviceType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введите имя устройства: ");
                    String deviceName = scanner.nextLine();

                    switch (deviceType) {
                        case 1:
                            Device light = factory.createLight();
                            light.setName(deviceName);
                            controller.addDevice(light);
                            System.out.println("Лампа '" + deviceName + "' добавлена.");
                            break;

                        case 2:
                            Device thermostat = factory.createThermostat();
                            thermostat.setName(deviceName);
                            controller.addDevice(thermostat);
                            System.out.println("Термостат '" + deviceName + "' добавлен.");
                            break;

                        case 3:
                            Device camera = factory.createCamera();
                            camera.setName(deviceName);
                            controller.addDevice(camera);
                            System.out.println("Камера '" + deviceName + "' добавлена.");
                            break;

                        default:
                            System.out.println("Неверный выбор.");
                            break;
                    }
                    break;

                case 7:
                    System.out.println("\n--- Управление отдельным устройством ---");
                    controller.listDevices();
                    System.out.print("Выберите устройство (введите номер): ");
                    int deviceIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    System.out.println("1. Включить устройство");
                    System.out.println("2. Выключить устройство");
                    System.out.print("Выберите действие: ");
                    int toggleChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (toggleChoice == 1) {
                        controller.toggleDevice(deviceIndex, true);
                    } else if (toggleChoice == 2) {
                        controller.toggleDevice(deviceIndex, false);
                    } else {
                        System.out.println("Неверный выбор.");
                    }
                    break;

                case 8:
                    System.out.println("\n--- Удаление устройства ---");
                    controller.listDevices();
                    System.out.print("Выберите устройство для удаления (введите номер): ");
                    int removeIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    controller.removeDevice(removeIndex);
                    break;

                case 9:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }
    }
}