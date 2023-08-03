package nur.xan.app.windows.gifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import nur.xan.app.R
import nur.xan.app.databinding.FragmentGiftsBinding
import nur.xan.app.interfacers.IClickListnearGIfts
import nur.xan.app.models.GiftsModels

class GiftsFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: GiftsAdapter

    private var _binding: FragmentGiftsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGiftsBinding.inflate(inflater, container, false)


        recycler = binding.rvGifts
        adapter = GiftsAdapter(
            object : IClickListnearGIfts {

                override fun clickListener(
                    baseID: Int,
                    title: String,
                    text: String,
                    image: Int
                ) {
                    val dataArray = arrayOf(title, text, image.toString())
                    val action = GiftsFragmentDirections.actionGiftsFragmentToInfoGiftsFragment(dataArray)
                    findNavController().navigate(action)

//                    findNavController().navigate(R.id.action_giftsFragment_to_infoGiftsFragment)
                }
            })

        recycler.adapter = adapter
        recycler.setHasFixedSize(true)

        val arGaid = arrayListOf(
            GiftsModels("Absinthe", "coctail", "200"  , R.drawable.frame_1),
            GiftsModels("Negroni", "coctail", "100"  , R.drawable.frame_2),
            GiftsModels("Tokeo Tea", "coctail", "100", R.drawable.frame_3),
            GiftsModels("Shamrock", "coctail", "100", R.drawable.frame_4),
            GiftsModels("Daiquiri", "coctail", "300", R.drawable.frame_5),
            GiftsModels("Margarita", "coctail", "200", R.drawable.frame_6),
            GiftsModels("Martini", "coctail", "400", R.drawable.frame_7)
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