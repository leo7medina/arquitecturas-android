package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.ICouponsInteractor
import com.example.apparquitectura.model.CouponsInteractorImpl
import com.example.apparquitectura.view.ICouponView

class CouponPresenterImpl(var couponView: ICouponView): ICouponPresenter {

    private var couponInteractor: ICouponsInteractor = CouponsInteractorImpl(this)

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }

}