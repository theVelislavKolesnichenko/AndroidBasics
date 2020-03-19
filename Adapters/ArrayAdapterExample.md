# ArrayAdapter

ArrayAdapter прави връзка между ArrayList (източник на данни) и ListView (визуално представяне) в два аспекта:

- Кой масив да се използва като източник на данни
- Как да конвертирате всеки даден елемент от масива в съответен View обект

# Използване на ArrayAdapter

### Задача:
```
Да се създаде приложение извеждащо списък 
със степените за оценяване.
```

При използването на ArrayAdapter с ListView с клас от стандартния пакет не е нужно да се реализират допълнителни методи.

Преди да се създаде имплементация на BaseAdapter, трябва да се създаде оформлението за един реда ListView, а също и клас за елементите (данните) в ListView.

## Kлас за данни - Генератор на данни

```java
public class Repository {
    public static String[] getItemsList() {
        return new String[] {
                "Слаб",
                "Среден",
                "Добър",
                "Много Добър",
                "Отличен"
        };
    }
}
```

## ListView оформление (layout)

Създава се с десен бутон върху папката **layout -> new -> XML -> layout XML file**

файла ще се казва: **item.xml**, защото ще съдържа визуалното описние на един ред от ListView.
Root Tag ще е: LinearLayout - този таг оказва, че всички визуални елементи в него ще се подреждат в линия

От палитрата с ресурси изберете TexView и гo провлачете върху изгледа, който създадохте.

![createproject](https://user-images.githubusercontent.com/10382663/77059669-fb1fa500-69df-11ea-840f-f415da6feec0.png)

## Добавяне на ListView

В аctivity_мain.xml трябва да се добави ListView от палитрата.

![textview](https://user-images.githubusercontent.com/10382663/77059672-fbb83b80-69df-11ea-9e03-dbbee730570f.png)

## Използване на ArrayAdapter

Адаптерът се използва лесно, като се създаде с необходимите параметри и зададете като адаптер на listview.

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] estimates = Repository.getItemsList();

        ArrayAdapter<String> estimatesAdapter = new ArrayAdapter<String>(
                this, // контекста където ще се използва адаптера
                R.layout.item, // визуален елемент за ред в ListView
                R.id.textView, // визуален елемент за показване на данните
                estimates // колекция с данни
                );
        // извличане ListView
        ListView listView = findViewById(R.id.listView);
        // задаване на адаптер
        listView.setAdapter(estimatesAdapter);
    }
}
```
По подразбиране това вече ще преобразува всеки елемент от масива от данни в изглед, като извиква toString елемента и след това ще присвоява резултата като стойност на TextView( R.id.textView) от изгледа R.layout.item, която се показва като ред за всеки елемент от данни. Ако приложението изисква по-сложен превод между елемент и View тогава вместо ArrayAdapter трябва да създадем персонализиран адаптер.

[Проекта](https://github.com/theVelislavKolesnichenko/AndroidBasics/tree/master/ExampleProjects/AdapterExamples/ArrayAdapterExample)



