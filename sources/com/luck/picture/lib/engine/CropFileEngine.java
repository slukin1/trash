package com.luck.picture.lib.engine;

import android.net.Uri;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public interface CropFileEngine {
    void onStartCrop(Fragment fragment, Uri uri, Uri uri2, ArrayList<String> arrayList, int i11);
}
