package com.hitherejoe.animate.ui.activity;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
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
        Log.d("Scene", "start Transition");
        Scene aScene = Scene.getSceneForLayout(mSceneRoot, R.layout.a_scene, this);
        Scene bScene = Scene.getSceneForLayout(mSceneRoot, R.layout.b_scene, this);

        aScene.setEnterAction(new Runnable() {
            @Override
            public void run() {
                Log.d("Scene", "Enter A Scene");
            }
        });

        aScene.setExitAction(new Runnable() {
            @Override
            public void run() {
                Log.d("Scene", "Exit A Scene");
            }
        });

        Transition multi = TransitionInflater.from(this).inflateTransition(R.transition.multi_transition);

        if (mShowingAScene) {
            TransitionManager.go(bScene, multi);
        } else {
            TransitionManager.go(aScene, multi);
        }

        mShowingAScene = !mShowingAScene;
    }
}
