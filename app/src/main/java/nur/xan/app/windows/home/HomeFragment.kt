package nur.xan.app.windows.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import nur.xan.app.R
import nur.xan.app.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextGifts.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_giftsFragment)
        }

        binding.nextBonus.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_bonusFragment)
        }

        binding.nextCard.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_cardFragment)
        }

        binding.nextInfo.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_infoFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}