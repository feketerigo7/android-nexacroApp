package com.example.nexacroapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nexacro.NexacroResourceManager;
import com.nexacro.NexacroUpdatorActivity;

public class MainActivity extends NexacroUpdatorActivity {

    public MainActivity() {
        super();

        setProjectURL("http://your project url");
        setBootstrapURL("http://your bootstrap url/start_android.json");

        // Default startupClass is NexacroActivity.class for NexacroView
        // setStartupClass(UserCustomActivity.class);

        /* for extends NexacroActivity (for soZam module, archive 없이 구동)*/
        //NexacroResourceManager.createInstance(this);
        //NexacroResourceManager.getInstance().setBootstrapURL("http://your bootstrap url/start_android.json", true);
        //NexacroResourceManager.getInstance().setProjectURL("http://your project url");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // updatetype : server 인 경우에만 아래 주석제거, 기본값은 false 임(update / local )
        //NexacroResourceManager.createInstance(this);
        //NexacroResourceManager.getInstance().setDirect(true);

        Intent intent = getIntent();
        if(intent != null) {
            String bootstrapURL = intent.getStringExtra("bootstrapURL");
            String projectUrl = intent.getStringExtra("projectUrl");
            if(bootstrapURL != null) {
                setBootstrapURL(bootstrapURL);
                setProjectURL(projectUrl);
            }
        }

        super.onCreate(savedInstanceState);

        if (!isTaskRoot()) {
            intent = getIntent();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(intent.getAction())) {
                startRuntime();
                finish();
                return;
            }
        }
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }
}
