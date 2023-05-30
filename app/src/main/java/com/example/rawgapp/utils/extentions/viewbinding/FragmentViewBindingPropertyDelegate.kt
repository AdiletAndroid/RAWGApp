package com.example.rawgapp.utils.extentions.viewbinding

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.example.nytimesclean.utils.extentions.viewbinding.ViewBindingPropertyDelegate

@PublishedApi
internal class FragmentViewBindingPropertyDelegate<TBinding : ViewBinding>(
    viewBinder: (Fragment) -> TBinding
) : ViewBindingPropertyDelegate<Fragment, TBinding>(viewBinder) {
    override fun getLifecycleOwner(thisRef: Fragment): LifecycleOwner = thisRef.viewLifecycleOwner
}