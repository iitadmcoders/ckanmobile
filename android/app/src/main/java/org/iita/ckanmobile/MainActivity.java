package org.iita.ckanmobile;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0x00000000); //transparent status bar
            GeneratedPluginRegistrant.registerWith(this);
            ViewTreeObserver viewTreeObserver = getFlutterView().getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    getFlutterView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }
            });
        } else {
            GeneratedPluginRegistrant.registerWith(this);
        }

    }
}
