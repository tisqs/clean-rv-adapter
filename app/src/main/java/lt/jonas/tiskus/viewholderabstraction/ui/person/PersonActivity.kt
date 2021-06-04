package lt.jonas.tiskus.viewholderabstraction.ui.person

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lt.jonas.tiskus.viewholderabstraction.data.model.Person
import lt.jonas.tiskus.viewholderabstraction.data.repository.PersonRepository
import lt.jonas.tiskus.viewholderabstraction.databinding.ActivityMainBinding

class PersonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = PersonAdapter()
    private val personRepository = PersonRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        binding.recyclerView.adapter = adapter

        adapter.submitList(personRepository.personList)

        binding.fab.setOnClickListener {
            addNewPersonAndUpdateAdapter()
        }
    }

    private fun addNewPersonAndUpdateAdapter() {
        //generate new person
        val newPersonId = adapter.itemCount + 1
        personRepository.addPerson(
            Person(
                newPersonId,
                "Added new person $newPersonId",
                20
            )
        )
        //submit new list
        adapter.submitList(personRepository.personList)
    }


}