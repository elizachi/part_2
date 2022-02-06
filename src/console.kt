enum class CommandType {
    CREATE,
    READ,
    DELETE,
    READALL;
}
fun reader() {
    // считываем и обрабатываем строку чтобы не было лишних пробелов
    var str = converter()
    // ссылки на функции
    val pointer1 = ::create
    val pointer2 = ::read
    val pointer3 = ::delete
    val pointer4 = ::readall
    // пока пользователь не нажал Enter
    while(str.isNotBlank()){
        // вырезаем команду
        val command = getFirstWord(str)
        // массив из ссылок на функции
        val pointers = listOf(pointer1, pointer2, pointer3, pointer4)
        // определяем индекс enum'а
        val pointerIndex = CommandType.valueOf(command.uppercase()).ordinal
        // проверка на readall
        if(pointerIndex == 3) {
            // вызываем соответствующую функцию
            pointers[pointerIndex].call()
        } else {
            // вырезаем аргументы
            val arguments = getArguments(str)
            // вызываем соответствующую функцию
            pointers[pointerIndex].call(arguments)
        }
        str = converter()
    }
}