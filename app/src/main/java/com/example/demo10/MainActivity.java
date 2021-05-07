package com.example.demo10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.demo10.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getMenuInflater());
        setContentView(binding.getRoot());
        binding.navigation.setOnNavigationItemReselectedListener(navigationItemSelectListener);

//        setContentView(R.layout.activity_main);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            binding.toolbar.setTitle(item.getTitle());
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    binding.viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    binding.viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    binding.viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    }
    private static class MyFragmentPagerAdapter extends FragmentPagerAdapterr{
        public MyFragmentPagerAdapter(@NonNull F)
    }


}