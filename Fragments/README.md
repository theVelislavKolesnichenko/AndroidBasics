# Фрагменти

Fragment е част от Activity, коeто позволява по-модулен дизайн на дейностите. Fragment представлява поведение или част от потребителския интерфейс в даденo Activity. Можем да комбинираме множество фрагменти в едно Activity, за да изградим интерфейс с множество панели и да използваме отново фрагмент в много Activity-та. Жизненият цикъл на фрагмента е пряко засегнат от жизнения цикъл на родителското Activity.

Фрагмент обикновено определя част от потребителския интерфейс. Фрагментите трябва да бъдат вградени в Activity те не могат да работят независимо.

## Характеристики

- Фрагментите включват изгледи и логика, така че да е по-лесно да се използва повторно в Activity.
- Фрагментите са самостоятелни компоненти, които могат да съдържат изгледи, събития и логика.
- Приложенията, ориентирана към фрагменти, дейностите стават навигационни контейнери за навигацията към други дейности, представящи фрагменти и предаващи данни.

## Употреба на фрагменти:

- Повторното използване на "View" или "Логика" – Фрагментите позволяват повторното използване на части от екрана, включително изгледи и логика на събитията по различни начини в много различни дейности. Например, използването на един и същ списък в различни източници на данни в дадено приложение.
- Tablet Support - Фрагментите позволяват специфични да се изграждат версии на телефон, която е различна от версията на таблета.
- Ориентация на екрана - Често в рамките на приложения, портретната версия на дадена дейност има значително различно оформление от пейзажната версия. Фрагментите позволяват на двете ориентации да използват повторно споделени елементи, като същевременно имат различия.

## Качество на кода

В рамките на приложение, което използва фрагменти широко, трябва да имаме предвид, че ролята на дадена Activity се променя.

Activity има навигационна отговорност:

- Навигация към други Activity.
- Представяне на навигационни компоненти като чекмеджето за навигация или на устройството за преглед.
- Скриване и показване на съответните фрагменти с помощта на мениджъра на фрагменти.
- Получаване на данни от Intent и предаване на данни между фрагменти.

Фрагментите са контролери на съдържание и съдържат повечето изгледи, оформления и логика:

- Изгледи, показващи подходящо съдържание на приложението.
- Логика за обработка на събития, свързана със съответните изгледи.
- Преглед на логиката за управление на състоянието, като например видимост или обработка на грешки.
- Задействане на мрежова заявка.
- Извличане и съхранение на данни.

# Използване

## Дефиниране на фрагмент

Fragment, подобно на Activity, има XML файл за оформление и Java клас, който служи за контрол на фрагмент.

**layout->New->Fragment**

Класа на fragmenta наследява базовия клас Fragment и овърайдва методите:

- ```onCreateView``` - дефинира изгледа на фрагмента
- ```onViewCreated``` - зарежда визуалните елементи от изгледа в Java обекти

## Вграждане на фрагмент

Добавяне на фрагмента динамично в Java става с помощта на класът FragmentTransaction. Класа позволява да се добавят, премахват и заместват фрагменти в оформлението на Activity по време на работа.

В този случай искате да добавите контейнер контейнер "контейнер" (обикновено a ) към вашата дейност, където фрагментът се вмъква по време на изпълнение:FrameLayout

- в activity_main.xml се добавя FrameLayout
- в MainActivity.java се добавя:

// Създаване на FragmentTransaction
FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Запълване на съдържанието на FrameLayout с новия фрагмент
ft.replace(R.id.your_placeholder, new FooFragment()); // or ft.add(R.id.your_placeholder, new FooFragment());
// Потвърждаване на замяната
ft.commit();

## Предаване на данни от Activity кум Fragment

За да се усигори съвместимост между ключовете на данните, който се изпращат от Activity кум Fragment е препоръчително да се създаде клас за създаване на фрагменти с данни

#### Пример:

```java
    //предаване на данните
    public static CustomFragment newInstance(String name) {
        CustomFragment customFragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString("user_name", name);
        customFragment.setArguments(args);
        return customFragment;
    }
```

```java
    //приемане на данните
    String name = getArguments().getString("user_name", "");	
```

# DialogFragment

DialogFragment е фрагмент, използван за покажете модален прозорец в рамките на Activity, която стой над останалата част от съдържанието.

## Използване

Всеки java клас на фрагмент, импортиран да използва пространството на имената, а пространството на имената. Ако всички внесени клас (FragmentManager, DialogFragment и т.н.) използва пространство на имената, ще възникнат грешки за компилиране-време.androidx.fragment.appandroid.appandroid.app

1. XML файл за оформлението на диалоговия прозорец. Фрагмент може да се създаде с десен бутон на **app -> New -> Fragment -> Fragment (Blank)**

