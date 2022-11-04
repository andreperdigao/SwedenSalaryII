package andre.perdigao.cursoandroid.swedensalaryrefactored

import andre.perdigao.cursoandroid.swedensalaryrefactored.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var salary = 0
    private var apartment = 0
    private var internet = 0
    private var electricity = 0
    private var food = 0
    private var transport = 0
    private var insurance = 0
    private var net = 0
    private var cost = 0
    private var rest = 0
    private val tax = 0.7618

    private val keyNet = "net"
    private val keyCost = "cost"
    private val keyRest = "rest"


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        calculate()

        clear()


    }

    private fun calculate() {

        binding.btnCalculate.setOnClickListener {

            if (checkValues()) {

                Toast.makeText(
                    this, "Calculating...",
                    Toast.LENGTH_SHORT
                ).show()

                salary = binding.editSalaryValue.text.toString().toInt()
                apartment = binding.editRentValue.text.toString().toInt()
                electricity = binding.editElectricityValue.text.toString().toInt()
                internet = binding.editInternetValue.text.toString().toInt()
                food = binding.editFoodValue.text.toString().toInt()
                transport = binding.editTransportValue.text.toString().toInt()
                insurance = binding.editInsuranceValue.text.toString().toInt()

                net = (salary * tax).toInt()
                cost = apartment + electricity + internet + food + transport + insurance
                rest = net - cost


                binding.txtNetSalaryValue.text = net.toString()
                binding.txtLifeCostValue.text = cost.toString()
                binding.txtRestValue.text = rest.toString()
            }

            closeKeyboard(binding.txtRestValue)

        }


    }

    private fun clear(){

        binding.btnClear.setOnClickListener {

            Toast.makeText(
                this, "Clear Success...",
                Toast.LENGTH_SHORT
            ).show()


            net = 0
            cost = 0
            rest = 0
            binding.txtNetSalaryValue.text = ""
            binding.txtLifeCostValue.text = ""
            binding.txtRestValue.text = ""
            binding.editSalaryValue.text.clear()
            binding.editRentValue.text.clear()
            binding.editElectricityValue.text.clear()
            binding.editFoodValue.text.clear()
            binding.editInternetValue.text.clear()
            binding.editInsuranceValue.text.clear()
            binding.editTransportValue.text.clear()

        }

    }

    private fun checkValues() : Boolean {

        var checkValues = true

        if (binding.editSalaryValue.text.toString().isEmpty()) {
            binding.editSalaryValue.error = "Please insert you Salary"
            binding.editSalaryValue.requestFocus()
            checkValues = false
        }

        else if (binding.editRentValue.text.toString().isEmpty()) {
            binding.editRentValue.error = "Please insert Rent Cost"
            binding.editRentValue.requestFocus()
            checkValues = false
        }

        else if (binding.editElectricityValue.text.toString().isEmpty()) {
            binding.editElectricityValue.error = "Please insert Electricity Cost"
            binding.editElectricityValue.requestFocus()
            checkValues = false
        }

        else if (binding.editInternetValue.text.toString().isEmpty()) {
            binding.editInternetValue.error = "Please insert Broadband Cost"
            binding.editInternetValue.requestFocus()
            checkValues = false
        }

        else if (binding.editFoodValue.text.toString().isEmpty()) {
            binding.editFoodValue.error = "Please insert Food/Household Cost"
            binding.editFoodValue.requestFocus()
            checkValues = false
        }

        else if (binding.editTransportValue.text.toString().isEmpty()) {
            binding.editTransportValue.error = "Please insert Transport Cost"
            binding.editTransportValue.requestFocus()
            checkValues = false
        }

        else if (binding.editInsuranceValue.text.toString().isEmpty()) {
            binding.editInsuranceValue.error = "Please insert Insurance Cost"
            binding.editInsuranceValue.requestFocus()
            checkValues = false
        }

        return checkValues


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(keyNet,net)
        outState.putInt(keyCost,cost)
        outState.putInt(keyRest,rest)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        net = savedInstanceState.getInt(keyNet,0)
        if (net!= 0) {
            binding.txtNetSalaryValue.text = net.toString()
        }
        cost = savedInstanceState.getInt(keyCost,0)
        if (cost != 0) {
            binding.txtLifeCostValue.text = cost.toString()
        }
        rest = savedInstanceState.getInt(keyRest,0)
        if (rest != 0) {
            binding.txtRestValue.text = rest.toString()
        }

    }

    private fun closeKeyboard(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }


}