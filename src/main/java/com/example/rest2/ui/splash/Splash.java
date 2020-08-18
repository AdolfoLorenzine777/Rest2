package com.example.rest2.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rest2.R;
import com.example.rest2.ui.Menu.MenuActivity;

import me.wangyuwei.particleview.ParticleView;

public class Splash extends AppCompatActivity {

    private ParticleView mPv1, mPv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        mPv1 = (ParticleView) findViewById(R.id.pv_1);
        mPv2 = (ParticleView) findViewById(R.id.pv_2);

        mPv1.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Toast.makeText(Splash.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        mPv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPv1.startAnim();
            }
        }, 500);

        mPv2.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPv2.startAnim();
            }
        }, 500);

    }
}