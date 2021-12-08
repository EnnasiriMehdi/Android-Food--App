package com.mehdi.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mehdi.myapplication.R
import com.mehdi.myapplication.setTextBold
import kotlinx.android.synthetic.main.product_details_summary_fragment.*

class ProductDetailsSummaryFragment : Fragment() {
    private val model: ProductSharedModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_summary_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product = model.selectedProduct.value
        barcode
            .setTextBold(
                getString(R.string.product_barcode, product?.barCode)
            )

        quantity
            .setTextBold(
                getString(R.string.product_quantity, product?.quantity)
            )

        countrySale
            .setTextBold(
                getString(R.string.product_country_sale, product?.countryToString())
            )

        ingredients
            .setTextBold(
                getString(R.string.product_ingredients, product?.ingredientsToString())
            )

        allergens
            .setTextBold(
                getString(R.string.product_allergens, product?.allergensToString())
            )

        additives
            .setTextBold(
                getString(R.string.product_additives, product?.additivesToString())
            )
        productName.text = product?.name

        brand.text = product?.brand
//        day_text.text = DetailsFragmentArgs.fromBundle(requireArguments())
//            .day
    }

}