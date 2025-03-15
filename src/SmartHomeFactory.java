// Интерфейс фабрики для создания устройств
interface SmartHomeFactory {
    Device createLight(); // Создать лампу
    Device createThermostat(); // Создать термостат
    Device createCamera(); // Создать камеру
}