// Продвинутая фабрика
class AdvancedSmartHomeFactory implements SmartHomeFactory {
    @Override
    public Device createLight() {
        return new Lamp();
    }

    @Override
    public Device createThermostat() {
        return new Thermostat();
    }

    @Override
    public Device createCamera() {
        return new Camera();
    }
}