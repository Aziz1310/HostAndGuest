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
import android.widget.ImageView;

import com.hostandguest.sim.hostandguest.R;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage2;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage4;


public class AddingAnnonceFragment4 extends Fragment {
    private static final String ARG_KEY = "key";
    private PageFragmentCallbacks mCallbacks;
    private String mKey;
    private AddingAnnoncePage4 mPage;
    private EditText edtDesc;
    private EditText edtTitle;
    private ImageView addimage;

    public static AddingAnnonceFragment4 create(String key) {
        Bundle args = new Bundle();
        args.putString(ARG_KEY, key);

        AddingAnnonceFragment4 fragment = new AddingAnnonceFragment4();
        fragment.setArguments(args);
        return fragment;
    }


    public AddingAnnonceFragment4() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mKey = args.getString(ARG_KEY);
        mPage = (AddingAnnoncePage4) mCallbacks.onGetPage(mKey);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view =    inflater.inflate(R.layout.fragment_adding_annonce_4, container, false) ;


        edtDesc = ((EditText) view.findViewById(R.id.edtDescAnnonce));
        edtDesc.setText(mPage.getData().getString(AddingAnnoncePage4.DESC_DATA_KEY));

        edtTitle = ((EditText) view.findViewById(R.id.edtTitreAnnonce));
        edtTitle.setText(mPage.getData().getString(AddingAnnoncePage4.TITLE_DATA_KEY));


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

        edtDesc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage4.DESC_DATA_KEY,
                        (editable != null) ? editable.toString() : null);
                mPage.notifyDataChanged();
            }
        });

        edtTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1,
                                          int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPage.getData().putString(AddingAnnoncePage4.TITLE_DATA_KEY,
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
        if (edtDesc != null && edtTitle != null ) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            if (!menuVisible) {
                imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        }
    }

}
