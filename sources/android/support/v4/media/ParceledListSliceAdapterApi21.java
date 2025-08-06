package android.support.v4.media;

import android.media.browse.MediaBrowser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        try {
            sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class});
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            e11.printStackTrace();
        }
    }

    private ParceledListSliceAdapterApi21() {
    }

    public static Object newInstance(List<MediaBrowser.MediaItem> list) {
        try {
            return sConstructor.newInstance(new Object[]{list});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
