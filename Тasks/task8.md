# Задача 1 

Да се създаде AsyncTask имитиращ мрежова заявка. 

1. Създайте Activity с Button, EditText за въвеждане на числа, TextView.
2. Създайте клас наследяващ AsyncTask:
   1. Приемаш въведената стойност от EditText
   2. Извежда прогрес фрагмент диалог с оставащите секунди до завършване на задачата (обновява се всяка секунда)
   3. Когато процеса завърши изписва "Завършена" със зелен цвят в TextView

# Задача 2

Създайте два AsyncTask:
1. Първия за случаино време от 2 до 5 секунди симулира изтегляне на изображение. Връща true - за успешно, false - за неуспешно (ползвайте Random)
2. Втория за случаино време от 3 до 5 секунди симулира login процес. Връща true - за успешно, false - за неуспешно (ползвайте Random)
3. При натискане на бутон се показва кръгъл прогресбар и се стартират двата процеса. Като приключат се скрива кръглия прогресбар
4. След приключване и на двата процеса да се изпише в TextView "Успешно" ако и двата са върнали true или "Не успешно" ако един е върнал false

**Упътване:** Направете задачите в едно приложение с отделни Activity за всяка задача