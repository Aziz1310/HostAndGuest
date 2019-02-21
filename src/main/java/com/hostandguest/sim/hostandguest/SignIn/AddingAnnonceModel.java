package com.hostandguest.sim.hostandguest.SignIn;

import android.content.Context;

import com.hostandguest.sim.hostandguest.SignIn.model.AbstractWizardModel;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage1;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage2;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage3;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage4;
import com.hostandguest.sim.hostandguest.SignIn.model.AddingAnnoncePage5;
import com.hostandguest.sim.hostandguest.SignIn.model.BranchPage;
import com.hostandguest.sim.hostandguest.SignIn.model.CustomerInfoPage;
import com.hostandguest.sim.hostandguest.SignIn.model.MultipleFixedChoicePage;
import com.hostandguest.sim.hostandguest.SignIn.model.PageList;
import com.hostandguest.sim.hostandguest.SignIn.model.SingleFixedChoicePage;

/**
 * Created by Aziz on 02/12/2017.
 */

public class AddingAnnonceModel extends AbstractWizardModel {

    public AddingAnnonceModel(Context context) {

      super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(


                new AddingAnnoncePage1(this, "step 1",mContext)
                        .setRequired(true)
                ,
                new AddingAnnoncePage2(this, "step 2",mContext)
                        .setRequired(true)
                ,
                new AddingAnnoncePage3(this, "step 3",mContext)
                        .setRequired(true)
                ,
                new AddingAnnoncePage4(this, "step 4",mContext)
                        .setRequired(true)
                ,
                new AddingAnnoncePage5(this, "step 5",mContext)
                        .setRequired(true)


        );
    }
}
