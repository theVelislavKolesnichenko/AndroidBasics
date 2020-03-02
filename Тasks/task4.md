# Задача

Създайте приложение с 3 Activity:

- Първото съдържа 2 бутона, съответно за отваряне на * второто * и * третото * Activity. Създайте клас OpenActivity с поле Class който да наследява View.OnClickListener и да се използва за пренасочване от главното към второто и третото Activity.
- Второто съдържа EditText и TextView, да се имплементира TextWatcher, като на onTextChanged() да се записва всяка промяна от EditText в TextView.
- Третото съдържа FloatingActionButton, TextView (без стойност) и EditText, при натискане на бутона да се провери дали въведената стойност в EditText е "123-456-789", ако формата е валиден в TextView да се изпише "Valid input" в зелено ако е невалиден в TextView да се изпише "Invalid input" в червено
