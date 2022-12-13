package com.example.apparquitectura.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(): ICouponRepository {

    private var coupons = MutableLiveData<List<Coupon>>()

    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return coupons
    }

    override fun callCouponsAPI() {
        val apiAdapter = ApiAdapter();
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()
        val couponsList: ArrayList<Coupon>? = ArrayList()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.e("ERROR: ", it) }
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }
                //View
                coupons.value = couponsList
            }
        })
    }
}