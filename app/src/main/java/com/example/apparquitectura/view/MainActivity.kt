package com.example.apparquitectura.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.R
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.presenter.CouponPresenterImpl
import com.example.apparquitectura.presenter.ICouponPresenter

class MainActivity : AppCompatActivity(), ICouponView {

    private var couponPresenter: ICouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        //VIEW
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }
}