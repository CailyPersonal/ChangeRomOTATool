package caily.jiaoye.com.changeromotatool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* when(checkLogInStats()) {
            LogInStatus.LogIn -> TODO()
            LogInStatus.LogOut -> {
                setContentView(R.layout.activity_login)
            }
        }*/



        setContentView(R.layout.activity_main)


        jump_test.setOnClickListener {
            run {
                val intent = Intent().apply {
                    this.setClass(this@MainActivity, caily.jiaoye.com.changeromotatool.view.LoginActivity::class.java)
                }
                this.startActivity(intent)
            }
        }
    }

    fun checkLogInStats(): LogInStatus {

        return LogInStatus.LogOut
    }
}
