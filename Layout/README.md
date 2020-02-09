# Layout

Layout в ресурс за оформление, който дефинира изгледа на Activity или на компонент. Името на Layout се използва като идентификатор (ID) за достъп до ресурса.

В Layout се дефинира контейнер за други елементи (ViewGroup LinearLayout RelativeLayout FrameLayout). Всеки контейнер дефинира различно поведение за подреждане на елементите в контейнера.

В контейнера се дефинират всички индивидуални компоненти на потребителския интерфейс (TextView, Button, CheckBox и др.).

Всеки елемент в layout има уникален идентификатор, който се дефинира с "@+id/name". Където "name" е уникалното име на елемента от потребителския интерфейс.

```xml
    <TextView android:id="@+id/firstName"/>
```

Достъпването до ресурси от layout в Activity става с метода findViewById който приема id на ресурс.

```Java
    TextView textView = findViewById(R.id.firstName);
```