// Базовый интерфейс для всех устройств
interface Device {
    void turnOn(); // Включить устройство
    void turnOff(); // Выключить устройство
    String getStatus(); // Получить текущий статус устройства
    void setName(String name); // Установить имя устройства
    String getName(); // Получить имя устройства
}