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
import android.widget.EditText;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage1;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage2;


public class AddingAnnonceFragment2 extends Fragment {
    private static final String ARG_KEY = "key";
    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private AddingAnnoncePage2 mPage;
    private EditText edtCountry;
    private EditText edtStreet;
    private EditText edtCodePostal;
    private EditText edtVille;

    public static AddingAnnonceFragment2 create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        AddingAnnonceFragment2 fragment = new AddingAnnonceFragment2();
        fragment.setArguments(args);
        return fragment;
    }


    public AddingAnnonceFragment2() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (AddingAnnoncePage2) mCallbacks.onGetPage(mKey);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =    inflater.inflate(R.layout.fragment_adding_annonce_2, container, false) ;


        edtCountry = ((EditText) view.findViewById(R.id.edtCountry));
        edtCountry.setText(mPage.getData().getString(AddingAnnoncePage2.COUNTRY_DATA_KEY));

        edtStreet = ((EditText) view.findViewById(R.id.edtStreet));
        edtStreet.setText(mPage.getData().getString(AddingAnnoncePage2.STREET_DATA_KEY));

        edtCodePostal = ((EditText) view.findViewById(R.id.edtCodePostal));
        edtCodePostal.setText(mPage.getData().getString(AddingAnnoncePage2.CODEPOSTAL_DATA_KEY));

        edtVille = ((EditText) view.findViewById(R.id.edtVille));
        edtVille.setText(mPage.getData().getString(AddingAnnoncePage2.VILLE_DATA_KEY));
        return view  ;

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

        edtCountry.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage2.COUNTRY_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        edtStreet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage2.STREET_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        edtVille.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage2.VILLE_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        edtCodePostal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage2.CODEPOSTAL_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);

        // In a future update to the support library, this should override setUserVisibleHint
        // instead of setMenuVisibility.
        if (edtCountry != null && edtStreet != null && edtCodePostal != null && edtVille != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }

}
