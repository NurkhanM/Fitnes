package nur.xan.app.windows.bonus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import nur.xan.app.R
import nur.xan.app.databinding.FragmentBonusBinding
import nur.xan.app.interfacers.IClickListnearBonus
import nur.xan.app.models.BonusModels

class BonusFragment : Fragment() {

    private var _binding: FragmentBonusBinding? = null
    private val binding get() = _binding!!


    private lateinit var recycler: RecyclerView
    private lateinit var adapter: BonusAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBonusBinding.inflate(inflater, container, false)

        recycler = binding.rvBonus
        adapter = BonusAdapter(
            object : IClickListnearBonus {

                override fun clickListener(
                    baseID: Int
                ) {
                    findNavController().navigate(R.id.action_bonusFragment_to_infoBonusFragment)
                }
            })

        recycler.adapter = adapter
        recycler.setHasFixedSize(true)

        val arGaid = arrayListOf(
            BonusModels(R.drawable.bonus_1),
            BonusModels(R.drawable.bonus_2),
            BonusModels(R.drawable.bonus_3)
        )

        adapter.setList(arGaid)

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