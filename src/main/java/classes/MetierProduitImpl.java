package classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit,Long>{

    List<Produit> products=new ArrayList<>();
    File file= new File("products.dat");
    public MetierProduitImpl() throws IOException {
    }

    @Override
    public Produit add(Produit o) {
        Produit p=findById(o.getId());
        if(p==null){
            this.products.add(o);
            System.out.println("added successfully");
        }else {
            System.out.println("cet id existe deja");
        }
        return p ;
    }

    @Override
    public List<Produit> getAll() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("products.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Produit> p=(List<Produit>)ois.readObject();
        for (int i=0;i<p.size();i++){
        System.out.println(p.get(i));}
        return null;
    }

    @Override
    public Produit findById(Long id) {
        for (Produit p:products) {
            if (p.getId()==id){
                return p;}
        }
        return null;
    }

    @Override
    public void delete(Long id) throws IOException {
        Produit p=findById(id);
        if (p!=null)
            products.remove(p);
        System.out.println("product deleted successfully");
        //in case we want the file to be updated too
        saveAll();

    }

    @Override
    public void saveAll() throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream objStream = new ObjectOutputStream(fos);
        objStream.writeObject(this.products);

        objStream.close();
    }
}
