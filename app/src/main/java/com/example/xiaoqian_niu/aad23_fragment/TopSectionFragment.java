package com.example.xiaoqian_niu.aad23_fragment;

/**
 * Created by xiaoqian-niu on 2015-11-15.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*import packages for widgets and main activity*/
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

/*
* Rules on using Fragment:
*   1. The new class need to extends the class Fragment;
*   2. The new class should override the Function onCreateView;
* */
public class TopSectionFragment extends Fragment {
    private static EditText topTextInput;
    private static EditText bottomTextInput;

    /*For main activity use start*/
    TopFragmentListener activityCommander;

    public interface TopFragmentListener{
        public void getTextFromTopFragment(String top, String bottom);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if(context instanceof Activity){
            activity = (Activity)context;
        }else{
            return;
        }

        try{
            activityCommander = (TopFragmentListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
    /*For main activity use end*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment, container, false);

        topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        final Button bt = (Button)view.findViewById(R.id.btResource);

        bt.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        btClicked(v);
                    }
                }
        );

        return view;
    }

    public void btClicked(View v){
        activityCommander.getTextFromTopFragment(
                    topTextInput.getText().toString(),
                    bottomTextInput.getText().toString()
                );
    }
}
