package com.example.apparquitectura.model

import androidx.lifecycle.MutableLiveData

interface ICouponRepository {
    fun getCoupons(): MutableLiveData<List<Coupon>>
    fun callCouponsAPI()
}