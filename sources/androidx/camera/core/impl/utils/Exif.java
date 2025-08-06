package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import m1.a;

public final class Exif {
    private static final List<String> ALL_EXIF_TAGS = getAllExifTags();
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = Arrays.asList(new String[]{"ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation"});
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private final a mExifInterface;
    private boolean mRemoveTimestamp = false;

    public static final class Speed {

        public static final class Converter {
            public final double mMph;

            public Converter(double d11) {
                this.mMph = d11;
            }

            public double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }
        }

        private Speed() {
        }

        public static Converter fromKilometersPerHour(double d11) {
            return new Converter(d11 * 0.621371d);
        }

        public static Converter fromKnots(double d11) {
            return new Converter(d11 * 1.15078d);
        }

        public static Converter fromMilesPerHour(double d11) {
            return new Converter(d11);
        }
    }

    private Exif(a aVar) {
        this.mExifInterface = aVar;
    }

    private void attachLastModifiedTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        String convertToExifDateTime = convertToExifDateTime(currentTimeMillis);
        this.mExifInterface.c0("DateTime", convertToExifDateTime);
        try {
            this.mExifInterface.c0("SubSecTime", Long.toString(currentTimeMillis - convertFromExifDateTime(convertToExifDateTime).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date convertFromExifDate(String str) throws ParseException {
        return DATE_FORMAT.get().parse(str);
    }

    private static Date convertFromExifDateTime(String str) throws ParseException {
        return DATETIME_FORMAT.get().parse(str);
    }

    private static Date convertFromExifTime(String str) throws ParseException {
        return TIME_FORMAT.get().parse(str);
    }

    private static String convertToExifDateTime(long j11) {
        return DATETIME_FORMAT.get().format(new Date(j11));
    }

    public static Exif createFromFile(File file) throws IOException {
        return createFromFileString(file.toString());
    }

    public static Exif createFromFileString(String str) throws IOException {
        return new Exif(new a(str));
    }

    public static Exif createFromImageProxy(ImageProxy imageProxy) throws IOException {
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        buffer.rewind();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.get(bArr);
        return createFromInputStream(new ByteArrayInputStream(bArr));
    }

    public static Exif createFromInputStream(InputStream inputStream) throws IOException {
        return new Exif(new a(inputStream));
    }

    public static List<String> getAllExifTags() {
        return Arrays.asList(new String[]{"ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType"});
    }

    private long parseTimestamp(String str, String str2) {
        if (str == null && str2 == null) {
            return -1;
        }
        if (str2 == null) {
            try {
                return convertFromExifDate(str).getTime();
            } catch (ParseException unused) {
                return -1;
            }
        } else if (str == null) {
            try {
                return convertFromExifTime(str2).getTime();
            } catch (ParseException unused2) {
                return -1;
            }
        } else {
            return parseTimestamp(str + " " + str2);
        }
    }

    public void attachLocation(Location location) {
        this.mExifInterface.d0(location);
    }

    public void attachTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        String convertToExifDateTime = convertToExifDateTime(currentTimeMillis);
        this.mExifInterface.c0("DateTimeOriginal", convertToExifDateTime);
        this.mExifInterface.c0("DateTimeDigitized", convertToExifDateTime);
        try {
            String l11 = Long.toString(currentTimeMillis - convertFromExifDateTime(convertToExifDateTime).getTime());
            this.mExifInterface.c0("SubSecTimeOriginal", l11);
            this.mExifInterface.c0("SubSecTimeDigitized", l11);
        } catch (ParseException unused) {
        }
        this.mRemoveTimestamp = false;
    }

    public void copyToCroppedImage(Exif exif) {
        ArrayList<String> arrayList = new ArrayList<>(ALL_EXIF_TAGS);
        arrayList.removeAll(DO_NOT_COPY_EXIF_TAGS);
        for (String str : arrayList) {
            String g11 = this.mExifInterface.g(str);
            String g12 = exif.mExifInterface.g(str);
            if (g11 != null && !g11.equals(g12)) {
                exif.mExifInterface.c0(str, g11);
            }
        }
    }

    public void flipHorizontally() {
        int i11;
        switch (getOrientation()) {
            case 2:
                i11 = 1;
                break;
            case 3:
                i11 = 4;
                break;
            case 4:
                i11 = 3;
                break;
            case 5:
                i11 = 6;
                break;
            case 6:
                i11 = 5;
                break;
            case 7:
                i11 = 8;
                break;
            case 8:
                i11 = 7;
                break;
            default:
                i11 = 2;
                break;
        }
        this.mExifInterface.c0("Orientation", String.valueOf(i11));
    }

    public void flipVertically() {
        int i11;
        switch (getOrientation()) {
            case 2:
                i11 = 3;
                break;
            case 3:
                i11 = 2;
                break;
            case 4:
                i11 = 1;
                break;
            case 5:
                i11 = 8;
                break;
            case 6:
                i11 = 7;
                break;
            case 7:
                i11 = 6;
                break;
            case 8:
                i11 = 5;
                break;
            default:
                i11 = 4;
                break;
        }
        this.mExifInterface.c0("Orientation", String.valueOf(i11));
    }

    public String getDescription() {
        return this.mExifInterface.g("ImageDescription");
    }

    public a getExifInterface() {
        return this.mExifInterface;
    }

    public int getHeight() {
        return this.mExifInterface.i("ImageLength", 0);
    }

    public long getLastModifiedTimestamp() {
        long parseTimestamp = parseTimestamp(this.mExifInterface.g("DateTime"));
        if (parseTimestamp == -1) {
            return -1;
        }
        String g11 = this.mExifInterface.g("SubSecTime");
        if (g11 == null) {
            return parseTimestamp;
        }
        try {
            long parseLong = Long.parseLong(g11);
            while (parseLong > 1000) {
                parseLong /= 10;
            }
            return parseTimestamp + parseLong;
        } catch (NumberFormatException unused) {
            return parseTimestamp;
        }
    }

    public Location getLocation() {
        double d11;
        String g11 = this.mExifInterface.g("GPSProcessingMethod");
        double[] m11 = this.mExifInterface.m();
        double f11 = this.mExifInterface.f(0.0d);
        double h11 = this.mExifInterface.h("GPSSpeed", 0.0d);
        String g12 = this.mExifInterface.g("GPSSpeedRef");
        if (g12 == null) {
            g12 = KILOMETERS_PER_HOUR;
        }
        long parseTimestamp = parseTimestamp(this.mExifInterface.g("GPSDateStamp"), this.mExifInterface.g("GPSTimeStamp"));
        if (m11 == null) {
            return null;
        }
        if (g11 == null) {
            g11 = TAG;
        }
        Location location = new Location(g11);
        location.setLatitude(m11[0]);
        location.setLongitude(m11[1]);
        if (f11 != 0.0d) {
            location.setAltitude(f11);
        }
        if (h11 != 0.0d) {
            char c11 = 65535;
            int hashCode = g12.hashCode();
            if (hashCode != 75) {
                if (hashCode != 77) {
                    if (hashCode == 78 && g12.equals("N")) {
                        c11 = 1;
                    }
                } else if (g12.equals(MILES_PER_HOUR)) {
                    c11 = 0;
                }
            } else if (g12.equals(KILOMETERS_PER_HOUR)) {
                c11 = 2;
            }
            if (c11 == 0) {
                d11 = Speed.fromMilesPerHour(h11).toMetersPerSecond();
            } else if (c11 != 1) {
                d11 = Speed.fromKilometersPerHour(h11).toMetersPerSecond();
            } else {
                d11 = Speed.fromKnots(h11).toMetersPerSecond();
            }
            location.setSpeed((float) d11);
        }
        if (parseTimestamp != -1) {
            location.setTime(parseTimestamp);
        }
        return location;
    }

    public int getOrientation() {
        return this.mExifInterface.i("Orientation", 0);
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 3:
            case 4:
                return 180;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long getTimestamp() {
        long parseTimestamp = parseTimestamp(this.mExifInterface.g("DateTimeOriginal"));
        if (parseTimestamp == -1) {
            return -1;
        }
        String g11 = this.mExifInterface.g("SubSecTimeOriginal");
        if (g11 == null) {
            return parseTimestamp;
        }
        try {
            long parseLong = Long.parseLong(g11);
            while (parseLong > 1000) {
                parseLong /= 10;
            }
            return parseTimestamp + parseLong;
        } catch (NumberFormatException unused) {
            return parseTimestamp;
        }
    }

    public int getWidth() {
        return this.mExifInterface.i("ImageWidth", 0);
    }

    public boolean isFlippedHorizontally() {
        return getOrientation() == 2;
    }

    public boolean isFlippedVertically() {
        int orientation = getOrientation();
        return orientation == 4 || orientation == 5 || orientation == 7;
    }

    public void removeLocation() {
        this.mExifInterface.c0("GPSProcessingMethod", (String) null);
        this.mExifInterface.c0("GPSLatitude", (String) null);
        this.mExifInterface.c0("GPSLatitudeRef", (String) null);
        this.mExifInterface.c0("GPSLongitude", (String) null);
        this.mExifInterface.c0("GPSLongitudeRef", (String) null);
        this.mExifInterface.c0("GPSAltitude", (String) null);
        this.mExifInterface.c0("GPSAltitudeRef", (String) null);
        this.mExifInterface.c0("GPSSpeed", (String) null);
        this.mExifInterface.c0("GPSSpeedRef", (String) null);
        this.mExifInterface.c0("GPSDateStamp", (String) null);
        this.mExifInterface.c0("GPSTimeStamp", (String) null);
    }

    public void removeTimestamp() {
        this.mExifInterface.c0("DateTime", (String) null);
        this.mExifInterface.c0("DateTimeOriginal", (String) null);
        this.mExifInterface.c0("DateTimeDigitized", (String) null);
        this.mExifInterface.c0("SubSecTime", (String) null);
        this.mExifInterface.c0("SubSecTimeOriginal", (String) null);
        this.mExifInterface.c0("SubSecTimeDigitized", (String) null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int i11) {
        int i12;
        if (i11 % 90 != 0) {
            Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", new Object[]{Integer.valueOf(i11)}));
            this.mExifInterface.c0("Orientation", String.valueOf(0));
            return;
        }
        int i13 = i11 % 360;
        int orientation = getOrientation();
        while (i13 < 0) {
            i13 += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i13 > 0) {
            i13 -= 90;
            switch (orientation) {
                case 2:
                    i12 = 7;
                    break;
                case 3:
                    i12 = 8;
                    break;
                case 4:
                    i12 = 5;
                    break;
                case 5:
                    i12 = 2;
                    break;
                case 6:
                    i12 = 3;
                    break;
                case 7:
                    i12 = 4;
                    break;
                case 8:
                    i12 = 1;
                    break;
                default:
                    i12 = 6;
                    break;
            }
        }
        this.mExifInterface.c0("Orientation", String.valueOf(orientation));
    }

    public void save() throws IOException {
        if (!this.mRemoveTimestamp) {
            attachLastModifiedTimestamp();
        }
        this.mExifInterface.X();
    }

    public void setDescription(String str) {
        this.mExifInterface.c0("ImageDescription", str);
    }

    public void setOrientation(int i11) {
        this.mExifInterface.c0("Orientation", String.valueOf(i11));
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription()});
    }

    private long parseTimestamp(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return convertFromExifDateTime(str).getTime();
        } catch (ParseException unused) {
            return -1;
        }
    }
}
