package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final DragAndDropPermissions f8587a;

    public static class a {
        public static void a(DragAndDropPermissions dragAndDropPermissions) {
            dragAndDropPermissions.release();
        }

        public static DragAndDropPermissions b(Activity activity, DragEvent dragEvent) {
            return activity.requestDragAndDropPermissions(dragEvent);
        }
    }

    public d(DragAndDropPermissions dragAndDropPermissions) {
        this.f8587a = dragAndDropPermissions;
    }

    public static d a(Activity activity, DragEvent dragEvent) {
        DragAndDropPermissions b11;
        if (Build.VERSION.SDK_INT < 24 || (b11 = a.b(activity, dragEvent)) == null) {
            return null;
        }
        return new d(b11);
    }
}
