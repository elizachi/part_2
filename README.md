# part_2
этап 2: Реализация модуля хранения на связном списке из
пар
Храним соответвие <Имя кота> → <цвет, возраст, вес>
• Имя кота: String; служит идентификатором
• Цвет: String
• Возраст: Int
• Вес: FloatЧтобы хранить пару из ключа и значения, храним в связном списке пары из имени кота и data
class’а, соответствующего значению <цвет, возраст, вес>
Одновременно может храниться любое количество пар.
Для вхождения “Имя → цвет, возраст, вес” фиксируется формат вывода, на усмотрение
исполнителя. Вывод вхождений осуществляется всегда в этом формате.
Команды для взаимодействия через CLI:
• create
• Не гарантируется уникальность id, т.е. в списке не обязательно хранится
пара, в которой первый компонент равен id.
• Формат ввода: “create <имя> <цвет> <возраст> <вес>”
• Выводит созданное вхождение или сообщение об ошибке “Create: already
exists”
• read
• Не гарантируется корректность id, т.е. в списке не обязательно хранится пара,
в которой первый компонент равен id.
• Формат ввода: “read <имя>”
• Выводит прочитанное вхождение или сообщение об ошибке “Read: not found”
• delete id
• Не гарантируется корректность id, т.е. в списке не обязательно хранится пара,
в которой первый компонент равен id.
• Формат ввода: “delete <имя>”
• Выводит “OK” или сообщение об ошибке “Delete: not found”
• readall
• Выводит все пары ключей и значений в произвольном порядке
• Формат ввода: “readall”
• Каждое вхождение выводится с новой строки.
По одной команде на строчке.