package com.example.msi.testaboutactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTv1 = null;
    Button mBt1 = null;
    Button mIntentBt = null;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate", "onCreate");

        mTv1 = (TextView) findViewById(R.id.tv1);
        if (savedInstanceState != null) {
            mTv1.setText(savedInstanceState.getString("tv1_text", "未点击"));
        } else {
            mTv1.setText("未点击");
        }
        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv1.setText("点击");
            }
        });

        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Activity2.class);
                startActivityForResult(intent, 1);
            }
        });

        mIntentBt = (Button) findViewById(R.id.intentBt);
        mIntentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, IntentTest.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("tag:", "onActivityResult");
        if (requestCode == 1) {
            if (resultCode == 1) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    Log.d("tag:", "bundle get");
                    String msg = bundle.getString("name");
                    mTv1.setText(msg);
                }
            }
        }
    }

    /*通过重写onSaveInstanceState方法保存数据
     * 该方法适用于简单临时的数据
     * 自定义对象数据或者socket等较大数据使用setRetainInstance(boolean)来保存,
     * 一般使用该方法保存Fragment*/
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag:", "onSaveInstanceState");
        outState.putString("tv1_text", mTv1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("tag:", "onRestoreInstanceState");
    }


}
