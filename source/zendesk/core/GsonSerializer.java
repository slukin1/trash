package zendesk.core;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.zendesk.logger.Logger;
import mz.f;

class GsonSerializer implements Serializer {
    private static final String LOG_TAG = "GsonSerializer";
    private final Gson gson;

    public GsonSerializer(Gson gson2) {
        this.gson = gson2;
    }

    public <E> E deserialize(Object obj, Class<E> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (!f.c(str)) {
                return null;
            }
            try {
                return this.gson.fromJson(str, cls);
            } catch (JsonSyntaxException unused) {
                Logger.b(LOG_TAG, "Unable to deserialize String into object of type %s", cls.getSimpleName());
                return null;
            }
        } else if (obj instanceof JsonElement) {
            try {
                return this.gson.fromJson((JsonElement) obj, cls);
            } catch (JsonSyntaxException e11) {
                Logger.b(LOG_TAG, "Unable to deserialize JsonElement into object of type %s", cls.getSimpleName(), e11);
                return null;
            }
        } else {
            Logger.b(LOG_TAG, "Unable to deserialize the provided object into %s", cls.getSimpleName());
            return null;
        }
    }

    public String serialize(Object obj) {
        return this.gson.toJson(obj);
    }
}
