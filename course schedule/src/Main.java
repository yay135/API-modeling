import java.util.*;
import java.lang.reflect.Field;

class Solution{
   public boolean contains(Object the, Object obj){
       if(the == null || obj == null){
           return false;
       }
       if(the instanceof Collection){
           Iterator<Object> itr = ((Collection) the).iterator();
           while (itr.hasNext()){
               Object o = itr.next();
               if (equals(o,obj)){
                   return true;
               }
           }
       }
       if(the instanceof String){
           if(the.getClass()!=obj.getClass()){
               return false;
           }
           if(((String)obj).length() == 0){
               return true;
           }
           int len = ((String) the).length();
           if(len < ((String) obj).length()){
               return false;
           }
           for(int i=0;i<((String) the).length()-(((String) obj).length()+1);i++){
               if(((String) the).charAt(i)== ((String) obj).charAt(0)){
                   if(((String)obj).length() == 1){
                       return true;
                   } else {
                       boolean flag = true;
                       for (int j = 1; j < ((String) obj).length(); j++) {
                           if (((String) the).charAt(i + j) != ((String) obj).charAt(j)) {
                               flag = false;
                               break;
                           }
                       }
                       if (flag) {
                           return true;
                       }
                   }
               }
           }
           return false;
       }
       return false;
   }

   public boolean equals(Object the,Object obj){
       if(the == obj){
           return true;
       }
       if (the == null||obj == null){
           return false;
       }
       if (the.getClass() != obj.getClass()){
           return false;
       }
       Field[] fields0 = the.getClass().getDeclaredFields();
       Field[] fields1 = obj.getClass().getDeclaredFields();
       if(fields0.length != fields1.length){
           return false;
       }
       for(int i=0;i<fields0.length;i++){
           boolean flag = false;
           for(int j=0;j<fields1.length;j++){
               if(fields0[i].getName() == fields1[i].getName()){
                   if(equals(fields0[i],fields1[j])){
                       flag = true;
                   }
               }
           }
           if (!flag){
               return false;
           }
       }
       return true;
   }

   public void execute(Object object){}

   public void collect(Object object){}

   public void times(Object object){}

   public void eachWithIndex(Object object){}

   public Object format(Object the,Object object){
       return object;
   }

   public void getTrips(Object object){
   }

   public Object parseText(Object object){
       if(!(object instanceof String)){
           return null;
       }
       return object;
   }

}
