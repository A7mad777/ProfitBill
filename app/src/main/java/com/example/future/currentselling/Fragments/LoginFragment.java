package com.example.future.currentselling.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.future.currentselling.Activities.HomeActivity;
import com.example.future.currentselling.Activities.LoginActivity;
import com.example.future.currentselling.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener{
    Button Register;
    Button Login;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Register = view.findViewById(R.id.button2);
        Login = view.findViewById(R.id.button);
        Register.setOnClickListener(this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HomeActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        RegisterFragment registerFragment = new RegisterFragment();
        LoginActivity activity = (LoginActivity) getActivity();
        activity.replaceFragment(registerFragment);
    }
}
