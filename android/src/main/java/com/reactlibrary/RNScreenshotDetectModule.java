package com.kierancrown;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNScreenshotDetectModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final ContentResolver contentResolver;

    public RNScreenshotDetectModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.contentResolver = reactContext.getContentResolver();

        // Register the content observer for detecting screenshots
        contentResolver.registerContentObserver(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            true,
            new ContentObserver(new Handler()) {
                @Override
                public void onChange(boolean selfChange) {
                    super.onChange(selfChange);
                    sendScreenshotEvent();
                }
            }
        );
    }

    @Override
    public String getName() {
        return "RNScreenshotDetect";
    }

    private void sendScreenshotEvent() {
        // Trigger an event to React Native when a screenshot is detected
        reactContext
            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
            .emit("screenshotTaken", null);
    }

    @Override
    public void onCatalystInstanceDestroy() {
        // Clean up the content observer when the module is destroyed
        contentResolver.unregisterContentObserver(new ContentObserver(new Handler()) {});
        super.onCatalystInstanceDestroy();
    }
}
