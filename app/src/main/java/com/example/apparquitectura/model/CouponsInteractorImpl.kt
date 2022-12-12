package com.example.apparquitectura.model

import com.example.apparquitectura.presenter.ICouponPresenter

class CouponsInteractorImpl(var couponPresenter: ICouponPresenter): ICouponsInteractor {

    private var couponRepository: ICouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}