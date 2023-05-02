package com.esra.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        //drawerLayout.openDrawer(GravityCompat.START);

        //bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        MoreFragment moreFragment= new MoreFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.nav_view, moreFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                FragmentHome fragmentHome=new FragmentHome();
                replaceFragment(fragmentHome);break;
            case R.id.navigation_profile:
                FragmentProfile FragmentProfile=new FragmentProfile();
                replaceFragment(FragmentProfile);break;
            case R.id.navigation_notify:
                FragmentNotification fragmentNotification=new FragmentNotification();
                replaceFragment(fragmentNotification);break;
        }
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }
}