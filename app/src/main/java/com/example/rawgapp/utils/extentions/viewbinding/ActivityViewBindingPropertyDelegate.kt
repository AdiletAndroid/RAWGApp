package com.example.rawgapp.utils.extentions.viewbinding

import androidx.activity.ComponentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.example.nytimesclean.utils.extentions.viewbinding.ViewBindingPropertyDelegate

@PublishedApi
internal class ActivityViewBindingPropertyDelegate<TBinding : ViewBinding>(
    viewBinder: (ComponentActivity) -> TBinding
) : ViewBindingPropertyDelegate<ComponentActivity, TBinding>(viewBinder) {
    override fun getLifecycleOwner(thisRef: ComponentActivity): LifecycleOwner = thisRef
}