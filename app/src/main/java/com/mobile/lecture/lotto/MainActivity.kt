package com.mobile.lecture.lotto

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.mobile.lecture.lotto.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lotto = listOf(1,2,3,4,5,6)

    private var lottoGenCount = 0
    private var lottoGenThreshold = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun displayLotto() {
        binding.setLotto(lotto)

        Toast.makeText(this, "${++lottoGenCount}회 생성했습니다.", Toast.LENGTH_LONG).show()
    }

    fun onDrawClick(v: View) {
        if (lottoGenCount === lottoGenThreshold) {
            Snackbar.make(binding.btDraw, "과도한 투자는 중독입니다.", Snackbar.LENGTH_INDEFINITE)
                    .setAction("멈출께요") {
                        finish()
                    }
                    .show()
        } else {
            makeLottoNumbers()
            displayLotto()
        }
    }

    private fun makeLottoNumbers() {
        val numbers = ArrayList<Int>()

        //로또 번호 생성
        for (i in 1..45) {
            numbers.add(i)
        }

        //번호를 섞는다
        numbers.shuffle()

        //앞의 6개의 값만 추출한다.
        lotto = numbers.slice(IntRange(0, 5)).sorted()
    }
}
