package com.hitherejoe.animate.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.hitherejoe.animate.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * Created by jacobsu on 4/29/16.
 */
public class TouchFeedBackActivity extends BaseActivity {

    @Bind(R.id.linear_root)
    LinearLayout mLinearLayout;

    @Bind(R.id.view1)
    View mViewOne;

    @Bind(R.id.view2)
    View mViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_feedback_layout);
        ButterKnife.bind(this);

        setupToolbar();
    }

    @OnClick(R.id.view2)
    public void onClickedViewTwo() {
        Log.d("TouchFeedBack", "onClicked View two");
    }

    @OnClick(R.id.view1root)
    public void onClickViewOneRoot() {
        Log.d("TouchFeedBack", "onClicked View one Root");
    }

    @OnClick(R.id.view3root)
    public void onClickViewThreeRoot() {

    }

    @OnClick(R.id.linear_root)
    public void onClickRoot() {
        Log.d("TouchFeedBack", "onClicked root View");
    }

    @OnTouch(R.id.view1)
    public boolean onTouchViewOne(MotionEvent motionEvent) {
        Log.d("TouchFeedBack", "onTouch View One: " + motionEvent.toString());
        return false;
    }

    @OnTouch(R.id.linear_root)
    public boolean onTouchRoot(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        Log.d("TouchFeedBack", "onTouch root view: " + motionEvent.toString());
        return false;
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
