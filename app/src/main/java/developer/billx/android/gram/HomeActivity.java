package developer.billx.android.gram;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import developer.billx.android.gram.util.BottomNavViewHelper;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: begin");
    }

    private void setupBottomNavView() {
        Log.d(TAG, "setupBottomNavView: setting up bottom nav");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.disableShiftMode(bottomNavigationView);

    }
}
