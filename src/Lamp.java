// Лампа
class Lamp implements Device {
    private boolean isOn = false; // Состояние устройства (включено/выключено)
    private String name = "Light"; // Имя устройства

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public String getStatus() {
        return name + ": " + (isOn ? "ON" : "OFF");
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

