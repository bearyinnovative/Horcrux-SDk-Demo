package com.bearyinnovative.anndroid_sdk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bearyinnovative.horcrux.ui.util.ActivityUtil;

/**
 * Created by nickming on 05/03/2018.
 */

public class EmptyFragment extends Fragment {

    public static EmptyFragment newInstance() {

        Bundle args = new Bundle();

        EmptyFragment fragment = new EmptyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_empty, container, false);

        view.findViewById(R.id.bt_start_p2p_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.INSTANCE.startMessagesActivity(getActivity(), "=bwNFB", null);
            }
        });

        view.findViewById(R.id.bt_start_group_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.INSTANCE.startMessagesActivity(getActivity(), "=ccZKs3pUt", null);
            }
        });
        return view;
    }
}
