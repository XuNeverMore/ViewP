package com.nevermore.viewp;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nevermore.loopviewpager.AutoLoopViewPager;
import com.nevermore.loopviewpager.viewpagerindicator.CirclePageIndicator;
import com.nevermore.loopviewpager.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] ivs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        AutoLoopViewPager vp = (AutoLoopViewPager) findViewById(R.id.view_pager);


        ivs = new int[]{R.mipmap.mv_00,R.mipmap.mv_01,R.mipmap.mv_02,R.mipmap.mv_03,R.mipmap.mv_04,R.mipmap.mv_05};

        vp.setAdapter(new ImagePagerAdapter());
        vp.startAutoScroll();
        indicator.setViewPager(vp);

    }

    class ImagePagerAdapter extends PagerAdapter{

        SparseArray<ImageView> views = new SparseArray<>();

        @Override
        public int getCount() {
            return ivs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "美女"+position;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = views.get(position);
            if(imageView==null){
                imageView = new ImageView(container.getContext());
                imageView.setImageResource(ivs[position]);
                container.addView(imageView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            }

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }



}
