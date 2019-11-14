package com.mobile.lecture.lotto

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mobile.lecture.lotto.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lotto = listOf(1,2,3,4,5,6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun displayLotto() {
        binding.setLotto(lotto)
    }

    fun onDrawClick(v: View) {
        makeLottoNumbers()

        displayLotto()
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
