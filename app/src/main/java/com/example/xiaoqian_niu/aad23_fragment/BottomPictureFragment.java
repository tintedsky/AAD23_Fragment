package com.example.xiaoqian_niu.aad23_fragment;

/**
 * Created by xiaoqian-niu on 2015-11-15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BottomPictureFragment extends Fragment{
    private static TextView bottomFragmentTopText;
    private static TextView bottomFragmentBottomText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        bottomFragmentTopText = (TextView)view.findViewById(R.id.photoTopText);
        bottomFragmentBottomText = (TextView)view.findViewById(R.id.photoBottomText);

        return view;
    }

    public void setPhotoText(String top, String bottom){
        bottomFragmentTopText.setText(top);
        bottomFragmentBottomText.setText(bottom);
    }
}
