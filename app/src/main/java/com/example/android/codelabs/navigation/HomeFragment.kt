package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val button = view.findViewById<Button>(R.id.navigate_destination_button)
        button?.setOnClickListener {

            findNavController().navigate(R.id.flow_step_one_dest, null)
        }

//    val options = navOptions {
//        anim {
//            enter = R.anim.slide_in_right
//            exit = R.anim.slide_out_left
//            popEnter = R.anim.slide_in_left
//            popExit = R.anim.slide_out_right
//        }
//    }
//     view.findViewById<Button>(R.id.navigate_destination_button)?.setOnClickListener {
//         findNavController().navigate(R.id.flow_step_one_dest, null, options)
//     }
        // animasyonlu geçiş için yukarıda kodları açabilirsin

//       view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
//             Navigation.createNavigateOnClickListener(R.id.next_action, null)
//       )

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
