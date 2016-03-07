package cn.hadcn.firebaseevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String TAG = "FirebaseEvents:";
    Firebase mFireRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFireRef = new Firebase("https://fire-gochat.firebaseio.com/");
        Firebase messages = mFireRef.child("messages");
        messages.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> data = dataSnapshot.getValue(Map.class);
                Log.d(TAG, data.get("a") + " " + data.get("b"));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        messages.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String data = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onChildAdded = " + data);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String data = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onChildChanged = " + data);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                Log.d(TAG, "onChildRemoved = " + data);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //ignore here
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
