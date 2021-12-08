package com.mehdi.myapplication.fragment

import ProductListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehdi.myapplication.R
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.android.synthetic.main.list_item_cell.view.*
import java.util.*

class ProductListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.list_fragment,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main_list.run {
            layoutManager = LinearLayoutManager(this@ProductListFragment.context)
            adapter = ProductListAdapter()
            addItemDecoration(
                DividerItemDecoration(
                    this@ProductListFragment.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

    }


}

