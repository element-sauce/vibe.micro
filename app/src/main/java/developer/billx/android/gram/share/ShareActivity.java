package developer.billx.android.gram.share;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import developer.billx.android.gram.R;
import developer.billx.android.gram.util.BottomNavViewHelper;

public class ShareActivity extends AppCompatActivity {
    private static final String TAG = "ShareActivity";

    private Context mContext = ShareActivity.this;
    private static final int ACTIVITY_ID = 2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: begun");

        setupBottomNavView();
    }

    private void setupBottomNavView() {
        Log.d(TAG, "setupBottomNavView: setting up bottom nav");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.setupBottomNavView(bottomNavigationView);
        BottomNavViewHelper.allowNavigation(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem item = menu.getItem(ACTIVITY_ID);
        item.setChecked(true);
    }
}
