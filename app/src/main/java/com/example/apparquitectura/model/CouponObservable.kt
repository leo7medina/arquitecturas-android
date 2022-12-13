package com.example.apparquitectura.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {

    private var couponRepository: ICouponRepository = CouponRepositoryImpl()


    fun callCoupons() {
        couponRepository.callCouponsAPI()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupons()
    }
}