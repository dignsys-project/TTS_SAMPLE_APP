package com.example.tts;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != android.speech.tts.TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        Button btn_Speak_Korean = findViewById(R.id.btnSpeakKorean);
        Button btn_Speak_English = findViewById(R.id.btnSpeakEnglish);
        Button btn_Speak_Chinese = findViewById(R.id.btnSpeakChinese);
        Button btn_Speak_Japanese = findViewById(R.id.btnSpeakJapanese);

        btn_Speak_Korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "안녕하세요";

                tts.setLanguage(Locale.KOREAN);
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btn_Speak_English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Hello world";

                tts.setLanguage(Locale.ENGLISH);
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btn_Speak_Japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "こんにちは";

                tts.setLanguage(Locale.JAPANESE);
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }


        });
        btn_Speak_Chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "你好";

                tts.setLanguage(Locale.CHINESE);
                tts.setPitch(1.0f);
                tts.setSpeechRate(1.0f);
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    @Override public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onDestroy();
    }





}
