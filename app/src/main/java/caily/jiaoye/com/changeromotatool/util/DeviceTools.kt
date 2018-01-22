package caily.jiaoye.com.changeromotatool.util

import android.app.AlertDialog
import caily.jiaoye.com.changeromotatool.MainActivity
import java.io.DataOutputStream
import java.io.IOException


/**
 * Created by caily on 22/01/2018.
 */
object DeviceTools {

    private var terminalInstance: Process? = null

    fun getImei(): String {
        TODO()
    }

    fun getVersion(): String {
        TODO()
    }

    fun getAndroidVersion(): String {
        TODO()
    }

    fun getBasebandVersion(): String {
        TODO()
    }

    fun getKernelVersion(): String {
        TODO()
    }

    fun rebootToRecovery(mainActivity: MainActivity) {
        try {
            // 获取管理员权限su
            val process = getSystemTerminal()
            // 输入命令
            val out = DataOutputStream(process.outputStream)
            out.writeBytes("reboot recovery\n")
            // 结束
            out.writeBytes("exit\n")
            out.flush()
        } catch (e: IOException) {
            AlertDialog.Builder(mainActivity).setTitle("很抱歉")
                    .setMessage("你的手机未ROOT，无法实现该功能！")
                    .setPositiveButton("OK", null).show()
        }
    }

    fun getSystemTerminal(): Process {
        if (terminalInstance == null) {
            terminalInstance = Runtime.getRuntime().exec("su")
        }

        return terminalInstance!!
    }

}