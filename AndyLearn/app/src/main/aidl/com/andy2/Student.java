package com.andy2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author：zhouhuan date： 2017/2/15 15:01 email：zhouhuan@fangdd.com function：
 */
public class Student implements Parcelable {
    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
    public int age;
    public String name;
    public int sex;

    public Student() {
    }

    protected Student(Parcel in) {
        this.age = in.readInt();
        this.name = in.readString();
        this.sex = in.readInt();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeString(this.name);
        dest.writeInt(this.sex);
    }
}
