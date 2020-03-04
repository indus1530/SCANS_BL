package edu.aku.hassannaqvi.uen_scans_bl.ui.sections

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import edu.aku.hassannaqvi.uen_scans_bl.R
import edu.aku.hassannaqvi.uen_scans_bl.utils.FLAGS_FULLSCREEN
import edu.aku.hassannaqvi.uen_scans_bl.utils.IMMERSIVE_FLAG_TIMEOUT

class SectionDentalActivity : AppCompatActivity() {

    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section_dental)
        container = findViewById(R.id.nav_host_fragment)
    }

    override fun onResume() {
        super.onResume()
        // Before setting full screen flags, we must wait a bit to let UI settle; otherwise, we may
        // be trying to set app to immersive mode before it's ready and the flags do not stick
        container.postDelayed({
            container.systemUiVisibility = FLAGS_FULLSCREEN
        }, IMMERSIVE_FLAG_TIMEOUT)
    }

    companion object {
        const val TAG = "DentalCameraX"
    }
}
