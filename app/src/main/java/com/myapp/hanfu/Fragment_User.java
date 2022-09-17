package com.myapp.hanfu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_User extends Fragment{
    private Context mContext;
    private View view;
    private ItemGroup nameIG, genderIG,cityIG;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_user,container,false);
        mContext = getContext();

        initView();
        return view;
    }

    private void initView() {
        nameIG = (ItemGroup) view.findViewById(R.id.name);
        genderIG = (ItemGroup) view.findViewById(R.id.gender);
        cityIG = (ItemGroup) view.findViewById(R.id.city);
    }
}
