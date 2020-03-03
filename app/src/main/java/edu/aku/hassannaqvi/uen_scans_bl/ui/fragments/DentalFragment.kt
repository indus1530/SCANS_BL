package edu.aku.hassannaqvi.uen_scans_bl.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.aku.hassannaqvi.uen_scans_bl.databinding.FragmentDentalBinding
import edu.aku.hassannaqvi.uen_scans_bl.utils.Util


/**
 * A simple [Fragment] subclass.
 */
class DentalFragment : Fragment() {

    private lateinit var bi: FragmentDentalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bi = FragmentDentalBinding.inflate(inflater, container, false)
        bi.callback = this

        return bi.root
    }

    fun btnCapture() {
//        findNavController().navigate(DentalFragmentDirections.actionDentalFragmentToPermissionsFragment())
    }

    fun btnNext() {
        Util.contextEndActivity(activity)
    }

}
