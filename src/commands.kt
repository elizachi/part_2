import java.util.*

// определены дата класс и связный список
// TODO придумать другой способ поиска по списку тк затратно для памяти
data class Cat(val colour: String, val age: Int, val weight: Float)
var linkedListOfCats = LinkedList<Pair<String, Cat>>()
var listOfCats = LinkedList<String>()

// стартовая команда
fun start() {
    print("Вы можете использовать любую из доступных Вам команд:\n\n" +
            "create <имя> <цвет> <возраст> <вес> - добавить элемент\n" +
            "read <имя>                          - дать информацию о существующем элементе\n" +
            "delete <имя>                        - удалить существующий элемент\n" +
            "readall                             - дать информацию о всех существующих элементах\n" +
            "\nдля выхода нажмите Enter\n")
} // команда добавления нового элемента
fun create(catInfo: String) {
    if(isArgumentsCorrect(catInfo)) {
        val catProperties = getArguments(catInfo).split(" ") // создаю список параметров кота
        // data class для нового кота
        val catDataClass = Cat(catProperties[0], catProperties[1].toInt(), catProperties[2].toFloat())
        // пара <id> <data class>
        val newCat = Pair(getFirstWord(catInfo), catDataClass)
        if (linkedListOfCats.indexOf(newCat) == -1) { // добавляю кота в связный список, если его там нет
            linkedListOfCats.add(newCat)
            listOfCats.add(getFirstWord(catInfo))
            print("${getFirstWord(catInfo)} successfully added.\n")
        } else {
            System.err.print("Create: already exist.\n")
        }
    } else {
        print("Данные введены неккоректно.\n")
    }
} // команда выдачи информации об уже существующем элементе
fun read(catId: String){
    val index = listOfCats.indexOf(catId)
    if(index  != -1) {
        print("${linkedListOfCats[index].first} --> ${linkedListOfCats[index].second.colour} " +
                "${linkedListOfCats[index].second.age} ${linkedListOfCats[index].second.weight}\n")
    } else {
        System.err.print("Read: not found.\n")
    }
} // команда удаления уже существующего элемента
fun delete(catId: String){
    val index = listOfCats.indexOf(catId)
    if(index  != -1) {
        linkedListOfCats.remove(linkedListOfCats[index])
        listOfCats.remove(catId)
        print("$catId removed successfully.\n")
    } else {
        System.err.print("Delete: not found.\n")
    }
} // команда выдачи информации о всех существующих элементах
fun readall(){
    for(element in linkedListOfCats){
        print("${element.first} --> ${element.second.colour} ${element.second.age} ${element.second.weight}\n")
    }
}