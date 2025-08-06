package zendesk.core;

import android.content.SharedPreferences;
import java.util.UUID;

public class ZendeskMachineIdStorage implements MachineIdStorage {
    private static final String MACHINE_ID_KEY = "machine_id_key";
    private final SharedPreferences sharedPreferences;

    public ZendeskMachineIdStorage(SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences2;
    }

    private String generateMachineId() {
        String uuid = UUID.randomUUID().toString();
        this.sharedPreferences.edit().putString(MACHINE_ID_KEY, uuid).apply();
        return uuid;
    }

    public String getMachineId() {
        String string = this.sharedPreferences.getString(MACHINE_ID_KEY, (String) null);
        if (string == null || string.isEmpty()) {
            return generateMachineId();
        }
        return string;
    }
}
