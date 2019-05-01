package com.example.travelo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class tourism extends Fragment implements View.OnClickListener {
    private ImageButton btnimagN,btnimagNe,btnimagE,btnimagC,btnimagS;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tourism, container, false);
        btnimagN = (ImageButton) v.findViewById(R.id.btnimagN);
        btnimagNe = (ImageButton) v.findViewById(R.id.btnimagNe);
        btnimagE = (ImageButton) v.findViewById(R.id.btnimagE);
        btnimagC = (ImageButton) v.findViewById(R.id.btnimagC);
        btnimagS = (ImageButton) v.findViewById(R.id.btnimagS);

        ImageButton btnimagN = (ImageButton) v.findViewById(R.id.btnimagN);
        btnimagN.setOnClickListener(this);
        ImageButton btnimagS = (ImageButton) v.findViewById(R.id.btnimagS);
        btnimagS.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent ;
        switch (v.getId()) {
            case R.id.btnimagN:
                intent = new Intent(getActivity(), northActivity.class);
                startActivity(intent);
                break;
            case R.id.btnimagS:
                intent = new Intent(getActivity(), southActivity.class);
                startActivity(intent);
                break;
        }
    }
}

