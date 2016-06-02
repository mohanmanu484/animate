package com.hitherejoe.animate.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hitherejoe.animate.R;
import com.hitherejoe.animate.ui.transformer.ZoomOutPageTransformer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewPageTransformerActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_transformer);

        ButterKnife.bind(this);

        mViewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());

    }

    public static class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {


        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            return NumberPageFragment.newInstance(position);
        }
    }

    public static class NumberPageFragment extends Fragment {
        int mNum;

        int colors[] = {R.color.android_stroke_green, R.color.cardview_shadow_start_color, R.color.red, R.color.accent,
                        R.color.primary_light};

        static NumberPageFragment newInstance(int num) {
            NumberPageFragment f = new NumberPageFragment();

            Bundle args = new Bundle();
            args.putInt("num", num);
            f.setArguments(args);

            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_pager_list, container, false);
            v.setBackgroundResource(colors[mNum % colors.length]);

            View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText("Fragment #" + mNum);

            return v;
        }
    }
}
