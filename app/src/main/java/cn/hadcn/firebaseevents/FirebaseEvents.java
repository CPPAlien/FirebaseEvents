package cn.hadcn.firebaseevents;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * FirebaseEvents
 * Created by 90Chris on 2016/3/7.
 */
public class FirebaseEvents extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
