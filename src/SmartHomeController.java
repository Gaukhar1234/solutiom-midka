import java.util.ArrayList;
import java.util.List;

// Контроллер умного дома
class SmartHomeController {
    private List<Device> devices = new ArrayList<>(); // Список устройств

    // Добавить устройство
    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Устройство '" + device.getName() + "' добавлено в систему.");
    }

    // Удалить устройство
    public void removeDevice(int index) {
        if (index >= 0 && index < devices.size()) {
            Device device = devices.remove(index);
            System.out.println("Устройство '" + device.getName() + "' удалено из системы.");
        } else {
            System.out.println("Неверный индекс устройства.");
        }
    }

    // Включить все лампы
    public void turnAllLightsOn() {
        boolean lightsFound = false;
        for (Device device : devices) {
            if (device instanceof Lamp) {
                device.turnOn();
                System.out.println("Лампа '" + device.getName() + "' включена.");
                lightsFound = true;
            }
        }
        if (!lightsFound) {
            System.out.println("В системе нет ламп.");
        }
    }

    // Выключить все лампы
    public void turnAllLightsOff() {
        boolean lightsFound = false;
        for (Device device : devices) {
            if (device instanceof Lamp) {
                device.turnOff();
                System.out.println("Лампа '" + device.getName() + "' выключена.");
                lightsFound = true;
            }
        }
        if (!lightsFound) {
            System.out.println("В системе нет ламп.");
        }
    }

    // Установить глобальную температуру
    public void setGlobalTemperature(int temperature) {
        for (Device device : devices) {
            if (device instanceof Thermostat) {
                ((Thermostat) device).setTemperature(temperature);
                System.out.println("Термостат '" + device.getName() + "' установлен на " + temperature + "°C.");
            }
        }
    }

    // Получить статус системы
    public String getSystemStatusReport() {
        StringBuilder status = new StringBuilder();
        for (Device device : devices) {
            status.append(device.getStatus()).append("\n");
        }
        return status.toString();
    }

    // Управление отдельным устройством
    public void toggleDevice(int index, boolean turnOn) {
        if (index >= 0 && index < devices.size()) {
            Device device = devices.get(index);
            if (turnOn) {
                device.turnOn();
                System.out.println("Устройство '" + device.getName() + "' включено.");
            } else {
                device.turnOff();
                System.out.println("Устройство '" + device.getName() + "' выключено.");
            }
        } else {
            System.out.println("Неверный индекс устройства.");
        }
    }

    // Список всех устройств
    public void listDevices() {
        if (devices.isEmpty()) {
            System.out.println("В системе нет устройств.");
        } else {
            System.out.println("--- Список устройств ---");
            for (int i = 0; i < devices.size(); i++) {
                System.out.println((i + 1) + ". " + devices.get(i).getName() + " - " + devices.get(i).getStatus());
            }
        }
    }
}