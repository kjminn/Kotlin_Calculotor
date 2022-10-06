package kr.ac.dongyang.minn.mobilec_0929_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import kr.ac.dongyang.minn.mobilec_0929_2.databinding.*;
import java.lang.NumberFormatException

class MainActivity2 : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var btns = arrayOf<Button>(binding.btnPlus, binding.btnMinus, binding.btnMulti, binding.btnDivide, binding.btnMod)
        for (btn in btns){
            btn.setOnClickListener(btnListener)
        }
    }

    val btnListener = View.OnClickListener {
        var s1 = binding.edit1.text.toString();
        var s2 = binding.edit2.text.toString();
        try{
            var n1 = s1.toDouble()
            var n2 = s2.toDouble()
            var result = 0.0
            when(it.id){
                R.id.btnPlus -> result = n1 + n2
                R.id.btnMinus -> result = n1 - n2
                R.id.btnMulti -> result = n1 * n2
                R.id.btnDivide -> result = n1 / n2
                R.id.btnMod -> result = n1 % n2
            }
            binding.textResult.setText(R.string.text_result)
            binding.textResult.append(String.format("%.2f", result))
        }catch (e: NumberFormatException){
            Toast.makeText(baseContext, "숫자를 입력하지 않고 버튼을 클릭하면 안됨!!", Toast.LENGTH_SHORT).show()
        }

    }
}