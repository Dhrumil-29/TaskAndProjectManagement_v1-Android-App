package com.example.taskandprojectmanagement_v1;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;

public class ViewPagerAdaptor extends PagerAdapter {
    Context context;

    int[] images = {
            R.raw.calendar_animation,
            R.raw.chat_animation,
            R.raw.business_presentation
    };

    int[] heading = {
            R.string.onBoardPage1,
            R.string.onBoardPage2,
            R.string.onBoardPage3
    };
    int[] descriptions = {
            R.string.description1,
            R.string.description2,
            R.string.description3
    };

    public ViewPagerAdaptor(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_on_board_pages, container, false);

        LottieAnimationView animationView = (LottieAnimationView) view.findViewById(R.id.animation);
        TextView slideHeading = (TextView) view.findViewById(R.id.heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.description);

        animationView.setAnimation(images[position]);
        slideHeading.setText(heading[position]);
        slideDescription.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
