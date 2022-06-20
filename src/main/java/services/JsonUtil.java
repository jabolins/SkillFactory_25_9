package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.University;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.apache.poi.hslf.record.RecordTypes.List;

public class JsonUtil {
    private JsonUtil() {
    }

    public static String studentToJson(Student student) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(student);
    }

    public static String universityToJson(University university) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(university);
    }

    public static String studentsListToJson(ArrayList<Student> students) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(students);
    }

    public static String universitiesListToJson(ArrayList<University> universities) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(universities);
    }

    public static Student jsonToStudent(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, University.class);
    }

    public static ArrayList<Student> jsonToStudentList(String json){
        Gson gson= new Gson();
        Type type = new TypeToken <ArrayList<Student>>(){}.getType();
        return gson.fromJson(json, type);
    }

       public static ArrayList<University> jsonToUniversityList(String json){
        Gson gson= new Gson();
        Type type = new TypeToken <ArrayList<University>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
