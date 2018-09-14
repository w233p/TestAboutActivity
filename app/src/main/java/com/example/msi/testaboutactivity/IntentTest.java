package com.example.msi.testaboutactivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.ACTION_CALL;
/*本段主要从此帖学习https://www.cnblogs.com/engine1984/p/4146621.html*/


public class IntentTest extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_test);
    }

    public void intentJump(View view) {
        Intent intent = new Intent("com.example.msi.MY_ACTION");
        startActivity(intent);
    }

    public void intentPlayMusic(View view) {
        Log.d("tag", "没写效果，实现看代码");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        Uri uri = Uri.parse("歌曲路径");
//        intent.setDataAndType(uri,"audio/mp3");
//        startActivity(intent);
    }

    public void intentOpenWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void intentOpenCallView(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    /*记得在手机上允许应用拨打电话*/
    public void intentCall(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:10086"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void intentOpenMsgView(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("sms_body", "短信内容");
        startActivity(intent);
    }

    public void intentSendMsg(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:10086"));
        intent.putExtra("sms_body", "短信内容");
        startActivity(intent);
    }
}
