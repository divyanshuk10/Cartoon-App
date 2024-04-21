package com.divyanshu.assignmentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.divyanshu.assignmentapp.databinding.FragmentCartoonDetailsBinding
import com.divyanshu.model.CartoonData

class CartoonDetailsFragment : Fragment() {

    private var _binding: FragmentCartoonDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: CartoonDetailsFragmentArgs by navArgs()
    private lateinit var cartoonData: CartoonData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        cartoonData = args.cartoonData!!
        _binding = FragmentCartoonDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            txtCartoon.text = buildString {
                append("Name : ")
                append(cartoonData.name)
            }
            val imageLink = cartoonData.image
            txtGender.text = buildString {
                append("Gender : ")
                append(cartoonData.gender)
            }
            txtStatus.text = buildString {
                append("Status : ")
                append(cartoonData.status)
            }
            txtSpecies.text = buildString {
                append("Species : ")
                append(cartoonData.species)
            }
            txtType.text = buildString {
                append("Type : ")
                append(cartoonData.type.ifBlank { "Unknown" })
            }
            imgCartoon.load(imageLink) {
                crossfade(true)
                crossfade(500)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}