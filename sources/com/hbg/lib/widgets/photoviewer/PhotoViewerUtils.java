package com.hbg.lib.widgets.photoviewer;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.widgets.R$anim;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import java.util.ArrayList;
import java.util.List;

public final class PhotoViewerUtils {
    public static void a(Activity activity, List<ImageData> list, int i11) {
        Intent intent = new Intent(activity, PhotoViewerActivity.class);
        intent.putParcelableArrayListExtra("photoviewer_extra_images", (ArrayList) list);
        intent.putExtra("photoviewer_extra_position", i11);
        activity.startActivity(intent);
        activity.overridePendingTransition(R$anim.fade_in, R$anim.fade_out);
    }

    public static List<ImageData> b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String imageData : list) {
                arrayList.add(new ImageData(imageData, ""));
            }
        }
        return arrayList;
    }
}
