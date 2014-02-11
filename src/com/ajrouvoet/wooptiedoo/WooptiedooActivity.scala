package com.ajrouvoet.wooptiedoo

import android.app.Activity
import android.os.Bundle
import android.widget.{Button,TextView}
import android.view.View
import scala.util.Random
import android.view.View.OnClickListener

object implicits {
  implicit def anon_to_onclick(f: View => Unit) = new OnClickListener {
    override def onClick(v: View): Unit = f(v)
  }
}

class WooptiedooActivity extends Activity {

  import implicits._

  lazy val rollBtn = findViewById(R.id.roll_btn).asInstanceOf[Button]
  lazy val outcome = findViewById(R.id.outcome_text).asInstanceOf[TextView]

  /** Called when the activity is first created. */
  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)

    rollBtn.setOnClickListener({ v:View => outcome.setText("You rolled: " + Random.nextInt(6))})
  }

}

