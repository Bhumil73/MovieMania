package com.bhumil73.moviemania;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bhumil73.moviemania.fragments.HomeFragment;
import com.bhumil73.moviemania.fragments.ProfileFragment;
import com.bhumil73.moviemania.fragments.RequestFragment;
import com.bhumil73.moviemania.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);

        //starting Listener
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //To set Home as the default fragment when app is opened
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }

    //Listener Implementation
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){

                    case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;

                    case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
                    case R.id.nav_Request:
                    selectedFragment = new RequestFragment();
                    break;
                    case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
}
