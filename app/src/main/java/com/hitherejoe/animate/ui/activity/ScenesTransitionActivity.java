package com.hitherejoe.animate.ui.activity;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.widget.FrameLayout;

import com.hitherejoe.animate.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScenesTransitionActivity extends BaseActivity {

    @Bind(R.id.scene_root)
    FrameLayout mSceneRoot;

    private volatile boolean mShowingAScene = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes_transition);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.fab_button)
    public void startTransition() {
        Log.e("Scene", "start Transition");
        Scene aScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        Scene bScene = Scene.getSceneForLayout(mSceneRoot, R.layout.b_scene, this);

        Transition fede = new Fade(Fade.IN);
        //mSceneRoot.removeAllViews();
        if (mShowingAScene) {
            TransitionManager.go(bScene, fede);
        } else {
            TransitionManager.go(aScene, fede);
        }

        mShowingAScene = !mShowingAScene;
    }
}
