
package hashTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Application {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int table_size = 100;
        
        File enrolledStudentsList = new File("/Users/JC/Documents/Coding/Java/listaAlunos.csv");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(enrolledStudentsList));

        String line;
        String enrollment[] = new String[table_size];
        String name[] = new String[table_size];
        Student students[] = new Student[table_size];
        SeparateHashTable table = new SeparateHashTable(100);
        SeparateHashTable table_100 = new SeparateHashTable(100);
        SeparateHashTable table_50 = new SeparateHashTable(50);
        SeparateHashTable table_20 = new SeparateHashTable(20);
        SeparateHashTable table_10 = new SeparateHashTable(10);

        for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
            for (int j = 0; j < line.indexOf(';'); j++) {
                if (j == 0) {
                    enrollment[i] = "" + line.charAt(j);
                } else {
                    enrollment[i] = enrollment[i] + line.charAt(j);
                }
            }
            for (int j = line.indexOf(';') + 1; j < line.length(); j++) {
                if (j == line.indexOf(';') + 1) {
                    name[i] = "" + line.charAt(j);
                } else {
                    name[i] = name[i] + line.charAt(j);
                }
            }
            students[i] = new Student(name[i], enrollment[i]);            
            table.insert(students[i]);
            table_100.insert(students[i]);
            table_50.insert(students[i]);
            table_20.insert(students[i]);
            table_10.insert(students[i]);
        }
        
        System.out.println("\tAntes da Remoção dos Alunos\n");
        table.printColision();
        
       // table.remove(students[0]);        
       // System.out.println("\n\t Após a Remoção dos Alunos\n");
       // table.printColision();  
        
        System.out.println("\n\t\tFator de Carga 1\n");
        table_100.printColision();
        
        System.out.println("\n\t\tFator de Carga 2\n");
        table_50.printColision();
        
        System.out.println("\n\t\tFator de Carga 5\n");
        table_20.printColision();
        
        System.out.println("\n\t\tFator de Carga 10\t\t\n");
        table_10.printColision();
    }
}