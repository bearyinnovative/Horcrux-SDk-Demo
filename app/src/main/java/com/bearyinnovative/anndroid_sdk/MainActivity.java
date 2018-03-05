package com.bearyinnovative.anndroid_sdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bearyinnovative.horcrux.ui.chat.conversation.BearyConversationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BearyConversationView bearyConversationView = findViewById(R.id.conversation_list);
        bearyConversationView.initConversationByParams("beary", "Beary Innovative", "15625430452", "abc962570483");
    }
}
