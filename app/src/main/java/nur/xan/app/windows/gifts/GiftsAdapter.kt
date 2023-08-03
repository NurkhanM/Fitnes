package nur.xan.app.windows.gifts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import nur.xan.app.R
import nur.xan.app.databinding.ItemGiftsBinding
import nur.xan.app.interfacers.IClickListnearGIfts
import nur.xan.app.models.GiftsModels
import java.util.*

class GiftsAdapter(private val mIClickListnear: IClickListnearGIfts) :
    RecyclerView.Adapter<GiftsAdapter.MyViewHolder>() {
    lateinit var context: Context

    private var listTovar = ArrayList<GiftsModels>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemGiftsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return MyViewHolder(binding)
    }

    @SuppressLint("NewApi", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listTovar[position]


        holder.binding.title.text = currentItem.title
        holder.binding.text.text = currentItem.text
        holder.binding.point.text = currentItem.point
        Glide.with(context).load(listTovar[position].image)
            .thumbnail(Glide.with(context).load(R.drawable.loader2))
            .centerCrop()
            .into(holder.binding.imageGifts)


        holder.binding.rowCostom.setOnClickListener {
            mIClickListnear.clickListener(position, currentItem.title, currentItem.text, currentItem.image)
        }


    }

    override fun getItemCount(): Int {
        return listTovar.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<GiftsModels>) {
        listTovar = list as ArrayList<GiftsModels>
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val binding: ItemGiftsBinding) : RecyclerView.ViewHolder(binding.root)

}

