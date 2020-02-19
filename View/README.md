# Button

Елемент на потребителският интерфейс, който потребителят може да докосне или щракне, за да извърши действие.

```xml
<Button
     android:id="@+id/button_id"
     android:layout_height="wrap_content"
     android:layout_width="wrap_content"
     android:text="@string/self_destruct" />
```

За да се зададе действие при натискане на бутона, се използва метода:

```java
  setOnClickListener (View.OnClickListener l)
```

Той приема като входен параматър инстанция на клас имплементираща интерфейса

```java
  public static interface View.OnClickListener
```

който имплементира метода за обратно извикване ```onClick```

```java
  @Override
  public void onClick(View v) {
     // Code here executes on main thread after user presses button
  }
```

# TextView

Елемент на потребителският интерфейс, който показва текст на потребителя.

```xml
<TextView
        android:id="@+id/text_view_id"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="@string/hello" />
```

# EditText

Елемент на потребителският интерфейс за въвеждане и промяна на текст.

```xml
<EditText
     android:id="@+id/plain_text_input"
     android:layout_height="wrap_content"
     android:layout_width="match_parent"
     android:inputType="text"/>
```

Когато се дефинира елемент за редактиране на текст, трябва се посочи типа на съдържанието което ще се добавя като:

```xml
android:inputType="text" <!- за въвендане на текстово съдържание ->
android:inputType="number" <!- за въвендане на числово съдържание ->
```

Метода за извличане на въведеното съдържание от елементът е ```getText()```

```java
  public Editable getText();
```

Метода за въвеждане на съдържание в елементът е ```setText()```

```java
  public void setText (CharSequence text, TextView.BufferType type)
```
