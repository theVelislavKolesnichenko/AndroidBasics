# Използване на персонализиран ArrayAdapter

За показването на поредица от елементи в списък, използвайки персонализирано представяне на елементите чрез клас, трябва да се използва и индовидуално решение за XML оформление за всеки елемент. За да направим това, трябва да създадем свой собствен персонализиран ArrayAdapter клас.

### Задача:
```
Да се създаде приложение извеждащо списък 
от потребители с името и града в който живеят.
```

![createproject](https://user-images.githubusercontent.com/10382663/77065227-92d5c100-69e9-11ea-8554-93259dd20a85.png)

## Kлас за данни

Всеки ред в ListView ще съдържа *име на човек* и *град*. А всеки град ще съдържа *име на град* и *пощенски код*, така че класът ще изглежда:

```java
public class City {
    private String name;
    private int PostCode;

    public City(String name, int postCode) {
        this.name = name;
        PostCode = postCode;
    }

    public String getName() {
        return name;
    }

    public int getPostCode() {
        return PostCode;
    }
}
```
```java
public class User {
    private String name;
    private City city;

    public User(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}
```

## Генератор на данни

```java
public class UserSource {
    public static ArrayList<User> generateItemsList() {
        ArrayList<User> cites = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            cites.add(new User("User " + i,  new City("City " + i, 9000 + i)));
        }
        return  cites;
    }
}
```

## Създаване на шаблон за оформление на ListView (layout)

Създава се с десен бутон върху папката **layout -> new -> XML -> layout XML file**

файла ще се казва: **user_item.xml**, защото ще съдържа визуалното описние на един ред от ListView.
Root Tag ще е: LinearLayout - този таг оказва, че всички визуални елементи в него ще се подреждат в линия

От палитрата с ресурси изберете три TexView и ги провлачете върху изгледа, който създадохте.

![listview](https://user-images.githubusercontent.com/10382663/77066208-67ec6c80-69eb-11ea-8998-3c6d44ef73cc.png)

## Реализация на Adapter

Aдаптера, тряба да опише процеса на преобразуване на Java обекта в изглед това става в метода getView.

```java
public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(@NonNull Context context, @NonNull ArrayList<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Извличане на текущия елемент от списъка
        User user = getItem(position);
        // проверя ва се дали съществува изглед с ресурси ако не го създава
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }

        // извлича елементите от изгледа
        TextView name = convertView.findViewById(R.id.username);
        TextView city = convertView.findViewById(R.id.city);
        TextView postCode = convertView.findViewById(R.id.postCode);

        // присвоява информацията от обекта User на елементите в изгледа
        name.setText(user.getName());
        city.setText(user.getCity().getName());
        postCode.setText(Integer.toString(user.getCity().getPostCode()));

        // Върнете завършения изглед за изобразяване на екрана
        return convertView;
    }
}
```

Този адаптер има конструктор и getView() метод, за описване на преобразуването на елемента с данни в изглед за показване.
- getView() е методът, който връща действителния изглед, използван като ред в ListView на определена позиция.
- getItem() вече присъства в ArrayAdapter класа и неговата задача е просто да върне елемент от данни, от съответната позиция в колекцията с данни, който е свързан с този ArrayAdapter.

# Прикачване на адаптера към ListView

За да покажем масив от елементи в ListView трябва да се дефинира UserAdapter в MainActivity:

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Създаване на колекция с потребители
        ArrayList<User> arrayOfUsers = UserSource.generateItemsList();
        // Създаване на адаптер
        UserAdapter adapter = new UserAdapter(this, arrayOfUsers);
        // Поставяне на адаптер за ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
```
[Проекта](https://github.com/theVelislavKolesnichenko/AndroidBasics/tree/master/ExampleProjects/AdapterExamples/CustomArrayAdapter)