package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon

interface ICouponPresenter {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Interactor
    fun getCoupons()
}