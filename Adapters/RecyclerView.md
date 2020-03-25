# Използване на RecyclerView

RecyclerView е създаден за да подобри работат със списачни данни, като подобрява ListView и GridView.

## При работа с RecyclerView се използват:

- ```RecyclerView.Adapter``` - За да обработи колекцията с данни и да свърже данните с изгледа
- ```LayoutManager``` - Помага при позиционирането на елементите 
- ```ItemAnimator``` - Помага при анимиране на обичайни операции като добавяне или премахване на елементи от списъка
- ```ViewHolder Pattern``` - За подобряване на производителността, чрез кеширане на изгледа, за по-гладко търсене и по-бързо зареждане на елемент.

## Компоненти на RecyclerView

### LayoutManagers

RecyclerView приема като параметри мениджър на оформление и адаптер, за да бъде създаден. Мениджърът на оформление позиционира елементи вътре в RecyclerView и определя кога да скриват и показват елементи.

#### Видове:

- ```LinearLayoutManager``` - показва елементи във вертикален или хоризонтален списък.
- ```GridLayoutManager``` - показва елементите в матрична решетка.
- ```StaggeredGridLayoutManager``` - показва елементите в шахматна решетка.

### RecyclerView.Adapter

RecyclerView използва специфичен вид адаптер. Това е подобен подход на вече използваните, но с някои особености, като например ViewHolder. Трябва да се имплементират два основни метода: един, за попълване на изгледа, и друг за свърване данните с изгледа.

### Промяна на данните в ResicleView

Всеки път, когато искаме да добавяме или премахваме елементи от RecyclerView, ще трябва да уведомим изрично адаптера за събитието. Има няколко методи, които да се използват при уведомяване на адаптера за различни промени:

| Метод | Описание |
|-|-|
notifyItemChanged(int pos) | Уведомява, че елемента на тази позиция е променен.
notifyItemInserted(int pos) | Уведомява, че на това място е добавен елемент.
notifyItemRemoved(int pos) | Уведомява, че елемента от тази позиция е премахнат.
notifyDataSetChanged() | Уведомява, че колекцията от данни е променена.

### Дизайн на елементите с CardView

CardView е създаден за оформление на елементите в RecyclerView. При показване на много компонентно съдържание. Той определя еднакъв изглед за всчки елементи

Когато се използва CardView в него трябва да се дефинира първо оформление на изгледа като: ConstraintLayou, ConstraintLayou, LinearLayou или друг

## Използване

**Задача**

Съставете списък с контакти

![Annotation 2020-03-25 102631](https://user-images.githubusercontent.com/10382663/77525685-154efc80-6e92-11ea-943b-a3b102627dc3.png)

1. Трябва да се добви зависимост за RecyclerView

```gradle
dependencies {
    ...
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    ...
}
```
2. Добавяне на RecyclerView в activity_main.xml

![Annotation 2020-03-25 102631_1](https://user-images.githubusercontent.com/10382663/77525582-f2244d00-6e91-11ea-9331-f874e91300b6.png)

3. Създаване на изглед за елементите в RecyclerView

**layout -> new -> XML -> layout XML file**

Поставете две TextView. Направете layout_height да е wrap_content виок колкото съдържанието в него.

![image](https://user-images.githubusercontent.com/10382663/77532853-649b2a00-6e9e-11ea-9a5d-6336133e9e4c.png)

1. Създаите класове 

![image](https://user-images.githubusercontent.com/10382663/77526083-b50c8a80-6e92-11ea-91d1-8548b62f8cca.png)

- Contact

```java
public class Contact {
    private String name;
    private long number;

    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }
}
```

- ContactSource

```java
public class ContactSource {
    public static ArrayList<Contact> generateContactList(int count) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            contacts.add(new Contact("Person " + i, 1000000000L + random.nextLong() % 9999999999L ));
        }

        return contacts;
    }
}
```
- ContactViewHolder

```java
public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView phone;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        // Извлича визуалните елементи от изгледа
        name = itemView.findViewById(R.id.textView);
        phone = itemView.findViewById(R.id.textView2);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.setText(phone);
    }
}
```
- ContactAdapter

```java
public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //извлича контекста където се намира RecyclerView
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Извлича персонализиран изглед
        View contactView = inflater.inflate(R.layout.contact_item, parent, false);

        // Създава viewHolder обект
        ContactViewHolder viewHolder = new ContactViewHolder((contactView));

        return viewHolder;
    }
    // Свързва данните с изгледа
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        // Взима текущия елемент от колекцията
        Contact contact = contacts.get(position);

        // Поставя стоиност на TextView за име
        holder.setName(contact.getName());
        // Поставя стоиност на TextView за телефон
        holder.setPhone(Long.toString(contact.getNumber()));
        // Поставя слушател за натискане на елемент от списъка
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.getName() + ": " + contact.getNumber(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Връща размера на колекцията
    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
```

- Използване в MainActivity
```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //извлича RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        //Създава адаптер
        ContactAdapter adapter = new ContactAdapter(ContactSource.generateContactList(10));
        // Поставя адаптер на RecyclerView
        recyclerView.setAdapter(adapter);
        // Поставя мениджър на изгледа
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
```