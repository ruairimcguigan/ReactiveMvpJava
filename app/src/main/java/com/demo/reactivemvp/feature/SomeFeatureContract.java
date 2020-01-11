package com.demo.reactivemvp.feature;

public interface SomeFeatureContract {

    interface View {
        void someFeatureViewContractMethod();
        void anotherFeatureViewContractMethod();
    }

    interface Presenter {
        void someFeaturePresenterMethod();
        void anotherFeaturePresenterMethod();
    }

}
