package zendesk.core;

class ZendeskPushDeviceIdStorage implements PushDeviceIdStorage {
    private final BaseStorage deviceIdStorage;

    public ZendeskPushDeviceIdStorage(BaseStorage baseStorage) {
        this.deviceIdStorage = baseStorage;
    }

    public PushRegistrationRequest getPushRegistrationRequest() {
        return (PushRegistrationRequest) this.deviceIdStorage.get(Constants.PUSH_REGISTRATION_REQUEST, PushRegistrationRequest.class);
    }

    public String getRegisteredDeviceId() {
        return this.deviceIdStorage.get(Constants.PUSH_DEVICE_IDENTIFIER);
    }

    public boolean hasRegisteredDeviceId() {
        return this.deviceIdStorage.get(Constants.PUSH_DEVICE_IDENTIFIER) != null;
    }

    public void removePushRegistrationRequest() {
        this.deviceIdStorage.remove(Constants.PUSH_REGISTRATION_REQUEST);
    }

    public void removeRegisteredDeviceId() {
        this.deviceIdStorage.remove(Constants.PUSH_DEVICE_IDENTIFIER);
    }

    public void storePushRegistrationRequest(PushRegistrationRequest pushRegistrationRequest) {
        this.deviceIdStorage.put(Constants.PUSH_REGISTRATION_REQUEST, (Object) pushRegistrationRequest);
    }

    public void storeRegisteredDeviceId(String str) {
        if (str != null) {
            this.deviceIdStorage.put(Constants.PUSH_DEVICE_IDENTIFIER, str);
        }
    }
}
