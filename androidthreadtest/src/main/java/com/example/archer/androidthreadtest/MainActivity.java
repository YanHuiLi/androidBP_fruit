package com.example.archer.androidthreadtest;

import android.os.Handler;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 说明android 的确不允许在子线程中更新UI的操作
 * 但有时候我们不得不根据某些耗时的子线程的结果来更新主界面的UI
 * 因此android给我们提供了一个完整的处理的方式——handler。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;

    public static final  int UPDATE_TEXT=1;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE_TEXT:
                    //这里进行UI操作
                    textView.setText("nice to meet  u");
                    break;

                default:
                    break;


            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.change);
        textView = (TextView) findViewById(R.id.text111);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        textView.setText("nice to meet u");

                        Message message=new Message();
                        message.what=UPDATE_TEXT;
                        handler.sendMessageDelayed(message,5000);

                    }
                }).start();
                break;
            default:
                break;
        }

    }
}
