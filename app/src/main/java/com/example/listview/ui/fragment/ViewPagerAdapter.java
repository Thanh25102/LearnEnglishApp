package com.example.listview.ui.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import org.jetbrains.annotations.NotNull;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new HomeFragment();
            case 2:
                return new RankFragment();
            case 3 :
                return new LessonFragment();
            default:
                return new ChartFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
