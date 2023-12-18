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
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var editText5: EditText
    private lateinit var editText6: EditText
    private lateinit var imageViewPicture: ImageView
    private lateinit var buttonSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        editText1 = view.findViewById(R.id.editText1)
        editText2 = view.findViewById(R.id.editText2)
        editText3 = view.findViewById(R.id.editText3)
        editText4 = view.findViewById(R.id.editText4)
        editText5 = view.findViewById(R.id.editText5)
        editText6 = view.findViewById(R.id.editText6)
        imageViewPicture = view.findViewById(R.id.imageViewPicture)
        buttonSubmit = view.findViewById(R.id.buttonSubmit)

        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        buttonSubmit.setOnClickListener {
            val airlineName = editText1.text.toString()
            if (airlineName.isEmpty()) {
                Toast.makeText(context, "Empty Airline Name", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.fetchDataFromServer(
                    arrayOf(
                        airlineName,
                        editText2.text.toString(),
                        editText3.text.toString(),
                        editText4.text.toString(),
                        editText5.text.toString(),
                        editText6.text.toString()
                    )
                )
            }
        }

        viewModel.imageData.observe(viewLifecycleOwner) { bitmap ->
            imageViewPicture.setImageBitmap(bitmap)
        }

        return view
    }
}