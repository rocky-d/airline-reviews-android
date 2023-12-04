package njit.rocky.airlinereviews.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import njit.rocky.airlinereviews.R

class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var editText1: EditText // Initialize these with appropriate IDs
    private lateinit var imageViewPicture: ImageView
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        editText1 = view.findViewById(R.id.editText1)
        // Initialize other views
        imageViewPicture = view.findViewById(R.id.imageViewPicture)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        buttonSubmit.setOnClickListener {  // TODO: have some problem now
            val airlineName = editText1.text.toString()
            if (airlineName.isEmpty()) {
                Toast.makeText(requireActivity(), "Empty Airline Name", Toast.LENGTH_SHORT).show()
            }
            viewModel.fetchDataFromServer(airlineName)
        }

        viewModel.imageData.observe(viewLifecycleOwner) { bitmap ->
            imageViewPicture.setImageBitmap(bitmap)
        }

        return view
    }
}