// Базовый декоратор
abstract class SmartDeviceDecorator implements Device {
    protected Device decoratedDevice;

    public SmartDeviceDecorator(Device decoratedDevice) {
        this.decoratedDevice = decoratedDevice;
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
    }

    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
    }

    @Override
    public String getStatus() {
        return decoratedDevice.getStatus();
    }
}