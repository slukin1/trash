package q0;

import android.content.res.Configuration;
import androidx.core.util.Consumer;

public interface c {
    void addOnConfigurationChangedListener(Consumer<Configuration> consumer);

    void removeOnConfigurationChangedListener(Consumer<Configuration> consumer);
}
