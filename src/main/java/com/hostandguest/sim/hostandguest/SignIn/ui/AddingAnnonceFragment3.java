package com.hostandguest.sim.hostandguest.SignIn.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage1;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage2;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage3;


public class AddingAnnonceFragment3 extends Fragment {
    private static final String ARG_KEY = "key";
    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private AddingAnnoncePage3 mPage;
    private String s1_checked = "false",
            s2_checked="false",
            s3_checked="false",
            s4_checked="false",
            s5_checked="false",
            s6_checked="false";
    private Switch s1;
    private Switch s2;
    private Switch s3;
    private Switch s4;
    private Switch s5;
    private Switch s6;


    public static AddingAnnonceFragment3 create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        AddingAnnonceFragment3 fragment = new AddingAnnonceFragment3();
        fragment.setArguments(args);
        return fragment;
    }


    public AddingAnnonceFragment3() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (AddingAnnoncePage3) mCallbacks.onGetPage(mKey);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_adding_annonce_3, container, false);


        s1 = (Switch) view.findViewById(R.id.switch1);
        s1.setText(mPage.getData().getString(AddingAnnoncePage3.S1_DATA_KEY));

        s2 = (Switch) view.findViewById(R.id.switch2);
        s2.setText(mPage.getData().getString(AddingAnnoncePage3.S2_DATA_KEY));

        s3 = (Switch) view.findViewById(R.id.switch3);
        s3.setText(mPage.getData().getString(AddingAnnoncePage3.S3_DATA_KEY));

        s4 = (Switch) view.findViewById(R.id.switch4);
        s4.setText(mPage.getData().getString(AddingAnnoncePage3.S4_DATA_KEY));

        s5 = (Switch) view.findViewById(R.id.switch5);
        s5.setText(mPage.getData().getString(AddingAnnoncePage3.S5_DATA_KEY));

        s6 = (Switch) view.findViewById(R.id.switch6);
        s6.setText(mPage.getData().getString(AddingAnnoncePage3.S6_DATA_KEY));
        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof PageFragmentCallbacks)) {
            throw new ClassCastException("Activity must implement PageFragmentCallbacks");
        }

        mCallbacks = (PageFragmentCallbacks) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s1_checked = "true";

                }
                else {
                    s1_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S1_DATA_KEY,
                        s1_checked);
                mPage.notifyDataChanged();
            }
        });
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s2_checked = "true";

                }
                else {
                    s2_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S2_DATA_KEY,
                        s2_checked);
                mPage.notifyDataChanged();
            }
        });
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s3_checked = "true";

                }
                else {
                    s3_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S3_DATA_KEY,
                        s3_checked);
                mPage.notifyDataChanged();
            }
        });
        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s4_checked = "true";

                }
                else {
                    s4_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S4_DATA_KEY,
                        s4_checked);
                mPage.notifyDataChanged();
            }
        });
        s5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s5_checked = "true";

                }
                else {
                    s5_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S5_DATA_KEY,
                        s5_checked);
                mPage.notifyDataChanged();
            }
        });
        s6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    s6_checked = "true";

                }
                else {
                    s6_checked = "false";
                }
                mPage.getData().putString(AddingAnnoncePage3.S6_DATA_KEY,
                        s6_checked);
                mPage.notifyDataChanged();
            }
        });


    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.
        if (s1 != null && s2 != null && s3 != null && s4 != null && s5 != null && s6 != null) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if (!menuVisible) {
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
        }
    }

}
