package com.example.listview.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.example.listview.R;
import com.example.listview.ui.fragment.HomeFragment;
import com.example.listview.ui.fragment.ViewPagerAdapter;
import com.example.listview.util.ActionBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView bottomNavigationViewOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.content_frame);
        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationViewOn = findViewById(R.id.bottomNavVIew);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0 : bottomNavigationView.getMenu().findItem(R.id.action_chart).setChecked(true); break;
                    case 1 : bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true); break;
                    case 2 : bottomNavigationView.getMenu().findItem(R.id.action_rank).setChecked(true); break;

                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(menuItem->{
            switch (menuItem.getItemId()){
                case R.id.action_chart:
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.action_home:
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.action_rank:
                    viewPager2.setCurrentItem(2);
                    break;
            }
            return true;
        });

        ActionBarUtil actionBarUtil = ActionBarUtil.getInstance();
        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.manhthanh);
        Drawable drawable = new BitmapDrawable(getResources(), actionBarUtil.createCircleBitmap(sourceBitmap));

        bottomNavigationViewOn.setItemIconTintList(null);
        bottomNavigationViewOn.getMenu().findItem(R.id.action_avatar).setIcon(drawable);
    }
}