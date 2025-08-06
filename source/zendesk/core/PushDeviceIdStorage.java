package zendesk.core;

interface PushDeviceIdStorage {
    PushRegistrationRequest getPushRegistrationRequest();

    String getRegisteredDeviceId();

    boolean hasRegisteredDeviceId();

    void removePushRegistrationRequest();

    void removeRegisteredDeviceId();

    void storePushRegistrationRequest(PushRegistrationRequest pushRegistrationRequest);

    void storeRegisteredDeviceId(String str);
}
