package lt.jonas.tiskus.viewholderabstraction.data.repository

import lt.jonas.tiskus.viewholderabstraction.data.model.Person

class PersonRepository {

    val personList : MutableList<Person> = mutableListOf()

    init {
        val initList = listOf(
            Person(1, "Tom", 24),
            Person(2, "Julia", 22),
            Person(3, "Peter", 30),
            Person(4, "Dave", 19)
        )
        personList.addAll(initList)
    }

    fun addPerson(person: Person) {
        personList.add(person)
    }
}