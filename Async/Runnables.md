# Runnable

Повтарянето на периодични задачи в рамките на приложение е често срещано изискване. Тази функционалност може да се използва за извличане на нови данни от мрежата, пускане на анимации или просто актуализиране на потребителския интерфейс.

Runnables е абстрактен клас, който има метод за изпълнение за изпълнение. Runnable представлява код, който може да бъде изпълнен в нишка, обикновено планирана чрез Handler.

**Пример**

```java
public class TaskToRun implements Runnable {
    @Override
    public void run() {
        // Кодът, който да се изпълни
    }
};
```
# Thread

Thread е единица за изпълнение, която изпълнява код, дефиниран в Runnable. Дефинираното по-горе taskToRun може да се изпълни с помощта на нишка:

**Пример**

```java
TaskToRun taskToRun = TaskToRun();

Thread thread = new Thread(taskToRun);
thread.start();
```

# join

Метода ```join``` изчаква да умре нишка.

```java
TaskToRun taskToRun1 = TaskToRun();
TaskToRun taskToRun2 = TaskToRun();

Thread thread1 = new Thread(taskToRun1);
Thread thread2 = new Thread(taskToRun2);

thread1.start();
thread2.start();
```

# Handler

Handler може да се използва, за стартираме код на дадена нишка след забавяне или за периодично повтаряне на задачи. Това се прави чрез конструиране на и след това "публикуване" на код на опашката за съобщение на събитието в нишката, която ще се обработва задачата.

## Изпълнение на код след забавяне

Използвайки Handler, можем да изпълним произволен код еднократно след определено забавяне: 

**Пример**

```java
// Handler package
import android.os.Handler;

// Създаване на Handler обекта (по подразбиране в основната нишка)
Handler handler = new Handler();

// Задачата която ще се изпълнява
private Runnable runnableCode = new Runnable() {
    @Override
    public void run() {
      // обновяване на UIThread
      Log.d("Handlers", "Called on main thread");
    }
};
// Изпълнение на горния код на основната нишка след 2 секунди
handler.postDelayed(runnableCode, 2000);
```

# Изпълнение на повтарящ се код в определен интервал

Тази техника, може да използва за изпълнение на периодична задача.

**Пример**

```java
// Handler package
import android.os.Handler;

//  Създаване на Handler обекта (по подразбиране в основната нишка)
Handler handler = new Handler();
// Задачата която ще се изпълнява
private Runnable runnableCode = new Runnable() {
    @Override
    public void run() {
      //  обновяване на UIThread
      Log.d("Handlers", "Called on main thread");
      // Повторение на този блок изпълнение 2 секунди
      // 'this' е обекта Runnable
      handler.postDelayed(this, 2000);
    }
};
// Стартиране на първоначалното изпълнение на адачата
handler.post(runnableCode);
```
Премахване на планирано изпълнение 

```java
handler.removeCallbacks(runnableCode);
```



