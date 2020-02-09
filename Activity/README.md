# Activity 

 Един от основните компоненти за създаване на визуален интерфейс в Android приложенията е Activity. Често е свързано с отделен екран или прозореца на приложението. Всяко Activity е обект от класа android.app.Activity, която предоставя основната функционалност за всички дейности. В приложението MainActivity наследява класа AppCompatActivity чрез който наследява класа Activity.

 - onCreate(Bundle) е метода в който се инициализира всяко activity. В метода се инициализира съдържанието на изгледа за текущото activity.

```Java
    setContentView(R.layout.activity_main);
```