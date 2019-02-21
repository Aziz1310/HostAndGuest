package com.hostandguest.sim.hostandguest.SignIn.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.RegisterActivity;
import com.hostandguest.sim.hostandguest.SignIn.entities.User;
import com.hostandguest.sim.hostandguest.SignIn.helpers.JsonToObjectParser;
import com.hostandguest.sim.hostandguest.SignIn.homeActivity.HomeActivity;
import com.hostandguest.sim.hostandguest.SignIn.providers.AccountManager;
import com.hostandguest.sim.hostandguest.SignIn.utilies.VolleyCallback;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;

    private EditText etEmail,etPassword;
    private Button btrnLogin;

    private AccountManager accountManager;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_login, container, false);
        etEmail=(EditText)view.findViewById(R.id.EdtEmailUser);
        etPassword=(EditText)view.findViewById(R.id.EdtPasswordUser);
        btrnLogin=(Button)view.findViewById(R.id.btnlogin);

        accountManager=new AccountManager(getActivity());



        btrnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(etEmail.getText().toString(),etPassword.getText().toString());

            }
        });



        return view;
    }

    private void login(String email,String password){
        accountManager.signin(email,password,new VolleyCallback(){

            @Override
            public void onSuccess(Object response) {
                JSONObject res=(JSONObject)response;
                try {
                    if(res.getInt("success")==1){
                        //parse the user

                        User user= new JsonToObjectParser().parseUser(res.getJSONArray("Existe").getJSONObject(0));
                        System.out.println(" !!!user exist "+user.toString());

                        Intent intent=new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);



                    }
                    else{
                        //wrong credentials
                        System.out.println("wrong email/password");
                        //Toast.makeText(getContext(),"Try Again",Toast.LENGTH_SHORT).show();



                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Object error) {
                System.out.println("error from the server");

            }
        });
    }

}
