package com.bearyinnovative.anndroid_sdk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bearyinnovative.horcrux.ui.chat.conversation.BearyConversationView;

/**
 * Created by nickming on 05/03/2018.
 */

public class ChatFragment extends Fragment {

    public static ChatFragment newInstance() {

        Bundle args = new Bundle();

        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private BearyConversationView bearyConversationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_conversation_list, container, false);
        bearyConversationView = rootView.findViewById(R.id.conversation_list);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bearyConversationView.initConversationByParams("beary", "Beary Innovative", "15625430452", "abc962570483");
    }
}
