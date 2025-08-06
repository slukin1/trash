package io.flutter.plugins;

import androidx.annotation.Keep;
import com.example.flutterimagecompress.FlutterImageCompressPlugin;
import com.fluttercandies.photo_manager.PhotoManagerPlugin;
import com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin;
import com.kurenai7968.volume_controller.VolumeControllerPlugin;
import com.sensorsdata.analytics.sensorsanalyticsflutterplugin.SensorsAnalyticsFlutterPlugin;
import com.tekartik.sqflite.SqflitePlugin;
import creativemaybeno.wakelock.WakelockPlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;
import seo.dongu.heic_to_jpg.HeicToJpgPlugin;

@Keep
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseCorePlugin());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseCrashlyticsPlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin firebase_crashlytics, io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterImageCompressPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin flutter_image_compress, com.example.flutterimagecompress.FlutterImageCompressPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterKeyboardVisibilityPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin flutter_keyboard_visibility, com.jrai.flutter_keyboard_visibility.FlutterKeyboardVisibilityPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new HeicToJpgPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin heic_to_jpg, seo.dongu.heic_to_jpg.HeicToJpgPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin image_picker, io.flutter.plugins.imagepicker.ImagePickerPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PhotoManagerPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin photo_manager, com.fluttercandies.photo_manager.PhotoManagerPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SensorsAnalyticsFlutterPlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin sensors_analytics_flutter_plugin, com.sensorsdata.analytics.sensorsanalyticsflutterplugin.SensorsAnalyticsFlutterPlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SqflitePlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VideoPlayerPlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin video_player, io.flutter.plugins.videoplayer.VideoPlayerPlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VolumeControllerPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin volume_controller, com.kurenai7968.volume_controller.VolumeControllerPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WakelockPlugin());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin wakelock, creativemaybeno.wakelock.WakelockPlugin", e25);
        }
    }
}
