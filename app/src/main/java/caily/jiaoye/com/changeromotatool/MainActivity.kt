package caily.jiaoye.com.changeromotatool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import caily.jiaoye.com.changeromotatool.enums.LogInStatus
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        jumpToView()

        jump_test.setOnClickListener {
            run {
                val intent = Intent().apply {
                    this.setClass(this@MainActivity, caily.jiaoye.com.changeromotatool.view.WelcomeActivity::class.java)
                }
                this.startActivity(intent)
            }
        }
    }

    fun jumpToView() {
         when(checkLogInStats()) {
            LogInStatus.LogIn -> TODO()
            LogInStatus.LogOut -> {
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
