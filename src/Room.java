import java.util.ArrayList;
import java.util.List;

// Составной узел (группа устройств)
class Room implements Device {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device device) {
        devices.add(device);
    }

    @Override
    public void turnOn() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder();
        for (Device device : devices) {
            status.append(device.getStatus()).append("\n");
        }
        return status.toString();
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }
}