package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyDatabaseGenerator {
    public static void main(String args[]) {
        Schema schema = new Schema(1, "com.miguelcr.a01_localdatabase.database");

        studentsSchemaGenerator(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void studentsSchemaGenerator(Schema schema) {
        Entity student = schema.addEntity("Student");
        student.addIdProperty().autoincrement().primaryKey();
        student.addStringProperty("name");
        student.addIntProperty("age");
        student.addStringProperty("sex");
    }
}
