package com.example.msi.testaboutactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    EditText mNameEt = null;
    Button mBackBt = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        mNameEt = (EditText) findViewById(R.id.nameEt);
        mBackBt = (Button) findViewById(R.id.backBt);
        mBackBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("name", mNameEt.getText().toString());
                intent.putExtras(bundle);
                Activity2.this.setResult(1, intent);
                Activity2.this.finish();
            }
        });
    }
}
