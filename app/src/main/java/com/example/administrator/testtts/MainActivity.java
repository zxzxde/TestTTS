package com.example.administrator.testtts;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private Button speakBtn;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.editText01);
        speakBtn= (Button) findViewById(R.id.speakbtn);

        textToSpeech=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    //设置朗读语音
                    int support=textToSpeech.setLanguage(Locale.US);
                    textToSpeech.setSpeechRate(0.8f);
                    if((support!=TextToSpeech.LANG_AVAILABLE)&&(support!=TextToSpeech.LANG_COUNTRY_AVAILABLE)){
                        Toast.makeText(MainActivity.this,"不支持该语音",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        speakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String conte=et1.getText().toString();
                textToSpeech.speak(conte,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
