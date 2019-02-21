package com.hostandguest.sim.hostandguest.SignIn.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.entities.User;
import com.hostandguest.sim.hostandguest.SignIn.helpers.JsonToObjectParser;
import com.hostandguest.sim.hostandguest.SignIn.homeActivity.HomeActivity;
import com.hostandguest.sim.hostandguest.SignIn.providers.AccountManager;
import com.hostandguest.sim.hostandguest.SignIn.utilies.VolleyCallback;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private EditText etNom,etPrenom,etPassword,etEmail,etType,etConfirmPassword;
    FloatingActionButton btnChooseImage;
    RadioGroup RgType;
    AccountManager accountManager;

    private OnFragmentInteractionListener mListener;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_register, container, false);

         accountManager=new AccountManager(getActivity());

        etPrenom = (EditText) view.findViewById(R.id.EdtFirstname);
         etNom= (EditText) view.findViewById(R.id.EdtLastname);
        etEmail = (EditText) view.findViewById(R.id.EdtEmail);
        etPassword = (EditText) view.findViewById(R.id.EdtPassword);
        etConfirmPassword = (EditText) view.findViewById(R.id.EdtConfirmPassword);
        btnChooseImage = (FloatingActionButton) view.findViewById(R.id.btnChooseImage);
        RgType = (RadioGroup) view.findViewById(R.id.RgType);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void register(String email,String password){
        accountManager.signin(email,password,new VolleyCallback(){

            @Override
            public void onSuccess(Object response) {
                JSONObject res=(JSONObject)response;
                try {
                    if(res.getInt("success")==1){
                        //parse the user

                        User user= new JsonToObjectParser().parseUser(res.getJSONArray("Existe").getJSONObject(0));
                        System.out.println("user exist "+user.toString());

                        Intent intent=new Intent(getActivity(), HomeActivity.class);
                        startActivity(intent);



                    }
                    else{
                        //wrong credentials
                        System.out.println("wrong email/password");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Object error) {
                System.out.println("erro from the server");

            }
        });
    }
}
