package com.mehdi.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mehdi.myapplication.Product
import com.mehdi.myapplication.R
import kotlinx.android.synthetic.main.product_details_fragment.*

class ProductSharedModel : ViewModel() {
    val selectedProduct = MutableLiveData<Product>()

    fun change(product: Product) {
        selectedProduct.value = product
    }
}

class ProductDetailsFragment : Fragment() {
    private val model: ProductSharedModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.product_details_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.product_details_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(product_details_bottom_nav, navHost.navController)
        model.change(arguments?.getSerializable("product") as Product)
    }

}