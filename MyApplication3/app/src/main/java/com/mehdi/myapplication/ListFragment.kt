import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mehdi.myapplication.Product
import com.mehdi.myapplication.R
import kotlinx.android.synthetic.main.list_item_cell.view.*

class ProductListAdapter : RecyclerView.Adapter<ListItemCell>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemCell {
        return ListItemCell(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_cell, parent, false)
        )
    }

    override fun onBindViewHolder(cell: ListItemCell, position: Int) {
        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "A",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            arrayOf<String>("France", "Japon", "Suisse"),
            arrayOf<String>(
                "Petits pois 66%",
                "eau",
                "garniture 2,8% (salade, oignon grelot)",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            arrayOf<String>(),
            arrayOf<String>("France", "Japon", "Suisse")
        )


        cell.itemView.setOnClickListener {
            cell.itemView.findNavController().navigate(
                R.id.action_productListFragment_to_productDetailsFragment,
                bundleOf("product" to product)
            )
        }

        cell.text.text = product.name
    }

    override fun getItemCount(): Int {
        return 10
    }

}

class ListItemCell(v: View) : RecyclerView.ViewHolder(v) {

    val text: TextView = v.text_cell

}