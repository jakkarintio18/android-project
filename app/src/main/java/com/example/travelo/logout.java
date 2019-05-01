package com.example.travelo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class logout extends Fragment implements View.OnClickListener {
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_logout, container, false);

        Button b = (Button) v.findViewById(R.id.Blogout);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Blogout:

                Intent intent = new Intent(mContext, StartActivity.class);
                mContext.startActivity(intent);
        }
    }
}
