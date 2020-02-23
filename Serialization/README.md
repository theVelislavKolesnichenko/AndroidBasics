# Parcelable

Parcelable е Android имплементация на Java Serializable. Интерфейсът Parcelable предполага определена структура и начин на обработката за обектите, който ще се предават през отделните компоненти на Android OS. По този начин Parcelable може да бъде обработен по бързо в сравнение със стандартната Java сериализация.

```java
package com.github.thevelislavkolesnichenko.picassoexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

```
Класовете имплементиращи `android.os.Parcelable` интерфейсът трябва да предоставят статична константа `CREATOR` която да имплементира интерфеисът `Parcelable.Creator`. Който служи за създаваме на обекти от клъса използвайки `Parcel`.

```java
    @Override
    public int describeContents() {
        return 0;
    }

    protected Person(Parcel in) {
        this.age = in.readInt();
        this.fName = in.readString();
        this.lName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeString(this.fName);
        dest.writeString(this.lName);
    }
}

```

Конструктора приемаш транспортния обект `Parcel` трябва да прочете записите в реда в който те са запазени в транспортния обект от метода `writeToParcel`.

