package com.example.lotteryrandom

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Use the correct binding class for this activity's layout
import com.example.lotteryrandom.databinding.ActivityMain2Binding
import kotlin.random.Random

private var nullOrEmpty: Boolean = TODO("initialize me")

class MainActivity2 : AppCompatActivity(), SensorEventListener {

    // Use the correct binding class
    private lateinit var binding: ActivityMain2Binding

    // Sensor-related variables
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var lastUpdate: Long = 0
    private var last_x: Float = 0.0f
    private var last_y: Float = 0.0f
    private var last_z: Float = 0.0f
    private val SHAKE_THRESHOLD = 800
    var receivedUserData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        receivedUserData = intent.getStringExtra("username")
        // Correctly inflate the layout and set the content view
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize sensor manager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Set the initial random number
        setRandomNumber()

        // Handle window insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.lottershare.setOnClickListener {
            val userIdentifier = if (!receivedUserData.isNullOrEmpty()) receivedUserData else "a user"
            val lotteryNumber = binding.lotternumber.text.toString()
            val recipientEmail = "" // Your support email address
            val subject = "Lottery Number Share"
            val message = "Hello,\n\nI am sharing my lottery number: $lotteryNumber\n\nFrom, $userIdentifier"

            // Create the email intent
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                // The 'mailto:' URI ensures only email apps handle this
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
            }

            // Use a try-catch block to prevent a crash if no email app is installed
            try {
                startActivity(Intent.createChooser(emailIntent, "Send email using..."))
            } catch (e: ActivityNotFoundException) {
                // Inform the user if no email app is found
                Toast.makeText(this, "No email app installed.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        // Register the sensor listener when the activity is resumed
        accelerometer?.also { accel ->
            sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Unregister the listener to save battery when the activity is paused
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val curTime = System.currentTimeMillis()
            // Only allow one update every 100ms.
            if ((curTime - lastUpdate) > 100) {
                val diffTime = (curTime - lastUpdate)
                lastUpdate = curTime

                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                val speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000

                if (speed > SHAKE_THRESHOLD) {
                    // --- SHAKE DETECTED ---
                    // You can put any logic here. For example, generate a new random number.
                    setRandomNumber()
                }
                last_x = x
                last_y = y
                last_z = z
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for this implementation, but required to be here.
    }

    fun setRandomNumber() {
        val min = 100_000_000_000_000L
        val max = 999_999_999_999_999L
        val randomNumber = Random.nextLong(min, max)
        // Use the binding object to access the TextView
        binding.lotternumber.text = randomNumber.toString()
    }
}
