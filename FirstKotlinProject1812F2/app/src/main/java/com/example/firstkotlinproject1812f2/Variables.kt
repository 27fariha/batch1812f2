package com.example.firstkotlinproject1812f2
import java.util.Scanner;
fun main(){
    var num=123
    var name="abc"
    var salary=125.876;
         salary=987.765
    val msg="This is First Kotlin App"
      // msg="This is Kotlin app";
   var firstname="abcc"

   var marks:Float=34.87f;
   var age:Int=67;

   var x=40
   var y=30
   var z=20
   val condition=x<y || x>z;  //40<30 ->false || 40>20 -> true =true

    println(num)
    print(name)
    println(salary)
   println(msg);
   println("Your Condition is :" +condition)
   println("Answer is : $condition")

   //built in readline function
   println("Enter Your Name :")
   var fullname= readLine(); //string
   println("Your name is : $fullname")

   // scanner with object
   var sc=Scanner(System.`in`);
   print("Enter Number 1 :")
   var num1:Int = sc.nextInt();
   print("Enter Number 2 :")
   var num2:Int= sc.nextInt();
   println("Your Answer is :"+(num1+num2))

   //array
   var array1= arrayOf(1,2,3,4,5,"abc",56.97f,'A')
   var array2= arrayOf<Int>(1,2,3,4,5,6);
   var array3= arrayOf<String>("Aqib","Husnain","Atif");

   println(array1[6])

   for (i in array1){
      println(i)
   }
   for (x in array2){
      println(x)
   }
   for(y in array3){
      println(y)
   }
   //lists
   var std= mutableListOf<String>("Aqib","Atif","Husmnain");
   std.remove("Husmnain")
   std.add("Husnain")
    print(std)


}