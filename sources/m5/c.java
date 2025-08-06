package m5;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ c f58116b = new c();

    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
