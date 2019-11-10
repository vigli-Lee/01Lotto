package com.mobile.lecture.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView lottoNumbersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottoNumbersTextView = findViewById(R.id.textView);
    }

    public void onDrawClick(View v) {
        int[] lotto = makeLottoNumbers();
        lottoNumbersTextView.setText(Arrays.toString(lotto));
    }

    private int[] makeLottoNumbers() {
        List<Integer> numbers = new ArrayList();

        //로또 번호 생성
        for (int i=1; i<=45; i++) {
            numbers.add(i);
        }

        //번호를 섞는다
        Collections.shuffle(numbers);

        //앞의 6개의 값만 추출한다.
        int[] lotto = new int[6];
        for (int i=0; i<6; i++) {
            lotto[i] = numbers.get(i);
        }

        //번호를 순차로 정렬한다.
        Arrays.sort(lotto);

        return lotto;
    }
}
