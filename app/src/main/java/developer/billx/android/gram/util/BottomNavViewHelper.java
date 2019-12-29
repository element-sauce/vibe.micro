package developer.billx.android.gram.util;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import java.lang.reflect.Field;

import developer.billx.android.gram.FavoritesActivity;
import developer.billx.android.gram.HomeActivity;
import developer.billx.android.gram.ProfileActivity;
import developer.billx.android.gram.R;
import developer.billx.android.gram.SearchActivity;
import developer.billx.android.gram.ShareActivity;

@SuppressLint("RestrictedApi")
public class BottomNavViewHelper {
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShifting(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    public static void setupBottomNavView(BottomNavigationView view) {
        disableShiftMode(view);
    }

    public static void allowNavigation(final Context context,BottomNavigationView view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent in1 = new Intent(context, HomeActivity.class);
                        context.startActivity(in1);
                        break;
                    case R.id.ic_search:
                        Intent in2 = new Intent(context, SearchActivity.class);
                        context.startActivity(in2);
                        break;
                    case R.id.ic_add:
                        Intent in3 = new Intent(context, ShareActivity.class);
                        context.startActivity(in3);
                        break;
                    case R.id.ic_favorite:
                        Intent in4 = new Intent(context, FavoritesActivity.class);
                        context.startActivity(in4);
                        break;
                    case R.id.ic_person:
                        Intent in5 = new Intent(context, ProfileActivity.class);
                        context.startActivity(in5);
                        break;
                }

                return false;
            }
        });
    }
} 