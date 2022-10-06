package kr.ac.dongyang.minn.mobilec_0929_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kr.ac.dongyang.minn.mobilec_0929_2.databinding.*;

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var btns = arrayOf<Button>(binding.btnPlus, binding.btnMinus, binding.btnMulti, binding.btnDivide)
        for (btn in btns){
            btn.setOnClickListener(btnListener)
        }
    }

    val btnListener = View.OnClickListener {
        var s1 = binding.edit1.text.toString();
        var s2 = binding.edit2.text.toString();

        try{
            var n1 = s1.toInt()
            var n2 = s2.toInt()
            var result = 0

            when(it.id){
                R.id.btnPlus -> result = n1 + n2
                R.id.btnMinus -> result = n1 - n2
                R.id.btnMulti -> result = n1 * n2
                R.id.btnDivide -> result = n1 / n2
            }
            binding.textResult.setText(R.string.text_result)
            binding.textResult.append(result.toString())
        }catch(e: NumberFormatException){
            Toast.makeText(baseContext, "숫자를 입력해 주세요!", Toast.LENGTH_SHORT).show();
            binding.edit1.requestFocus()
        }catch(e: ArithmeticException){
            Toast.makeText(baseContext, "0으로 나누면 안됩니다.!", Toast.LENGTH_SHORT).show();
            binding.edit2.requestFocus()
        }

    }
}