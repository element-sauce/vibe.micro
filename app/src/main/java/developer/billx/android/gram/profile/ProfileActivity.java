package developer.billx.android.gram.profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import developer.billx.android.gram.R;
import developer.billx.android.gram.util.BottomNavViewHelper;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_ID = 4;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: begun");

        // setupBottomNavView();, bottom nav not set up yet in layout
        setupToolbar();
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

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked profile menu item " + item);

                switch (item.getItemId()) {
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: going to profile settings");
                }

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
}

