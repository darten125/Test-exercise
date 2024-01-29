package com.example.testexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var is_Menu_Button_pressed :Boolean = false
    val SWIPE_MIN_DISTANCE = 100
    val SWIPE_MIN_VELOCITY = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gestureDetector: GestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener(){
            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                if (e1 != null) {
                    val deltaX = e2.x - e1.x
                    if (Math.abs(deltaX) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY && deltaX < 0) {
                        return true
                    }
                }
                return false
            }
        })

        val button_1: FloatingActionButton = findViewById(R.id.appearing_button_1)
        val button_2: FloatingActionButton = findViewById(R.id.appearing_button_2)
        val button_3: FloatingActionButton = findViewById(R.id.appearing_button_3)
        val button_4: FloatingActionButton = findViewById(R.id.appearing_button_4)
        val button_5: FloatingActionButton = findViewById(R.id.appearing_button_5)

        val menu_button: Button = findViewById(R.id.menu_button)

        menu_button.setOnClickListener{
            if (!is_Menu_Button_pressed){
                showAnimation(button_1,400)
                showAnimation(button_2,380)
                showAnimation(button_3,360)
                showAnimation(button_4,330)
                showAnimation(button_5,300)
                is_Menu_Button_pressed = true
            }
            else{
                hideAnimation(button_1,400)
                hideAnimation(button_2,380)
                hideAnimation(button_3,360)
                hideAnimation(button_4,330)
                hideAnimation(button_5,300)
                is_Menu_Button_pressed = false
            }
        }

        button_1.setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                swipeAnimation(button_1,300)
                true
            } else {
                false
            }
        }

        button_2.setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                swipeAnimation(button_2,300)
                true
            } else {
                false
            }
        }

        button_3.setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                swipeAnimation(button_3,300)
                true
            } else {
                false
            }
        }

        button_4.setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                swipeAnimation(button_4,300)
                true
            } else {
                false
            }
        }

        button_5.setOnTouchListener { v, event ->
            if (gestureDetector.onTouchEvent(event)) {
                swipeAnimation(button_5,300)
                true
            } else {
                false
            }
        }
    }
    fun showAnimation(button: FloatingActionButton, duration:Long){
        button.visibility = View.VISIBLE
        val parent = button.parent as View
        val distanceToMoveDown = parent.bottom - button.top
        button.translationY = distanceToMoveDown.toFloat()
        button.animate().translationY(0f).setDuration(duration).start()
    }

    fun hideAnimation(button:FloatingActionButton, duration:Long) {
        val parent = button.parent as View
        val distanceToMoveDown = parent.bottom - button.top
        button.animate().translationY(distanceToMoveDown.toFloat()).setDuration(duration).withEndAction{button.visibility = View.INVISIBLE}.start()
    }

    fun swipeAnimation(button:FloatingActionButton, duration:Long){
        val parent = button.parent.parent as View
        val distanceToMoveLeft = parent.left - button.right
        button.animate().translationX(distanceToMoveLeft.toFloat()).setDuration(duration).withEndAction {
            button.visibility = View.INVISIBLE
            button.translationX = 0f}.start()
    }
}