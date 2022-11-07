package andre.perdigao.cursoandroid.swedensalaryrefactored

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplitActivity : AppCompatActivity() {

    private var waitTime = 5000


    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split)

        changeScreen()

    }

    private fun changeScreen() {

        Handler(
            Looper.getMainLooper()).postDelayed({
            val changeScreenInt = Intent(this@SplitActivity, MainActivity::class.java)
            startActivity(changeScreenInt)
            finish()
        }, waitTime.toLong())

    }


}