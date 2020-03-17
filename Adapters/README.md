# Адаптери в Android

Адаптерът е обект от клас, който имплементира интерфейса **Adapter**. Той действа като връзка между данните и изгледа. Адаптерът отговаря от данните да се генерират обекти за изгледа.

Основни адаптер в Android, използвани за попълване на данни в списъчен изглед.
1. BaseAdapter – Родителски адаптер наследяван от всички адаптери.
2. ArrayAdapter – Подходящ е за използване, когато имаме списък от единични елементи, които се поддържат от масив.
3. Custom ArrayAdapter – Използва се когато трябва да покажем персонализиран списък.
4. SimpleAdapter – Подходящ е за преобразуване на статични данни, дефинирани във вашен XML файл
5. Custom SimpleAdapter – Използва се когато трябва да покажем персонализиран списък до чиито елементи да имаме достъп.

## Компоненти на потребителския интерфейс

Визуалните елементи който използват адаптери за данни се:

- ListView
- GridView
- RecyclerView

Тези елемети показват данни от колекции. Като един елемент от списъка се дефинира от Ресурсен XML файл.

## Примерно използване:

1. Необходимо е да се дефинира колекция с данни като променлива на класа MainActivity

```java
    String[] estimates = {
            "Слаб",
            "Среден",
            "Добър",
            "Много Добър",
            "Отличен"
          };
```

2. Трябва да се създаде XML резурс за оформление на данните в изгледа. Това става с десен бутон върху папката **layout -> new -> XML -> layout XML file**

Файла ще се казва: item
Root Tag ще е: LinearLayout - този таг оказва, че всички визуални елементи в него ще се подреждат в линия

От панела с ресурсите изберете TexView и го провлачете върху изгледа, който създадохте.

3. В MainActivity след като се е заредил потребителския интерфеис в OnCreate метода, следва да се създаде адаптер:

Конструктора на ArrayAdapter приема като входни параметри:

   - 1. Контекста в който се намира обекта на адаптера.
   - 2. Ресурсния файл който представя как ще изглежда  единелемент от списъка файла item
   - 3. Идентификатора на TextView от файла item
   - 4. Колекцията чиито данни ще се зареждат

```java
ArrayAdapter<String> estimatesAdapter = 
    new ArrayAdapter<String>(this,
        R.layout.item,
        R.id.textView,
        estimates
    );
```

4. Адаптера трябва да се зареди в изгледа за целта в аctivity_мain.xml трябва да се добави ListView от палитрата.

след това се извлича в MainActivity класа и му се поставя адаптер.

```java
ListView listView = findViewById(R.id.listView);
listView.setAdapter(cheeseAdapter);
```

## Персонален Адаптер

Когато искаме да изобразим данни от потребителски клас напрмер Animal с име и снимка е необходимо да използваме персонализиран адаптер. За целта трябва да се създаде нов клас например AnimalAdapter който да наследява ArrayAdapter и да имплементира конструктор и метода getView.


Примерна реализация на метода getView
```java
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    v = inflater.inflate(R.layout.list_view_items, null);// извлича се обекта на изгледа в които ще се зареждат наните
    TextView textView = (TextView) v.findViewById(R.id.textView);// извлича текстови изглед по ID
    ImageView imageView = (ImageView) v.findViewById(R.id.imageView);// извлича изглед на изображение по ID
    textView.setText(animalList.get(position).getAnimalName());//поставя текст
    imageView.setImageResource(animalList.get(position).getAnimalImage());//поставя снимка по ID от ресурсите на приложението
    return v;//връща като резултат обекта който трябва да се зареди в ListView елемента
}
```



