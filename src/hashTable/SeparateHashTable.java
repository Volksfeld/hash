
package hashTable;

import java.util.LinkedList;

public class SeparateHashTable {

    private LinkedList[] hashList;

    private static final int DEFAULT_TABLE_SIZE = 100;

    

    public SeparateHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateHashTable(int size) {
        hashList = new LinkedList[nextPrime(size)]; // Usa a funcao nextPrime para forcar o tamanho a ser primo
        for (int i = 0; i < hashList.length; i++) {
            hashList[i] = new LinkedList();
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < hashList.length; i++) {
            hashList[i].clear();
        }
    }

    @SuppressWarnings("empty-statement")
    
    // Só podem haver elementos primos
    private static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }
        for (; !isPrime(n); n += 2)
                ;
        return n;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n == 1 || n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void insert(Hashable x) {
        LinkedList whichList = hashList[x.hash(hashList.length)];
        if (whichList.indexOf(x) == -1) 
        {
            whichList.add(0, x);
        }
    }
    
    public void printColision(){
        
    	int collisionCounter = 0; 
        int emptyPosition = 0;  
        int listSize = 0; 
        
        for (int j = 0; j < hashList.length; j++) {
        	
            listSize = hashList[j].size();

            if(listSize >= 2){
                // teria como botar um getName do Student aqui pra printar o nome dos alunos? 
                System.out.println("Quantidade de Colisões: " + hashList[j].size() + "\nPosição das colisões " + j + "\n-------------");
                collisionCounter += listSize;
            
            }else if (listSize == 0){
                
                emptyPosition ++;
            }

        }
        System.out.println("\nTotal de " + collisionCounter + " Colisões"  + " e "+ emptyPosition + " Posições vazias na tabela ");
    }

    public void remove(Hashable x) {
       hashList[x.hash(hashList.length)].pop();
    }
}
