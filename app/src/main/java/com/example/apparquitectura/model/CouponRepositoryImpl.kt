package com.example.apparquitectura.model

import android.util.Log
import com.example.apparquitectura.presenter.ICouponPresenter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(var couponPresenter: ICouponPresenter): ICouponRepository {

    //TODa la logica de conexion
    override fun getCouponsAPI() {
        val apiAdapter = ApiAdapter();
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()
        val coupons: ArrayList<Coupon>? = ArrayList()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                //View
                couponPresenter.showCoupons(coupons)
            }
        })

    }
}