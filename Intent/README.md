# Intent

 Intent е обект-съобщение, което се използва, за да се извика действие от друг компонент на системата

## Видове:

- Експлицитни интенти - задават кой компонент конкретно искат да се стартира

```java
Intent i = new Intent(this, NewActivity.class);
```

- Имплицитни интенти - задават само какво трябва да може компонента, който се стартира

```java
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE)
```

## Предаване на данни към Activity

``` java
intent.putExtra("objectName", obj);
```

Прочитане на данни

```java
getIntent().getSerializableExtra("objectName");
```

## Извикване на Activity

```
startActivity(intent);
```
