# Андроид activity клас
Един от основните компоненти за създаване на визуален интерфейс в Android приложенията е Activity. Често е свързано с отделен екран или прозореца на приложението. Всяко Activity е обект от класа android.app.Activity, която предоставя основната функционалност за всички дейности. В приложението MainActivity наследява класа AppCompatActivity чрез който наследява класа Activity.

Достъпването на ресурси от layout в Activity става с метода findViewById който приема id на ресурс.

# Intent
 Intent е обект-съобщение, което се използва за да се извика действие от друг компонент на системата
Видове:
Експлицитни интенти - задават кой компонент конкретно искат да се стартира

```java
Intent i = new Intent(this, NewActivity.class);
```

Имплицитни интенти - задават само какво трябва да може компонента, който се стартира

```java
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE)
```

Предаване на данни към Activity

``` java
intent.putExtra("objectName", obj);
```

Прочитане на данни

```java
getIntent().getSerializableExtra("objectName");
```
