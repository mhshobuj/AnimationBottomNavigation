package com.dma.bottomnavigationofanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_nav = findViewById(R.id.bottom_nav);

        bottom_nav.add(new MeowBottomNavigation.Model(1, R.drawable.notifications_24));
        bottom_nav.add(new MeowBottomNavigation.Model(2, R.drawable.settings_24));
        bottom_nav.add(new MeowBottomNavigation.Model(3, R.drawable.home_24));
        bottom_nav.add(new MeowBottomNavigation.Model(4, R.drawable.info_24));
        bottom_nav.add(new MeowBottomNavigation.Model(5, R.drawable.person_24));

        bottom_nav.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new NotificationFragment();
                        break;
                    case 2:
                        fragment = new SettingFragment();
                        break;
                    case 3:
                        fragment = new HomeFragment();
                        break;
                    case 4:
                        fragment = new InfoFragment();
                        break;
                    case 5:
                        fragment = new ProfileFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        bottom_nav.setCount(1,"10");
        bottom_nav.show(3,true);

        bottom_nav.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(MainActivity.this, "You Clicked" + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottom_nav.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(MainActivity.this, "You Reselected" + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}