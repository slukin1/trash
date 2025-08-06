package butterknife;

import android.util.Property;
import android.view.View;
import java.util.List;

public final class ViewCollections {
    private ViewCollections() {
    }

    @SafeVarargs
    public static <T extends View> void run(List<T> list, Action<? super T>... actionArr) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            for (Action<? super T> apply : actionArr) {
                apply.apply((View) list.get(i11), i11);
            }
        }
    }

    public static <T extends View, V> void set(List<T> list, Setter<? super T, V> setter, V v11) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            setter.set((View) list.get(i11), v11, i11);
        }
    }

    public static <T extends View, V> void set(T[] tArr, Setter<? super T, V> setter, V v11) {
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            setter.set(tArr[i11], v11, i11);
        }
    }

    @SafeVarargs
    public static <T extends View> void run(T[] tArr, Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            for (Action<? super T> apply : actionArr) {
                apply.apply(tArr[i11], i11);
            }
        }
    }

    public static <T extends View, V> void set(T t11, Setter<? super T, V> setter, V v11) {
        setter.set(t11, v11, 0);
    }

    public static <T extends View, V> void set(List<T> list, Property<? super T, V> property, V v11) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            property.set(list.get(i11), v11);
        }
    }

    public static <T extends View> void run(List<T> list, Action<? super T> action) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            action.apply((View) list.get(i11), i11);
        }
    }

    public static <T extends View, V> void set(T[] tArr, Property<? super T, V> property, V v11) {
        for (T t11 : tArr) {
            property.set(t11, v11);
        }
    }

    public static <T extends View> void run(T[] tArr, Action<? super T> action) {
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            action.apply(tArr[i11], i11);
        }
    }

    public static <T extends View, V> void set(T t11, Property<? super T, V> property, V v11) {
        property.set(t11, v11);
    }

    @SafeVarargs
    public static <T extends View> void run(T t11, Action<? super T>... actionArr) {
        for (Action<? super T> apply : actionArr) {
            apply.apply(t11, 0);
        }
    }

    public static <T extends View> void run(T t11, Action<? super T> action) {
        action.apply(t11, 0);
    }
}