![image](https://user-images.githubusercontent.com/10382663/78098928-167bae80-73e9-11ea-9ff2-56f09a1e8855.png)

2. Свързвания Java класа трябва да наследи базовия клас DialogFragment.

```java

public class EditNameDialogFragment extends DialogFragment {

	private EditText еditText;

    // Задължително е да има празен конструктор
	public EditNameDialogFragment() { }
	
    // Метод за създаване на EditNameDialogFragment обект с данни
	public static EditNameDialogFragment newInstance(String title) {
		EditNameDialogFragment frag = new EditNameDialogFragment();
		Bundle args = new Bundle();
		args.putString("title", title);
		frag.setArguments(args);
		return frag;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_edit_name, container);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		// Извличане на елементите от изгледа
		еditText = view.findViewById(R.id.editText);
		// Поставяне на заглавие
		String title = getArguments().getString("title", "Enter Name");
		getDialog().setTitle(title);
		// Фокуситане на курсора за писане върху еditText
		еditText.requestFocus();
        // Автоматично показване на клавиятурата
		getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
	}
}

```

3. Показване на диалоговия прозорец

```java
public class MainActivity extends AppCompatActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
    FragmentManager fm = getSupportFragmentManager();
    EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance("Title");
    editNameDialogFragment.show(fm, "fragment_edit_name");
  }
}
```

4. Предаване на данни към Activity

За предаване на данни от Fragment към Activity, се създава персонализиран слушател:

- Създава се интерфейс с методи, които могат да се извикат за предаване на резултата от Fragment към Activity
- Имплементиране на интерфейс слушател от Fragment класа и поставяне на дайствие за визуалния обект, след което да се изпрати резултат към Activity
- Имплементиране на интерфейса в Activity към което ще се предават данните.

# Пример

### Задача

Направете списък с пациентите на ветеринарен лекар.

1. Дефинираме клас Animal един пациент

```java
public class Animal {
    private String name;
    private String type;
    private String imageUrl;

    public Animal(String name, String type, String imageUrl) {
        this.name = name;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
```

2. Дефинираме клас с предварителна дефинирана колекция от Animal

```java
public class AnimalSource {

    ArrayList<Animal> animals;

    public AnimalSource() {
        animals = new ArrayList<Animal>() {{
            add(new Animal("Charly", "Dog", "https://www.brandeps.com/icon-download/D/Dog-icon-vector-01.svg"));
            add(new Animal("Sara", "Cat", "https://www.brandeps.com/icon-download/C/Cat-icon-vector-01.svg"));
        }};
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
```

3. Създаваме animal_item.xml файл с изгледа за 1 ред в RecyclerView

**layout->New->XML->Layout XML file**

Добавяме CardView с 1 ImageView и 2 TextView

4. Създаваме AnimalViewHorder клас за оформлението animal_item.xml

```java
public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView name;
    private TextView type;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.textView3);
        type = itemView.findViewById(R.id.textView4);
    }

    public void setImage(String url) {
       Picasso.get().load(url).error(R.drawable.farm_animals_vector_cartoons).into(image);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
```

5. Добавяне на RecycleView в activity_main.xml и създаване на Adapter

```java
public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private ArrayList<Animal> animals;

    public AnimalAdapter(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View canimalView = inflater.inflate(R.layout.animal_item, parent, false);

        return new AnimalViewHolder(canimalView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {

        Animal animal = animals.get(position);

        holder.setName(animal.getName());
        holder.setType(animal.getType());
        holder.setImage(animal.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animals.add(0, animal);
        notifyItemChanged(0);
    }
}
```

6. Създаване на Fragment - AddAnimalFragment

    - Десен бутон **app -> New -> Fragment -> Fragment (Blank)**

7. Създаване на интерфейс за прехвърляне на данни от Activity към Frqgment

```java
public interface AddAnimalDialogListener {
    void onFinishAddDialog(Animal animal);
}
```

8. Имплементиране на AddAnimalFragment

```java
public class AddAnimalFragment extends DialogFragment implements View.OnClickListener {

    private EditText name;
    private EditText type;
    private EditText image;
    private Button add;
    AddAnimalDialogListener listener;

    public AddAnimalFragment() {
        // Required empty public constructor
    }

    public static AddAnimalFragment newInstance() {
        return new AddAnimalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_animal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.editText);
        type = view.findViewById(R.id.editText2);
        image = view.findViewById(R.id.editText3);
        add = view.findViewById(R.id.button);
        add.setOnClickListener(this);

        // Фокуситане на курсора за писане върху еditText
        name.requestFocus();
        // Автоматично показване на клавиятурата
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddAnimalDialogListener)context;
    }

    @Override
    public void onClick(View v) {
        Animal animal = new Animal(name.getText().toString(), type.getText().toString(), image.getText().toString());

        listener.onFinishAddDialog(animal);

        dismiss();
    }
}
```

9. Използване на RecycleView и отваряне на DialogFrgment

```java
public class MainActivity extends AppCompatActivity implements AddAnimalDialogListener {

    RecyclerView recyclerView;
    AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        AnimalSource animals = new AnimalSource();

        adapter = new AnimalAdapter(animals.getAnimals());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddAnimalFragment addAnimalFragment = AddAnimalFragment.newInstance();
                addAnimalFragment.show(fm, "fragment_add_animal");
            }
        });
    }

    @Override
    public void onFinishAddDialog(Animal animal) {
        adapter.addAnimal(animal);
    }
}
```