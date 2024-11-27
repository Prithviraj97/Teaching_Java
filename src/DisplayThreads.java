public class DisplayThreads {    
    public static void main(String[] args){
        ThreadGroup topGroup = Thread.currentThread().getThreadGroup().getParent();        
        topGroup.list();    }
    }
    
