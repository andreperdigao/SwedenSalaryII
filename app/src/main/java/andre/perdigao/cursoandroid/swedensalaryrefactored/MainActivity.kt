package andre.perdigao.cursoandroid.swedensalaryrefactored

import andre.perdigao.cursoandroid.swedensalaryrefactored.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private var salary = 0
    private var net = 0

    private val tax = 0.7618


    private var salaryValue : TextView? = null
    private var netSalaryValue : TextView? = null
    private var btnCalculateVal : Button? = null

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        salaryValue = binding.editSalaryValue

        netSalaryValue = binding.txtNetSalaryValue

        btnCalculateVal = binding.btnCalculate

        calculate()


    }

    private fun calculate() {

        binding.btnCalculate.setOnClickListener {
            salary = salaryValue!!.text.toString().toInt()
            net =(salary*tax).toInt()
            netSalaryValue!!.text = net.toString()

        }


    }


}