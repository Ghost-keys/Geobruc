package co.za.geobruc.presentation.screens.sign_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import co.za.geobruc.R

class SignInFragment : Fragment() {

    private lateinit var signInButton: Button
    private lateinit var signUpTextLinkView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Load visual layout for sign in screen from fragment_sign_in.xml
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        signInButton = view.findViewById(R.id.sign_in_button)
        signUpTextLinkView = view.findViewById(R.id.sign_up_link)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signInButton.setOnClickListener {
            findNavController()
        }

        signUpTextLinkView.setOnClickListener {
            findNavController()
        }
    }
}