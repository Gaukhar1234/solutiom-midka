// Декоратор для добавления планирования
class ScheduledOperationDecorator extends SmartDeviceDecorator {
    private String schedule;

    public ScheduledOperationDecorator(Device decoratedDevice, String schedule) {
        super(decoratedDevice);
        this.schedule = schedule;
    }

    @Override
    public void turnOn() {
        System.out.println("Scheduled to turn ON at " + schedule);
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Scheduled to turn OFF at " + schedule);
        super.turnOff();
    }

    @Override
    public void setName(String name) {
        decoratedDevice.setName(name);
    }

    @Override
    public String getName() {
        return decoratedDevice.getName();
    }
}