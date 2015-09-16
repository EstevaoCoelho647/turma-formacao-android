package br.com.cast.turmaformacao.taskmanager.model.entities;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Administrador on 15/09/2015.
 */
public class Task implements Parcelable{
    private Long id;
    private String name;
    private String description;

    public Task(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Task() {
        super();
    }
    public Task(Parcel imp) {
        super();
        readFromParcel(imp);
    }




    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id == null ? -1 : id);
        dest.writeString(name == null ? "" : name);
        dest.writeString(description == null ? "" : description);
    }

    public void readFromParcel(Parcel imp){
        id = imp.readLong();
        id = id == -1 ? null : id;

        name = imp.readString();
        description = imp.readString();
    }

   public static final Parcelable.Creator<Task> CREATOR = new Creator<Task>() {
       @Override
       public Task createFromParcel(Parcel source) {
           return new Task(source);
       }

       @Override
       public Task[] newArray(int size) {
           return new Task[size];
       }
   };
}
