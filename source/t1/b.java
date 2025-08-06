package t1;

import android.content.Context;
import java.util.List;

public interface b<T> {
    T create(Context context);

    List<Class<? extends b<?>>> dependencies();
}
