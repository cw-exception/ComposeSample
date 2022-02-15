package com.test.composesample.sampleMigration

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.composesample.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LegacyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val mRecyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        val mRecyclerAdapter = LegacyAdapter(this)
        mRecyclerView.adapter = mRecyclerAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val list = ArrayList<SampleData>()
        for (index in dataURL.indices) {
            list.add(SampleData("$index", dataURL[index]))
        }
        mRecyclerAdapter.initItem(list)
    }
}


val dataURL = arrayListOf<String>(
    "https://media2.giphy.com/media/xT9IgmaQ9628ub1Ypq/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/2TOi6OJP04FDu1x34F/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/iGcJ68f1n34XM4NKGZ/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/LNrkfz72cEK7GHxBrT/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/9Oh7v4q4sBq1S3tlOE/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/QtBjlmw0vIZ7PL7A59/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/MZu0LixpPL6l2lmJvo/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/8SjH2xRSjXA4w/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/idRKsYgreApM2ybmpG/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/rnshwCdGdDyg0/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/pPeghiaPUSDtxZJnti/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/o2UqvfjPC78etVjCGA/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/aq32o275JVnss3kpHz/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/SwIMZUJE3ZPpHAfTC4/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/l2olcETxXQjImhNcm2/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/kiX1wcbKvP4lz6hqVk/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/KJP92WJoGSE5gYUT9O/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/sjVsQih0n1NPQkLQaG/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/cJRnD0a1fSukg/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/l0Ra2zKdSrIVB5b4UF/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/inj6fudEXehACSUunv/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/AXhbp00D9dxF9BCqpn/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/k9KucKGI73f3nsuY8G/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/yoJC2GnSClbPOkV0eA/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/d3erWmTEGXoiYVgY/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/l0Exl9psRODcQgaIM/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/QMDNQuAmRBYbIZ2VKo/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/sXFwUsfF7dCEg/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/XKF0HdbWZ0p0n8stLo/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/fCCCy9QuTtsFM9S88n/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/aqmlaGvU8B2yJiJ0Xp/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/feio2yIUMtdqWjRiaF/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/wvJEtW7Fpoq4hq9QLO/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/EBJQRG6M99zSNhnhsW/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/t7sStb9XO61TvKNVjZ/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/Drhcxcu5GzJwmhjrEV/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/TrgAAwTiTfHhhH40jJ/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/eKs4S9DoQwLSYx522G/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/U6dkYb6UT5FKWHmyVI/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media0.giphy.com/media/Xw3pnKSKhcH7ozPozR/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/wtIqMY0v7IWFJ8UNYv/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/EGmJLBB7QNHj68786D/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/R1sVlFHrYbWhbr6qr9/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/WnmcWTUZBpLBdQQP4n/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/5b4G01qDFbRvOeV4f3/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/5KUOsm8H3O46Y/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media3.giphy.com/media/Qyrg46yEWg0dFgdIGt/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media4.giphy.com/media/H2naGa3wituA0FfZVX/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media1.giphy.com/media/Qvns6NmhC1MBLKGbL1/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
    ,"https://media2.giphy.com/media/hPTZgtzfRIB5Nfb5rL/100w.gif?cid=a96efab6lk3eb3xfuhy3sjuv9j7f123p2qmvpeomxp59yumb&rid=100w.gif&ct=g"
)
