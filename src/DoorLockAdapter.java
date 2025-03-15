// Адаптер для устаревшего дверного замка
class DoorLockAdapter implements Device {
    private LegacyDoor legacyDoorLock;
    private boolean isLocked = false; // Состояние замка (заблокирован/разблокирован)
    private String name = "Устаревший дверной замок"; // Имя устройства

    public DoorLockAdapter(LegacyDoor legacyDoorLock) {
        this.legacyDoorLock = legacyDoorLock;
    }

    @Override
    public void turnOn() {
        legacyDoorLock.unlock();
        isLocked = false;
    }

    @Override
    public void turnOff() {
        legacyDoorLock.lock();
        isLocked = true;
    }

    @Override
    public String getStatus() {
        return name + " статус: " + (isLocked ? "Заблокирован" : "Разблокирован");
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