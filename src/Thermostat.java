// Термостат
class Thermostat implements Device {
    private int currentTemperature = 20; // Текущая температура
    private int targetTemperature = 20; // Целевая температура
    private String name = "Thermostat"; // Имя устройства

    public void setTemperature(int temperature) {
        this.targetTemperature = temperature;
        adjustTemperature();
    }

    // Регулировка температуры
    private void adjustTemperature() {
        if (currentTemperature < targetTemperature) {
            currentTemperature++;
        } else if (currentTemperature > targetTemperature) {
            currentTemperature--;
        }
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is ON");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is OFF");
    }

    @Override
    public String getStatus() {
        return name + ": Текущая температура = " + currentTemperature + "°C, Целевая температура = " + targetTemperature + "°C";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
