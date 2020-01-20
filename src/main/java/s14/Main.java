package s14;

import java.util.List;
import java.util.Optional;

import s14.dao.Coder;
import s14.dao.CoderDao;

public class Main {
    public static void main(String[] args) {
        CoderDao cd = new CoderDao();

        // create a new coder
        Coder tom = new Coder(501, "Tom", "Jones", 2000);
        cd.save(tom); // chiamata al metodo save, cambiamento anche nel DB e non solo nella RAM
     

        // get a coder
        Optional<Coder> opt = cd.get(501); // optional (java 8) per cercare di fare a meno dei null. E' una sorta di collection in cui dentro ci può essere un valore reference o 0. Ritorna un coder che c'è o non c'è. Questo perchè get potrebbe ritornare un null.
        if (opt.isPresent()) {
            System.out.println("Coder 501: " + opt.get());
        } else {
            System.out.println("Unexpected! Can't get coder 501");
        }
        
        // rename a coder
        tom.setLastName("Bombadil");
        cd.update(tom);
        
        opt = cd.get(501);
        if (opt.isPresent()) {
            System.out.println("Coder 501: " + opt.get());
        } else {
            System.out.println("Unexpected! Can't get coder 501");
        }
        
        // delete a coder
        cd.delete(501);
                
        opt = cd.get(501);
        if (opt.isPresent()) {
            System.out.println("Unexpected! Coder 501 still alive: " + opt.get());
        } else {
            System.out.println("Coder 501 is no more");
        }

        // get all coders
        List<Coder> coders = cd.getAll();
        System.out.println("Coders: " + coders);        
    }
}
