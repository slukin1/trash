package io.flutter.plugins.imagepicker;

import android.util.Log;
import java.util.Arrays;
import m1.a;

class ExifDataCopier {
    private static void setIfNotNull(a aVar, a aVar2, String str) {
        if (aVar.g(str) != null) {
            aVar2.c0(str, aVar.g(str));
        }
    }

    public void copyExif(String str, String str2) {
        try {
            a aVar = new a(str);
            a aVar2 = new a(str2);
            for (String ifNotNull : Arrays.asList(new String[]{"FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "Orientation"})) {
                setIfNotNull(aVar, aVar2, ifNotNull);
            }
            aVar2.X();
        } catch (Exception e11) {
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e11);
        }
    }
}
