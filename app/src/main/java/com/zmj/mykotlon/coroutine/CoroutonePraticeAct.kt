package com.zmj.mykotlon.coroutine

import android.os.Bundle
import android.view.View
import com.zmj.mykotlon.R
import com.zmj.mykotlon.ui.activity.BaseActivity
import kotlinx.android.synthetic.main.act_coroutine_pritace.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2019/7/1
 * Description :
 */
class CoroutonePraticeAct : BaseActivity() {
    override fun setLayoutId(): Int {
        return R.layout.act_coroutine_pritace
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //countDown()
        //countDownJob()

        //coRoutineExpand()
        //coRoutinePlaus()
        setFib()
    }

    fun countDown(){
        GlobalScope.launch(Dispatchers.Main) {
            for (i in 20 downTo 1){
                tv_countDown.text = "CountDown $i...."
                delay(500)

            }
            tv_countDown.text = "Done!"
        }
    }

    fun countDownJob(){
        val job = GlobalScope.launch (Dispatchers.Main){
            for (i in 20 downTo 1){
                tv_countDown.text = "CountDown $i..."
                delay(500)
            }
        }

        btn_float.setOnClickListener { job.cancel() }//点击取消协程
    }

    fun coRoutineExpand(){
        btn_float.onClick {
            for (i in 20 downTo 1){
                tv_countDown.text = "Count Down $i..."
                delay(500)
            }
            tv_countDown.text = "Done!"
        }
    }

    //View 的扩展函数
    fun View.onClick(action: suspend ()-> Unit){
        setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                action()
            }
        }
    }

    fun coRoutinePlaus(){
        btn_float.onClickNew {
            for (i in 20 downTo 1){
                tv_countDown.text = "COunt Down $i..."
                delay(500)
            }
            tv_countDown.text = "Done!"
        }
    }
    //View扩展函数的优化
    fun View.onClickNew(action: suspend (View) -> Unit){
        //启动一个actor
                                        //capacity = Channel.CONFLATED/*设置处理最近的事件，执行本次事件及本次事件中点击的下一个事件（如果点击多次只执行到下一次）*/
        val eventActor = GlobalScope.actor<View>(Dispatchers.Main,capacity = Channel.UNLIMITED/*设置处理最近的事件*/) {
            for (event in channel) action(event)
        }
        //设置一个监听器来启用actor
        setOnClickListener {
            eventActor.offer(it)
        }
    }

    //在UI主线程中处理最后一次点击，斐波那契数列计算
    //斐波那契数列
    fun fib(x:Int) : Int = if (x <= 1) x else fib(x -1) + fib(x - 20)

    fun setFib(){
        var result = "none"  //最后一个结果
        //计数动画
        GlobalScope.launch(Dispatchers.Main) {
            var count = 0
            while (true){
                tv_countDown.text = "${++count} : $result"
                delay(100)
            }
        }

        //在每次点击时计算下一个斐波那契数
        var x = 1
        btn_float.onClick {
            result = "fib($x) = ${fib(x)}"
            x++
        }
    }



}