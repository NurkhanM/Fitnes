package nur.xan.app.windows.bonus

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nur.xan.app.R
import nur.xan.app.databinding.ItemBonusBinding
import nur.xan.app.interfacers.IClickListnearBonus
import nur.xan.app.models.BonusModels
import java.util.*

class BonusAdapter(private val mIClickListnear: IClickListnearBonus) :
    RecyclerView.Adapter<BonusAdapter.MyViewHolder>() {
    lateinit var context: Context

    private var listTovar = ArrayList<BonusModels>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemBonusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    @SuppressLint("NewApi", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]


        Glide.with(context).load(listTovar[position].image)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .centerCrop()
            .into(holder.binding.image)


        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position)
        }


    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<BonusModels>) {
        listTovar = list as ArrayList<BonusModels>
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemBonusBinding) : RecyclerView.ViewHolder(binding.root)

}

