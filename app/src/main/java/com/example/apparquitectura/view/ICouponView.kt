package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface ICouponView {
    //Vista
    fun showCoupons(coupons: ArrayList<Coupon>?)

    //Presentaror
    fun getCoupons()
}