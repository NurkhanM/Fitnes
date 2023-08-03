package nur.xan.app.windows.bonus.infoBonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nur.xan.app.R
import nur.xan.app.databinding.FragmentBonusBinding
import nur.xan.app.databinding.FragmentInfoBonusBinding

class InfoBonusFragment : Fragment() {

    private var _binding: FragmentInfoBonusBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBonusBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBack.setOnClickListener {
            activity?.onBackPressed()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}