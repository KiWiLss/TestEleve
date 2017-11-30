package com.magicsoft.daybyday.factory.simple.complex.factory;

import com.magicsoft.daybyday.factory.simple.complex.fav_volk.Magotan;
import com.magicsoft.daybyday.factory.simple.complex.fav_volk.Sagitar;
import com.magicsoft.daybyday.factory.simple.complex.insurance.Insurance;
import com.magicsoft.daybyday.factory.simple.complex.insurance.TwoInsurance;
import com.magicsoft.daybyday.factory.simple.complex.volk.FAWVolkswagen;

public class FAWVolkswagenFactory extends VolkswagenFactory {


    @Override
    public FAWVolkswagen createVolkswagen(int productID) {
        FAWVolkswagen volkswagen = null;
        switch(productID){
            case Magotan.ID:
                volkswagen = new Magotan();
                break;
            case Sagitar.ID:
                volkswagen = new Sagitar();
                break;
            default:
                volkswagen = null;
        }
        return  volkswagen;
    }

    @Override
    public Insurance bindInsurance() {
        return new TwoInsurance();
    }
}