package com.mobile.lecture.lotto

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var lottoNumbersTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lottoNumbersTextView = findViewById(R.id.textView)
    }

    fun onDrawClick(v: View) {
        val lotto = makeLottoNumbers()
        lottoNumbersTextView.text = Arrays.toString(lotto)
    }

    private fun makeLottoNumbers(): IntArray {
        val numbers = ArrayList<Int>()

        //로또 번호 생성
        for (i in 1..45) {
            numbers.add(i)
        }

        //번호를 섞는다
        numbers.shuffle()

        //앞의 6개의 값만 추출한다.
        val lotto = IntArray(6)
        for (i in 0..5) {
            lotto[i] = numbers.get(i)
        }

        //번호를 순차로 정렬한다.
        Arrays.sort(lotto)

        return lotto
    }
}
