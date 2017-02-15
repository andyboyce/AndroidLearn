// ITestService.aidl
package com.andy2;

// Declare any non-default types here with import statements
import com.andy2.Student;
interface ITestService {

   String query(in int id);
   String add(in String name);
   Student addStudent(in Student student);
}
